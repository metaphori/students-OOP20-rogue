package rogue.model.items.inventory;

import java.util.Optional;

import rogue.model.items.Item;

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
     * @throws InventoryIsFullException if the inventory is full.
     */
    boolean addItem(Item item) throws InventoryIsFullException;

    /**
     * Swaps the contents of two slots.
     * @param first slot to swap.
     * @param second slot to swap.
     * @return true if the two slots have been correctly swapped, false
     * if given two empty slots indexes.
     */
    boolean swap(int first, int second);

    /**
     * Get the scroll container which contains currently active
     * scroll (could also be empty).
     * @return ScrollContainer associated with the inventory.
     */
    ScrollContainer getScrollContainer();

    /**
     * Remove the item in the given slot.
     * @param index of the slot to remove the contained item.
     * @return true if item correctly removed, false if slot is empty.
     */
    boolean remove(int index);
}
