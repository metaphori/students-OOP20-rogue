package model.items;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javafx.util.Pair;
import model.creature.Player;

public class InventoryImpl implements Inventory {

    private static final int INVENTORY_SIZE = 20;

    private final Player player;
    private final Map<Integer, Pair<Optional<Item>, Integer>> inventory = new HashMap<>(INVENTORY_SIZE);

    public InventoryImpl(final Player player) {
        this.player = player;
        for (int i = 1; i <= INVENTORY_SIZE; i++) {
            this.inventory.put(i, new Pair<>(Optional.empty(), 0));
        }
    }

    /**
     * @param index of the inventory slot to select.
     * @return true if the item was correctly used, false otherwise.
     */
    public boolean useItem(final int index) {
        if (inventory.containsKey(index)) {
            if (inventory.get(index).getKey().isPresent()) {
                /*
                 * Save to use Item.
                 */
                final Item toUse = inventory.get(index).getKey().get();
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
                /*
                 * Use item
                 */
                return toUse.use(this.player);
            } else {
                return false;
            }
        }
        //TODO Add OutOfInventoryException
        return false;
    }

    /**
     * @param item to search in the inventory and use.
     * @return true if the item was correctly used, false otherwise.
     */
    public boolean useItem(final Item item) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @param index of the inventory slot to select.
     * @return the item contained in the given inventory slot.
     */
    public boolean getItem(final int index) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @param item to add to the inventory.
     * @return true if the item was correctly added to the inventory, 
     * false if the inventory is full or if the inventory contains the
     * limit amount for the item.
     */
    public boolean addItem(final Item item) {
        // TODO Auto-generated method stub
        return false;
    }

}
