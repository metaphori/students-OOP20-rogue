package rogue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;

import rogue.model.creature.Player;
import rogue.model.creature.PlayerLife;
import rogue.model.events.EquipmentEvent;
import rogue.model.events.EventSubscriber;
import rogue.model.events.LifeEvent;
import rogue.view.StatusBarView;

/**
 * The player controller.
 */
public final class PlayerController extends AbstractEntityController<StatusBarView> implements EventSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(PlayerController.class);

    /**
     * Creates a new PlayerController.
     * @param statusBarView
     *          the {@link StatusBarView} which displays the player life's statistics
     * @param player
     *          the {@link Player} entity
     */
    public PlayerController(final StatusBarView statusBarView, final Player player) {
        super(statusBarView, player);
        player.getLife().register(this);
        player.getEquipment().register(this);
        // Sets the initial score view!
        this.onLifeChange(new LifeEvent<>(player.getLife()));
    }

    /**
     * Notifies that the {@link PlayerLife} changed.
     * @param event
     *          the {@link LifeEvent} associated to the life change
     */
    @Subscribe
    public void onLifeChange(final LifeEvent<PlayerLife> event) {
        LOG.info("Life changed " + event);
        this.getView().setCoins(event.getLife().getCoins());
        this.getView().setCurrentHealthPoints(event.getLife().getHealthPoints());
        this.getView().setMaxHealthPoints(event.getLife().getMaxHealthPoints());
        this.getView().setExperience(event.getLife().getExperience());
        this.getView().setLevel(event.getLife().getLevel());
        this.getView().setStrength(event.getLife().getStrength());
    }

    /**
     * TODO to refactor...
     * Notifies that the {@link Equipment} changed.
     * @param event
     *          the {@link EquipmentEvent} associated to the equipment change
     */
    @Subscribe
    public void onEquipmentChange(final EquipmentEvent event) {
        LOG.info("Equipment changed");
        // TODO
    }

}
