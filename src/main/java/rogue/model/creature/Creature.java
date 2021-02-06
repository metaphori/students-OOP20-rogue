package rogue.model.creature;

import rogue.model.Entity;

/**
 * An interface modeling a game Creature: Monsters or Player.
 *
 * @param <L> the creature's life
 */
public interface Creature<L extends Life> extends Entity {

    /**
     * TODO to finish.
     * @return true if the movement was successful, false otherwise
     */
    boolean move();

    /**
     * 
     * @return the creature's life
     */
    L getLife();

}
