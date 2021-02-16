package rogue.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;
import rogue.model.items.armor.ArmorImpl;
import rogue.model.items.armor.ArmorType;
import rogue.model.items.rings.Ring;
import rogue.model.items.rings.RingImpl;
import rogue.model.items.rings.RingType;
import rogue.model.items.weapons.BaseWeapon;
import rogue.model.items.weapons.IncreaseAccuracy;
import rogue.model.items.weapons.WeaponType;
import rogue.view.StatusBarViewImpl;

public class PlayerControllerTest {

    private Player player;

    @org.junit.Before
    public void init() {
        // with default configs
        player = new PlayerFactoryImpl().create();
        new PlayerController(new StatusBarViewImpl(), player);
    }

    @org.junit.Test
    public void testChangeLife() {
        final int val = 10;
        final int hp = player.getLife().getHealthPoints();
        player.getLife().hurt(val);
        assertEquals(hp - val, player.getLife().getHealthPoints());
        player.getLife().powerUp(val);
        assertEquals(hp, player.getLife().getHealthPoints());
    }

    @org.junit.Test
    public void testChangeEquipment() {
        final Ring ring = new RingImpl(RingType.DEXTERITY);
        player.getEquipment().setWeapon(new BaseWeapon(WeaponType.SHURIKEN));
        player.getEquipment().setArmor(new ArmorImpl(ArmorType.SPLINT_MAIL));
        assertTrue(ring.use(player));
        assertEquals(new IncreaseAccuracy(new BaseWeapon(WeaponType.SHURIKEN)), player.getEquipment().getWeapon());
        assertEquals(new ArmorImpl(ArmorType.SPLINT_MAIL), player.getEquipment().getArmor());
        player.getEquipment().setWeapon(new BaseWeapon(WeaponType.SHORT_BOW));
        player.getEquipment().setWeapon(new BaseWeapon(WeaponType.DAGGER));
        assertEquals(new IncreaseAccuracy(new BaseWeapon(WeaponType.DAGGER)), player.getEquipment().getWeapon());
        player.getEquipment().setArmor(new ArmorImpl(ArmorType.PLATE_MAIL));
        assertEquals(new ArmorImpl(ArmorType.PLATE_MAIL), player.getEquipment().getArmor());
        ring.stopUsing(player);
        assertEquals(new ArmorImpl(ArmorType.PLATE_MAIL), player.getEquipment().getArmor());
        assertEquals(new BaseWeapon(WeaponType.DAGGER), player.getEquipment().getWeapon());
    }

}
