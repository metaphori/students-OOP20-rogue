package OOP20.rogue;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import OOP20.rogue.model.world.World;
import OOP20.rogue.model.world.WorldImpl;

public class WorldTest {
    @Test public void testWorldCreation() {
        World w = new WorldImpl(5);
        assertNotNull(w.getLevel(0).getTileStream().findFirst());
    }
}
