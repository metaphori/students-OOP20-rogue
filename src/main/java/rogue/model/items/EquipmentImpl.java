package rogue.model.items;

import java.util.Objects;
import java.util.Optional;
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
 *
 */
public class EquipmentImpl implements Equipment {

    private Weapon weapon;
    private Armor armor;
    private Optional<Ring> ring;

    static final class Memento {
        private final Weapon weapon;
        private final Armor armor;

        private Memento(final Weapon weapon, final Armor armor) {
            this.weapon = weapon;
            this.armor = armor;
        }

        private Weapon getWeapon() {
            return this.weapon;
        }

        private Armor getArmor() {
            return this.armor;
        }
    }

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

    private boolean updateRing(final Predicate<Optional<Ring>> predicate, final Optional<Ring> ring) {
        if (predicate.test(this.ring)) {
            this.ring = ring;
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean attachRing(final Ring ring) {
        return this.updateRing(r -> r.isEmpty(), Optional.of(ring));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean detachRing() {
        return this.updateRing(r -> r.isPresent(), Optional.empty());
    }

    // TODO

    public Memento save() {
        return new Memento(this.weapon, this.armor);
    }

    public void restore(final Memento memento) {
        this.armor = memento.getArmor();
        this.weapon = memento.getWeapon();
    }

}
