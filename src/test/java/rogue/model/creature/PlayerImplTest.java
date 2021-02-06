package rogue.model.creature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerImplTest {

    private Player pl;

    @org.junit.Before
    public void init() {
    }

    @org.junit.Test
    public void testDefaultsLife() {
        // with default configs
        pl = new PlayerFactoryImpl().create();

        assertEquals(50, pl.getLife().getHealthPoints());
        assertEquals(0, pl.getLife().getExperience());
        assertEquals(0, pl.getLife().getStrength());
        assertEquals(50, pl.getLife().getFood());

        pl.getLife().hurt(49);
        assertEquals(1, pl.getLife().getHealthPoints());
        assertFalse(pl.getLife().isDead());
        pl.getLife().increaseExperience(10);
        assertEquals(10, pl.getLife().getExperience());
        pl.getLife().updateFood(-4);
        assertFalse(pl.getLife().isDead());
        assertEquals(46, pl.getLife().getFood());
        pl.getLife().updateFood(-46);
        pl.getLife().updateFood(+3);
        pl.getLife().updateFood(-2);
        pl.getLife().updateFood(-1);
        assertTrue(pl.getLife().isDead());
    }

    @org.junit.Test
    public void testExplicitLife() {
        // with default configs
        final PlayerLifeImpl.Builder lifeBuilder = new PlayerLifeImpl.Builder();
        pl = new PlayerFactoryImpl().createByLife(lifeBuilder.initExperience(20).initFood(10).initStrength(50).initHealthPoints(3).build());

        assertEquals(3, pl.getLife().getHealthPoints());
        assertEquals(20, pl.getLife().getExperience());
        assertEquals(50, pl.getLife().getStrength());
        assertEquals(10, pl.getLife().getFood());

        pl.getLife().hurt(2);
        assertEquals(1, pl.getLife().getHealthPoints());
        assertFalse(pl.getLife().isDead());
        pl.getLife().increaseExperience(10);
        assertEquals(30, pl.getLife().getExperience());
        pl.getLife().updateFood(-4);
        assertFalse(pl.getLife().isDead());
        assertEquals(6, pl.getLife().getFood());
        pl.getLife().updateFood(-6);
        pl.getLife().updateFood(+3);
        pl.getLife().updateFood(-2);
        pl.getLife().updateFood(-1);
        assertTrue(pl.getLife().isDead());
    }

    @org.junit.Test(expected = IllegalStateException.class)
    public void testMultipleBuild() {
        // cannot be built multiple times...
        final PlayerLifeImpl.Builder lifeBuilder = new PlayerLifeImpl.Builder();
        lifeBuilder.initExperience(20).initFood(10).initStrength(50).initHealthPoints(3).build();
        lifeBuilder.build();
    }

}
