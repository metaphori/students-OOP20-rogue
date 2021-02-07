package rogue.model.items.inventory;

import java.util.Optional;

import rogue.model.items.Item;
import rogue.model.items.scroll.Scroll;

/**
 * An interface for modeling a game Inventory.
 *
 */
public interface Inventory {

    /**
     * Use the item contained in the index slot.
     * @param index of the slot to select.
     * @return true if the item was correctly used, false if 
     * item cannot be consumed.
     * @throws OutOfInventoryException if given an invalid index.
     */
    boolean useItem(int index) throws OutOfInventoryException;

    /**
     * Get the item contained in the index slot of the inventory.
     * @param index of the wanted slot.
     * @return Optional.empty if given slot is empty, Optional.of(Item)
     * otherwise.
     */
    Optional<Item> getItem(int index);

    /**
     * Add an item to the inventory.
     * @param item to add to the inventory.
     * @return true if item was correctly added, false if
     * the inventory is full.
     */
    boolean addItem(Item item);

    /**
     * Get the currently active effect.
     * @return Optional.empty() if no active effect, Optional.of(Scroll.ScrollEffect) otherwise
     */
    Optional<Scroll.ScrollEffect> getActiveEffect();

}
