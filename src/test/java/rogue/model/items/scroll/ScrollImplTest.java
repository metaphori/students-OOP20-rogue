package rogue.model.items.scroll;

import org.junit.Test;

//import rogue.model.creature.PlayerImpl;
//import rogue.model.creature.PlayerLifeImpl;

//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class ScrollImplTest {

    //private PlayerImpl pl;

    @Test
    public void testGetStrengthValue() {
        final Scroll scroll = new ScrollImpl(ScrollType.SCROLL_II);
        /*
         * After creating the scroll item, strength value
         * should be the same every time.
         */
        final int value = scroll.getEffectValue();
        assertEquals(value, scroll.getEffectValue());
    }
}
