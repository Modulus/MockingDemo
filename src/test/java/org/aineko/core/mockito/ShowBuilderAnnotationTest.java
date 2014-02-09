package org.aineko.core.mockito;

import org.aineko.core.HtmlReader;
import org.aineko.core.Show;
import org.aineko.core.ShowBuilder;
import org.junit.Before;
import org.junit.Ignore;
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
@Ignore
//@RunWith(MockitoJUnitRunner.class)
public class ShowBuilderAnnotationTest {
    private ShowBuilder builder;

    @Mock
    private HtmlReader reader;



    @Before
    public void setUp() throws MalformedURLException {

//        MockitoAnnotations.initMocks(this);


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



        assertEquals(shows.size(), 3);
    }




}