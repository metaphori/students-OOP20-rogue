package rogue.model.items.potion;

import org.junit.Test;

import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class PotionImplTest {
    /*
     * TODO FIX TESTS 
     */

    private static final int MAXIMUM_HEALTH = 50;
    private static final int REMOVE_AMOUNT_40 = 40;
    private static final int REMOVE_AMOUNT_30 = 30;
    private static final int REMOVE_AMOUNT_20 = 20;
    private static final int REMOVE_AMOUNT_10 = 10;

    private Player pl;

    @Test
    public void testGetHpValue() {
        final PotionImpl potion = new PotionImpl(PotionType.POTION_II);
        /*
         * Once the potion's created, getHpValue should 
         * return the same value every time. Only PotionType's
         * getHpValue random.
         */
        final int value = potion.getHpValue();
        assertEquals(value, potion.getHpValue());
    }

    @Test
    public void testUseWithMaxHealth() {
        //pl = new PlayerFactoryImpl().create();
        //final PotionImpl potion = new PotionImpl(PotionType.POTION_II);
        /*
         * Trying to use a potion with the max health.
         * Expecting false return.
         */
        //assertFalse(potion.use(pl));
    }

    @Test
    public void testUseWithNormalHealth() {
        pl = new PlayerFactoryImpl().create();
        final PotionImpl potion = new PotionImpl(PotionType.POTION_II);
        /*
         * Trying to use a potion without max health.
         * Expecting true return and correct update of the health.
         */
        pl.getLife().hurt(REMOVE_AMOUNT_30);
        final int newAmount = pl.getLife().getHealthPoints();
        assertTrue(potion.use(pl));
        assertEquals(newAmount + potion.getHpValue(), pl.getLife().getHealthPoints());
    }

    @Test
    public void testWithMaxHealth() {
        //pl = new PlayerFactoryImpl().create();
        //final PotionImpl potion = new PotionImpl(PotionType.POTION_II);
        /*
         * Using potion with max health, expecting false return.
         */
        //assertFalse(potion.use(pl));
    }

    @Test
    public void testExceedMaxHealth() {
        //pl = new PlayerFactoryImpl().create();
        //final PotionImpl potion = new PotionImpl(PotionType.POTION_II);
        /*
         * Use potion that would exceed the max health,
         * expecting true return and correct health update.
         * potion II give 15-20 removing 10.
         */
        //pl.getLife().hurt(REMOVE_AMOUNT_10);
        //assertTrue(potion.use(pl));
        //assertEquals(MAXIMUM_HEALTH, pl.getLife().getHealthPoints());
    }

    @Test
    public void useCorruptWithMaxHealth() {
        //pl = new PlayerFactoryImpl().create();
        //final PotionImpl potion = new PotionImpl(PotionType.CORRUPT_POTION_I);
        /*
         * Use a corrupt potion with max health,
         * Except true and correct health update.
         */
        //assertTrue(potion.use(pl));
        //assertEquals(MAXIMUM_HEALTH + potion.getHpValue(), pl.getLife().getHealthPoints());
    }

    @Test
    public void useCorruptWithNormalHealth() {
        //pl = new PlayerFactoryImpl().create();
        //final PotionImpl potion = new PotionImpl(PotionType.CORRUPT_POTION_I);
        /*
         * Use a corrupt potion with normal health,
         * Except true and correct health update.
         */
        //pl.getLife().hurt(REMOVE_AMOUNT_20);
        //final int newAmount = pl.getLife().getHealthPoints();
        //assertTrue(potion.use(pl));
        //assertEquals(newAmount + potion.getHpValue(), pl.getLife().getHealthPoints());
    }

    @Test
    public void useCorruptBelowZero() {
        pl = new PlayerFactoryImpl().create();
        final PotionImpl potion = new PotionImpl(PotionType.CORRUPT_POTION_II);
        /*
         * Use corrupt potion when the potion value would
         * set the health below zero.
         * Expect true and correct update of health to 0.
         * corrupt potion II removes from 15-20, set health to 10.
         */
        pl.getLife().hurt(REMOVE_AMOUNT_40);
        assertTrue(potion.use(pl));
        assertEquals(0, pl.getLife().getHealthPoints());
    }
}
