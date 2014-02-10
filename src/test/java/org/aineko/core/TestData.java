package org.aineko.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Modulus on 23.01.14.
 */
public class TestData {

    public static String getRootMarkup() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div id='series'>");
        sb.append("<a href='#serier'>Series</a>");
        sb.append("<a href='/s1'>Series 1</a>");
        sb.append("<a href='/s2'>Series 2</a>");
        sb.append("<a href='/s3'>Series 3</a>");
        sb.append("</div>");
        return sb.toString();
    }

    public static Show getSeries1() throws MalformedURLException {
        List<Episode>  episodes = Arrays.asList(
                    new Episode("11", "Episode 1 of Series 1", "First Episode ever!", new URL("http://www.tullball.no/shows/s1.jpg"),
                            "01.01.2001", new URL("http://www.tullball.no/shows/s1/e1.jpg"), Time.valueOf("00:89:59"),
                            1234, 35, new URL("http://www.tullball.no/shows/s1/e1.mkv")),
                    new Episode("12", "Episode 2 of Series 1", "Second episode", new URL("http://www.tullball.no/shows/s1.jpg"),
                            "14.01.2001", new URL("http://www.tullball.no/shows/s1/e2.jpg"), Time.valueOf("00:09:30"),
                            114040, 2134, new URL("http://www.tullball.no/shows/s1/e2.mkv")),
                    new Episode("13", "Episode 3 of Series 1", "Last episode buhu!!!", new URL("http://www.tullball.no/shows/s1/e3.jpg"),
                            "20.01.2001", new URL("http://www.tullball.no/shows/s1.jpg"), Time.valueOf("00:89:59"),
                            56, 11, new URL("http://www.tullball.no/shows/s1/e3.mkv")));

        return new Show(new URL("http://www.dbtv.no/s1"), "Series 1", episodes);
    }


    public static String getEpisodeSeries1Markup() {

        return "[{'id':11,"+
                "'name':'Episode 1 of Series 1', 'shortDescription': 'First Episode ever!', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s1.jpg', 'publishedDate':'01.01.2001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s1/e1.jpg', 'url': 'http://www.tullball.no/shows/s1/e1.mkv'," +
                "'length':'89:59', 'playsTotal':'1234', 'playsTrailingWeek': '35'},"+
                "{'id': 12, 'name':'Episode 2 of Series 1', 'shortDescription': 'Second episode', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s1.jpg', 'publishedDate':'14.01.2001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s1/e2.jpg', 'url': 'http://www.tullball.no/shows/s1/e2.mkv'," +
                "'length':'9:30', 'playsTotal':'114040','playsTrailingWeek': '2134'}, "+
                "{'id':13, 'name':'Episode 3 of Series 1', 'shortDescription': 'Last episode buhu!!!', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s1/e3.jpg', 'publishedDate':'20.01.2001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s1.jpg', " +
                "'length':'89:59','playsTotal':'56', 'playsTrailingWeek': '11',"+
                "'url': 'http://www.tullball.no/shows/s1/e3.mkv'}]";
    }

    public static Show getSeries2() throws MalformedURLException{

        List<Episode> episodes = Arrays.asList(
                new Episode("21", "Episode 1 of Series 2", "First Episode of Series2!", new URL("http://www.tullball.no/shows/s2.jpg"),
                        "28.05.2011", new URL("http://www.tullball.no/shows/s2/s1.jpg"),
                Time.valueOf("00:89:59"), 56, 11, new URL("http://www.tullball.no/shows/s2/e1.mkv")),
                new Episode("22", "Episode 2 of Series 2", "Second episode of Series2", new URL("http://www.tullball.no/shows/s1.jpg"),
                        "28.06.2011", new URL("http://www.tullball.no/shows/s1/e2.jpg"),
                        Time.valueOf("00:89:59"), 56, 11, new URL("http://www.tullball.no/shows/s2/e2.mkv")),
                new Episode("23", "Episode 3 of Series 2", "Last episode of Series3!!!", new URL("http://www.tullball.no/shows/s2/e3.jpg"),
                        "29.12.2013", new URL("http://www.tullball.no/shows/s2/e3.jpg"), Time.valueOf("00:89:59"), 56, 11,
                        new URL("http://www.tullball.no/shows/s2/e3.mkv"))
        );

        return new Show(new URL("http://www.dbtv.no/s2"), "Series 2", episodes);
    }


    public static String getEpisodeSeries2Markup() {

        return "[{'id':21, 'name':'Episode 1 of Series 2', 'shortDescription': 'First Episode of Series2!', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s2.jpg', 'publishedDate':'28.05.2011',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s2/s1.jpg', 'url': 'http://www.tullball.no/shows/s2/e1.mkv', "+
                "'length':'89:59','playsTotal':'56', 'playsTrailingWeek': '11'}, "+
                "{'id':22, 'name':'Episode 2 of Series 2', 'shortDescription': 'Second episode of Series2', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s1.jpg', 'publishedDate':'28.06.2011',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s1/e2.jpg', 'url': 'http://www.tullball.no/shows/s2/e2.mkv',"+
                "'length':'89:59','playsTotal':'56', 'playsTrailingWeek': '11'},"+
                "{'id': 23, 'name':'Episode 3 of Series 2', 'shortDescription': 'Last episode of Series3!!!', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s2/e3.jpg', 'publishedDate':'29.12.2013',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s2/e3.jpg', 'length':'89:59','playsTotal':'56', 'playsTrailingWeek': '11',"+
                " 'url': 'http://www.tullball.no/shows/s2/e3.mkv'}]";
    }

    public static Show getSeries3() throws MalformedURLException{
        List<Episode> episodes = Arrays.asList(
            new Episode("31", "Episode 1 of Series 3", "Learn mocking", new URL("http://www.tullball.no/shows/s3.jpg"),
                    "01.01.2014", new URL("http://www.tullball.no/shows/s3/e1.jpg"),
                    Time.valueOf("00:89:59"), 56, 11, new URL("http://www.tullball.no/shows/s3/e1.mkv")),
            new Episode("32", "Episode 2 of Series 3", "Apply Mocking", new URL("http://www.tullball.no/shows/s3.jpg"),
                    "14.01.2014", new URL("http://www.tullball.no/shows/s1/e2.jpg"),
                Time.valueOf("00:89:59"), 56, 11, new URL("http://www.tullball.no/shows/s3/e2.mkv")),
            new Episode("33", "Episode 3 of Series 3", "What about integration tests you bloody idiot??!!!",
                    new URL("http://www.tullball.no/shows/s3/e3.jpg"),
                    "21.01.2014", new URL("http://www.tullball.no/shows/s3/e3.jpg"),
                    Time.valueOf("00:89:59"), 56, 11, new URL("http://www.tullball.no/shows/s3/e3.mkv"))
        );

        return new Show(new URL("http://www.dbtv.no/s3"), "Series 3", episodes);
    }

    public static String getEpisodeSeries3Markup() {

        return "[{'id': 31, 'name':'Episode 1 of Series 3', 'shortDescription': 'Learn mocking', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s3.jpg', 'publishedDate':'01.01.2014',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s3/e1.jpg','length':'89:59','playsTotal':'56', 'playsTrailingWeek': '11'," +
                " 'url': 'http://www.tullball.no/shows/s3/e1.mkv'}, " +
                "{'id': 32, 'name':'Episode 2 of Series 3', 'shortDescription': 'Apply Mocking', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s3.jpg', 'publishedDate':'14.01.2014',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s1/e2.jpg', 'length':'89:59','playsTotal':'56', 'playsTrailingWeek': '11'," +
                "'url': 'http://www.tullball.no/shows/s3/e2.mkv'}, "+
                "{'id': 33, 'name':'Episode 3 of Series 3', 'shortDescription': 'What about integration tests you bloody idiot??!!!', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s3/e3.jpg', 'publishedDate':'21.01.2014',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s3/e3.jpg','length':'89:59','playsTotal':'56', 'playsTrailingWeek': '11'," +
                " 'url': 'http://www.tullball.no/shows/s3/e3.mkv'}]";
    }
}
