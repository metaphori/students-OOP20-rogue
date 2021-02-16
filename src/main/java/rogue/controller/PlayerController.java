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
public final class PlayerController extends AbstractEntityController implements EventSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(PlayerController.class);

    protected PlayerController(final StatusBarView statusBarView, final Player player) {
        super(statusBarView, player);
        player.getLife().register(this);
        player.getEquipment().register(this);
    }

    /**
     * 
     * @param event
     */
    @Subscribe
    public void onLifeChange(final LifeEvent<PlayerLife> event) {
        LOG.info("life changed " + event.getLife().getHealthPoints());
        // TODO: update status bar view
    }

    /**
     * 
     * @param event
     */
    @Subscribe
    public void onEquipmentChange(final EquipmentEvent event) {
        LOG.info("equipment changed ");
        LOG.info("Armor: " + event.getEquipment().getArmor());
        LOG.info("Weapon: " + event.getEquipment().getWeapon());
        // TODO: update equipment view
    }

}
