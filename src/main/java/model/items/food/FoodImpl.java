package model.items.food;

import model.Creature;

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
     * @param creature 
     * @return true if item was correctly used, false otherwise.
     */
    public boolean use(final Creature creature) {
        /*
         * Checks if the given creature is the player,
         * Food has no use for a monster creature.
         */
        /*Life life = creature.getLife();
        if ( life.equals(check if it's the player's life) {
            life.increase(this.food.getStarvationValue())
            return true;
        } else {
            return false;
        }*/
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
