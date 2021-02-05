package model.items.scroll;

import javafx.util.Pair;

public enum ScrollType {

    /**
     * Scroll I, increases the player's strength by a small
     * amount and lasts for 15 turns.
     */
    SCROLL_I(new Pair<>(2, 15)),
    /**
     * Scroll II, increases the player's strength by a small
     * amount and lasts for 25 turns. 
     */
    SCROLL_II(new Pair<>(2, 25)),
    /**
     * Scroll III, increases the player's strength by a medium
     * amount and lasts for 15 turns.
     */
    SCROLL_III(new Pair<>(4, 15)),
    /**
     * Scroll IV, increases the player's strength by a medium
     * amount and lasts for 25 turns.
     */
    SCROLL_IV(new Pair<>(4, 25)),
    /**
     * Scroll V, increases the player's strength by a high
     * amount and lasts for 15 turns.
     */
    SCROLL_V(new Pair<>(7, 15)),
    /**
     * Corrupt Scroll I, decreases the player's strength by
     * a small amount and lasts for 30 turns.
     */
    CORRUPT_SCROLL_I(new Pair<>(-2, 30)),
    /**
     * Corrupt Scroll II, decreases the player's strength by
     * a medium amount and lasts for 20 turns.
     */
    CORRUPT_SCROLL_II(new Pair<>(-4, 20));

    private final Pair<Integer, Integer> scrollValues;

    ScrollType(final Pair<Integer, Integer> scrollValues) {
        this.scrollValues = scrollValues;
    }

    public int getEffectValue() {
        return this.scrollValues.getKey();
    }

    public int getEffectDuration() {
        return this.scrollValues.getValue();
    }
}
