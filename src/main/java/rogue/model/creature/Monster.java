package rogue.model.creature;

import javafx.util.Pair;

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
    /*Item getItem();*/
}
