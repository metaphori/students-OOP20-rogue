package rogue.model.items.rings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;
import rogue.model.items.armor.ArmorImpl;
import rogue.model.items.armor.ArmorType;
import rogue.model.items.weapons.BaseWeapon;
import rogue.model.items.weapons.IncreaseAccuracy;
import rogue.model.items.weapons.IncreaseDamage;
import rogue.model.items.weapons.WeaponType;

public class RingsTest {

    private final Player player = new PlayerFactoryImpl().create();

    @Before
    public void initTest() {
        assertEquals(new ArmorImpl(ArmorType.LEATHER), player.getEquipment().getArmor());
        assertEquals(new BaseWeapon(WeaponType.MACE), player.getEquipment().getWeapon());
    }

    @Test
    public void testBasic1() {
        // Improves weapon accuracy
        final Ring ring = new RingImpl(RingType.DEXTERITY);
        assertTrue(ring.use(player));
        assertEquals(new IncreaseAccuracy(new BaseWeapon(WeaponType.MACE)), player.getEquipment().getWeapon());
        this.player.getEquipment().detachRing();
        assertEquals(new BaseWeapon(WeaponType.MACE), player.getEquipment().getWeapon());
    }

    @Test
    public void testBasic2() {
        // Improves armor AC
        final Ring ring = new RingImpl(RingType.PROTECTION);
        assertTrue(ring.use(player));
        assertEquals(10, player.getEquipment().getArmor().getAC());
        this.player.getEquipment().detachRing();
        assertEquals(8, player.getEquipment().getArmor().getAC());
    }

    @Test
    public void testChangeWeapon() {
        // Improves weapon accuracy
        final Ring ring = new RingImpl(RingType.DEXTERITY);
        assertTrue(ring.use(player));
        // change the weapon currently in use, so i expect the dexterity ring is now applied to arrow 
        player.getEquipment().setWeapon(new BaseWeapon(WeaponType.ARROW));
        assertEquals(new IncreaseAccuracy(new BaseWeapon(WeaponType.ARROW)), player.getEquipment().getWeapon());
        assertEquals(new ArmorImpl(ArmorType.LEATHER), player.getEquipment().getArmor());
        this.player.getEquipment().detachRing();
        assertEquals(new BaseWeapon(WeaponType.ARROW), player.getEquipment().getWeapon());
        assertEquals(new ArmorImpl(ArmorType.LEATHER), player.getEquipment().getArmor());
    }

    @Test
    public void testChangeWeapon1() {
        // Improves armor AC
        final Ring ring = new RingImpl(RingType.PROTECTION);
        assertTrue(ring.use(player));
        assertEquals(new BaseWeapon(WeaponType.MACE), player.getEquipment().getWeapon());
        assertEquals(10, player.getEquipment().getArmor().getAC());
        player.getEquipment().setWeapon(new BaseWeapon(WeaponType.ARROW));
        assertEquals(new BaseWeapon(WeaponType.ARROW), player.getEquipment().getWeapon());
        assertEquals(10, player.getEquipment().getArmor().getAC());
        this.player.getEquipment().detachRing();
        assertEquals(8, player.getEquipment().getArmor().getAC());
    }

    @Test
    public void testChangeArmor() {
        // Improves weapon accuracy
        final Ring ring = new RingImpl(RingType.DEXTERITY);
        assertTrue(ring.use(player));
        // change the armor -> does not produce any effects!
        player.getEquipment().setArmor(new ArmorImpl(ArmorType.CHAIN_MAIL));
        assertEquals(new IncreaseAccuracy(new BaseWeapon(WeaponType.MACE)), player.getEquipment().getWeapon());
        assertEquals(new ArmorImpl(ArmorType.CHAIN_MAIL), player.getEquipment().getArmor());
        this.player.getEquipment().detachRing();
        assertEquals(new BaseWeapon(WeaponType.MACE), player.getEquipment().getWeapon());
        assertEquals(new ArmorImpl(ArmorType.CHAIN_MAIL), player.getEquipment().getArmor());
    }

    @Test
    public void testChangeArmor1() {
        // Improves armor AC
        final Ring ring = new RingImpl(RingType.PROTECTION);
        assertTrue(ring.use(player));
        assertEquals(10, player.getEquipment().getArmor().getAC());
        // change the armor currently in use, so i expect the protection ring is now applied to the new armor 
        player.getEquipment().setArmor(new ArmorImpl(ArmorType.CHAIN_MAIL));
        assertEquals(7, player.getEquipment().getArmor().getAC());
    }

    @Test
    public void testReplace() {
        final Ring ring = new RingImpl(RingType.DEXTERITY);
        assertTrue(ring.use(player));
        assertEquals(new IncreaseAccuracy(new BaseWeapon(WeaponType.MACE)), player.getEquipment().getWeapon());
        assertEquals(new ArmorImpl(ArmorType.LEATHER), player.getEquipment().getArmor());

        final Ring ring2 = new RingImpl(RingType.INCREASE_DAMAGE);
        assertFalse(ring2.use(player));
        assertEquals(new IncreaseAccuracy(new BaseWeapon(WeaponType.MACE)), player.getEquipment().getWeapon());
        assertEquals(new ArmorImpl(ArmorType.LEATHER), player.getEquipment().getArmor());

        assertTrue(this.player.getEquipment().detachRing());
        assertTrue(ring2.use(player));
        assertEquals(new IncreaseDamage(new BaseWeapon(WeaponType.MACE)), player.getEquipment().getWeapon());
        assertEquals(new ArmorImpl(ArmorType.LEATHER), player.getEquipment().getArmor());
    }

}
