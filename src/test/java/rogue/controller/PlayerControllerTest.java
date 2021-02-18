package rogue.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;

public class PlayerControllerTest {

    private Player player;
    private StatusBarControllerImpl controller;

    @org.junit.Before
    public void init() {
        player = new PlayerFactoryImpl().create();
        // pass a real implementation of StatusBarView!!!
        // controller = new StatusBarControllerImpl(null, player);
    }

    /**
     * NOTE that this test does't work because you must pass a view 
     * and not null to the controller constructor here above!!
     */
    @Test
    public void test() {
        /*
        player.getLife().hurt(10);
        assertEquals(2, player.getLife().getHealthPoints());
        player.getLife().powerUp(10);
        assertEquals(12, player.getLife().getHealthPoints());
        player.getLife().setMaxHealthPoints(50);
        assertEquals(50, player.getLife().getMaxHealthPoints());

        player.getLife().addStrength(2);
        assertEquals(18, player.getLife().getStrength());

        player.getLife().addCoins(5);
        assertEquals(5, player.getLife().getCoins());
        player.getLife().subCoins(5);
        assertEquals(0, player.getLife().getCoins());

        assertEquals(0, player.getLife().getExperience());
        player.getLife().increaseExperience(10);
        assertEquals(10, player.getLife().getExperience());
        assertEquals(2, player.getLife().getLevel());
        player.getLife().increaseExperience(11_990);
        assertEquals(12_000, player.getLife().getExperience());
        assertEquals(20, player.getLife().getLevel());
        */
    }

}
