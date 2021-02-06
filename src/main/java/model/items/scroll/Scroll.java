package model.items.scroll;

import model.items.Item;

public interface Scroll extends Item {

    enum ScrollEffect {
        GAIN, LOSE;
    }

    int getEffectValue();

    int getEffectDuration();

}
