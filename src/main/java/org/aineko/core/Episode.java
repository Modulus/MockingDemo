package org.aineko.core;

import java.net.URL;
import java.sql.Time;

/**
 * Created by Modulus on 22.01.14.
 */
public class Episode {
    private String id;
    private String name;
    private String shortDescription;
    private URL thumbnailUrl;
    private String publishedDate;
    private URL videoStill;
    private Time length;
    private int playsTotal;
    private int playsTrailingWeek;
    private URL videoUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public URL getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(URL thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    /**
     * Convert to Date/Calendar
     * */
    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public URL getVideoStill() {
        return videoStill;
    }

    public void setVideoStill(URL videoStill) {
        this.videoStill = videoStill;
    }

    public Time getLength() {
        return length;
    }

    public void setLength(Time length) {
        this.length = length;
    }

    public int getPlaysTotal() {
        return playsTotal;
    }

    public void setPlaysTotal(int playsTotal) {
        this.playsTotal = playsTotal;
    }

    public int getPlaysTrailingWeek() {
        return playsTrailingWeek;
    }

    public void setPlaysTrailingWeek(int playsTrailingWeek) {
        this.playsTrailingWeek = playsTrailingWeek;
    }

    public URL getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(URL videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", thumbnailUrl=" + thumbnailUrl +
                ", publishedDate='" + publishedDate + '\'' +
                ", videoStill=" + videoStill +
                ", length=" + length +
                ", playsTotal=" + playsTotal +
                ", playsTrailingWeek=" + playsTrailingWeek +
                ", videoUrl=" + videoUrl +
                '}';
    }
}
