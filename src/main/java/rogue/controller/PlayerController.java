package rogue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;

import rogue.model.creature.Player;
import rogue.model.events.EventSubscriber;
import rogue.model.events.LifeEvent;
import rogue.view.PlayerView;

/**
 * The player controller.
 */
public final class PlayerController extends AbstractEntityController implements EventSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(PlayerController.class);

    protected PlayerController(final PlayerView playerView, final Player player) {
        super(playerView, player);
        player.getLife().register(this);
    }

    /**
     * 
     * @param event
     */
    @Subscribe
    public void onLifeChange(final LifeEvent event) {
        LOG.info("life changed");
    }

}
