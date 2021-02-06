package rogue.model.items.weapons;

import rogue.model.creature.Player;

/**
 * A decorator for a {@link BaseWeapon}.
 *
 */
public abstract class WeaponDecorator implements Weapon {

    private final Weapon weapon;

    public WeaponDecorator(final Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean use(final Player player) {
        return this.weapon.use(player);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDamage(final Use use) {
        return this.weapon.getDamage(use);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPrecision() {
        return this.weapon.getPrecision();
    }

}
