package org.aineko.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Time;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Modulus on 06.02.14.
 */
@RunWith(Parameterized.class)
public class ConverterUtilIntegerParamTest {

    private final Double actualDouble;
    private final int expectedTime;

    @Parameterized.Parameters
    public static Collection<Object[]> getParams(){
        return Arrays.asList(new Object[][]{
                {null, 0},
                {1.0, 1},
                {1.5, 1},
                {123.421, 123},
                {421.09928123213124, 421},
                {123213123.7899123798213, 123213123},
                {98190218.2, 98190218},
                {8908.98887, 8908},

        });
    }

    public ConverterUtilIntegerParamTest(Double actualDouble, int expectedInt){
        this.actualDouble = actualDouble;
        this.expectedTime = expectedInt;
    }

    @Test
    public void testValues(){
        assertEquals(ConvertUtil.toInteger(actualDouble), expectedTime);
    }


}
