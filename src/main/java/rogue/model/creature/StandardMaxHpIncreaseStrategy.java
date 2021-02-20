package rogue.model.creature;

public final class StandardMaxHpIncreaseStrategy implements MaxHpIncreaseStrategy {

    private static final int DELTA = 12;

    @Override
    public int getMaxHp(final int level) {
        return level * DELTA;
    }

}
