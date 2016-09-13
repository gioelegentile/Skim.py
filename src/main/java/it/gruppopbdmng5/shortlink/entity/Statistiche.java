package it.gruppopbdmng5.shortlink.entity;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Statistiche {
    private String id;
    private ArrayList<URL> topTen;
    private int num;
    private HashMap<String, Integer> statistichePaesi;
    private HashMap<String, Integer> statisticheBrowser;
    private HashMap<String, Integer> statisticheOS;

    public Statistiche(List<DBObject> topTen, BasicDBObject statistiche) {
        this.topTen = new ArrayList<>();
        for (DBObject basicDBObject : topTen)
            this.topTen.add(new URL((BasicDBObject) basicDBObject));
        this.id = ((ObjectId) statistiche.get("_id")).toString();

        this.num = statistiche.getInt("num");
        this.statistichePaesi = (HashMap<String, Integer>) statistiche.get("paesi");
        this.statisticheBrowser = (HashMap<String, Integer>) statistiche.get("browser");
        this.statisticheOS = (HashMap<String, Integer>) statistiche.get("os");
    }

    public Statistiche(BasicDBObject statistiche) {
        this.num = statistiche.getInt("num");
        this.statistichePaesi = (HashMap<String, Integer>) statistiche.get("paesi");
        this.statisticheBrowser = (HashMap<String, Integer>) statistiche.get("browser");
        this.statisticheOS = (HashMap<String, Integer>) statistiche.get("os");

    }

    public Statistiche() {
        num = 0;
        statisticheBrowser = new HashMap<>();
        statisticheOS = new HashMap<>();
        statistichePaesi = new HashMap<>();
    }

    public ArrayList<URL> getTopTen() {
        return topTen;
    }

    public int getNum() {
        return num;
    }

    public void addNum() {
        this.num++;
    }

    public void addClickCountry(String country) {
        this.statistichePaesi.put(country, this.statistichePaesi.getOrDefault(country, 0) + 1);
    }

    public void addClickBrowser(String browser) {

        this.statisticheBrowser.put(browser, this.statisticheBrowser.getOrDefault(browser, 0) + 1);
    }

    public void addClickOS(String os) {
        this.statisticheOS.put(os, this.statisticheOS.getOrDefault(os, 0) + 1);
    }

    public HashMap<String, Integer> getStatistichePaesi() {
        return statistichePaesi;
    }

    public HashMap<String, Integer> getStatisticheBrowser() {
        return statisticheBrowser;
    }

    public HashMap<String, Integer> getStatisticheOS() {
        return statisticheOS;
    }

    public String getId() {
        return id;
    }

    public BasicDBObject getBasicDBObjectClass() {
        BasicDBObject document = new BasicDBObject()
                .append("num", this.num)
                .append("paesi", this.statistichePaesi)
                .append("browser", this.statisticheBrowser)
                .append("os", this.statisticheOS);
        return document;
    }

    @Override
    public String toString() {
        return "Statistiche{" +
                "id='" + id + '\'' +
                ", topTen=" + topTen +
                ", num=" + num +
                ", statistichePaesi=" + statistichePaesi +
                ", statisticheBrowser=" + statisticheBrowser +
                ", statisticheOS=" + statisticheOS +
                '}';
    }
}
