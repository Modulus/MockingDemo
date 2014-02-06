package org.aineko.core;

/**
 * Created by Modulus on 23.01.14.
 */
public class TestData {

     public static String getRootMarkup() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div id='series'>");
        sb.append("<a href='/s1'>Series 1</a>");
        sb.append("<a href='/s2'/>Series 2</a>");
        sb.append("<a href='/s3'>Series 3</a>");
        sb.append("</div>");
        return sb.toString();
    }

    public static String getEpisodeSeries1Markup() {

        return "[{'id':1878692615001,"+
                "name':'Episode 1 of Series 1', 'shortDescription': 'First Episode ever!', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s1.jpg', 'publishedDate':'01.01.0001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s1/e1.jpg', 'url': 'http://www.tullball.no/shows/s1/e1.mkv'}," +
                "'length'89:59', 'playsTotal':'1234', 'playsTrailingWeek': '35'"+
                "{'id': 1875296713001, 'name':'Episode 2 of Series 1', 'shortDescription': 'Second episode', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s1.jpg', 'publishedDate':'01.01.0001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s1/e2.jpg', 'url': 'http://www.tullball.no/shows/s1/e2.mkv'}," +
                "'length'9:30', 'playsTotal':'114040','playsTrailingWeek': '2134'"+
                "{'id':1937053475001, 'name':'Episode 3 of Series 1', 'shortDescription': 'Last episode buhu!!!', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s1/e3.jpg', 'publishedDate':'01.01.0001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s1/e3.jpg', 'length'89:59',"+
                "'playsTotal':'56', 'playsTrailingWeek': '11'"+
                "'url': 'http://www.tullball.no/shows/s1/e3.mkv'}]";
    }

     public static String getEpisodeSeries2Markup() {

        return "[{'id':1940987026001, 'name':'Episode 1 of Series 2', 'shortDescription': 'First Episode of Series2!', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s2.jpg', 'publishedDate':'01.01.0001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s2/s1.jpg', 'url': 'http://www.tullball.no/shows/s2/e1.mkv'}, "+
                 "{'id':1925046271001, 'name':'Episode 2 of Series 2', 'shortDescription': 'Second episode of Series2', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s1.jpg', 'publishedDate':'01.01.0001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s1/e2.jpg', 'url': 'http://www.tullball.no/shows/s2/e2.mkv'},"+
                "{'id': 1911361442001, 'name':'Episode 3 of Series 2', 'shortDescription': 'Last episode of Series3!!!', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s2/e3.jpg', 'publishedDate':'01.01.0001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s2/e3.jpg', 'url': 'http://www.tullball.no/shows/s2/e3.mkv'}]";
    }

    public static String getEpisodeSeries3Markup() {

        return "[{'id': 1890760115001, 'name':'Episode 1 of Series 3', 'shortDescription': 'Learn mocking', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s3.jpg', 'publishedDate':'01.01.0001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s3/e1.jpg', 'url': 'http://www.tullball.no/shows/s3/e1.mkv'}, " +
                "{'id': 1895787270001, 'name':'Episode 2 of Series 3', 'shortDescription': 'Apply Mocking', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s3.jpg', 'publishedDate':'01.01.0001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s1/e2.jpg', 'url': 'http://www.tullball.no/shows/s3/e2.mkv'}, "+
                "{'id': 1871929343001, 'name':'Episode 3 of Series 3', 'shortDescription': 'What about integration tests you bloody idiot??!!!', " +
                "'thumbnailUrl':'http://www.tullball.no/shows/s3/e3.jpg', 'publishedDate':'01.01.0001',  " +
                "'videoStillUrl': 'http://www.tullball.no/shows/s3/e3.jpg', 'url': 'http://www.tullball.no/shows/s3/e3.mkv'}]";
    }
}
