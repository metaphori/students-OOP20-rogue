package rogue;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import rogue.model.world.World;
import rogue.model.world.WorldImpl;

public class WorldTest {
    @Test public void testWorldCreation() {
        World w = new WorldImpl(5);
        assertNotNull(w.getLevel(0).getTileStream().findFirst());
    }
}
