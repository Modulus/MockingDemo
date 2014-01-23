package org.aineko.core.mockito;

import org.aineko.core.HtmlReader;
import org.aineko.core.Show;
import org.aineko.core.ShowBuilder;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.aineko.core.TestData.getRootMarkup;
import static org.aineko.core.TestData.getEpisodeSeries1Markup;
import static org.aineko.core.TestData.getEpisodeSeries2Markup;
import static org.aineko.core.TestData.getEpisodeSeries3Markup;

/**
 * Created by Modulus on 22.01.14.
 */
public class ShowBuilderTest {
    private ShowBuilder builder;
    private HtmlReader reader;



    @Before
    public void setUp() throws MalformedURLException {
        reader = mock(HtmlReader.class);
        when(reader.read(matches("http://www.dbtv.no"))).thenReturn(getRootMarkup());
        when(reader.read(contains("&vid=s1"))).thenReturn(getEpisodeSeries1Markup());
        when(reader.read(contains("&vid=s2"))).thenReturn(getEpisodeSeries2Markup());
        when(reader.read(contains("&vid=s3"))).thenReturn(getEpisodeSeries3Markup());
        builder = new ShowBuilder();
    }


    @Test
    public void testBuild(){
        builder.withReader(reader).withShowCollectionId("#serier").withUrl("http://www.dbtv.no");
        List<Show> shows = builder.build();

        assertEquals(shows.size(), 3);
    }




}
