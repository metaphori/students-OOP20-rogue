package rogue.model.items.inventory;

import org.junit.Test;

import rogue.model.creature.PlayerImpl;
import rogue.model.creature.PlayerLifeImpl;
import rogue.model.items.potion.Potion;
import rogue.model.items.potion.PotionImpl;
import rogue.model.items.potion.PotionType;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class InventoryImplTest {

    private static final int INVENTORY_SIZE = 20;
    private static final int ITEM_AMOUNT_MAX = 10;

    private PlayerImpl pl;

    @Test
    public void testAddItemAndGetItem() {
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
}
