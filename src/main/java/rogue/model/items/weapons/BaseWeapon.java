package rogue.model.items.weapons;

import rogue.model.creature.Player;

/**
 * A minimal implementation for a {@link Weapon}.
 */
public class BaseWeapon implements Weapon {

    private final WeaponType weapon;

    public BaseWeapon(final WeaponType weapon) {
        this.weapon = weapon;
    }

    /**
     * Equip the player with this weapon.
     */
    @Override
    public boolean use(final Player player) {
        player.getEquipment().setWeapon(this);
        return true;
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
        return this.weapon.getAccuracy();
    }

}
