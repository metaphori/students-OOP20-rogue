package rogue.model.items;

import rogue.model.Entity;
import rogue.model.creature.Player;

public interface Item extends Entity {

    boolean use(Player player);

}
