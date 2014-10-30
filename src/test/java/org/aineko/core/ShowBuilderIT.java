package org.aineko.core;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Modulus on 20/01/14.
 */
public class ShowBuilderIT {

    @Ignore("This needs to be fixed")
    @Test
    public void testShowBuilder(){

        ShowBuilder builder = new ShowBuilder()
                .appendUrl("http://www.dbtv.no")
                .appendShowCollectionId("series")
                .appendShowTag("a")
                .appendIgnoreAttr("#serier")
                .appendReader(new HtmlReader());

        List<Show> shows = builder.build();
        assertTrue(shows.size() >= 17);
        for(Show show : shows){
            assertNotNull(show.getEpisodes());
        }
    }
}
