package rogue.model.items.potion;

import rogue.model.items.Item;

public interface Potion extends Item {

    enum PotionEffect {
        HEAL, HURT;
    }

    int getHpValue();

}
