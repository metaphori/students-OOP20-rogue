package model.items.weapons;

import model.items.Item;

/**
 * An interface for modeling a game weapon.
 *
 */
public interface Weapon extends Item {

    /** 
     * Represents an enumeration for declaring weapon use.
     */
    enum Use {
        HANDLED, 
        THROWABLE;
    }

    /**
     * @param use 
     *          how the Weapon is used (by hand or thrown)
     * @return the weapon's damage
     */
    int getDamage(Use use);

    /**
     * 
     * @return the weapon's precision
     */
    int getPrecision();

}
