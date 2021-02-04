package model.creature;

/**
 * An interface modeling the enemy/monster.
 *
 */
public interface Monster extends Creature {
	
	 /**
     * 
     * @return the Class Armor of the monster
     */	
	int getCA();
	
	 /**
     * 
     * @return the maximum damage the monster can do the minimum is 1 
     */
	int getMaxDamage();	 
	
	/**
     * 
     * @return the amount of money of the monster 
     */
	int getMoney();
	
	/**
     * 
     * @return the monster's item
     */
	//Item getItem();
	
	/**
     * 
     * @return the monster's special skill
     */
	Special getSpecial();
		
}
