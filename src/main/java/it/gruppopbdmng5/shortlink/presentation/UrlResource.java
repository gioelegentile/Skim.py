package it.gruppopbdmng5.shortlink.presentation;


import com.google.api.client.util.Charsets;
import com.google.common.io.Files;
import it.gruppopbdmng5.shortlink.data_access.DAO;
import it.gruppopbdmng5.shortlink.utility.JsonTransformer;

import java.io.File;

import static spark.Spark.get;
import static spark.Spark.post;

public class UrlResource {
    private static final String API_CONTEXT = "/api/v1";
    private DAO dao;

    public UrlResource(UrlService urlService) {
        this.dao = new DAO(urlService);
        setupEndpoints();
    }

    private void setupEndpoints() {

       post(API_CONTEXT + "/shortCustom", "application/json", (request, response) -> dao.generaUrlCustom(request.body()), new JsonTransformer());

        post(API_CONTEXT + "/short", "application/json", (request, response) -> dao.creaUrlShort(request.body()), new JsonTransformer());

        post(API_CONTEXT + "/risultato", "application/json", (request, response) -> dao.espandiUrl(request), new JsonTransformer());

        get(API_CONTEXT + "/url_statistics/", "application/json", (request, response) -> dao.getUrlStatistics(request.queryParams("param1")), new JsonTransformer());

        get(API_CONTEXT + "/top_sites", "application/json", (request, response) -> dao.getStatistics(), new JsonTransformer());

        get("/test/testCheck", (request, response) -> Files.toString(new File(System.getProperty("user.dir") + "/src/main/resources/public/test/testCheck.html"),Charsets.UTF_8));
    }


}
