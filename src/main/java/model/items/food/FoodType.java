package model.items.food;

/**
 * Represents an enumeration for declaring foods types.
 * 
 * The field keeps track of the food's starvation value.
 *
 */
public enum FoodType {

    /** 
     * Foods list.
     */
    APPLE(5), CAKE(10), SOUP(8), HAMBURGER(12), CHEESE(4), STEAK(8), BREAD(6);

    /*
     * The higher the starvationValue of a food is, the longer the player's
     * hunger will last.
     */
    private final int starvationValue;

    /**
     * @return the food's starvation value.
     */
    public int getStarvationValue() {
        return starvationValue;
    }

    FoodType(final int value) {
        starvationValue = value;
    }

}
