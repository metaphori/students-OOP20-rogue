package rogue.model.creature;

public final class StandardMahHpIncreaseStrategy implements MaxHpIncreaseStrategy {

    private static final int DELTA = 12;

    @Override
    public int getMaxHp(final int level) {
        return level * DELTA;
    }

}
