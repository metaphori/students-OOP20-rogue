package rogue.controller;

/**
 * An interface modeling the player's {@link Inventory} controller.
 */
public interface InventoryController {

    /**
     * Use an item when clicked with First Mouse button.
     * @param col of the inventory slot.
     * @param row of the inventory slot.
     * @return true if correctly used, false otherwise.
     */
    boolean onPrimaryClick(int col, int row);

    /**
     * Remove an item when clicked with Second Mouse button. 
     * @param col of the inventory slot.
     * @param row of the inventory slot.
     * @return true if correctly removed, false otherwise.
     */
    boolean onSecondaryClick(int col, int row);

    /**
     * Swaps two items when both clicked with the Middle Mouse Button.
     * @param col of the second inventory slot.
     * @param row of the second inventory slot.
     * @param swapping of the first inventory slot.
     * @return true if correctly swapped, false otherwise.
     */
    boolean onMiddleClick(int col, int row, int swapping);

    /**
     * Detaches the ring when clicked with First Mouse Button.
     * @return true if correctly removed, false otherwise.
     */
    boolean onRingContainer();
}
