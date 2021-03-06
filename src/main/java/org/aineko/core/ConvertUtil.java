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
        else if(value != null && String.class.isAssignableFrom(value.getClass()) ){
            String text = (String)value;
            if( text.isEmpty()){
                return 0;
            }
            else {
                if(text.contains(".")){
                    return Integer.valueOf((text.split("\\."))[0]);
                }
                return Integer.valueOf(value.toString());
            }
        }
        return 0;
    }


    public static String convertId(Object value){

        if(value != null && String.class.isAssignableFrom(value.getClass())){
            return value.toString();
        }
        else if (value != null && Double.class.isAssignableFrom(value.getClass())) {
            StringBuilder sb = new StringBuilder();
            String text = value.toString();

            if(text.contains(".")){
                String[] parts = text.split("\\.");
                sb.append(parts[0]);

                if(text.contains("E")){
                    String lastPart = parts[1].substring(0, (parts[1]).indexOf("E"));
                    sb.append(lastPart);
                }
            }



            return sb.toString();
        }
        return "";
    }

    public static Time toTime(Object length) {
        if (length != null && String.class.isAssignableFrom(length.getClass())) {

            String text = (String) length;
            if(text.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")){
                return Time.valueOf(text);
            }
            else if(text.matches("\\d{1,2}:\\d{1,2}")){
                return Time.valueOf(String.format("00:%s",text));
            }
            else if(text.matches("\\d{1,2}")){
                return Time.valueOf(String.format("00:00:%s", text));
            }
            return Time.valueOf("00:00:00");
        }
       return Time.valueOf("00:00:00");
    }
}

