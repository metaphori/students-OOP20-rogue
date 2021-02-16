package rogue.model.items;

import java.util.ArrayList;

public interface ItemFactory {

    ArrayList<Item> getItems(int quantity);
}
