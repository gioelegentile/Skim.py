package it.gruppopbdmng5.shortlink.utility;

import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;

public class UserAgentInfo {
    private ReadableUserAgent agent;

    public UserAgentInfo(String userAgent) {
        UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
        this.agent = parser.parse(userAgent);
    }

    public String getOS() {
        return agent.getOperatingSystem().getFamilyName();
    }

    public String getBrowser() {
        return agent.getFamily().getName();
    }
}
