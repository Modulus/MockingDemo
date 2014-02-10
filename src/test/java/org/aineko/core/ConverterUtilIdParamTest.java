package org.aineko.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Modulus on 10.02.14.
 */

@RunWith(Parameterized.class)
public class ConverterUtilIdParamTest {
    private String expectedId;
    private Double actualId;


    @Parameterized.Parameters
    public static Collection<Object[]> getParams(){
        return Arrays.asList(new Object[][]{
                {"1878692615001", 1.878692615001E12 },
                { "1", 1.0},
                {"123", 123.123,}


        });
    }

    public ConverterUtilIdParamTest(String expectedId, Double actualId){
        this.expectedId = expectedId;
        this.actualId = actualId;
    }

    @Test
    public void testId(){
        assertEquals(expectedId, ConvertUtil.convertId(actualId));
    }
}
