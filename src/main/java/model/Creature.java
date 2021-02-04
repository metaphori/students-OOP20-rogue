package model;

/**
 * An interface modeling game Creature.
 *
 */
public interface Creature {

    /**
     * TODO to finish.
     * @return true if the movement was successful, false otherwise.
     */
    boolean move();

    /**
     * 
     * @return the creature's life
     */
    Life getLife();

}
