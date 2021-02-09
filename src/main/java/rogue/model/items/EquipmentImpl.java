package rogue.model.items;

import java.util.Objects;
import java.util.Optional;

import rogue.model.creature.Player;
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

    private final Player owner;

    private Weapon weapon;
    private Armor armor;
    private Optional<Ring> ring;

    public final class Memento {
        private final Weapon weapon;
        private final Armor armor;

        private Memento(final Weapon weapon, final Armor armor) {
            this.weapon = weapon;
            this.armor  = armor;
        }

        private Weapon getWeapon() {
            return this.weapon;
        }

        private Armor getArmor() {
            return this.armor;
        }
    }

    public EquipmentImpl(final Player player) {
        this.owner = player;
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
            this.ring.get().stopUsing(this.owner);
            this.armor = Objects.requireNonNull(armor);
            ring.use(owner);
        } else {
            this.armor = Objects.requireNonNull(armor);
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
    public void setWeapon(final Weapon weapon) {
        if (this.ring.isPresent()) {
            final Ring ring = this.ring.get();
            this.ring.get().stopUsing(this.owner);
            this.weapon = Objects.requireNonNull(weapon);
            ring.use(owner);
        } else {
            this.weapon = Objects.requireNonNull(weapon);
        }
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
    public Optional<Ring> getRing() {
        return this.ring;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attachRing(final Ring ring) {
        if (this.ring.isPresent()) {
            throw new IllegalStateException("One ring per time could be worn!");
        }
        this.ring = Optional.of(ring);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Memento save() {
        return new Memento(this.weapon, this.armor);
    }

    private void restore(final Memento m) {
        this.weapon = m.getWeapon();
        this.armor = m.getArmor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean detachRing(final Memento memento) {
        if (this.ring.isPresent()) {
            this.ring = Optional.empty();
            this.restore(memento);
            return true;
        }
        return false;
    }

}
