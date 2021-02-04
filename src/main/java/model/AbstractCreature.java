package model;

public abstract class AbstractCreature implements Creature {

    private final Life life;

    protected AbstractCreature(final Life life) {
        this.life = life;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean move() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Life getLife() {
        return this.life;
    }

}
