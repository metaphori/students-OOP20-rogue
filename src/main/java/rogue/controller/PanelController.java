package rogue.controller;

import rogue.model.Entity;
import rogue.view.View;

/**
 * An interface modeling the entity controller.
 *
 * @param <V>
 */
public interface PanelController<V extends View> {

    /**
     * @return the associated {@link EntityView}
     */
    V getView();

    /**
     * @return the associated {@link Entity}
     */
    Entity getEntity();

}
