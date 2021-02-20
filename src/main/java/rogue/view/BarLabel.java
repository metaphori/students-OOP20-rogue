package rogue.view;

public enum BarLabel {

    /**
     * Maximum health point value.
     */
    MAX_HP("#maxHp"),
    /**
     * Current health point value.
     */
    HP("#hp"),
    /**
     * Current coins amount.
     */
    COINS("#gold"),
    /**
     * Current level.
     */
    LEVEL("#level"),
    /**
     * Current strength value.
     */
    STRENGTH("#strength"),
    /**
     * Current experience value.
     */
    EXPERIENCE("#experience"),
    /**
     * Currently used weapon.
     */
    WEAPON("#weapon"),
    /**
     * Currently used armor.
     */
    ARMOR("#armor"),
    /**
     * Food.
     */
    FOOD("#food");

    private final String labelName;

    BarLabel(final String labelName) {
        this.labelName = labelName;
    }

    /**
     * @return the label name
     */
    protected String getNameLabel() {
        return this.labelName;
    }

}
