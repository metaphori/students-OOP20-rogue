package model.items.weapons;

public class IncreaseDamage extends WeaponDecorator {

    private static final int ADDITIONAL_DAMAGE = 2;

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

}
