package rogue.model.items.weapons;

/**
 * A decorator to increase the weapon damage.
 */
public class IncreaseDamage extends WeaponDecorator {

    private static final int ADDITIONAL_DAMAGE = 3;

    public IncreaseDamage(final Weapon weapon) {
        super(weapon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDamage(final Use use) {
        return super.getDamage(use) + ADDITIONAL_DAMAGE;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "IncreaseDamage [" + super.toString() + "]";
    }

}
