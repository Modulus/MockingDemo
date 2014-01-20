package org.aineko.core;

import java.net.URL;

/**
 * Created by JohnSigvald on 20/01/14.
 */
public class Show {
    private URL url;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Show{" +
                "url=" + url +
                ", name='" + name + '\'' +
                '}';
    }
}
