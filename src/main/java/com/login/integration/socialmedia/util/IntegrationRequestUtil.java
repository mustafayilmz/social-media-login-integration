package com.login.integration.socialmedia.util;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Component
public class IntegrationRequestUtil {

    public String sendGetRequest(String address, int timeout) throws IOException {
        URL url = new URL(address);
        URLConnection conn = url.openConnection();
        conn.setConnectTimeout(timeout);
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null){
            output.append(line);
        }
        return output.toString();
    }
}
