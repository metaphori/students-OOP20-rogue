package rogue.model.items.food;

import rogue.model.creature.Player;

/** 
 * Represents an implementation for a game {@link Food}.
 *
 */
public class FoodImpl implements Food {

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
        return false;
    }

    /**
     * Use this method to get the starvation value of the Food.
     * @return food's starvation value.
     */
    public int getStarvationValue() {
        return this.food.getStarvationValue();
    }

}
