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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((weapon == null) ? 0 : weapon.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseWeapon)) {
            return false;
        }
        final BaseWeapon other = (BaseWeapon) obj;
        return weapon == other.weapon;
    }

    @Override
    public String toString() {
        return "BaseWeapon [weapon=" + weapon + "]";
    }

}
