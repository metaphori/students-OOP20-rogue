package rogue.model.items.rings;

// import java.util.function.Consumer;

/**
 * Represents an enumeration for declaring ring types.
 * 
 * The first field keeps track the percentage of chance that
 * the corresponding ring has of being found.
 * The second field keeps track 
 *
 * TODO to finish
 */
public enum RingType {

    /**
     * Adds to strength.
     */
    ADD_STRENGTH(9),
    /**
     * Increase armor AC.
     */
    PROTECTION(9),
    /**
     * Worth 10 gold.
     */
    ADORNMENT(1),
    /**
     * Improves weapon accuracy.
     */
    DEXTERITY(8),
    /**
     * Increases weapon damage.
     */
    INCREASE_DAMAGE(8),
    /** 
     * Heals 1 health points per turn.
     */
    REGENERATION(4);

    private final int chance;
    // TODO Change Creature with Player
    // private final Consumer<Creature> consumer;

    RingType(final int chance) {
        this.chance = chance;
        // this.consumer = consumer;
    }

}
