package rogue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;
import rogue.view.PlayerView;

public class PlayerControllerTest {

    private static final Logger LOG = LoggerFactory.getLogger(PlayerController.class);

    private Player pl;
    private PlayerController pController;

    @org.junit.Before
    public void init() {
        // with default configs
        pl = new PlayerFactoryImpl().create();
        pController = new PlayerController(new PlayerView() { }, pl);
    }

    @org.junit.Test
    public void testDefaultsLife() {
        LOG.info("hurt");
        pl.getLife().hurt(5);
    }

}
