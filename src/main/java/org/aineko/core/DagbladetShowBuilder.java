package org.aineko.core;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.*;

/**
 * Created by JohnSigvald on 20/01/14.
 */
public class DagbladetShowBuilder  {
    private String url;
    private String divId;

    public DagbladetShowBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public DagbladetShowBuilder withShowCollectionId(String id) {
        this.divId = id;
        return this;
    }


    public List<Show> build() {
        List<Show> shows = new ArrayList<Show>();
        try {
            Document doc = getDocument("http://www.dbtv.no");
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


                    String showDetails = getShowDetails(element.baseUri(),element.attr("href").substring(1));

                    try {
                    Gson gson = new Gson();
                  ArrayList<LinkedTreeMap> detailsList = gson.fromJson(showDetails, ArrayList.class);
                    List<Episode> episodes = new ArrayList<Episode>();
                        for(LinkedTreeMap<String, String> map : detailsList){
                            Episode episode = new Episode();
//                            episode.setId(map.get("id"));
                            episode.setName(map.get("name"));
                            episode.setShortDescription(map.get("shortDescription"));
                            episode.setThumbnailUrl(new URL(map.get("thumbnailUrl")));
                            episode.setPublishedDate(map.get("publishedDate"));
                            episode.setVideoStill(new URL(map.get("videoStillUrl")));
//                            episode.setLength(Time.valueOf(map.get("length")));
//                            episode.setPlaysTotal(Integer.valueOf(map.get("playsTotal")));
//                            episode.setPlaysTrailingWeek(Integer.valueOf(map.get("playsTrailingWeek")));
                            episode.setVideoUrl(new URL(map.get("url")));

                            episodes.add(episode);
                        }
                        show.setEpisodes(episodes);
                        shows.add(show);
                    }
                    catch (JsonSyntaxException e){
                        e.printStackTrace();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return shows;
        }

    }

    protected String getShowDetails(String baseUri, String showName) {
        StringBuilder episodeUrlBuilder = new StringBuilder();
        episodeUrlBuilder.append(baseUri).append("?op=ContentTail&t=q&vid=")
                .append(showName)
                .append("&inapp=");

        StringBuilder content = new StringBuilder();

        try {
            URL url  = new URL(episodeUrlBuilder.toString());
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

    protected Document getDocument(String url) throws IOException {
        return Jsoup.connect(url).get();
    }
}
