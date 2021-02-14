package rogue.model.creature;

/**
 * An implementation for a {@link PlayerLife}. 
 * Uses the pattern builder in order to create a new instance (even custom).
 */
public final class PlayerLifeImpl extends AbstractLife implements PlayerLife {

    private static final int MAX_FOOD = 100; // fixed
    private int maxHealthPoints; // changes dynamically during the game
    private int strength;
    private int leftFood;
    private int level;
    private int coins;

    private PlayerLifeImpl(final int healthPoints, final int maxHealthPoints, final int experience, 
            final int strength, final int food, final int level, final int coins) {
        super(healthPoints, experience);
        this.maxHealthPoints = maxHealthPoints;
        this.strength = strength;
        this.leftFood = food;
        this.level = level;
        this.coins = coins;
    }

    @Override
    public void increaseExperience(final int increment) {
        this.setExperience(this.getExperience() + increment);
    }

    @Override
    public void powerUp(final int increment) {
        this.setHealthPoints(this.getHealthPoints() + increment);
    }

    @Override
    public void addStrength(final int increment) {
        this.strength = this.strength + increment;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    private void updateFood(final int amount) {
        this.leftFood = this.checkNonNegative(this.leftFood + amount);
    }

    @Override
    public void increaseFood(final int amount) {
        this.updateFood(amount);
    }

    @Override
    public void decreaseFood(final int amount) {
        this.updateFood(-amount);
    }

    @Override
    public int getFood() {
        return this.leftFood;
    }

    @Override
    public boolean isDead() {
        return super.isDead() || this.leftFood == 0;
    }

    private void updateCoins(final int amount) {
        this.coins = this.checkNonNegative(this.coins + amount);
    }

    @Override
    public void addCoins(final int amount) {
        this.updateCoins(amount);
    }

    @Override
    public void subCoins(final int amount) {
        this.updateCoins(-amount);
    }

    @Override
    public int getCoins() {
        return this.coins;
    }

    @Override
    public void increaseLevel(final int amount) {
        this.level = this.level + amount;
    }

    @Override
    public int getLevel() {
        return this.level;
    }
    
    @Override
    public void setMaxHealthPoints(int maxHealthPoints) {
        if (maxHealthPoints > this.getHealthPoints()) {
            throw new IllegalStateException("The current value of hp cannot be greater than the maximum one!");
        }
        this.maxHealthPoints = maxHealthPoints;
    }

    @Override
    public int getMaxHealthPoints() {
        return this.maxHealthPoints;
    }

    public static class Builder {

        /**
         * Default values.
         */
        private static final int MAX_HEALTH_POINTS = 12;
        private static final int HEALTH_POINTS = 12;
        private static final int FOOD = 50; 
        private static final int EXPERIENCE = 0;
        private static final int STRENGTH = 16;
        private static final int COINS = 0;
        private static final int LEVEL = 0;
        
        private int maxHealthPoints = MAX_HEALTH_POINTS;
        private int healthPoints = HEALTH_POINTS;
        private int food = FOOD;
        private int experience = EXPERIENCE;
        private int strength = STRENGTH;
        private int level = LEVEL;
        private int coins = COINS;
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
         * Initialize the player health points.
         * @param healthPoints
         *      the initial player health points.
         * @return this Builder for chaining
         */
        public Builder initMaxHealthPoints(final int maxHealthPoints) {
            this.maxHealthPoints = maxHealthPoints;
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

        /**
         * Initialize the player level.
         * @param level
         *      the initial player level
         * @return this Builder for chaining
         */
        public Builder initLevel(final int level) {
            this.level = level;
            return this;
        }

        /**
         * Initialize the player level.
         * @param coins
         *      the initial amount of player coins
         * @return this Builder for chaining
         */
        public Builder initCoins(final int coins) {
            this.coins = coins;
            return this;
        }

        /**
         * @return a player life 
         */
        public final PlayerLifeImpl build() {
            if (consumed) {
                throw new IllegalStateException("The builder can only be used once");
            }
            consumed = true;
            return new PlayerLifeImpl(healthPoints, maxHealthPoints, experience, strength, food, level, coins);
        }
    }

}
