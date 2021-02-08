package rogue.model.items.armor;

import rogue.model.items.Item;

/**
 * An interface modeling a game armor.
 */
public interface Armor extends Item {

    /**
     * @return the armor's AC
     */
    int getAC();

    /**
     * Increases the armor's AC of the given value.
     * @param value
     *          the value to add to the armor's AC
     */
    void increaseAC(int value);

    /**
     * @return the armor type
     */
    ArmorType getArmorType();

}
