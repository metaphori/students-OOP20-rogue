package rogue.model.creature;

import javafx.util.Pair;


public class MonsterImpl implements Monster {

    private final MonsterType type;

    public MonsterImpl(final MonsterType type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean move() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MonsterLife getLife() {
        return this.type.getLife();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MonsterType getMonsterType() {
        return this.type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAC() {
        return this.type.getAC();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<Integer, Integer> getDamage() {
        return this.type.getDamage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Special getSpecial() {
        return this.type.getSpecial();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMoney() {
        return this.type.getMoney();
    }

    /**
     *
     * @return the damage that the monster does for that single attack 
     */
    public int attackDamage() {
        return (int) (Math.random() * (this.getDamage().getValue() - this.getDamage().getKey()) + this.getDamage().getKey());
    }

}
