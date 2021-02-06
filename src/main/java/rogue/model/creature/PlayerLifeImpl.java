package rogue.model.creature;

public final class PlayerLifeImpl extends AbstractLife implements PlayerLife {

    private int strength;
    private int leftFood;

    private PlayerLifeImpl(final int healthPoints, final int experience, final int strength, final int food) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDead() {
        return super.isDead() || this.leftFood == 0;
    }

    public static class Builder {

        // TODO review constants!
        private static final int HEALTH_POINTS = 50;
        private static final int FOOD = 50;
        private static final int EXPERIENCE = 0;
        private static final int STRENGTH = 0;

        private int healthPoints = HEALTH_POINTS;
        private int food = FOOD;
        private int experience = EXPERIENCE;
        private int strength = STRENGTH;
        private boolean consumed;

        /**
         * Initialize the food.
         * @param food
         *      the initial food quantity
         * @return this Builder for chaining
         */
        public Builder initFood(final int food) {
            this.food = food;
            return this;
        }

        /**
         * Initialize the player experience.
         * @param experience
         *      the initial player experience
         * @return this Builder for chaining
         */
        public Builder initExperience(final int experience) {
            this.experience = experience;
            return this;
        }

        /**
         * Initialize the player health points.
         * @param healthPoints
         *      the initial player health points.
         * @return this Builder for chaining
         */
        public Builder initHealthPoints(final int healthPoints) {
            this.healthPoints = healthPoints;
            return this;
        }

        /**
         * Initialize the player experience.
         * @param strength
         *      the initial player strength
         * @return this Builder for chaining
         */
        public Builder initStrength(final int strength) {
            this.strength = strength;
            return this;
        }

        public final PlayerLifeImpl build() {
            if (consumed) {
                throw new IllegalStateException("The builder can only be used once");
            }
            consumed = true;
            return new PlayerLifeImpl(healthPoints, experience, strength, food);
        }
    }
}
