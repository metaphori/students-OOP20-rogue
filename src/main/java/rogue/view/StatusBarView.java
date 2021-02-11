package rogue.view;

/**
 * An interface for controlling the game status bar display.
 */
public interface StatusBarView {

    /**
     * Sets the maximum obtainable health points.
     * @param max
     *          the maximum health points value
     */
    void setMaxHealthPoints(int max);

    /**
     * Sets the current health points.
     * @param healthPoints
     *          the current health points value
     */
    void setCurrentHealthPoints(int healthPoints);

    /**
     * Sets the current coins.
     * @param coins
     *          the current amount of coins
     */
    void setCoins(int coins);

    /**
     * Sets the current level.
     * @param level
     *          the current level value
     */
    void setLevel(int level);

    /**
     * Sets the current strength.
     * @param strength
     *          the current strength value
     */
    void setStrength(int strength);

    /**
     * Sets the current experience.
     * @param experience
     *          the current experience value
     */
    void setExperience(int experience);

}
