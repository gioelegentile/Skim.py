package it.gruppopbdmng5.shortlink.entity;

import com.mongodb.BasicDBObject;

import java.util.ArrayList;

public class URL {
    private String longURL;
    private String shortURL;
    private ArrayList<String> customURL;
    private int click;

    public URL(BasicDBObject dbObject) {
        this.longURL = dbObject.getString("_id");
        this.shortURL = dbObject.getString("shortURL");
        this.click = dbObject.getInt("click");


    }

    public URL(String longURL, String shortURL) {
        this.longURL = longURL;
        this.shortURL = shortURL;
        this.customURL = new ArrayList<>();
        this.customURL.add(shortURL);
        this.click = 0;


    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getClick() {
        return click;
    }

    public void addClick() {
        this.click++;
    }


    public ArrayList<String> getCustomURL() {
        return customURL;
    }

    public void setCustomURL(ArrayList<String> customURL) {
        this.customURL = customURL;
    }

    public void addCustomURL(String customURL) {
        this.customURL.add(customURL);
    }

    public String getLongURL() {
        return longURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public BasicDBObject getBasicDBObjectClass() {

        BasicDBObject customURL = new BasicDBObject("URL", shortURL).append("statistiche", new Statistiche().getBasicDBObjectClass());
        ArrayList<BasicDBObject> arrayList = new ArrayList<>();
        arrayList.add(customURL);
        BasicDBObject document = new BasicDBObject("_id", this.longURL)
                .append("shortURL", this.shortURL)
                .append("customURL", arrayList)
                .append("click", this.click);


        return document;
    }
}
