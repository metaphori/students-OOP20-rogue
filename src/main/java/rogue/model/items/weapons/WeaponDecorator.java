package rogue.model.items.weapons;

import rogue.model.creature.Player;

/**
 * A decorator for a {@link BaseWeapon}.
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((weapon == null) ? 0 : weapon.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeaponDecorator)) {
            return false;
        }
        WeaponDecorator other = (WeaponDecorator) obj;
        if (weapon == null) {
            if (other.weapon != null) {
                return false;
            }
        } else if (!weapon.equals(other.weapon)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.weapon.toString();
    }

}
