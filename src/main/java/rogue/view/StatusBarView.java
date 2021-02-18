package rogue.view;

import rogue.model.items.armor.Armor;
import rogue.model.items.weapons.Weapon;

/**
 * An interface for controlling the game status bar display.
 */
public interface StatusBarView extends View {

    /**
     * Sets the maximum obtainable health points label.
     * @param max
     *          the maximum health points value
     */
    void setMaxHealthPointsLabel(int max);

    /**
     * Sets the current health points label.
     * @param healthPoints
     *          the current health points value
     */
    void setCurrentHealthPointsLabel(int healthPoints);

    /**
     * Sets the current coins.
     * @param coins
     *          the current amount of coins
     */
    void setCoinsLabel(int coins);

    /**
     * Sets the current level label.
     * @param level
     *          the current level value
     */
    void setLevelLabel(int level);

    /**
     * Sets the current strength label.
     * @param strength
     *          the current strength value
     */
    void setStrengthLabel(int strength);

    /**
     * Sets the current experience label.
     * @param experience
     *          the current experience value
     */
    void setExperienceLabel(int experience);

    /**
     * Sets the weapon label.
     * @param weapon
     *          the weapon currently in use
     */
    void setWeaponLabel(Weapon weapon);

    /**
     * Sets the weapon label.
     * @param armor
     *          the armor currently in use
     */
    void setArmorLabel(Armor armor);

}
