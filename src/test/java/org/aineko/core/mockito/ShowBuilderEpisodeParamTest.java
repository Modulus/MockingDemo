package org.aineko.core.mockito;

import org.aineko.core.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.aineko.core.TestData.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Modulus on 23.01.14.
 */

@RunWith(Parameterized.class)
public class ShowBuilderEpisodeParamTest {

    private Episode actualEpisode;
    private Episode expectedEpisode;

    @Parameterized.Parameters
    public static Collection<Object[]> getParams(){
        ShowBuilder builder;
        HtmlReader reader;
        reader = mock(HtmlReader.class);
        List<Show> shows = null;
        try {
            when(reader.read(matches("http://www.dbtv.no"))).thenReturn(getRootMarkup());
            when(reader.read(contains("&vid=s1"))).thenReturn(getEpisodeSeries1Markup());
            when(reader.read(contains("&vid=s2"))).thenReturn(getEpisodeSeries2Markup());
            when(reader.read(contains("&vid=s3"))).thenReturn(getEpisodeSeries3Markup());
            builder = new ShowBuilder();

            builder.appendReader(reader).
                    appendShowCollectionId("series").
                    appendShowTag("a").
                    appendIgnoreAttr("#serier").
                    appendUrl("http://www.dbtv.no");

            shows = builder.build();

            Object[][] data = new Object[][] {
                    //Series1
                    { TestData.getSeries1().getEpisodes().get(0), shows.get(0).getEpisodes().get(0)},
                    { TestData.getSeries1().getEpisodes().get(1), shows.get(0).getEpisodes().get(1)},
                    { TestData.getSeries1().getEpisodes().get(2), shows.get(0).getEpisodes().get(2)},

                    //Series2
                    { TestData.getSeries2().getEpisodes().get(0), shows.get(1).getEpisodes().get(0)},
                    { TestData.getSeries2().getEpisodes().get(1), shows.get(1).getEpisodes().get(1)},
                    { TestData.getSeries2().getEpisodes().get(2), shows.get(1).getEpisodes().get(2)},

                    //Series3
                    { TestData.getSeries3().getEpisodes().get(0), shows.get(2).getEpisodes().get(0)},
                    { TestData.getSeries3().getEpisodes().get(1), shows.get(2).getEpisodes().get(1)},
                    { TestData.getSeries3().getEpisodes().get(2), shows.get(2).getEpisodes().get(2)}
            };

            return Arrays.asList(data);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();

    }

    public ShowBuilderEpisodeParamTest(Episode expectedEpisode, Episode currentShow){
        this.actualEpisode = currentShow;
        this.expectedEpisode = expectedEpisode;
    }

    @Test
    public void testEpisodesNotNull(){
        assertNotNull(actualEpisode);
        assertNotNull(expectedEpisode);
    }


    @Test
    public void testId(){
        assertEquals(expectedEpisode.getId(), actualEpisode.getId());
    }

    @Test
    public void testLength(){
        assertEquals(expectedEpisode.getLength(), actualEpisode.getLength());
    }

    @Test
    public void testName(){
        assertEquals(expectedEpisode.getName(), actualEpisode.getName());
    }

    @Test
    public void testPlaysTotal(){
        assertEquals(expectedEpisode.getPlaysTotal(), actualEpisode.getPlaysTotal());
    }

    @Test
    public void testPlaysTrailingWeek(){
        assertEquals(expectedEpisode.getPlaysTrailingWeek(), actualEpisode.getPlaysTrailingWeek());
    }

    @Test
    public void testPublishedDate(){
        assertEquals(expectedEpisode.getPublishedDate(), actualEpisode.getPublishedDate());
    }

    @Test
    public void testShortDescription(){
        assertEquals(expectedEpisode.getShortDescription(), actualEpisode.getShortDescription());
    }

    @Test
    public void testThumbnailUrl(){
        assertEquals(expectedEpisode.getThumbnailUrl(), actualEpisode.getThumbnailUrl());
    }

    @Test
    public void testVideoStill(){
        assertEquals(expectedEpisode.getVideoStill(), actualEpisode.getVideoStill());
    }

    @Test
    public void testVideoUrl(){
        assertEquals(expectedEpisode.getVideoUrl(), actualEpisode.getVideoUrl());
    }

}