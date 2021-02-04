package model.items;

/**
 * Represents an enumeration for declaring armor types.
 * 
 * The field keeps track the armor's AC.
 *
 */
public enum ArmorType {

    /**
     * Leather armor.
     */
    LEATHER(8),
    /**
     * Ring mail.
     */
    RING_MAIL(7), 
    /**
     * Studded leather.
     */
    STUDDED_LEATHER(7), 
    /**
     * Scale mail.
     */
    SCALE_MAIL(6), 
    /**
     * Chain mail.
     */
    CHAIN_MAIL(5),
    /**
     * Splint mail.
     */
    SPLINT_MAIL(4),
    /** 
     * Banded mail.
     */
    BANDED_MAIL(4), 
    /** 
     * Plate mail.
     */
    PLATE_MAIL(3);

    /**
     * A lower AC gives a better chance to avoid damage.
     */
    private final int ac;

    ArmorType(final int ac) {
        this.ac = ac;
    }

    /**
     * @return the armor's AC value.
     */
    public int getAC() {
        return this.ac;
    }

}
