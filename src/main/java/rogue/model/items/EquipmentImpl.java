package rogue.model.items;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import rogue.model.items.armor.Armor;
import rogue.model.items.armor.ArmorImpl;
import rogue.model.items.armor.ArmorType;
import rogue.model.items.rings.Ring;
import rogue.model.items.weapons.BaseWeapon;
import rogue.model.items.weapons.Weapon;
import rogue.model.items.weapons.WeaponType;

/**
 * An implementation for an {@link Equipment}.
 */
public class EquipmentImpl implements Equipment {

    private Weapon lastWeapon;
    private Armor lastArmor;

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
    public void setArmor(final Armor armor) {
        if (this.ring.isPresent()) {
            final Ring ring = this.ring.get();
            this.detachRing();
            this.armor = Objects.requireNonNull(armor);
            this.attachRing(ring);
        } else {
            this.armor = Objects.requireNonNull(armor);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWeapon(final Weapon weapon) {
        if (this.ring.isPresent()) {
            final Ring ring = this.ring.get();
            this.detachRing();
            this.weapon = Objects.requireNonNull(weapon);
            this.attachRing(ring);
        } else {
            this.weapon = Objects.requireNonNull(weapon);
        }

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
    public Weapon getWeapon() {
        return this.weapon;
    }

    private void setState() {
        this.lastArmor = this.armor;
        this.lastWeapon = this.weapon;
    }

    private void restore() {
        this.weapon = this.lastWeapon;
        this.armor = this.lastArmor;
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
    public boolean attachRing(final Ring ring) {
        if (this.ring.isEmpty()) {
            this.setState();
            ring.consume(this);
            this.ring = Optional.of(ring);
            return true;
        } 
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean detachRing() {
        if (this.ring.isEmpty()) {
            return false;
        }
        this.restore();
        this.ring = Optional.empty();
        return true;
    }

}
