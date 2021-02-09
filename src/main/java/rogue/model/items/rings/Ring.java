package rogue.model.items.rings;

import rogue.model.creature.Player;
import rogue.model.items.Item;

/** 
 * An interface modeling a game Ring. 
 * A Ring is an item relatively permanent magic which adds 
 * to the player different behaviors depending on its type.
 * 
 */
public interface Ring extends Item {

    /**
     * @return the ring chance
     */
    int getChance();

    /**
     * 
     * @param player
     */
    void stopUsing(Player player);

}
