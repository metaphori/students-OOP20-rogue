package rogue.model.items.food;

import rogue.model.items.Item;

/**
 * An interface modeling a game food.
 *
 */
public interface Food extends Item {

    int getStarvationValue();

}
