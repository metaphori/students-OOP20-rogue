package rogue.model.items.scroll;

import rogue.model.creature.Player;

public class ScrollImpl implements Scroll {

    private final ScrollType scroll;

    public ScrollImpl(final ScrollType scroll) {
        this.scroll = scroll;
    }

    /**
     * Use this method to consume the Scroll on the given Player.
     * @param player to which apply the scroll to.
     * @return true if the item was correctly used, false otherwise.
     */
    public boolean use(final Player player) {
        /*
         * The minimum value for strength is 0,
         * There is no maximum value for strength.
         * Check the effect of the scroll
         */
        return false;
    }

    /**
     * @return The scroll's effect.
     */
    public Scroll.ScrollEffect getEffect() {
        return this.scroll.getEffect();
    }
    /**
     * @return amount of strength to add or remove to the player.
     */
    public int getEffectValue() {
        return this.scroll.getEffectValue();
    }

    /**
     * @return amount of turns the effect will last.
     */
    public int getEffectDuration() {
        return this.scroll.getEffectDuration();
    }

}
