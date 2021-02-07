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

}
