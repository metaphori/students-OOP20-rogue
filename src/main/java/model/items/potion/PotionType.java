package model.items.potion;

import java.util.concurrent.ThreadLocalRandom;

import javafx.util.Pair;

public enum PotionType {

    /**
     * Potion I, smallest amount of HP Value.
     */
    POTION_I(Potion.PotionEffect.HEAL, new Pair<Integer, Integer>(5, 10)),
    /**
     * Potion II, small amount of HP Value.
     */
    POTION_II(Potion.PotionEffect.HEAL, new Pair<Integer, Integer>(15, 20)),
    /**
     * Potion III, medium amount of HP Value.
     */
    POTION_III(Potion.PotionEffect.HEAL, new Pair<Integer, Integer>(25, 33)),
    /**
     * Potion IV, high amount of HP Value.
     */
    POTION_IV(Potion.PotionEffect.HEAL, new Pair<Integer, Integer>(40, 50)),
    /**
     * Potion V, heals the player to full Health.
     */
    POTION_V(Potion.PotionEffect.HEAL, new Pair<Integer, Integer>(100, 100)),
    /**
     * Corrupt Potion I, hurts the player for a small
     * amount of HP.
     */
    CORRUPT_POTION_I(Potion.PotionEffect.HURT, new Pair<Integer, Integer>(5, 10)),
    /**
     * Corrupt Potion II, hurts the player for a medium
     * amount of HP.
     */
    CORRUPT_POTION_II(Potion.PotionEffect.HURT, new Pair<Integer, Integer>(15, 20));

    /**
     * The amount of HP added or removed to the player from
     * each Potion.
     */
    private Pair<Integer, Integer> hpValue;
    /**
     * The effect the potion has on the player.
     */
    private Potion.PotionEffect effect;

    PotionType(final Potion.PotionEffect effect, final Pair<Integer, Integer> value) {
        this.effect = effect;
        this.hpValue = value;
    }

    public int getHpValue() {
        return ThreadLocalRandom.current().nextInt(this.hpValue.getKey(), this.hpValue.getValue() + 1) 
                * (this.effect.equals(Potion.PotionEffect.HEAL) ? 1 : -1);
    }

}
