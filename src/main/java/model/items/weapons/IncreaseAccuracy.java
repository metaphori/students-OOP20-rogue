package model.items.weapons;

public class IncreaseAccuracy extends WeaponDecorator {

    private static final int ADDITIONAL_ACCURACY = 2;

    public IncreaseAccuracy(final BaseWeapon weapon) {
        super(weapon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPrecision() {
        return super.getPrecision() + ADDITIONAL_ACCURACY;
    }

}
