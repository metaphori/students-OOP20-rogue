package rogue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rogue.model.creature.Player;
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
                if (!player.getInventory().useItem(indexConv(col, row))) {
                    LOG.info("Cannot use item: " + player.getInventory().getItem(indexConv(col, row)).get().toString() + ".");
                    return false;
                }
                LOG.info("Item correctly used.");
                return true;
            }
        } catch (OutOfInventoryException e) {
            LOG.info("Called useItem with invalid Index.");
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
            if (player.getInventory().getItem(indexConv(col, row)).isPresent()) {
                if (!player.getInventory().remove(indexConv(col, row))) {
                    LOG.info("Cannot remove item: " + player.getInventory().getItem(indexConv(col, row)).get().toString() + ".");
                    return false;
                }
                LOG.info("Item correctly removed.");
                return true;
            }
        } catch (OutOfInventoryException e) {
            LOG.info("Called removeItem with invalid Index");
        }
        return false;
    }

    /**
     * Event triggered when the player clicks on a inventory slot
     * with middle mouse button.
     * @param col of the clicked slot.
     * @param row of the clicked slot.
     * @param swapping index of the swapping slot.
     * @return true if the item was correctly used, false otherwise.
     */
    public boolean onMiddleClick(final int col, final int row, final int swapping) {
        try {
            if (!player.getInventory().swap(swapping, indexConv(col, row))) {
                LOG.info("Cannot swap items");
                return false;
            }
            LOG.info("Swap correctly executed.");
            return true;
        } catch (OutOfInventoryException e) {
            LOG.info("Called swap with invalid Indexes.");
        }
        return false;
    }

    /**
     * @return true if the ring was correctly removed, false otherwise.
     */
    public boolean onRingContainer() {
        if (player.getEquipment().getRing().isPresent()) {
            /*
             * Remove the ring and update the inventory.
             */
            player.getEquipment().getRing().get().stopUsing(player);
            player.getInventory().updateInventory();
            LOG.info("Ring correctly removed.");
            return true;
        }
        /*
         * No active ring nothing to update.
         */
        LOG.info("No active Ring to remove.");
        return false;
    } 
}
