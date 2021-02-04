package model.creature;

public interface PlayerLife extends Life {

    /**
     * Increase the player experience.
     * @param increment
     *          the quantity to add to the player experience
     */
    void increaseExperience(int increment);

    /**
     * Increase the player health points.
     * @param increment
     *          the quantity to add to the player health points
     */
    void powerUp(int increment);

    /**
     * Increase the player strength.
     * @param increment
     *          the quantity to add to the player strength
     */
    void addStrength(int increment);

    /**
     * 
     * @return the player strength
     */
    int getStrength();

    // TODO hunger?
}
