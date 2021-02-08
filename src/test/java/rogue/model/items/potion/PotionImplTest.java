package rogue.model.items.potion;

import org.junit.Test;

import rogue.model.creature.PlayerImpl;
import rogue.model.creature.PlayerLifeImpl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class PotionImplTest {

    private static final int REMOVE_AMOUNT_30 = 30;

    private PlayerImpl pl;

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
        pl = new PlayerImpl(new PlayerLifeImpl.Builder().build());
        final PotionImpl potion = new PotionImpl(PotionType.POTION_II);
        /*
         * Trying to use a potion with the max health.
         * Expecting false return.
         */
        assertFalse(potion.use(pl));
    }

    @Test
    public void testUseWithNormalHealth() {
        pl = new PlayerImpl(new PlayerLifeImpl.Builder().build());
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
}
