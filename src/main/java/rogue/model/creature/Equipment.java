package rogue.model.creature;

import rogue.model.items.armor.Armor;
import rogue.model.items.rings.Ring;
import rogue.model.items.weapons.Weapon;

/**
 * An interface modeling the player's equipment.
 *
 */
public interface Equipment {

    /**
     * 
     * @return the armor currently in use
     */
    Armor getArmor();

    /**
     * Replaces the current armor with the given one.
     * @param armor
     *          the armor to be placed instead of the one currently in use
     */
    void setArmor(Armor armor);

    /**
     * 
     * @return the weapon currently in use
     */
    Weapon getWeapon();

    /**
     * Replaces the current weapon with the given one.
     * @param weapon
     *          the armor to be placed instead of the one currently in use
     */
    void setWeapon(Weapon weapon);

    /**
     * 
     * @return the ring currently in use
     */
    Ring getRing();

    /**
     * Try to wear a ring. Note that only one ring per time could be worn.
     * @param ring
     *          the ring to put on
     * @return true if it's possible to wear it, false otherwise
     */
    boolean putRing(Ring ring);

}
