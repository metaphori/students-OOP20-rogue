package model.items.potion;

import model.items.Item;

public interface Potion extends Item {

    enum Effect {
        HEAL, HURT;
    }

    int getHpValue();

}
