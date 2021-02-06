package rogue.model.creature;

public class MonsterTest {
	
	public static void main(String [ ] args){
			
	  MonsterImpl mon = new MonsterImpl(MonsterType.KOBOLD);
	  
	  System.out.println("La vita del mostro " + mon.getLife().getHealthPoints());
	  System.out.println("La CA del mostro " + mon.getAC());
	  System.out.println("Le monete del mostro " + mon.getMoney());
	  System.out.println("La exp del mostro " + mon.getLife().getExperience());
	  System.out.println("Il danno fatto dal mostro " + mon.attackDamage());
	  
	  
	}

}
