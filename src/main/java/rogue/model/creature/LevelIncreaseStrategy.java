package rogue.model.creature;

import java.util.Optional;

/**
 * This interface manages the strategy with which 
 * to increase the player's level.
 */
public interface LevelIncreaseStrategy {

    /**
     * @param experience
     *          the actual experience value
     * @return the level value corresponding to the given experience
     */
    Optional<Integer> level(int experience);

}
