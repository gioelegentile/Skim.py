import it.gruppopbdmng5.shortlink.utility.UserAgentInfo;
import junit.framework.TestCase;

public class UserAgentInfoTest extends TestCase {

    private String[] cases = {
            "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_4) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.27 Safari/536.11",
            "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0",
            "Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 920)",
            "Opera/12.02 (Android 4.1; Linux; Opera Mobi/ADR-1111101157; U; en-US) Presto/2.9.201 Version/12.02",
            "Mozilla/5.0 (iPad; CPU OS 7_0 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53",
            "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_4) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2",
            "Mozilla/5.0 (X11; Linux i586; rv:31.0) Gecko/20100101 Firefox/31.0",
            "Mozilla/5.0 (iPhone; U; CPU iPhone OS 5_1_1 like Mac OS X; en) AppleWebKit/534.46.0 (KHTML, like Gecko) CriOS/19.0.1084.60 Mobile/9B206 Safari/7534.48.3"
    };

    private String[] expectedOS = {
            "Windows",
            "OS X",
            "Windows",
            "Windows",
            "Android",
            "iOS",
            "Android",
            "OS X",
            "Linux",
            "iOS"
    };

    private String[] expectedBrowser = {
            "Chrome",
            "Chrome",
            "Firefox",
            "IE Mobile",
            "Opera Mobile",
            "Mobile Safari",
            "Chrome Mobile",
            "Safari",
            "Firefox",
            "Chrome Mobile"
    };

    private UserAgentInfo[] results;

    public void setUp() throws Exception {
        results = new UserAgentInfo[cases.length];
        super.setUp();
    }

    public void tearDown() throws Exception {
        results = null;
        super.tearDown();
    }

    public void testGetOS() throws Exception {
        for(int i = 0; i < cases.length; i++) {
            results[i] = new UserAgentInfo(cases[i]);
            assertTrue("CASE: " + (i + 1) + " EXPECTED: " + expectedOS[i]
                    + " RESULT: " + results[i].getOS(), results[i].getOS().equals(expectedOS[i]));
        }
    }

    public void testGetBrowser() throws Exception {
        for(int i = 0; i < cases.length; i++) {
            results[i] = new UserAgentInfo(cases[i]);
            assertTrue("CASE: " + (i + 1) + " EXPECTED: " + expectedBrowser[i]
                    + " RESULT: " + results[i].getBrowser(), results[i].getBrowser().equals(expectedBrowser[i]));
        }
    }
}