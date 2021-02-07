package rogue.model.items.scroll;

import rogue.model.creature.Player;
import rogue.model.items.Item;

public interface Scroll extends Item {

    enum ScrollEffect {
        GAIN, LOSE;
    }

    void remove(Player player);

    int getEffectValue();

    int getEffectDuration();

}
