package rogue.model.items.scroll;

import rogue.model.items.Item;

public interface Scroll extends Item {

    enum ScrollEffect {
        GAIN, LOSE;
    }

    int getEffectValue();

    int getEffectDuration();

}
