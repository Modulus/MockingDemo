package org.aineko.core;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Modulus on 20/01/14.
 */
public class ShowBuilder {
    private String url;
    private String divId;
    private String showTagName;
    private List<String> ignoreAttributes;
    private HtmlReader reader;

    public ShowBuilder appendUrl(String url) {
        this.url = url;
        return this;
    }

    public ShowBuilder appendShowCollectionId(String id) {
        this.divId = id;
        return this;
    }

    public ShowBuilder appendReader(HtmlReader reader){
        this.reader = reader;
        return this;
    }

    public ShowBuilder appendShowTag(String tagName){
        this.showTagName = tagName;
        return this;
    }

    public ShowBuilder appendIgnoreAttr(String... ignoreAttributes){
        if(ignoreAttributes != null){
            this.ignoreAttributes = Arrays.asList(ignoreAttributes);
        }
        else {
            this.ignoreAttributes = null;
        }
        return this;
    }

    public List<Show> build() {
        List<Show> shows = new ArrayList<Show>();
        try {
            String rootHtml = reader.read(url);
            Document doc = Jsoup.parse(rootHtml);
            Element seriesDiv = doc.getElementById(divId);
            Elements showAnchors = seriesDiv.getElementsByTag(showTagName);

            for (Element element : showAnchors) {
                String currentShowHref = element.attr("href");
                if (!ignoreAttributes.contains(currentShowHref)) {
                    Show show = extractShowInfo(element, currentShowHref);
                    List<Episode> episodes = extractEpisodeInfo(element);
                    show.setEpisodes(episodes);
                    shows.add(show);
                }

            }
        } catch (MalformedURLException e){
            e.printStackTrace();

        } finally {
            return shows;
        }

    }

    protected List<Episode> extractEpisodeInfo(Element element) {
        String showDetails = getShowDetails(url,element.attr("href").substring(1));
        List<Episode> episodes = new ArrayList<Episode>();
        try {
            episodes = getEpisodes(showDetails);
        }
        catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        finally {
            return episodes;
        }
    }

    protected Show extractShowInfo(Element element, String currentShowHref) throws MalformedURLException {
        Show show = new Show();
        StringBuilder showRootUrlBuilder = new StringBuilder();
        showRootUrlBuilder.append(url).append(currentShowHref);
        show.setUrl(new URL(showRootUrlBuilder.toString()));
        show.setName(element.text());
        return show;
    }

    protected List<Episode> getEpisodes(String showDetails) throws MalformedURLException {
        Gson gson = new Gson();
        ArrayList<LinkedTreeMap> detailsList = gson.fromJson(showDetails, ArrayList.class);
        List<Episode> episodes = new ArrayList<Episode>();
        for(LinkedTreeMap<String, String> map : detailsList){
            Episode episode = new Episode();
            episode.setId(String.valueOf(map.get("id")));
            episode.setName(map.get("name"));
            episode.setShortDescription(map.get("shortDescription"));
            episode.setThumbnailUrl(new URL(map.get("thumbnailUrl")));
            episode.setPublishedDate(map.get("publishedDate"));
            episode.setVideoStill(new URL(map.get("videoStillUrl")));
            episode.setLength(ConvertUtil.toTime(map.get("length")));
            episode.setPlaysTotal(ConvertUtil.toInteger(map.get("playsTotal")));
            episode.setPlaysTrailingWeek( ConvertUtil.toInteger(map.get("playsTrailingWeek")));
            episode.setVideoUrl(new URL(map.get("url")));

            episodes.add(episode);
        }
        return episodes;
    }

    protected String getShowDetails(String baseUri, String showName) {
        StringBuilder episodeUrlBuilder = new StringBuilder();
        episodeUrlBuilder.append(baseUri).append("?op=ContentTail&t=q&vid=")
                .append(showName)
                .append("&inapp=");

        String content = "";

        try {
            content =  reader.read(episodeUrlBuilder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return content;

    }


}