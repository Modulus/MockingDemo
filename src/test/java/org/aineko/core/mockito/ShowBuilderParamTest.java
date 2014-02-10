package org.aineko.core.mockito;

import org.aineko.core.HtmlReader;
import org.aineko.core.Show;
import org.aineko.core.ShowBuilder;
import org.aineko.core.TestData;
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
public class ShowBuilderParamTest {

    private Show excpectedShow;
    private Show actualShow;


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
                    { TestData.getSeries1(), shows.get(0)},
                    { TestData.getSeries2(), shows.get(1) },
                    { TestData.getSeries3(), shows.get(2) }};

            return Arrays.asList(data);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();

    }

    public ShowBuilderParamTest(Show expectedShow, Show actualShow){
        this.excpectedShow = expectedShow;
        this.actualShow = actualShow;
    }

    @Test
    public void verifyShow(){
        assertNotNull(actualShow);
    }

    @Test
    public void testEpisodesSize(){
        assertEquals("Failed for show %s".format(actualShow.getName()), excpectedShow.getEpisodes().size(), actualShow.getEpisodes().size());
    }

    @Test
    public void testName(){
        assertEquals(excpectedShow.getName(), actualShow.getName() );
    }

    @Test
    public void test(){
        assertEquals(excpectedShow.getUrl(), actualShow.getUrl());
    }

}