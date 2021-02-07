package rogue.model.items.inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javafx.util.Pair;
import rogue.model.creature.Player;
import rogue.model.items.Item;
import rogue.model.items.scroll.Scroll;

class OutOfInventoryException extends Exception {

    private static final long serialVersionUID = -4154450610441652376L;

    OutOfInventoryException(final String message) {
        super(message);
    }

}

public class InventoryImpl implements Inventory {

    /*
     * TODO Make scroll container,get and update.
     */
    private static final int INVENTORY_SIZE = 20;
    private static final int ITEM_AMOUNT_MAX = 10;

    private Pair<Optional<Scroll>, Integer> scroll;
    private final Player player;
    private final Map<Integer, Pair<Optional<Item>, Integer>> inventory = new HashMap<>(INVENTORY_SIZE);

    public InventoryImpl(final Player player) {
        this.scroll = new Pair<>(Optional.empty(), 0);
        this.player = player;
        for (int i = 1; i <= INVENTORY_SIZE; i++) {
            this.inventory.put(i, new Pair<>(Optional.empty(), 0));
        }
    }

    /**
     * Use the item in the given slot.
     * @param index of the inventory slot to select.
     * @return true if the inventory was correctly updated, false if there
     * was no inventory update (Item's use returned false).
     */
    public boolean useItem(final int index) throws OutOfInventoryException {
        if (inventory.containsKey(index)) {
            if (inventory.get(index).getKey().isPresent()) {
                /*
                 * Save to use Item.
                 */
                final Item toUse = inventory.get(index).getKey().get();
                /*
                 * Use the item, check if correctly used.
                 */
                if (!toUse.use(this.player)) {
                    /*
                     * If not correctly used the item can't be consumed,
                     * can't update inventory.
                     */
                    return false;
                } else  {
                /*
                 * Update Inventory.
                 */
                final int amount = inventory.get(index).getValue();
                if (amount == 1) {
                    //Last of that Item in inventory, make the optional empty.
                    inventory.put(index, new Pair<>(Optional.empty(), 0));
                } else {
                    //Lower amount of item by one after use.
                    inventory.put(index, new Pair<>(Optional.of(toUse), amount - 1));
                }
                return true;
                }
            } else {
                return false;
            }
        }
        throw new OutOfInventoryException("Given index is out of the inventory.");
    }

    /**
     * @param index of the inventory slot to select.
     * @return the item contained in the given inventory slot.
     */
    public Optional<Item> getItem(final int index) {
        return this.inventory.get(index).getKey();
    }

    /**
     * @param item to add to the inventory.
     * @return true if the item was correctly added to the inventory, 
     * false if the inventory is full or if the inventory contains the
     * limit amount for the item.
     */
    public boolean addItem(final Item item) {
        /*
         * Checks if item is already contained in inventory.
         */
        for (int i = 1; i <= INVENTORY_SIZE; i++) {
            if (this.inventory.get(i).getKey().equals(Optional.of(item))) {
                /*
                 * Inventory already contains the item to add.
                 * Increase it's quantity.
                 * Check if item's quantity is already at max.
                 */
                if (this.inventory.get(i).getValue().equals(ITEM_AMOUNT_MAX)) {
                    /*
                     * Item's amount already at max, cannot add item to
                     * inventory.
                     */
                    return false;
                } else {
                    /*
                     * Increase item's amount.
                     */
                    this.inventory.put(i, new Pair<>(this.inventory.get(i).getKey(), 
                            this.inventory.get(i).getValue() + 1));
                    return true;
                }
            }
        }
        /*
         * Item's not already contained in inventory.
         * Look for first Empty slot
         */
        for (int j = 1; j <= INVENTORY_SIZE; j++) {
            if (this.inventory.get(j).getKey().equals(Optional.empty())) {
                /*
                 * Empty slot found, insert item.
                 */
                this.inventory.put(j, new Pair<>(Optional.of(item), 1));
                return true;
            }
        }
        /*
         * No empty slot found return false.
         */
        //TODO Make InventoryFullException (??)
        return false;
    }

    /**
     * @param scroll to activate 
     */
    public void activateScroll(final Scroll scroll) {
        // TODO Auto-generated method stub
    }

    /**
     * @return Currently active scroll.
     */
    public Optional<Scroll> getActiveScroll() {
        return this.scroll.getKey();
    }

    /**
     * @param amount to subtract to scroll's duration
     * @return true if correctly updated the duration, false if
     * there's no active scroll.
     */
    public boolean updateEffectDuration(final int amount) {
        /*
         * Check if active Scroll
         */
        if (!this.scroll.getKey().equals(Optional.empty())) {
            /*
             * Check if amount will remove the scroll.
             */
            if (this.scroll.getValue() - amount <= 0) {
                /*
                 * Scroll duration is over, remove scroll.
                 */
                this.scroll = new Pair<>(Optional.empty(), 0);
                return true;
            } else {
                /*
                 * Update scroll's duration
                 */
                this.scroll = new Pair<>(this.scroll.getKey(), this.scroll.getValue() - amount);
                return true;
            }
        } else {
            /*
             * No active scroll, nothing to update
             */
            return false;
        }
    }

}
