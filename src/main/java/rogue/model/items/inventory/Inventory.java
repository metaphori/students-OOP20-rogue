package rogue.model.items.inventory;

import rogue.model.items.Item;

public interface Inventory {

    boolean useItem(int index);

    boolean useItem(Item item);

    boolean getItem(int index);

    boolean addItem(Item item);

}
