package rogue.model.creature;

import javafx.util.Pair;


public class MonsterImpl implements Monster{
	
	private final MonsterType type;	
	
	public MonsterImpl(MonsterType type) {
		this.type = type;
	}

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MonsterLife getLife() {
		// TODO Auto-generated method stub
		return this.type.getLife();
	}

	@Override
	public MonsterType getMonsterType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public int getAC() {
		// TODO Auto-generated method stub
		return this.type.getAC();
	}

	@Override
	public Pair<Integer, Integer> getDamage() {
		// TODO Auto-generated method stub
		return this.type.getDamage();
	}

	@Override
	public Special getSpecial() {
		// TODO Auto-generated method stub
		return this.type.getSpecial();
	}

	@Override
	public int getMoney() {
		// TODO Auto-generated method stub
		return this.type.getMoney();
	}
	
	public int attackDamage() {	
		
		return (int)(Math.random()*(this.getDamage().getValue() - this.getDamage().getKey()) + this.getDamage().getKey());		
	}
	

}
