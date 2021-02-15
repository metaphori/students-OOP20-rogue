package rogue.controller;

import rogue.model.Entity;
import rogue.view.EntityView;

/**
 * An interface modeling the entity controller.
 */
public interface EntityController {

    /**
     * @return the associated {@link EntityView}
     */
    EntityView getView();

    /**
     * @return the associated {@link Entity}
     */
    Entity getEntity();

}
