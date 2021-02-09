package rogue.model.items.inventory;

import org.junit.Test;

import rogue.model.creature.PlayerImpl;
import rogue.model.creature.PlayerLifeImpl;
import rogue.model.items.potion.Potion;
import rogue.model.items.potion.PotionImpl;
import rogue.model.items.potion.PotionType;
import rogue.model.items.scroll.Scroll;
import rogue.model.items.scroll.ScrollImpl;
import rogue.model.items.scroll.ScrollType;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class InventoryImplTest {

    private static final int INVENTORY_SIZE = 20;
    private static final int ITEM_AMOUNT_MAX = 10;

    private PlayerImpl pl;

    @Test
    public void testAddItemAndGetItemPotion() {
        pl = new PlayerImpl(new PlayerLifeImpl.Builder().build());
        final Inventory inv = new InventoryImpl(pl);
        final Potion potion = new PotionImpl(PotionType.POTION_I);
        /*
         * Add item to inventory, expect true and correct
         * inventory update.
         */
        try {
            assertTrue(inv.addItem(potion));
        } catch (InventoryIsFullException e) {
            e.printStackTrace();
        }
        assertTrue(inv.getItem(1).isPresent());
        assertFalse(inv.getItem(2).isPresent());
        assertEquals(potion, inv.getItem(1).get());
    }

    @Test
    public void testAddTwoItemScroll() {
        pl = new PlayerImpl(new PlayerLifeImpl.Builder().build());
        final Inventory inv = new InventoryImpl(pl);
        final Scroll scroll = new ScrollImpl(ScrollType.SCROLL_II);
        final Scroll scroll2 = new ScrollImpl(ScrollType.SCROLL_V);
        /*
         * Add item to inventory, expect true and correct
         * inventory update.
         */
        try {
            assertTrue(inv.addItem(scroll));
        } catch (InventoryIsFullException e) {
            e.printStackTrace();
        }
        assertTrue(inv.getItem(1).isPresent());
        assertFalse(inv.getItem(2).isPresent());
        assertEquals(scroll, inv.getItem(1).get());
        /*
         * Add a different scroll, expect different item
         * to be stored in slot 2.
         */
        try {
            assertTrue(inv.addItem(scroll2));
        } catch (InventoryIsFullException e) {
            e.printStackTrace();
        }
        assertTrue(inv.getItem(1).isPresent());
        assertEquals(scroll, inv.getItem(1).get());
        assertTrue(inv.getItem(2).isPresent());
        assertEquals(scroll2, inv.getItem(2).get());
    }
}
