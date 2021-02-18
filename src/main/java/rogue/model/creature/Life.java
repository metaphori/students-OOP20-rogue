package rogue.model.creature;

import rogue.model.events.EventPublisher;

/** 
 * An interface modeling a life for a {@link Creature}.
 */
public interface Life extends EventPublisher {

    /**
     * Hurts the Creature.
     * @param damage
     *          the quantity to subtract to health points
     */
    void hurt(int damage);

    /**
     * Increase the player health points.
     * @param heal
     *          the quantity to add to the player health points
     */
    void powerUp(int heal);

    /**
     * @return the amount of health points
     */
    int getHealthPoints();

    /**
     * @return the creature's experience
     */
    int getExperience();

    /**
     * @return true if the creature is dead, false otherwise
     */
    boolean isDead();

}
