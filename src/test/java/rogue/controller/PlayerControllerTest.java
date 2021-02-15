package rogue.controller;

import static org.junit.Assert.assertEquals;

import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;
import rogue.view.PlayerView;

public class PlayerControllerTest {

    private Player pl;

    @org.junit.Before
    public void init() {
        // with default configs
        pl = new PlayerFactoryImpl().create();
        new PlayerController(new PlayerView() { }, pl);
    }

    @org.junit.Test
    public void testDefaultsLife() {
        pl.getLife().hurt(10);
        assertEquals(2, pl.getLife().getHealthPoints());
    }

}
