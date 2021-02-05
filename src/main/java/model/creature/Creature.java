package model.creature;

/**
 * An interface modeling a game Creature: Monsters or Player.
 *
 * @param <L> the creature's life
 */
public interface Creature<L extends Life> {

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
