package rogue.model.items.rings;

import rogue.model.creature.Player;
import rogue.model.items.Item;

/** 
 * An interface modeling a game Ring. 
 * A Ring is a permanent magic item which adds to the player
 * equipment different behavior depending on its type.
 * 
 */
public interface Ring extends Item {

    /**
     * 
     * @param player
     */
    void stopUsing(Player player);

}
