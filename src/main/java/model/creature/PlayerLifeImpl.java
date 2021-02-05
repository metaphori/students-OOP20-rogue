package model.creature;

public class PlayerLifeImpl extends AbstractLife implements PlayerLife {

    private int strength;
    private int leftFood;

    public PlayerLifeImpl(final int healthPoints, final int experience, final int strength, final int food) {
        super(healthPoints, experience);
        this.strength = strength;
        this.leftFood = food;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void increaseExperience(final int increment) {
        this.setExperience(this.getExperience() + increment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void powerUp(final int increment) {
        this.setHealthPoints(this.getHealthPoints() + increment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addStrength(final int increment) {
        this.strength = this.strength + increment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getStrength() {
        return this.strength;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateFood(final int quantity) {
        this.leftFood = this.leftFood + quantity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFood() {
        return this.leftFood;
    }

}
