package model.items.potion;

import model.items.Item;

public interface Potion extends Item {

    enum PotionEffect {
        HEAL, HURT;
    }

    int getHpValue();

}
