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
public final class StatusBarControllerImpl extends AbstractPanelController<StatusBarView> implements EventSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(StatusBarControllerImpl.class);

    /**
     * Creates a new PlayerController.
     * @param statusBarView
     *          the {@link StatusBarView} which displays the player life's statistics
     * @param player
     *          the {@link Player} entity
     */
    public StatusBarControllerImpl(final StatusBarView statusBarView, final Player player) {
        super(statusBarView, player);
        player.getLife().register(this);
        player.getEquipment().register(this);
        // Sets the initial score and equipment view!
        this.onLifeChange(new LifeEvent<>(player.getLife()));
        this.onEquipmentChange(new EquipmentEvent(player.getEquipment()));
    }

    /**
     * TODO to refactor...
     * Notifies that the {@link PlayerLife} changed.
     * @param event
     *          the {@link LifeEvent} associated to the life change
     */
    @Subscribe
    public void onLifeChange(final LifeEvent<PlayerLife> event) {
        LOG.info("Life changed " + event);
        this.getView().setCoinsLabel(event.getLife().getCoins());
        this.getView().setCurrentHealthPointsLabel(event.getLife().getHealthPoints());
        this.getView().setMaxHealthPointsLabel(event.getLife().getMaxHealthPoints());
        this.getView().setExperienceLabel(event.getLife().getExperience());
        this.getView().setLevelLabel(event.getLife().getLevel());
        this.getView().setStrengthLabel(event.getLife().getStrength());
    }

    /**
     * TODO to refactor...
     * Notifies that the {@link Equipment} changed.
     * @param event
     *          the {@link EquipmentEvent} associated to the equipment change
     */
    @Subscribe
    public void onEquipmentChange(final EquipmentEvent event) {
        LOG.info("Equipment changed " + event);
        this.getView().setArmorLabel(event.getEquipment().getArmor());
        this.getView().setWeaponLabel(event.getEquipment().getWeapon());
    }

}
