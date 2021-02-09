package rogue.model.items.food;

import rogue.model.creature.Player;

/** 
 * Represents an implementation for a game {@link Food}.
 *
 */
public class FoodImpl implements Food {

    private static final int HUNGER_VALUE_MAX = 50;
    private final FoodType food;

    public FoodImpl(final FoodType food) {
        this.food = food;
    }

    /**
     * Use this method to consume the Food item.
     * @param player to which apply the food on.
     * @return true if item was correctly used, false if the
     * player's hunger is already at max.
     */
    public boolean use(final Player player) {
        if (player.getLife().getFood() == HUNGER_VALUE_MAX) {
            /*
             * Player's hunger is already at max, cannot
             * use the food item.
             */
            return false;
        } else {
            if (player.getLife().getFood() + this.food.getStarvationValue() > HUNGER_VALUE_MAX) {
                /*
                 * Adding the food's starvation value to the current
                 * player's hunger would exceed the hunger maximum value.
                 * So the player's hunger is updated to max.
                 */
                player.getLife().updateFood(HUNGER_VALUE_MAX - player.getLife().getFood());
            } else {
                /*
                 * simply add the food's starvation value.
                 */
                player.getLife().updateFood(this.food.getStarvationValue());
            }
            return true;
        }
    }

    /**
     * Use this method to get the starvation value of the Food.
     * @return food's starvation value.
     */
    public int getStarvationValue() {
        return this.food.getStarvationValue();
    }

    /**
     * @return hashCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((food == null) ? 0 : food.hashCode());
        return result;
    }

    /**
     * equals.
     * @param obj to apply the equals.
     * @return true if equal, false otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FoodImpl other = (FoodImpl) obj;
        return food != other.food;
    }
}
