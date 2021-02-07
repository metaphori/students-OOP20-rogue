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
        if (this.scroll.getEffect().equals(Scroll.ScrollEffect.GAIN)) {
            /*
             * Since there's no maximum strength for the player
             * simply increase the player's strength.
             */
            player.getLife().addStrength(this.scroll.getEffectValue());
            return true;
        } else {
            /*
             * LOSE effect, player's strength can't go below 0
             */
            final int decrease = this.scroll.getEffectValue();
            if (player.getLife().getStrength() + decrease < 0) {
                /*
                 * Just set the player's strength to 0.
                 */
                player.getLife().addStrength(-player.getLife().getStrength());
            } else {
                /*
                 * Simply decrease player's strength.
                 */
                player.getLife().addStrength(decrease);
            }
            return true;
        }
    }

    /*
     * Removes the scroll effect.
     */
    public void remove() {
        // TODO Auto-generated method stub

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
