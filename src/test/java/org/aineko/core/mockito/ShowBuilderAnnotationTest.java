package org.aineko.core.mockito;

import org.aineko.core.HtmlReader;
import org.aineko.core.Show;
import org.aineko.core.ShowBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.MalformedURLException;
import java.util.List;

import static org.aineko.core.TestData.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.*;

/**
 * Created by Modulus on 22.01.14.
 * This is an exact copy of ShowBuilderTest, but with Mockito annotations
 */

//@RunWith(MockitoJUnitRunner.class)
public class ShowBuilderAnnotationTest {
    private ShowBuilder builder;

    @Mock
    private HtmlReader reader;



    @Before
    public void setUp() throws MalformedURLException {

        MockitoAnnotations.initMocks(this);
        when(reader.read(matches("http://www.dbtv.no"))).thenReturn(getRootMarkup());
        when(reader.read(contains("&vid=s1"))).thenReturn(getEpisodeSeries1Markup());
        when(reader.read(contains("&vid=s2"))).thenReturn(getEpisodeSeries2Markup());
        when(reader.read(matches("http://www.dbtv.no.*&vid=s3.*"))).thenReturn(getEpisodeSeries3Markup());

        builder = new ShowBuilder();
    }


    @Test
    public void testBuild() throws MalformedURLException {

        builder.appendReader(reader).
                appendShowCollectionId("series").
                appendShowTag("a").
                appendIgnoreAttr("#serier").
                appendUrl("http://www.dbtv.no");

        List<Show> shows = builder.build();

        //Verify Reader's read method calld once with http://www.dbtv.no
        verify(reader, times(1)).read("http://www.dbtv.no");

        //Verify Reader's read method called 4 times in total
        verify(reader, times(4)).read(anyString());
        verify(reader, atMost(4)).read(anyString());

        //Verify Reader's read method called 3 times for each of the 3 shows
        verify(reader, times(1)).read("http://www.dbtv.no?op=ContentTail&t=q&vid=s1&inapp=");
        verify(reader, times(1)).read(matches(".*vid=s2.*"));
        verify(reader, times(1)).read(matches("^http://www.dbtv.no.*&vid=s3.*"));

        verify(reader, atLeast(1)).read("http://www.dbtv.no?op=ContentTail&t=q&vid=s3&inapp=");
        verify(reader, atMost(1)).read("http://www.dbtv.no?op=ContentTail&t=q&vid=s3&inapp=");


        assertEquals(shows.size(), 3);
    }




}