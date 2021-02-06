package rogue.model.creature;

public class MonsterImpl implements Monster{
	
	 private final int ca;
	 private final int maxDamage;
	 private final Life life;
	 private final int money;
	// private final Item item;
	 private final Special special;	
	
	
	public MonsterImpl(int ca, int maxDamage, Life life, int money/*, Item item*/, Special special) {
		this.ca = ca;
		this.maxDamage = maxDamage;
		this.life = life;
		this.money = money;
	//	this.item = item;
		this.special = special;
	}

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Life getLife() {
		
		return this.life;
	}

	@Override
	public int getCA() {
		// TODO Auto-generated method stub
		return this.ca;
	}

	@Override
	public int getMaxDamage() {
		// TODO Auto-generated method stub
		return this.maxDamage;
	}

	@Override
	public int getMoney() {
		// TODO Auto-generated method stub
		return this.money;
	}

	/*@Override
	public Item getItem() {
		// TODO Auto-generated method stub
		return this.money;
	}*/

	@Override
	public Special getSpecial() {
		// TODO Auto-generated method stub
		return this.special;
	}

}
