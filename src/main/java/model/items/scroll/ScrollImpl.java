package model.items.scroll;

import model.creature.Player;

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
        return false;
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
