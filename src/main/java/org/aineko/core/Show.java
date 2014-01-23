package org.aineko.core;

import java.net.URL;
import java.util.List;

/**
 * Created by Modulus on 20/01/14.
 */
public class Show {
    private URL url;
    private String name;

    List<Episode> episodes;

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

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
                ", episodes=" + episodes +
                '}';
    }
}
