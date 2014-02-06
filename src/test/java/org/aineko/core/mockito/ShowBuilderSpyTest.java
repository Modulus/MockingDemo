package org.aineko.core.mockito;

import org.aineko.core.HtmlReader;
import org.aineko.core.Show;
import org.aineko.core.ShowBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.net.MalformedURLException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by modulus on 25/01/14.
 * */
public class ShowBuilderSpyTest {
    private ShowBuilder spyBuilder;
    private HtmlReader reader;

    @Before
    public void setUp() throws MalformedURLException {
        ShowBuilder originalBuilder = new ShowBuilder();
        reader = mock(HtmlReader.class);
        when(reader.read(anyString())).thenReturn("");

        spyBuilder = spy(originalBuilder);
        when(spyBuilder.withReader(any(HtmlReader.class))).thenCallRealMethod();
        when(spyBuilder.withShowCollectionId(anyString())).thenCallRealMethod();
        when(spyBuilder.withUrl(anyString())).thenCallRealMethod();
        when(spyBuilder.build()).thenReturn(new ArrayList<Show>());

    }

    @Test
    public void testSpy() {
        spyBuilder.withReader(reader).withShowCollectionId("#finnesikke").withUrl("http://fjasogvas.no");

        assertTrue(spyBuilder.build().isEmpty());
    }
}