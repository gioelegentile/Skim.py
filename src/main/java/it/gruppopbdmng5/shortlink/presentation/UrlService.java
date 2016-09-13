package it.gruppopbdmng5.shortlink.presentation;

import com.mongodb.*;
import com.mongodb.util.JSON;
import it.gruppopbdmng5.shortlink.entity.Statistiche;
import it.gruppopbdmng5.shortlink.entity.URL;
import it.gruppopbdmng5.shortlink.entity.UrlCustom;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UrlService {
    private final DB db;
    private final DBCollection collection;
    private final DBCollection collectionStatistiche;

    public UrlService(DB db) {
        this.db = db;
        this.collection = db.getCollection("url");
        this.collectionStatistiche = db.getCollection("statistiche");
        this.collection.createIndex(new BasicDBObject("click", -1));


        this.collection.createIndex(new BasicDBObject("customURL.URL", 1), "customURL", true);
    }

    public void popoladb() {
        BasicDBObject obj0 = (BasicDBObject) JSON.parse("{\"_id\":\"http://www.google.it\",\"shortURL\":\"http://localhost:8080/#/EwJKLU\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/EwJKLU\",\"statistiche\":{\"num\":6500,\"paesi\":{\"Italy\":1500,\"United States of America\":3000,\"Japan\":2000},\"browser\":{\"Chrome\":5500,\"ChromeMobile\":500,\"Firefox\":500},\"os\":{\"Windows\":6000,\"Android\":250,\"iOS\":250}}}],\"click\":6500}");
        BasicDBObject obj1 = (BasicDBObject) JSON.parse("{\"_id\":\"http://www.imdb.com\",\"shortURL\":\"http://localhost:8080/#/nLikeq\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/nLikeq\",\"statistiche\":{\"num\":650,\"paesi\":{\"Canada\":150,\"Japan\":300,\"United States of America\":200},\"browser\":{\"Chrome\":550,\"ChromeMobile\":50,\"Firefox\":50},\"os\":{\"Windows\":600,\"Android\":25,\"iOS\":25}}},{\"URL\":\"http://localhost:8080/#/asodijoijas\",\"statistiche\":{\"num\":1,\"paesi\":{\"Japan\":1},\"browser\":{\"Chrome\":1},\"os\":{\"Windows\":1}}}],\"click\":651}");
        BasicDBObject obj2 = (BasicDBObject) JSON.parse("{\"_id\":\"http://www.youtube.com\",\"shortURL\":\"http://localhost:8080/#/iI4foh\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/iI4foh\",\"statistiche\":{\"num\":65000,\"paesi\":{\"Canada\":15000,\"Germany\":30000,\"France\":20000},\"browser\":{\"Chrome\":55000,\"ChromeMobile\":5000,\"Firefox\":5000},\"os\":{\"Windows\":60000,\"Android\":2500,\"iOS\":2500}}},{\"URL\":\"http://localhost:8080/#/youtube\",\"statistiche\":{\"num\":11,\"paesi\":{\"United States of America\":11},\"browser\":{\"Chrome\":11},\"os\":{\"Windows\":11}}}],\"click\":65011}");
        BasicDBObject obj3 = (BasicDBObject) JSON.parse("{\"_id\":\"http://www.ondacinema.it\",\"shortURL\":\"http://localhost:8080/#/PNZvQX\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/PNZvQX\",\"statistiche\":{\"num\":50,\"paesi\":{\"Italy\":25,\"Germany\":20,\"United States of America\":5},\"browser\":{\"Chrome\":50},\"os\":{\"Android\":50}}}],\"click\":50}");
        BasicDBObject obj4 = (BasicDBObject) JSON.parse("{\"_id\":\"http://www.ondarock.it\",\"shortURL\":\"http://localhost:8080/#/SNeXwt\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/SNeXwt\",\"statistiche\":{\"num\":100,\"paesi\":{\"Italy\":50,\"Canada\":50},\"browser\":{\"ChromeMobile\":50,\"Firefox\":50},\"os\":{\"Windows\":50,\"Android\":25,\"iOS\":25}}}],\"click\":100}");
        BasicDBObject obj5 = (BasicDBObject) JSON.parse("{\"_id\":\"http://plus.google.com/u/0\",\"shortURL\":\"http://localhost:8080/#/u6mcz3\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/u6mcz3\",\"statistiche\":{\"num\":1000,\"paesi\":{\"Italy\":500,\"United States of America\":300,\"Japan\":200},\"browser\":{\"Chrome\":550,\"ChromeMobile\":50,\"Firefox\":400},\"os\":{\"Windows\":600,\"Android\":25,\"iOS\":375}}}],\"click\":1000}");
        BasicDBObject obj6 = (BasicDBObject) JSON.parse("{\"_id\":\"http://www.facebook.com/home.php\",\"shortURL\":\"http://localhost:8080/#/vrXxIq\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/vrXxIq\",\"statistiche\":{\"num\":650000,\"paesi\":{\"Italy\":150000,\"Japan\":300000,\"France\":200000},\"browser\":{\"Chrome\":550000,\"ChromeMobile\":50000,\"Firefox\":50000},\"os\":{\"Windows\":600000,\"Android\":25000,\"iOS\":25000}}},{\"URL\":\"http://localhost:8080/#/fb\",\"statistiche\":{\"num\":2,\"paesi\":{\"Canada\":2},\"browser\":{\"Chrome\":2},\"os\":{\"Windows\":2}}},{\"URL\":\"http://localhost:8080/#/facebook\",\"statistiche\":{\"num\":5,\"paesi\":{\"France\":5},\"browser\":{\"Firefox\":5},\"os\":{\"Windows\":5}}}],\"click\":650007}");
        BasicDBObject obj7 = (BasicDBObject) JSON.parse("{\"_id\":\"http://twitter.com\",\"shortURL\":\"http://localhost:8080/#/uGnk6y\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/uGnk6y\",\"statistiche\":{\"num\":0,\"paesi\":{},\"browser\":{},\"os\":{}}}],\"click\":0}");
        BasicDBObject obj8 = (BasicDBObject) JSON.parse("{\"_id\":\"http://www.italiansubs.net\",\"shortURL\":\"http://localhost:8080/#/hA73aB\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/hA73aB\",\"statistiche\":{\"num\":0,\"paesi\":{},\"browser\":{},\"os\":{}}}],\"click\":0}");
        BasicDBObject obj9 = (BasicDBObject) JSON.parse("{\"_id\":\"http://www.google.com\",\"shortURL\":\"http://localhost:8080/#/DMuCJK\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/DMuCJK\",\"statistiche\":{\"num\":45000,\"paesi\":{\"Canada\":15000,\"United States of America\":15000,\"France\":15000},\"browser\":{\"Chrome\":15000,\"ChromeMobile\":15000,\"Firefox\":15000},\"os\":{\"Windows\":15000,\"Android\":15000,\"iOS\":15000}}}],\"click\":45000}");
        BasicDBObject obj10 = (BasicDBObject) JSON.parse("{\"_id\":\"http://www.subtitleseeker.com\",\"shortURL\":\"http://localhost:8080/#/dyTCCn\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/dyTCCn\",\"statistiche\":{\"num\":45000,\"paesi\":{\"Italy\":15000,\"Canada\":15000,\"United States of America\":15000},\"browser\":{\"Chrome\":15000,\"ChromeMobile\":15000,\"Firefox\":15000},\"os\":{\"Windows\":15000,\"Android\":15000,\"iOS\":15000}}}],\"click\":0}");
        BasicDBObject obj11 = (BasicDBObject) JSON.parse("{\"_id\":\"http://www.opensubtitles.org/it/search\",\"shortURL\":\"http://localhost:8080/#/OhEWAg\",\"customURL\":[{\"URL\":\"http://localhost:8080/#/OhEWAg\",\"statistiche\":{\"num\":4500,\"paesi\":{\"United States of America\":1500,\"Canada\":1500,\"France\":1500},\"browser\":{\"Chrome\":1500,\"ChromeMobile\":1500,\"Firefox\":1500},\"os\":{\"Windows\":1500,\"Android\":1500,\"iOS\":1500}}}],\"click\":4500}");

        collection.insert(obj0);
        collection.insert(obj1);
        collection.insert(obj2);
        collection.insert(obj3);
        collection.insert(obj4);
        collection.insert(obj5);
        collection.insert(obj6);
        collection.insert(obj7);
        collection.insert(obj8);
        collection.insert(obj9);
        collection.insert(obj10);
        collection.insert(obj11);

        BasicDBObject stats = (BasicDBObject) JSON.parse("{\"num\":6118,\"paesi\":{\"United States of America\":35016,\"Brazil\":3016,\"Russia\":325016,\"Russia\":5676,\"South Africa\":67808,\"China\":405678,\"Canada\":46702,\"France\":236505,\"Italy\":167075,\"Germany\":30020,\"Japan\":302501},\"browser\":{\"Chrome\":1643164,\"ChromeMobile\":987150,\"Firefox\":187505,\"Safari\":27150,\"Opera\":5675},\"os\":{\"Windows\":2712269,\"Android\":957902,\"iOS\":759675,\"Windows Phone\":59375,\"Linux\":24536}}");
        collectionStatistiche.insert(stats);
    }

    public void droppadb() {
        collection.drop();
        collectionStatistiche.drop();
    }

    public void createNewURL(String longURL, String shortURL) {
        URL url = new URL(longURL, shortURL);
        collection.insert(url.getBasicDBObjectClass());
    }

    public String findURLByShortUrl(String shortURL) {
        return ((BasicDBObject) collection.findOne(new BasicDBObject("customURL.URL", shortURL))).getString("_id");
    }

    public URL findUrlByLongURL(String longURL) {
        return new URL((BasicDBObject) collection.findOne(new BasicDBObject("_id", longURL)));
    }

    public void aumentaClick(String url) {
        BasicDBObject query = new BasicDBObject().append("_id", url);
        BasicDBObject newDocument =
                new BasicDBObject().append("$inc",
                        new BasicDBObject().append("click", 1));
        collection.update(query, newDocument);

    }

    public URL findUrlByCustomUrl(String url) {
        return new URL((BasicDBObject) collection.findOne(new BasicDBObject("customURL.URL", url)));
    }

    public List<DBObject> findTopTen() {
        return collection.find().limit(10).sort(new BasicDBObject("click", -1)).toArray();
    }

    public Statistiche prendiStatistiche() {
        try {
            return new Statistiche(findTopTen(), (BasicDBObject) collectionStatistiche.findOne());

        } catch (NullPointerException e) {
            Statistiche statistiche = new Statistiche();
            collectionStatistiche.insert(statistiche.getBasicDBObjectClass());
            return new Statistiche(findTopTen(), (BasicDBObject) collectionStatistiche.findOne());

        }
    }

    public void aggiornaListaCustom(String longURL, String customURL) {
        BasicDBObject query = new BasicDBObject().append("_id", longURL);


        BasicDBObject var = new BasicDBObject("URL", customURL).append("statistiche", new Statistiche().getBasicDBObjectClass());
        BasicDBObject updateDocument = new BasicDBObject();
        ArrayList<BasicDBObject> arrayList = new ArrayList<>();
        arrayList.addAll((Collection<? extends BasicDBObject>) collection.findOne(query).get("customURL"));
        arrayList.add(var);
        updateDocument.append("$set", new BasicDBObject("customURL", arrayList));
        collection.update(query, updateDocument);


    }

    public void aggiornaStatisticheCustomURL(UrlCustom urlCustom) {
        BasicDBObject query = new BasicDBObject("_id", urlCustom.getLongURL());
        ArrayList<BasicDBObject> arrayList = new ArrayList<>();
        arrayList.addAll((Collection<? extends BasicDBObject>) collection.findOne(query).get("customURL"));
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getString("URL").equals(urlCustom.getCustomURL()))
                arrayList.remove(i);
        }
        BasicDBObject var = new BasicDBObject("URL", urlCustom.getCustomURL()).append("statistiche", urlCustom.getStatistiche().getBasicDBObjectClass());
        arrayList.add(var);
        BasicDBObject updateDocument = new BasicDBObject();
        updateDocument.append("$set", new BasicDBObject("customURL", arrayList));
        collection.update(query, updateDocument);
    }

    public void aggiornaStatistiche(Statistiche statistiche) {

        collectionStatistiche.update(new BasicDBObject().append("_id", new ObjectId(statistiche.getId())), statistiche.getBasicDBObjectClass());
    }

    public BasicDBObject prendiStatisticheShortURL(String shortUrl) {
        BasicDBList dbList = (BasicDBList) (collection.findOne(new BasicDBObject("customURL.URL", shortUrl))).get("customURL");
        for (int i = 0; i < dbList.size(); i++) {
            BasicDBObject basicDBObject = (BasicDBObject) dbList.get(i);
            if (basicDBObject.getString("URL").equals(shortUrl))
                return new BasicDBObject((Map) basicDBObject.get("statistiche"));
        }
        return new BasicDBObject();
    }
}
