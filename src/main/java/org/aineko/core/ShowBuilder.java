package org.aineko.core;

import java.util.List;

/**
 * Created by JohnSigvald on 20/01/14.
 */
public interface ShowBuilder {
    public ShowBuilder withUrl(String url);
    public ShowBuilder withShowCollectionId(String id);
    public List<Show> build();

}
