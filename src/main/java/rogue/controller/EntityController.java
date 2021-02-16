package rogue.controller;

import rogue.model.Entity;
import rogue.view.View;

/**
 * An interface modeling the entity controller.
 */
public interface EntityController {

    /**
     * @return the associated {@link EntityView}
     */
    View getView();

    /**
     * @return the associated {@link Entity}
     */
    Entity getEntity();

}
