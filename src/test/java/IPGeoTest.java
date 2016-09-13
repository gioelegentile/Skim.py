import it.gruppopbdmng5.shortlink.utility.IPGeo;
import junit.framework.TestCase;


public class IPGeoTest extends TestCase {

    private String[] cases = {
            "23.26.134.156",
            "23.17.167.88",
            "93.186.143.1",
            "5.149.31.72",
            "31.43.63.1",
            "1.0.31.255",
            "5.2.127.12",
            "37.219.11.96",
            "5.8.239.72",
            "2.247.27.189",
            "189.201.191.162",
            "105.183.144.32",
            "5.243.54.77",
            "5.158.63.173",
            "41.57.63.13",
            "117.74.111.23",
            "181.16.127.95",
            "179.60.63.37",
            "5.178.63.129",
            "64.66.15.246"
    };

    private String[] expected = {
            "United States",
            "Canada",
            "Italy",
            "Switzerland",
            "Ukraine",
            "Japan",
            "United Kingdom",
            "Finland",
            "Russia",
            "Germany",
            "Mexico",
            "Egypt",
            "Sweden",
            "Portugal",
            "South Africa",
            "Australia",
            "Argentina",
            "Ecuador",
            "Slovak Republic",
            "Bahamas"
    };

    private String[] result;


    public void setUp() throws Exception {
        super.setUp();
        result = new String[cases.length];

    }

    public void tearDown() throws Exception {
        super.tearDown();
        result = null;
    }

    public void testGetCountry() throws Exception {
        for (int i = 0; i < cases.length; i++) {
            result[i] = IPGeo.getCountry(cases[i]);
            assertTrue("CASE: " + (i + 1) + " EXPECTED: " + expected[i]
                    + " RESULT: " + result[i], result[i].equals(expected[i]));
        }
    }
}