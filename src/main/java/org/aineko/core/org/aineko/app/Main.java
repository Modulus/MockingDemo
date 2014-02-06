package org.aineko.core.org.aineko.app;

import org.aineko.core.HtmlReader;
import org.aineko.core.Show;
import org.aineko.core.ShowBuilder;

import java.util.List;

/**
 * Created by Modulus on 06.02.14.
 */
public class Main {

    public static void main(String... args){
        ShowBuilder builder = new ShowBuilder()
                .appendUrl("http://www.dbtv.no")
                .appendShowCollectionId("series")
                .appendShowTag("a")
                .appendIgnoreAttr("#serier")
                .appendReader(new HtmlReader());

        List<Show> shows = builder.build();
        for(Show show : shows){
            System.out.println(show);
        }
    }
}
