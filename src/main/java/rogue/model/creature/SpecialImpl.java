package rogue.model.creature;

public class SpecialImpl implements Special {

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
    private final boolean weaken;
    private final boolean poisonous;
    private final boolean drainLife;


    public SpecialImpl(final boolean hostile, final boolean flying, final boolean greedy, final boolean invisible,
            final boolean flyingRandom, final boolean weaken, final boolean poisonous, final boolean drainLife) {
        super();
        this.hostile = hostile;
        this.flying = flying;
        this.greedy = greedy;
        this.invisible = invisible;
        this.flyingRandom = flyingRandom;
        this.weaken = weaken;
        this.poisonous = poisonous;
        this.drainLife = drainLife;
    }

    public SpecialImpl(final boolean hostile) {
        super();
        this.hostile = hostile;
        this.flying = false;
        this.greedy = false;
        this.invisible = false;
        this.flyingRandom = false;
        this.weaken = false;
        this.poisonous = false;
        this.drainLife = false;
    }

    public SpecialImpl() {
        super();
        this.hostile = false;
        this.flying = false;
        this.greedy = false;
        this.invisible = false;
        this.flyingRandom = false;
        this.weaken = false;
        this.poisonous = false;
        this.drainLife = false;
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isHostile() {
        return this.hostile;
   }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFlyng() {
        return this.flying;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isGreedy() {
        return this.greedy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInvisible() {
        return this.invisible;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFlyingRandom() {
        return this.flyingRandom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isWeaken() {
        return this.weaken;
   }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPoisonous() {
        return this.poisonous;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDrainLife() {
        return this.drainLife;
    }

}
