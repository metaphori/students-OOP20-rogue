package rogue.model.creature;

import rogue.model.items.inventory.Inventory;

/**
 * An interface modeling the player.
 */
public interface Player extends Creature<PlayerLife> {

    /**
     * @return the inventory
     */
    Inventory getInventory();

    /**
     * @return the equipment
     */
    Equipment getEquipment();

}
