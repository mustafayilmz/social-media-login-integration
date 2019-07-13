package com.login.integration.socialmedia.constants;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FacebookConstants {
    private static final Logger LOG = Logger.getLogger(FacebookConstants.class);
    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";
    private static final String SCOPE = "email";
    private static final String USER_FIELDS = "id,name,email";
    public static final String FACEBOOK_RETURN_CODE_PARAM = "code";
    public static final int DEFAULT_REQUEST_TIMEOUT = 7000;
    public static final int TOKEN_REQUEST_TIMEOUT = 20000;
    public static final String REDIRECT_URI = "http://localhost:8080/facebook/loginResult";

    public static String getFacebookLoginUri(String redirectUri) {
        try {
            return new StringBuilder("https://www.facebook.com/dialog/oauth?client_id=").append(CLIENT_ID)
                    .append("&redirect_uri=").append(URLEncoder.encode(redirectUri, StandardCharsets.UTF_8.toString()))
                    .append("&scope=").append(SCOPE).toString();
        } catch (UnsupportedEncodingException e) {
            LOG.error(e);
            return "";
        }
    }

    public static String getTokenURI(String redirectUri, String facebookReturnCode) {
        try {
            return new StringBuilder("https://graph.facebook.com/oauth/access_token?client_id=").append(CLIENT_ID)
                    .append("&redirect_uri=").append(URLEncoder.encode(redirectUri, StandardCharsets.UTF_8.toString()))
                    .append("&client_secret=").append(CLIENT_SECRET)
                    .append("&code=").append(facebookReturnCode).toString();
        } catch (UnsupportedEncodingException e) {
            LOG.error(e);
            return "";
        }
    }

    public static String getProfileURI(String accessToken) {
        return new StringBuilder("https://graph.facebook.com/me?access_token=").append(accessToken).toString();
    }

    public static String getUserFieldsURI(String accessToken, String userId) {
        return new StringBuilder("https://graph.facebook.com/").append(userId)
                .append("?fields=").append(USER_FIELDS)
                .append("&access_token=").append(accessToken).toString();
    }
}
