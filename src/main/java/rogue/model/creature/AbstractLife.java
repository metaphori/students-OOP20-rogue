package rogue.model.creature;

/**
 * A generic implementation for a creature {@link Life}.
 *
 */
public abstract class AbstractLife implements Life {

    private int healthPoints;
    private int experience;

    protected AbstractLife(final int healthPoints, final int experience) {
        this.healthPoints = healthPoints;
        this.experience = experience;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hurt(final int damage) {
        this.healthPoints = this.healthPoints - damage < 0 ? 0 : this.healthPoints - damage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    /**
     * 
     * @param healthPoints
     *          the healthPoints
     */
    protected void setHealthPoints(final int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getExperience() {
        return this.experience;
    }

    /**
     * 
     * @param experience
     *          the experience
     */
    protected void setExperience(final int experience) {
        this.experience = experience;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDead() {
        return this.healthPoints == 0;
    }

}
