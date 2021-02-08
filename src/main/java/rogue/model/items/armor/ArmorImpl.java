package rogue.model.items.armor;

import rogue.model.creature.Player;

/** 
 * Represents an implementation for a game {@link Armor}.
 *
 */
public class ArmorImpl implements Armor {

    private final ArmorType armor;

    /**
     * Builds a new {@link ArmorImpl}.
     * @param armor
     *          the armor type
     */
    public ArmorImpl(final ArmorType armor) {
        this.armor = armor;
    }

    @Override
    public final int getAC() {
        return armor.getAC();
    }

    /**
     * Equip the player with this armor.
     */
    @Override
    public boolean use(final Player player) {
        player.getEquipment().setArmor(this);
        return true;
    }

    public void increaseAC(final int value) {
        this.armor.setAC(this.armor.getAC() + value);
    }

}
