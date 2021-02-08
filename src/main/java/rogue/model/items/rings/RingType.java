package rogue.model.items.rings;

import java.util.function.Consumer;

import rogue.model.items.Equipment;
import rogue.model.items.armor.ArmorImpl;
import rogue.model.items.weapons.IncreaseAccuracy;
import rogue.model.items.weapons.IncreaseDamage;

/**
 * Represents an enumeration for declaring ring types.
 * 
 * The first field keeps track the percentage of chance that the corresponding ring has of being found.
 * The second field keeps track a consumer describing its effect on the player.
 * TODO to finish
 */
public enum RingType {

    /**
     * Increase armor AC.
     */
    PROTECTION(9, e -> { 
        e.setArmor(new ArmorImpl(e.getArmor().getArmorType())); 
        e.getArmor().increaseAC(2); 
    }),
    /**
     * Improves weapon accuracy.
     */
    DEXTERITY(8, e -> e.setWeapon(new IncreaseAccuracy(e.getWeapon()))),
    /**
     * Increases weapon damage.
     */
    INCREASE_DAMAGE(8, e -> e.setWeapon(new IncreaseDamage(e.getWeapon())));

    private final int chance;
    private final Consumer<Equipment> consumer;

    RingType(final int chance, final Consumer<Equipment> consumer) {
        this.chance = chance;
        this.consumer = consumer;
    }

    protected Consumer<Equipment> getConsumer() {
        return this.consumer;
    }

    protected int getChance() {
        return this.chance;
    }

}
