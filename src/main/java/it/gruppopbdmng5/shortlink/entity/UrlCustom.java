package it.gruppopbdmng5.shortlink.entity;

import com.mongodb.BasicDBObject;

public class UrlCustom {
    private String longURL;
    private String customURL;
    private Statistiche statistiche;


    public UrlCustom(String longURL, String customURL, BasicDBObject statistiche) {
        this.longURL = longURL;
        this.customURL = customURL;

        this.statistiche = new Statistiche(statistiche);
    }

    public void setCustomURL(String customURL) {
        this.customURL = customURL;
    }

    public String getCustomURL() {
        return customURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public Statistiche getStatistiche() {
        return statistiche;
    }


    @Override
    public String toString() {
        return "UrlCustom{" +
                "longURL='" + longURL + '\'' +
                ", customURL='" + customURL + '\'' +
                ", statistiche=" + statistiche +
                '}';
    }
}
