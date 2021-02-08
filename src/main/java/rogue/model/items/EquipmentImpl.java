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
    private Memento memento;

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
    public Weapon getWeapon() {
        return this.weapon;
    }

    private void reset() {
        this.weapon = this.memento.getWeapon();
        this.armor = this.memento.getArmor();
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
    public Optional<Ring> getRing() {
        return this.ring;
    }

    @Override
    public boolean attachRing(Ring ring) {
        if (this.ring.isEmpty()) {
            this.memento = new Memento(this.weapon, this.armor);
            ring.consume(this);
            this.ring = Optional.of(ring);
            return true;
        } 
        return false;
    }

    @Override
    public boolean detachRing() {
        if (this.ring.isEmpty()) {
            return false;
        }
        this.reset();
        this.ring = Optional.empty();
        return true;
    }

//    private boolean updateRing(final Predicate<Optional<Ring>> predicate, final Optional<Ring> ring) {
//        if (predicate.test(this.ring)) {
//            this.ring = ring;
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public boolean attachRing(final Ring ring) {
//        return this.updateRing(r -> r.isEmpty(), Optional.of(ring));
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public boolean detachRing() {
//        return this.updateRing(r -> r.isPresent(), Optional.empty());
//    }

}
