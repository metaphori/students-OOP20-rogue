package model.items;

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

}
