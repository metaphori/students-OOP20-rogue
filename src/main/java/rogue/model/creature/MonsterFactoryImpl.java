package rogue.model.creature;

import java.util.ArrayList;
import java.util.List;

public class MonsterFactoryImpl implements MonsterFactory {

    private static final int HIGH_SPAWN_RATE = 60;
    private static final int MEDIUM_SPAWN_RATE = 40;
    private static final int LOW_SPAWN_RATE = 20;

    private static final int PLAYER_LEVEL_1 = 1;
    private static final int PLAYER_LEVEL_2 = 2;
    private static final int PLAYER_LEVEL_3 = 3;
    private static final int PLAYER_LEVEL_4 = 4;
    private static final int PLAYER_LEVEL_5 = 5;
    private static final int PLAYER_LEVEL_6 = 6;
    private static final int PLAYER_LEVEL_7 = 7;
    private static final int PLAYER_LEVEL_8 = 8;
    private static final int PLAYER_LEVEL_9 = 9;
    private static final int PLAYER_LEVEL_10 = 10;

    private final List<MonsterImpl> monsterList = new ArrayList<>();

    private List<MonsterImpl> getMonsterList() {
        return this.monsterList;
    }

    private boolean isSpanwned(final int spawnRate) {
        final int casuale = (int) (Math.random() * 100) + 1;
        return casuale <= spawnRate;
    }

    /**
     * {@inheritDoc}
     */ 
    @Override
    public List<MonsterImpl> createMonsterList(final int playerLevel) {
        switch (playerLevel) {
            case PLAYER_LEVEL_1:
                monsterList.add(new MonsterImpl(MonsterType.BAT));
                monsterList.add(new MonsterImpl(MonsterType.KOBOLD));
                if (this.isSpanwned(HIGH_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.BAT));
                }
                if (this.isSpanwned(MEDIUM_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.KOBOLD));
                }
                if (this.isSpanwned(LOW_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.SNAKE));
                }
                return this.getMonsterList();

            case PLAYER_LEVEL_2:
                monsterList.add(new MonsterImpl(MonsterType.SNAKE));
                monsterList.add(new MonsterImpl(MonsterType.KOBOLD));
                if (this.isSpanwned(HIGH_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.EMU));
                }
                if (this.isSpanwned(MEDIUM_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.EMU));
                }
                if (this.isSpanwned(LOW_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.HOBGOBLIN));
                }
                return this.getMonsterList();

            case PLAYER_LEVEL_3:
                monsterList.add(new MonsterImpl(MonsterType.EMU));
                monsterList.add(new MonsterImpl(MonsterType.HOBGOBLIN));
                if (this.isSpanwned(HIGH_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.SNAKE));
                }
                if (this.isSpanwned(MEDIUM_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.HOBGOBLIN));
                }
                if (this.isSpanwned(LOW_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.ICE_CUBE));
                }
                return this.getMonsterList();

            case PLAYER_LEVEL_4:
                monsterList.add(new MonsterImpl(MonsterType.ORC));
                monsterList.add(new MonsterImpl(MonsterType.ICE_CUBE));
                if (this.isSpanwned(HIGH_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.ORC));
                }
                if (this.isSpanwned(MEDIUM_SPAWN_RATE)) {
                     monsterList.add(new MonsterImpl(MonsterType.ICE_CUBE));
                }
                if (this.isSpanwned(LOW_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.ZOMBIE));
                }
                return this.getMonsterList();

            case PLAYER_LEVEL_5:
                monsterList.add(new MonsterImpl(MonsterType.ZOMBIE));
                monsterList.add(new MonsterImpl(MonsterType.ICE_CUBE));
                if (this.isSpanwned(HIGH_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.ZOMBIE));
                }
                if (this.isSpanwned(MEDIUM_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.RATFOLK));
                }
                if (this.isSpanwned(LOW_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.LYCANTHROPE));
                }
                return this.getMonsterList();

            case PLAYER_LEVEL_6:
                monsterList.add(new MonsterImpl(MonsterType.RATFOLK));
                monsterList.add(new MonsterImpl(MonsterType.ZOMBIE));
                if (this.isSpanwned(HIGH_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.LYCANTHROPE));
                }
                if (this.isSpanwned(MEDIUM_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.RATFOLK));
                }
                if (this.isSpanwned(LOW_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.QUAQQA));
                }
                return this.getMonsterList();

            case PLAYER_LEVEL_7:
                monsterList.add(new MonsterImpl(MonsterType.LYCANTHROPE));
                monsterList.add(new MonsterImpl(MonsterType.RATFOLK));
                if (this.isSpanwned(HIGH_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.LYCANTHROPE));
                }
                if (this.isSpanwned(MEDIUM_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.QUAQQA));
                }
                if (this.isSpanwned(LOW_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.CENTAUR));
                }
                return this.getMonsterList();

            case PLAYER_LEVEL_8:
                monsterList.add(new MonsterImpl(MonsterType.QUAQQA));
                monsterList.add(new MonsterImpl(MonsterType.LYCANTHROPE));
                if (this.isSpanwned(HIGH_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.CENTAUR));
                }
                if (this.isSpanwned(MEDIUM_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.QUAQQA));
                }
                if (this.isSpanwned(LOW_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.AIR_ELEMENTAL));
                }
                return this.getMonsterList();

            case PLAYER_LEVEL_9:
                monsterList.add(new MonsterImpl(MonsterType.CENTAUR));
                monsterList.add(new MonsterImpl(MonsterType.QUAQQA));
                if (this.isSpanwned(HIGH_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.AIR_ELEMENTAL));
                }
                if (this.isSpanwned(MEDIUM_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.CENTAUR));
                }
                if (this.isSpanwned(LOW_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.NYMPH));
                }
                return this.getMonsterList();

            case PLAYER_LEVEL_10:
                monsterList.add(new MonsterImpl(MonsterType.AIR_ELEMENTAL));
                monsterList.add(new MonsterImpl(MonsterType.CENTAUR));
                if (this.isSpanwned(HIGH_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.NYMPH));
                }
                if (this.isSpanwned(MEDIUM_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.AIR_ELEMENTAL));
                }
                if (this.isSpanwned(LOW_SPAWN_RATE)) {
                    monsterList.add(new MonsterImpl(MonsterType.YETI));
                }
                return this.getMonsterList();


            default:
                return this.getMonsterList();
        }
    }

    /**
     * {@inheritDoc}
     */ 
    @Override
    public MonsterImpl createBoss() {
        return new MonsterImpl(MonsterType.DRAGON);
    }
}
