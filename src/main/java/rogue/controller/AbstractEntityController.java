package rogue.controller;

import rogue.model.Entity;
import rogue.view.EntityView;

/**
 * An abstract implementation of {@link EntityController}.
 */
public abstract class AbstractEntityController implements EntityController {

    private final EntityView view;
    private final Entity entity;

    /**
     * Creates a new AbstractEntityController.
     * @param view
     *          the entity view which this controller refers to
     * @param entity
     *          the entity which this controller refers to
     */
    protected AbstractEntityController(final EntityView view, final Entity entity) {
        this.view = view;
        this.entity = entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityView getView() {
        return this.view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity getEntity() {
        return this.entity;
    }

}
