import com.mongodb.DB;
import com.mongodb.MongoClient;
import it.gruppopbdmng5.shortlink.presentation.UrlResource;
import it.gruppopbdmng5.shortlink.presentation.UrlService;
import it.gruppopbdmng5.shortlink.utility.Constant;

import static spark.Spark.*;

public class Bootstrap {


    public static void main(String[] args) {
        setIpAddress(Constant.IPSPARK);
        setPort(Constant.PORTSPARK);
        staticFileLocation(Constant.PATHLOCAL);
        try {
            UrlService s = new UrlService(mongo());
            new UrlResource(s);
//           s.droppadb();
//            s.popoladb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static DB mongo() throws Exception {
        MongoClient mongoClient = new MongoClient(Constant.IPMONGO);
        return mongoClient.getDB(Constant.NAMEMONGO);
    }

}
