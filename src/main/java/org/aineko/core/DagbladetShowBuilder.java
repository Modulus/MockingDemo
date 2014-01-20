package org.aineko.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by JohnSigvald on 20/01/14.
 */
public class DagbladetShowBuilder implements ShowBuilder {
    private String url;
    private String divId;

    public ShowBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public ShowBuilder withShowCollectionId(String id) {
        this.divId = id;
        return this;
    }


    public List<Show> build() {
        List<Show> shows = new ArrayList<Show>();
        try {
            Document doc = Jsoup.connect("http://www.dbtv.no").get();
            Element seriesDiv = doc.getElementById("series");
            Elements showAnchors = seriesDiv.getElementsByTag("a");

            for (Element element : showAnchors) {
                String currentShowHref = element.attr("href");
                if (!currentShowHref.equalsIgnoreCase("#serier")) {
                    Show show = new Show();
                    StringBuilder showRootUrlBuilder = new StringBuilder();
                    showRootUrlBuilder.append(element.baseUri()).append(currentShowHref);
                    show.setUrl(new URL(showRootUrlBuilder.toString()));
                    show.setName(element.text());
                    shows.add(show);

                    StringBuilder episodeUrlBuilder = new StringBuilder();
                    episodeUrlBuilder.append(element.baseUri()).append("?op=ContentTail&t=q&vid=")
                            .append(show.getName())
                            .append("&inapp=");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return shows;
        }

    }
}
