package rogue.view;

import rogue.model.creature.Player;
import rogue.model.events.InventoryEvent;
import rogue.model.items.inventory.Inventory;
import rogue.model.items.inventory.OutOfInventoryException;

/**
 * An interface for the {@link Inventory} display.
 */
public interface InventoryView {

    /**
     * Updates the inventory when updated by the
     * controller.
     * @param event Inventory event.
     * @throws OutOfInventoryException if reading inventory with invalid index.
     */
    void update(InventoryEvent<Inventory> event) throws OutOfInventoryException;

    /**
     * Passes the player to the InventoryView.
     * @param player that owns the inventory.
     */
    void init(Player player);

}
