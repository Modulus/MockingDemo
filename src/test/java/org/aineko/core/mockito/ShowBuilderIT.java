package org.aineko.core.mockito;

import org.aineko.core.HtmlReader;
import org.aineko.core.Show;
import org.aineko.core.ShowBuilder;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Modulus on 20/01/14.
 */
public class ShowBuilderIT {

    @Test
    public void testShowBuilder(){

        ShowBuilder builder = new ShowBuilder().
                withUrl("http://www.dbtv.no").
                withShowCollectionId("#serier").
                withReader(new HtmlReader());

        List<Show> shows = builder.build();
        assertTrue(shows.size() >= 17);
        for(Show show : shows){
            assertNotNull(show.getEpisodes());
        }
    }
}
