package rogue.model.creature;

import javafx.util.Pair;




public enum MonsterType {


	AIR_ELEMENTAL(new MonsterLife((int)(Math.random()*(32-4)+3),20), 2,  new Pair<>(4,24), new SpecialImpl(), 0/*, new item()*/),
	
	BAT(new MonsterLife((int)(Math.random()*(8-1)+1),1), 3,  new Pair<>(1,2), new SpecialImpl(), 0/*, new item()*/),
	
	CENTAUR(new MonsterLife((int)(Math.random()*(32-4)+4),1), 4,  new Pair<>(4,32), new SpecialImpl(), 51/*, new item()*/),
	
	DRAGON(new MonsterLife((int)(Math.random()*(80-10)+10),5000), -1,  new Pair<>(4,40), new SpecialImpl(), 15000/*, new item()*/),
	
	EMU(new MonsterLife((int)(Math.random()*(8-1)+1),2), 7,  new Pair<>(1,2), new SpecialImpl(), 0/*, new item()*/),
	
	KOBOLD(new MonsterLife((int)(Math.random()*(8-1)+1),1), 6,  new Pair<>(2,12), new SpecialImpl(true), 3/*, new item()*/);

   
    private final MonsterLife life;      
    private final int ac;
    private final Pair<Integer, Integer> damage;
    private final Special special;
    private final int money;
    //private final Item item;
    

     
    private MonsterType(MonsterLife life, int ac, Pair<Integer,Integer> damage, SpecialImpl specialImpl, int money/*, Item item*/) {
    	this.life = life;
    	this.ac = ac;
    	this.damage = damage;
    	this.special = specialImpl;
    	this.money = money;
    	//this.item = item;		
	}

	public MonsterLife getLife() {
		return this.life;
	}

	public int getAC() {
		return this.ac;
	}

	public Pair<Integer, Integer> getDamage() {
		return this.damage;
	}

	public Special getSpecial() {
		return this.special;
	}


	public int getMoney() {
		return this.money;
	}
    
    
    

}
