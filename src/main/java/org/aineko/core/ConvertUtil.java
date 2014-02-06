package org.aineko.core;


import java.sql.Time;

/**
 * Created by Modulus on 06.02.14.
 */
public class ConvertUtil {
    public static int toInteger(Object value) {
        if(value != null && Double.class.isAssignableFrom(value.getClass()) ){
           return ((Double)value).intValue();
        }
        return 0;
    }

    public static Time toTime(Object length) {
        if (length != null && String.class.isAssignableFrom(length.getClass())) {

            String text = (String) length;
            if (!"live".equalsIgnoreCase(text)) {
                return Time.valueOf("00:" + text.toString());
            }
            return Time.valueOf("00:00:00");

        }
       return Time.valueOf("00:00:00");
    }
}
