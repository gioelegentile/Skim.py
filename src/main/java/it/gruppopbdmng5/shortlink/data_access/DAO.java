package it.gruppopbdmng5.shortlink.data_access;


import com.google.gson.Gson;
import com.sun.jndi.toolkit.url.Uri;
import it.gruppopbdmng5.shortlink.entity.Statistiche;
import it.gruppopbdmng5.shortlink.entity.URL;
import it.gruppopbdmng5.shortlink.entity.UrlCustom;
import it.gruppopbdmng5.shortlink.presentation.UrlService;
import it.gruppopbdmng5.shortlink.utility.IPGeo;
import it.gruppopbdmng5.shortlink.utility.URLShortener;
import it.gruppopbdmng5.shortlink.utility.UserAgentInfo;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import spark.Request;

import java.awt.*;

public class DAO {
    private UrlService urlService;

    private final static int INDISPONIBILE = 0;
    private final static int DISPONIBILE_USO = 1;
    private final static int DISPONIBILE = 2;

    public DAO(UrlService urlService) {
        this.urlService = urlService;
    }

    public URL creaUrlShort(String body) {
        if (body.substring(0, 8).equals("https://")) {
            body = body.replace("https://", "http://");
        } else if (!body.substring(0, 7).equals("http://")) {
            body = "http://" + body;
        }
        if (body.charAt(body.length() - 1) == '/') body = body.substring(0, body.length() - 1);
        URL url;
        try {
            url = urlService.findUrlByLongURL(body);
        } catch (NullPointerException e) {
            url = null;
        }


        if (url != null) {
            return url;
        } else {
            String URLSHORT = URLShortener.shortenURL(body);
            urlService.createNewURL(body, URLSHORT);
            url = urlService.findUrlByLongURL(body);
            aggiungiSitoStatistiche();
            return url;
        }
    }

    public String espandiUrl(Request request) {
        try {
            String longURl = urlService.findURLByShortUrl(request.body());
            UrlCustom url = new UrlCustom(longURl, request.body(), urlService.prendiStatisticheShortURL(request.body()));
            UserAgentInfo userAgentInfo=new UserAgentInfo(request.userAgent());
            aggiornaUrl(userAgentInfo, request.ip(), url);
            aggiornaStatistiche(userAgentInfo, request.ip());
            urlService.aumentaClick(url.getLongURL());
            return url.getLongURL();
        } catch (NullPointerException e) {
            return "/#/404_Rendering_Error_Page_Not_Found";
        }


    }

    public URL generaUrlCustom(String body) {
        if (body.substring(12, 20).equals("https://")) {
            body = body.replace("https://", "http://");
        } else if (!body.substring(12, 19).equals("http://")) {
            body = body.substring(0, 12) + "http://" + body.substring(12);
        }
        UrlCustom urlCustom = new Gson().fromJson(body, UrlCustom.class);
        urlCustom.setCustomURL("http://localhost:8080/#/" + urlCustom.getCustomURL());
        URL url = null;
        if (isAvailable(urlCustom) == INDISPONIBILE || isViewName(urlCustom))
            return null;
        if (isAvailable(urlCustom) == DISPONIBILE_USO) {
            url = urlService.findUrlByLongURL(urlCustom.getLongURL());
            return url;
        }
        try {
            url = urlService.findUrlByLongURL(urlCustom.getLongURL());
            urlService.aggiornaListaCustom(urlCustom.getLongURL(), urlCustom.getCustomURL());
        } catch (NullPointerException e) {
            url = new URL(urlCustom.getLongURL(), URLShortener.shortenURL(urlCustom.getLongURL()));
            urlService.createNewURL(url.getLongURL(), url.getShortURL());
            urlService.aggiornaListaCustom(urlCustom.getLongURL(), urlCustom.getCustomURL());
            aggiungiSitoStatistiche();
            return url;
        }
        return url;
    }

    public UrlCustom getUrlStatistics(String body) {
        try {
            String longURl = urlService.findURLByShortUrl(body);
            UrlCustom url = new UrlCustom(longURl, body, urlService.prendiStatisticheShortURL(body));
            return url;
        } catch (NullPointerException e) {
            return null;
        }

    }

    public Statistiche getStatistics() {
        return urlService.prendiStatistiche();
    }


    private void aggiornaUrl(UserAgentInfo agent, String ip, UrlCustom url) {
        url.getStatistiche().addClickOS(agent.getOS());
        url.getStatistiche().addClickBrowser(agent.getBrowser());
        url.getStatistiche().addNum();
        url.getStatistiche().addClickCountry(IPGeo.getCountry(ip));
        urlService.aggiornaStatisticheCustomURL(url);
    }

    private void aggiornaStatistiche(UserAgentInfo agent, String ip) {
        Statistiche statistiche = urlService.prendiStatistiche();
        statistiche.addClickBrowser(agent.getBrowser());
        statistiche.addClickOS(agent.getOS());
        statistiche.addClickCountry(IPGeo.getCountry(ip));
        urlService.aggiornaStatistiche(statistiche);
    }

    private boolean isViewName(UrlCustom urlCustom) {
        if(urlCustom.getCustomURL().equals("http://localhost:8080/#/topSites"))
            return true;
        return false;
    }

    private int isAvailable(UrlCustom customURL) {
        try {
            URL url = urlService.findUrlByCustomUrl(customURL.getCustomURL());
            if (url.getLongURL().equalsIgnoreCase(customURL.getLongURL()))
                return DISPONIBILE_USO;
            return INDISPONIBILE;
        } catch (NullPointerException e) {
            return DISPONIBILE;
        }
    }

    private void aggiungiSitoStatistiche() {
        Statistiche statistiche = urlService.prendiStatistiche();
        statistiche.addNum();
        urlService.aggiornaStatistiche(statistiche);

    }
}

