package rogue.model.creature;

public class SpecialImpl implements Special{
	
     /**
     * TODO to finish.
     * per il momento non mi fà impazzire il costruttore visto che ci deve passare una valangata di boolean
     * ma attualmente non mi viene in mente nulla di meglio per sitemarlo
     */
	
     private final boolean hostile;
     private final boolean flying;
     private final boolean greedy;
     private final boolean invisible;
     private final boolean flyingRandom;
     private final boolean fireBlow;
     private final boolean freeze;
     private final boolean confuse;
     private final boolean steal;
     private final boolean poisonous;
     private final boolean drainLife;
     private final boolean paralyze;
	
	
     public SpecialImpl(final boolean hostile, final boolean flying, final boolean greedy, final boolean invisible, final boolean flyingRandom, 
	final boolean fireBlow, final boolean freeze, final boolean confuse, final boolean steal, final boolean poisonous, 
	final boolean drainLife, final boolean paralyze) {
		
       this.hostile = hostile;
       this.flying = flying;
       this.greedy = greedy;
       this.invisible = invisible;
       this.flyingRandom = flyingRandom;
       this.fireBlow = fireBlow;
       this.freeze = freeze;
       this.confuse = confuse;
       this.steal = steal;
       this.poisonous = poisonous;
       this.drainLife = drainLife;
       this.paralyze = paralyze;       
    }
	
   public SpecialImpl(boolean hostile) {
       super();
       this.hostile = hostile;
       this.flying = false;
       this.greedy = false;
       this.invisible = false;
       this.flyingRandom = false;
       this.fireBlow = false;
       this.freeze = false;
       this.confuse = false;
       this.steal = false;
       this.poisonous = false;
       this.drainLife = false;
       this.paralyze = false; 
   }
	
    public SpecialImpl() {
        super();
	this.hostile = false;
	this.flying = false;
	this.greedy = false;
	this.invisible = false;
	this.flyingRandom = false;
	this.fireBlow = false;
	this.freeze = false;
	this.confuse = false;
	this.steal = false;
	this.poisonous = false;
	this.drainLife = false;
	this.paralyze = false;
    }

   @Override
   public boolean getHostile() {  	
       return this.hostile;
   }

  @Override
  public boolean getFlyng() {
      return this.flying;
   }
	
    @Override
    public boolean getGreedy() {
        return this.greedy;
    }
	
    @Override
    public boolean getInvisible() {
	return this.invisible;
    }

    @Override
    public boolean getFlyingRandom() {
	return this.flyingRandom;
    }

    @Override
    public boolean getFireBlow() {
	return this.fireBlow;
    }

   @Override
   public boolean getFreeze() {
	return this.freeze;
   }

   @Override
   public boolean getConfuse() {
	return this.confuse;
   }

    @Override
    public boolean getSteal() {
	return this.steal;
     }

    @Override
    public boolean getPoisonous() {
	return this.poisonous;
    }

    @Override
    public boolean getDrainLife() {
	return this.drainLife;
    }

    @Override
    public boolean getParalyze() {
	return this.paralyze;
    }

}
