package org.aineko.core.mockito;

import org.aineko.core.HtmlReader;
import org.aineko.core.Show;
import org.aineko.core.ShowBuilder;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.List;

import static org.aineko.core.TestData.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.argThat;
import static org.mockito.Mockito.*;

/**
 * Created by Modulus on 22.01.14.
 */
public class ShowBuilderTest {
    private ShowBuilder builder;
    private HtmlReader reader;



    @Before
    public void setUp() throws MalformedURLException {


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
        /**
         * Print for debug
         * */
        for(Show show : shows){
            System.out.println(show);
        }

        //Verify Reader's read method calld once with http://www.dbtv.no


        //Verify Reader's read method called 4 times in total


        //Verify Reader's read method called 3 times for each of the shows(Add 3 verify statements)




        assertEquals(shows.size(), 3);
    }

    @Test
    public void testReaderMalformedURLException(){
        builder.appendReader(reader).
                appendShowCollectionId("exception").
                appendShowCollectionId("a").
                appendUrl("http://wwww.vgtv.no");

        assertTrue(builder.build().isEmpty());
    }






    private class ContainsMatcher extends BaseMatcher<String> {
        private  String text;

        public ContainsMatcher(String text){
            this.text = text;
        }

        @Override
        public boolean matches(Object o) {

                return ((String)o).contains(text);
        }

        @Override
        public void describeMismatch(Object o, Description description) {
            description.appendValue(o).appendText("Does not match ").appendValue(text);

        }

        @Override
        public void describeTo(Description description) {
            description.appendText("Should match ").appendValue(text);
        }
    }
}
