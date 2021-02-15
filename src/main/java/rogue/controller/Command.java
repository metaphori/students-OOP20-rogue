package rogue.controller;

import rogue.model.Entity;

/**
 * An interface for performing a generic operation.
 */
public interface Command {

    /**
     * TODO
     * A method performing an operation.
     * @param entity
     *          the entity on which performs the operation
     */
    void execute(Entity entity);

}
