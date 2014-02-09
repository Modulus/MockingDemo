package org.aineko.core.mockito;

import org.aineko.core.HtmlReader;
import org.aineko.core.Show;
import org.aineko.core.ShowBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;
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
@Ignore
@RunWith(Parameterized.class)
public class ShowBuilderParamTest {

    private Show show;

    @Parameterized.Parameters
    public static Collection<Object[]> getParams(){
        ShowBuilder builder;
        HtmlReader reader;
        reader = mock(HtmlReader.class);
        List<Show> shows = null;
        try {
            builder = new ShowBuilder();

            builder.appendReader(reader).
                    appendShowCollectionId("series").
                    appendShowTag("a").
                    appendIgnoreAttr("#serier").
                    appendUrl("http://www.dbtv.no");

            shows = builder.build();

            throw new MalformedURLException();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Object[][] data = new Object[][] { { shows.get(0) }, { shows.get(1) }, { shows.get(2) }};

        return Arrays.asList(data);
    }

    public ShowBuilderParamTest(Show currentShow){
        this.show = currentShow;
    }

    @Test
    public void verifyShow(){
        assertNotNull(show);
    }

    @Test
    public void verifyEpisodes(){
        assertEquals("Failed for show %s".format(show.getName()), 3, show.getEpisodes().size());
    }

}