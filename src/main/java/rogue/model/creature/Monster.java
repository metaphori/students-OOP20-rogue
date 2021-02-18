package rogue.model.creature;

import javafx.util.Pair;
import rogue.model.items.potion.PotionImpl;
import rogue.model.world.Direction;

/**
 * An interface modeling the enemy/monster.
 *
 */
public interface Monster extends Creature<MonsterLife> {

    /**
     *
     *
     * @return the type of the monster
     */
    MonsterType getMonsterType();

    /**
     * 
     * @return the Armor Class of the monster
     */
    int getAC();

    /**
     * 
     * @return the maximum damage the monster can do the minimum is 1 
     */
    Pair<Integer, Integer> getDamage();

    /**
     * 
     * @return the monster's special skill
     */
    Special getSpecial();

    /**
     * 
     * @return the amount of money of the monster 
     */
    int getMoney();

    /**
     * 
     * @return the monster's item
     */
    PotionImpl getItem();

    /**
     * 
     * @return the item's possibility to drop
     */
    int getItemChange();

   /**
    *
    * @return the damage that the monster does for that single attack 
    */
    int attackDamage();

    /**
     * 
     * @return or not the monster's item
     */
    PotionImpl dropItem();

    /**
     * 
     * @param playerDirection
     *          the direction of where the player is
     * @param monster
     *         who did the move
     * @return the direction where the monster must move
     */
    Direction monsterMove(Direction playerDirection, Monster monster);
}
