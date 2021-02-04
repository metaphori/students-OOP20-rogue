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
     * 
     * @return the weapon's damage
     */
    int getDamage();

    /**
     * 
     * @return the weapon's precision
     */
    int getPrecision();

}
