package rogue.model.creature;

 /** 
 * An interface modeling the Special skill for a {@link Monster}.
 *
 */
public interface Special {

    /**
     * 
     * @return true if the monster is hostile
     */
     boolean isHostile();

    /**
     * 
     * @return true if the monster can fly
     */
    boolean isFlyng();

    /**
     * 
     * @return true if the monster attempt to pick up gold
     */
     boolean isGreedy();

    /**
     * 
     * @return true if the monster invisible
     */
     boolean isInvisible();

    /**
     * 
     * @return true if the monster flies randomly
     */
     boolean isFlyingRandom();

    /**
     * 
     * @return true if the monster can decrease the player's strength
     */
     boolean isWeaken();

    /**
     * 
     * @return true if the monster can poison the player
     */
     boolean isPoisonous();

    /**
     * 
     * @return true if the monster can steal life from the player
     */
    boolean isDrainLife();

}
