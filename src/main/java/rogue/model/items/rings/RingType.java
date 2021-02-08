package rogue.model.items.rings;

import java.util.function.Consumer;

import rogue.model.items.weapons.IncreaseAccuracy;
import rogue.model.items.weapons.IncreaseDamage;

import rogue.model.creature.Player;

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
    PROTECTION(9, p -> p.getEquipment().getArmor().increaseAC(2)),
    /**
     * Improves weapon accuracy.
     */
    DEXTERITY(8, p -> p.getEquipment().setWeapon(new IncreaseAccuracy(p.getEquipment().getWeapon()))),
    /**
     * Increases weapon damage.
     */
    INCREASE_DAMAGE(8, p -> p.getEquipment().setWeapon(new IncreaseDamage(p.getEquipment().getWeapon())));

    private final int chance;
    private final Consumer<Player> consumer;

    RingType(final int chance, final Consumer<Player> consumer) {
        this.chance = chance;
        this.consumer = consumer;
    }

    protected Consumer<Player> getConsumer() {
        return this.consumer;
    }

    protected int getChance() {
        return this.chance;
    }

}
