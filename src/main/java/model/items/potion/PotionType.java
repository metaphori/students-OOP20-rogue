package model.items.potion;

public enum PotionType {

    /**
     * Potion I, smallest amount of HP Value.
     */
    POTION_I(5),
    /**
     * Potion II, small amount of HP Value.
     */
    POTION_II(15),
    /**
     * Potion III, medium amount of HP Value.
     */
    POTION_III(30),
    /**
     * Potion IV, high amount of HP Value.
     */
    POTION_IV(60),
    /**
     * Potion V, heals the player to full Health.
     */
    POTION_V(700),
    /**
     * Corrupt Potion I, hurts the player for a small
     * amount of HP.
     */
    CORRUPT_POTION_I(-15),
    /**
     * Corrupt Potion II, hurts the player for a medium
     * amount of HP.
     */
    CORRUPT_POTION_II(-30);

    /**
     * The amount of HP added or remove to the player from
     * each Potion.
     */
    private final int hpValue;

    PotionType(final int value) {
        this.hpValue = value;
    }

    public int getHpValue() {
        return this.hpValue;
    }

}
