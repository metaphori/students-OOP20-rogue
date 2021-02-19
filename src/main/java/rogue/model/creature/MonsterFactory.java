package rogue.model.creature;

import java.util.List;

/**
 * An interface modeling a list of {@link Monster}.
 *
 */
public interface MonsterFactory  {

   /**
    * 
    * @param playerLevel
    *          the player's level
    * @return a list of monsters based on the player's level
    */
    List<MonsterImpl> createMonsterList(int playerLevel);

   /**
    *
    * @return the final boss(the final monster)
    */
    MonsterImpl createBoss();

}
