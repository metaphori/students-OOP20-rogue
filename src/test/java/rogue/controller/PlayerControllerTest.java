package rogue.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;

public class PlayerControllerTest {

    private Player player;
    private PlayerController controller;

    @org.junit.Before
    public void init() {
        player = new PlayerFactoryImpl().create();
        controller = new PlayerController(null, player);
    }

    @Test
    public void test() {
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

        player.getLife().increaseExperience(10);
    }

}
