import org.aineko.core.DagbladetShowBuilder;
import org.aineko.core.Show;
import org.aineko.core.ShowBuilder;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by JohnSigvald on 20/01/14.
 */
public class DagbladetShowBuilderIT {

    @Test
    public void test(){

        ShowBuilder builder = new DagbladetShowBuilder().withUrl("http://www.dbtv.no").withShowCollectionId("#serier");
        List<Show> shows = builder.build();
        assertTrue(shows.size() >= 17);
    }
}
