package rogue.model.creature;

import com.google.common.eventbus.EventBus;

import rogue.model.events.EntityEvent;
import rogue.model.events.EventSubscriber;
import rogue.model.events.LifeEvent;

/**
 * A generic implementation for a creature {@link Life}.
 */
public abstract class AbstractLife implements Life {

    private final EventBus eventBus = new EventBus("Life");

    private int healthPoints;
    private int experience;

    /**
     * Creates a new AbstractLife.
     * @param healthPoints
     *          the health points value
     * @param experience
     *          the experience value
     */
    protected AbstractLife(final int healthPoints, final int experience) {
        this.healthPoints = healthPoints;
        this.experience = experience;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void post(final EntityEvent event) {
        this.eventBus.post(event);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void register(final EventSubscriber subscriber) {
        this.eventBus.register(subscriber);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unregister(final EventSubscriber subscriber) {
        this.eventBus.unregister(subscriber);
    }

    /**
     * Check if value is negative or not. 
     * @param value
     *          the value to check
     * @return the value given if it is positive, 0 otherwise
     */
    protected int checkNotNegative(final int value) {
        return value < 0 ? 0 : value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hurt(final int damage) {
        this.healthPoints = checkNotNegative(this.healthPoints - damage);
        this.post(new LifeEvent<>(this));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    /**
     * Set the health points to the given value.
     * @param healthPoints
     *          the healthPoints
     */
    protected void setHealthPoints(final int healthPoints) {
        this.healthPoints = healthPoints;
        this.post(new LifeEvent<>(this));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getExperience() {
        return this.experience;
    }

    /**
     * Set the experience to the given value.
     * @param experience
     *          the experience
     */
    protected void setExperience(final int experience) {
        this.experience = experience;
        this.post(new LifeEvent<>(this));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDead() {
        return this.healthPoints == 0;
    }

}
