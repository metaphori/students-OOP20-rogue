package model.items.weapons;

import model.creature.Player;

/**
 * A minimal implementation for a {@link Weapon}.
 *
 */
public class BaseWeapon implements Weapon {

    private final WeaponType weapon;

    public BaseWeapon(final WeaponType weapon) {
        this.weapon = weapon;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean use(final Player player) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDamage(final Use use) {
        return this.weapon.getDamageSupplier(use).get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPrecision() {
        // TODO Auto-generated method stub
        return 0;
    }

}
