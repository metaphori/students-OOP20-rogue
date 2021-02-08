package rogue.model.items.potion;

import rogue.model.creature.Player;

public class PotionImpl implements Potion {

    private static final int MAXIMUM_HEALTH = 50;
    private final PotionType potion;
    private final int hpValue;

    public PotionImpl(final PotionType potion) {
        this.potion = potion;
        this.hpValue = potion.getHpValue();
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
        if (this.potion.getEffect().equals(Potion.PotionEffect.HEAL)) {
            final int increase = this.potion.getHpValue();
            /*
             * HEAL
             */
            if (player.getLife().getHealthPoints() != MAXIMUM_HEALTH) {
                if (player.getLife().getHealthPoints() + increase > MAXIMUM_HEALTH) {
                    /*
                     * I can't increase the player's health over the MAXIMUM_HEALTH
                     * so i just set it to max.
                     */
                    player.getLife().powerUp(MAXIMUM_HEALTH - player.getLife().getHealthPoints());
                } else {
                    /*
                     * Simply updates the player's health points.
                     */
                    player.getLife().powerUp(increase);
                }
                return true;
            } else {
                /*
                 * Player's life already full, cannot use item.
                 */
                return false;
            }
        } else {
            /*
             * HURT
             */
            final int decrease = this.potion.getHpValue();
            if (player.getLife().getHealthPoints() + decrease < 0) {
                /*
                 * Player's health can't be below 0.
                 * Update player's health to exactly 0.
                 */
                player.getLife().powerUp(-player.getLife().getHealthPoints());
            } else {
                /*
                 * Simply update player's health points.
                 */
                player.getLife().powerUp(decrease);
            }
            return false;
        }
    }

    /**
     * @return return the amount of health the Potion will add or remove
     * to the player.
     */
    public int getHpValue() {
        return this.hpValue;
    }

    /**
     * @return the potion's effect.
     */
    public Potion.PotionEffect getEffect() {
        return this.potion.getEffect();
    }

}
