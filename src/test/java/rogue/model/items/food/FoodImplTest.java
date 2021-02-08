package rogue.model.items.food;

import org.junit.Test;

import rogue.model.creature.PlayerImpl;
import rogue.model.creature.PlayerLifeImpl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class FoodImplTest {

    private static final int HUNGER_MAX = 50;
    private static final int REMOVE_AMOUNT_20 = -20;
    private PlayerImpl pl;

    @Test
    public void testUseMaxHunger() {
        pl = new PlayerImpl(new PlayerLifeImpl.Builder().build());
        final FoodImpl testFood = new FoodImpl(FoodType.APPLE);
        /*
         * Consume food with full hunger.
         * expecting false return.
         */
        assertEquals(HUNGER_MAX, pl.getLife().getFood());
        assertFalse(testFood.use(pl));
    }

    @Test
    public void testUseNormalHunger() {
        pl = new PlayerImpl(new PlayerLifeImpl.Builder().build());
        final FoodImpl testFood = new FoodImpl(FoodType.APPLE);
        /*
         * Consume food with not full hunger.
         * expecting true return and correctly updated hunger.
         */
        pl.getLife().updateFood(REMOVE_AMOUNT_20);
        final int newAmount = pl.getLife().getFood();
        assertTrue(testFood.use(pl));
        assertEquals(newAmount + testFood.getStarvationValue(), pl.getLife().getFood());
    }
}
