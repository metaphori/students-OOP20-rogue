package OOP20.rogue;

import org.junit.Test;

import OOP20.rogue.model.world.World;
import OOP20.rogue.model.world.WorldImpl;

import static org.junit.Assert.*;

public class WorldTest {
    @Test public void testWorldCreation() {
        World w = new WorldImpl(5);
        assertNotNull(w.getLevel(0).getTile(0, 0));
    }
}
