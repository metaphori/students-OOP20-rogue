package rogue.model.creature;

import java.util.Objects;
import java.util.Optional;

import rogue.model.items.armor.Armor;
import rogue.model.items.armor.ArmorImpl;
import rogue.model.items.armor.ArmorType;
import rogue.model.items.rings.Ring;
import rogue.model.items.weapons.BaseWeapon;
import rogue.model.items.weapons.Weapon;
import rogue.model.items.weapons.WeaponType;

/**
 * An implementation for an {@link Equipment}.
 *
 */
public class EquipmentImpl implements Equipment {

    private Weapon weapon;
    private Armor armor;
    private Optional<Ring> ring;

    public EquipmentImpl() {
        this.weapon = new BaseWeapon(WeaponType.MACE);
        this.armor = new ArmorImpl(ArmorType.LEATHER);
        this.ring = Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Armor getArmor() {
        return this.armor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setArmor(final Armor armor) {
        this.armor = Objects.requireNonNull(armor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Weapon getWeapon() {
        return this.weapon;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWeapon(final Weapon weapon) {
        this.weapon = Objects.requireNonNull(weapon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Ring> getRing() {
        return this.ring;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean putRing(final Ring ring) {
        if (this.ring.isEmpty()) {
            this.ring = Optional.of(ring);
            return true;
        }
        return false;
    }

}
