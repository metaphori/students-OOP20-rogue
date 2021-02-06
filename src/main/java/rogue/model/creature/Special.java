package rogue.model.creature;

public interface Special {
	
	 /**
     * 
     * @return true if the monster is hostile
     */	
	boolean getHostile();
	
	 /**
     * 
     * @return true if the monster can fly
     */	
	boolean getFlyng();
	
	 /**
     * 
     * @return true if the monster attempt to pick up gold
     */	
	boolean getGreedy();
	
	 /**
     * 
     * @return true if the monster invisible
     */	
	boolean getInvisible();
	
	/**
     * 
     * @return true if the monster flies randomly
     */	
	boolean getFlyingRandom();
	
	/**
     * 
     * @return true if the monster can blow fire
     */	
	boolean getFireBlow();
	
	/**
     * 
     * @return true if the monster can freeze the player
     */	
	boolean getFreeze();
	
	/**
     * 
     * @return true if the monster can confuse the player
     */	
	boolean getConfuse();
	
	/**
     * 
     * @return true if the monster can steal Item from the player
     */	
	boolean getSteal();
	
	/**
     * 
     * @return true if the monster can poison the player
     */	
	boolean getPoisonous();
	
	/**
     * 
     * @return true if the monster can steal life from the player
     */	
	boolean getDrainLife();
	
	/**
     * 
     * @return true if the monster can paralyze the player
     */	
	boolean getParalyze();
	

}
