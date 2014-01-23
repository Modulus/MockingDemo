package org.aineko.core;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by JohnSigvald on 20/01/14.
 */
public class DagbladetShowBuilderIT {

    @Test
    public void test(){

        DagbladetShowBuilder builder = new DagbladetShowBuilder().
                withUrl("http://www.dbtv.no").
                withShowCollectionId("#serier").withReader(new HtmlReader());
        List<Show> shows = builder.build();
        assertTrue(shows.size() >= 17);
        for(Show show : shows){
            assertNotNull(show.getEpisodes());
//            assertTrue("Failed for show " + show.getName()+ ", link: "+show.getUrl(), show.getEpisodes().size() > 0);
        }
    }
}
