package rogue.model.items.inventory;

import org.junit.Test;

import rogue.model.creature.PlayerImpl;
import rogue.model.creature.PlayerLifeImpl;
import rogue.model.items.food.Food;
import rogue.model.items.food.FoodImpl;
import rogue.model.items.food.FoodType;
import rogue.model.items.potion.Potion;
import rogue.model.items.potion.PotionImpl;
import rogue.model.items.potion.PotionType;
import rogue.model.items.scroll.Scroll;
import rogue.model.items.scroll.ScrollImpl;
import rogue.model.items.scroll.ScrollType;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class ScrollContainerTest {

    private PlayerImpl pl;

    @Test
    public void testActivateScroll() {
        pl = new PlayerImpl(new PlayerLifeImpl.Builder().build());
        final Inventory inv = new InventoryImpl(pl);
        final Scroll scroll = new ScrollImpl(ScrollType.SCROLL_II);
        /*
         * check to active scroll.
         */
        assertTrue(inv.getScrollContainer().getActiveScroll().isEmpty());
        /*
         * activate a scroll.
         */
        inv.getScrollContainer().activateScroll(scroll);
        /*
         * check if activated.
         */
        assertEquals(scroll, inv.getScrollContainer().getActiveScroll().get());
    }
}
