package model.creature;

import static org.junit.Assert.assertEquals;

public class PlayerImplTest {

    private PlayerImpl pl;

    @org.junit.Before
    public void init() {
        pl = new PlayerImpl(new PlayerLifeImpl(50, 0, 10, 4));
    }

    @org.junit.Test
    public void testLife() {
        assertEquals(50, pl.getLife().getHealthPoints());
        assertEquals(0, pl.getLife().getExperience());
        assertEquals(10, pl.getLife().getStrength());
        assertEquals(4, pl.getLife().getFood());

        pl.getLife().hurt(49);
        assertEquals(false, pl.getLife().isDead());
        pl.getLife().increaseExperience(10);
        assertEquals(10, pl.getLife().getExperience());
        pl.getLife().updateFood(-4);
        assertEquals(true, pl.getLife().isDead());
    }

}
