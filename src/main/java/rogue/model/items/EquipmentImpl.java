package rogue.model.items;

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
public final class EquipmentImpl implements Equipment {

    private final Player owner;
    private Weapon weapon;
    private Armor armor;
    private Optional<Ring> ring;

    private interface Operation {
        void doOperation();
    }

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

    private void set(final Operation op) {
        if (this.ring.isPresent()) {
            final Ring ring = this.ring.get();
            this.ring.get().stopUsing(this.owner);
            op.doOperation();
            ring.use(owner);
        } else {
            op.doOperation();
        }
    }

    @Override
    public void setArmor(final Armor armor) {
        this.set(() -> this.armor = armor);
    }

    @Override
    public void setWeapon(final Weapon weapon) {
        this.set(() -> this.weapon = weapon);
    }

    @Override
    public Weapon getWeapon() {
        return this.weapon;
    }

    @Override
    public Armor getArmor() {
        return this.armor;
    }

    @Override
    public Optional<Ring> getRing() {
        return this.ring;
    }

    @Override
    public void attachRing(final Ring ring) {
        if (this.ring.isPresent()) {
            throw new IllegalStateException("One ring per time could be worn!");
        }
        this.ring = Optional.of(ring);
    }

    @Override
    public Memento save() {
        return new Memento(this.weapon, this.armor);
    }

    private void restore(final Memento m) {
        this.weapon = m.getWeapon();
        this.armor = m.getArmor();
    }

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
