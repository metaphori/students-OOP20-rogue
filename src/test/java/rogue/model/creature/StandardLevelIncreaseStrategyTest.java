package rogue.model.creature;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

public class StandardLevelIncreaseStrategyTest {

    private static final int EXP_MIDDLE_LEVEL = 789;
    private static final int EXP_LEVEL_20 = 12_000;
    private static final int EXP_LEVEL_2 = 7;
    private LevelIncreaseStrategy strategy;

    @org.junit.Before
    public void init() {
        strategy = new StandardLevelIncreaseStrategy();
    }

    @Test
    public void test() {
        assertEquals(Optional.of(2), strategy.level(EXP_LEVEL_2));
        assertEquals(Optional.of(20), strategy.level(EXP_LEVEL_20));
        assertEquals(Optional.of(12), strategy.level(EXP_MIDDLE_LEVEL));

    }

}
