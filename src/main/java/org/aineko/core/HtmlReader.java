package org.aineko.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Modulus on 23.01.14.
 */
public class HtmlReader {

    public String read(String url) throws MalformedURLException {
        if(url != null && !url.isEmpty()){
            return read(new URL(url));
        }
        return null;
    }

    public String read(URL url){
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while((line = reader.readLine()) != null){
                content.append(line);
            }
            reader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}