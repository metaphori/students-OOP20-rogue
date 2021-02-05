package model.items.potion;

import model.creature.Player;

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
        return false;
    }

    /**
     * @return return the amount of health the Potion will add or remove
     * to the player.
     */
    public int getHpValue() {
        return this.potion.getHpValue();
    }

}
