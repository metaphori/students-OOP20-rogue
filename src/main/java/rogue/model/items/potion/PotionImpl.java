package rogue.model.items.potion;

import rogue.model.creature.Player;

public class PotionImpl implements Potion {

    private final PotionType potion;

    public PotionImpl(final PotionType potion) {
        this.potion = potion;
    }

    /**
     * Use this method to consume to potion on the player.
     * @param player to which apply the potion.
     * @return true if the potion was correctly used, false otherwise
     */
    public boolean use(final Player player) {
        /*
         * The first thing to check is the potion effect.
         * If the potion effect is HEAL we have to check not to
         * increase over the MAXIMUM_HEALTH value-
         * if the potion effect is HURT we have to check not to 
         * lower it under 0, we just set it to 0 and the player dies.
         */
        return false;
    }

    /**
     * @return return the amount of health the Potion will add or remove
     * to the player.
     */
    public int getHpValue() {
        return this.potion.getHpValue();
    }

    /**
     * @return the potion's effect.
     */
    public Potion.PotionEffect getEffect() {
        return this.potion.getEffect();
    }

}
