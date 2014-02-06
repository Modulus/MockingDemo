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
public class ConverterUtilTimeParamTest {

    private final String actualString;
    private final Time expectedTime;

    @Parameterized.Parameters
    public static Collection<Object[]> getParams(){
        return Arrays.asList(new Object[][]{
                {"LIVE", Time.valueOf("00:00:00")},
                {"live", Time.valueOf("00:00:00")},
                {"Live", Time.valueOf("00:00:00")},
                {"LiVe", Time.valueOf("00:00:00")},
                {"liVE", Time.valueOf("00:00:00")},
                {"LIVe", Time.valueOf("00:00:00")},
                {"58:01", Time.valueOf("00:58:01")},
                {"99:99", Time.valueOf("00:99:99")},
                {null, Time.valueOf("00:00:00")},
                {"", Time.valueOf("00:00:00")},

        });
    }

    public ConverterUtilTimeParamTest(String actualString, Time expectedTime){
        this.actualString = actualString;
        this.expectedTime = expectedTime;
    }

    @Test
    public void testValues(){
        assertEquals(ConvertUtil.toTime(actualString), expectedTime);
    }


}
