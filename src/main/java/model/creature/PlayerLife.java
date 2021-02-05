package model.creature;

/**
 * An interface modeling a specific {@link Life} for the {@link Player}.
 *
 */
public interface PlayerLife extends Life {

    /**
     * Increase the player experience.
     * @param quantity
     *          the quantity to add to the player experience
     */
    void increaseExperience(int quantity);

    /**
     * Increase the player health points.
     * @param quantity
     *          the quantity to add to the player health points
     */
    void powerUp(int quantity);

    /**
     * Increase the player strength.
     * @param quantity
     *          the quantity to add to the player strength
     */
    void addStrength(int quantity);

    /**
     * 
     * @return the player strength
     */
    int getStrength();

    /**
     * Update the leftover food which player eats.
     * @param quantity
     *          the quantity to add/subtract to the leftover food.
     */
    void updateFood(int quantity);
}
