package rogue.model.creature;

/**
 * 
 *   An interface modeling the combat between two creature.
 */
public interface Combat {

    /**
     * 
     * @param attacker
     *          who made the attack
     * @param defender
     *         who defends himself from the attack
     */
    void attack(Creature<?> attacker, Creature<?> defender);

}
