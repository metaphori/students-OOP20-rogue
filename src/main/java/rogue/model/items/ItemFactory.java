package rogue.model.items;

import java.util.List;

public interface ItemFactory {
    List<Item> getItems(int quantity);

    List<Item> getItems();
}
