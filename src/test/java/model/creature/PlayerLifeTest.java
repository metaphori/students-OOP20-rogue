package model.creature;

import static org.junit.Assert.assertEquals;

public final class PlayerLifeTest {

    private PlayerLife pl;

    @org.junit.Before
    public void init() {
        pl = new PlayerLifeImpl(50, 0, 5, 25);
    }

    @org.junit.Test
    public void testHealthPoints() {
        assertEquals(50, pl.getHealthPoints());
        pl.powerUp(10);
        assertEquals(60, pl.getHealthPoints());
        pl.powerUp(25);
        pl.hurt(60);
        assertEquals(25, pl.getHealthPoints());
        assertEquals(false, pl.isDead());
        pl.hurt(25);
        assertEquals(true, pl.isDead());
    }

    @org.junit.Test
    public void testExperience() {
        assertEquals(0, pl.getExperience());
        pl.increaseExperience(1);
        pl.increaseExperience(2);
        assertEquals(3, pl.getExperience());
    }

    @org.junit.Test
    public void testStrength() {
        assertEquals(5, pl.getStrength());
        pl.addStrength(3);
        assertEquals(8, pl.getStrength());
        pl.addStrength(5);
        assertEquals(13, pl.getStrength());
        assertEquals(false, pl.isDead());
    }

    @org.junit.Test
    public void testFood() {
        assertEquals(25, pl.getFood());
        pl.updateFood(5);
        pl.updateFood(-4);
        assertEquals(26, pl.getFood());
        pl.updateFood(-28);
        pl.updateFood(2);
        assertEquals(0, pl.getFood());
        assertEquals(true, pl.isDead());
    }

}
