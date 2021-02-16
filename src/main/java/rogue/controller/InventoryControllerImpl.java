package rogue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rogue.model.creature.Player;
import rogue.model.items.Item;
import rogue.model.items.inventory.OutOfInventoryException;

public class InventoryControllerImpl implements InventoryController {

    private static final Logger LOG = LoggerFactory.getLogger(InventoryController.class);
    private final Player player;

    public InventoryControllerImpl(final Player player) {
        this.player = player;
    }
 
    /**
     * Gives the updated number for the Model inventory.
     * @param col 
     * @param row
     * @return index for the model inventory.
     */
    public int indexConv(final int col, final int row) {
        return row * 4 + col + 1;
    }


    /**
     * Event triggered when the player clicks on a inventory slot
     * with mouse button 1.
     * @param col of the clicked slot.
     * @param row of the clicked slot.
     * @return true if the item was correctly used, false otherwise.
     */
    public boolean onPrimaryClick(final int col, final int row) {
        try {
            if (player.getInventory().getItem(indexConv(col, row)).isPresent()) {
                final Item usedItem = player.getInventory().getItem(indexConv(col, row)).get();
                if (!player.getInventory().useItem(indexConv(col, row))) {
                    LOG.info("Cannot use item: " + player.getInventory().getItem(indexConv(col, row)).get().toString());
                    return false;
                }
                LOG.info("Used item: " + usedItem.toString());
                return true;
            }
        } catch (OutOfInventoryException e) {
            LOG.info("Called useItem with invalid Index");
        }
        return false;
    }

    /**
     * Event triggered when the player clicks on a inventory slot
     * with mouse button 2.
     * @param col of the clicked slot.
     * @param row of the clicked slot.
     * @return true if the item was correctly used, false otherwise.
     */
    public boolean onSecondaryClick(final int col, final int row) {
        try {
            if (!player.getInventory().remove(indexConv(col, row))) {
                LOG.info("Cannot remove item: " + player.getInventory().getItem(indexConv(col, row)).get().toString());
                return false;
            }
            LOG.info("Remove item: " + player.getInventory().getItem(indexConv(col, row)).get().toString());
        } catch (OutOfInventoryException e) {
            LOG.info("Called removeItem with invalid Index");
        }
        return true;
    }
}
