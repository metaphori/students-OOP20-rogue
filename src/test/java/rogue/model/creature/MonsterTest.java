package rogue.model.creature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MonsterTypeTest {

    private static final int IPOTETICAL_DAMAGE = 999;

    private static final int AIR_ELEMENTAL_EXPERIENCE = 20;
    private static final int AIR_ELEMENTAL_MONEY = 0;
    private static final int AIR_ELEMENTAL_ITEM_CHANGE = 20;
    private static final int AIR_ELEMENTAL_HP_MIN = 4;
    private static final int AIR_ELEMENTAL_HP_MAX = 32;
    private static final int AIR_ELEMENTAL_DAMAGE_MIN = 4;
    private static final int AIR_ELEMENTAL_DAMAGE_MAX = 24;
    private static final int AIR_ELEMENTAL_AC = 2;

    private static final int BAT_EXPERIENCE = 1;
    private static final int BAT_MONEY = 0;
    private static final int BAT_ITEM_CHANGE = 0;
    private static final int BAT_HP_MIN = 1;
    private static final int BAT_HP_MAX = 8;
    private static final int BAT_DAMAGE_MIN = 1;
    private static final int BAT_DAMAGE_MAX = 2;
    private static final int BAT_AC = 3;

    private static final int CENTAUR_EXPERIENCE = 17;
    private static final int CENTAUR_MONEY = 51;
    private static final int CENTAUR_ITEM_CHANGE = 10;
    private static final int CENTAUR_HP_MIN = 4;
    private static final int CENTAUR_HP_MAX = 32;
    private static final int CENTAUR_DAMAGE_MIN = 4;
    private static final int CENTAUR_DAMAGE_MAX = 32;
    private static final int CENTAUR_AC = 4;

    private static final int DRAGON_EXPERIENCE = 5000;
    private static final int DRAGON_MONEY = 15_000;
    private static final int DRAGON_ITEM_CHANGE = 100;
    private static final int DRAGON_HP_MIN = 10;
    private static final int DRAGON_HP_MAX = 100;
    private static final int DRAGON_DAMAGE_MIN = 4;
    private static final int DRAGON_DAMAGE_MAX = 40;
    private static final int DRAGON_AC = -1;

    private static final int EMU_EXPERIENCE = 2;
    private static final int EMU_MONEY = 0;
    private static final int EMU_ITEM_CHANGE = 0;
    private static final int EMU_HP_MIN = 1;
    private static final int EMU_HP_MAX = 8;
    private static final int EMU_DAMAGE_MIN = 1;
    private static final int EMU_DAMAGE_MAX = 2;
    private static final int EMU_AC = 7;

    private static final int FIRE_LIZARD_EXPERIENCE = 80;
    private static final int FIRE_LIZARD_MONEY = 0;
    private static final int FIRE_LIZARD_ITEM_CHANGE = 40;
    private static final int FIRE_LIZARD_HP_MIN = 8;
    private static final int FIRE_LIZARD_HP_MAX = 64;
    private static final int FIRE_LIZARD_DAMAGE_MIN = 3;
    private static final int FIRE_LIZARD_DAMAGE_MAX = 18;
    private static final int FIRE_LIZARD_AC = 2;

    private static final int GRIFFIN_EXPERIENCE = 2000;
    private static final int GRIFFIN_MONEY = 6000;
    private static final int GRIFFIN_ITEM_CHANGE = 80;
    private static final int GRIFFIN_HP_MIN = 13;
    private static final int GRIFFIN_HP_MAX = 104;
    private static final int GRIFFIN_DAMAGE_MIN = 5;
    private static final int GRIFFIN_DAMAGE_MAX = 25;
    private static final int GRIFFIN_AC = 2;

    private static final int HOBGOBLIN_EXPERIENCE = 3;
    private static final int HOBGOBLIN_MONEY = 9;
    private static final int HOBGOBLIN_ITEM_CHANGE = 30;
    private static final int HOBGOBLIN_HP_MIN = 1;
    private static final int HOBGOBLIN_HP_MAX = 8;
    private static final int HOBGOBLIN_DAMAGE_MIN = 1;
    private static final int HOBGOBLIN_DAMAGE_MAX = 8;
    private static final int HOBGOBLIN_AC = 5;

    private static final int ICE_CUBE_EXPERIENCE = 5;
    private static final int ICE_CUBE_MONEY = 15;
    private static final int ICE_CUBE_ITEM_CHANGE = 60;
    private static final int ICE_CUBE_HP_MIN = 1;
    private static final int ICE_CUBE_HP_MAX = 8;
    private static final int ICE_CUBE_DAMAGE_MIN = 2;
    private static final int ICE_CUBE_DAMAGE_MAX = 12;
    private static final int ICE_CUBE_AC = 9;

    private static final int JABBERWOCK_EXPERIENCE = 3000;
    private static final int JABBERWOCK_MONEY = 9000;
    private static final int JABBERWOCK_ITEM_CHANGE = 60;
    private static final int JABBERWOCK_HP_MIN = 15;
    private static final int JABBERWOCK_HP_MAX = 120;
    private static final int JABBERWOCK_DAMAGE_MIN = 3;
    private static final int JABBERWOCK_DAMAGE_MAX = 24;
    private static final int JABBERWOCK_AC = 6;

    private static final int KOBOLD_EXPERIENCE = 1;
    private static final int KOBOLD_MONEY = 3;
    private static final int KOBOLD_ITEM_CHANGE = 0;
    private static final int KOBOLD_HP_MIN = 1;
    private static final int KOBOLD_HP_MAX = 16;
    private static final int KOBOLD_DAMAGE_MIN = 2;
    private static final int KOBOLD_DAMAGE_MAX = 12;
    private static final int KOBOLD_AC = 6;

    private static final int LYCANTHROPE_EXPERIENCE = 10;
    private static final int LYCANTHROPE_MONEY = 30;
    private static final int LYCANTHROPE_ITEM_CHANGE = 30;
    private static final int LYCANTHROPE_HP_MIN = 2;
    private static final int LYCANTHROPE_HP_MAX = 16;
    private static final int LYCANTHROPE_DAMAGE_MIN = 2;
    private static final int LYCANTHROPE_DAMAGE_MAX = 12;
    private static final int LYCANTHROPE_AC = 3;

    private static final int MEDUSA_EXPERIENCE = 200;
    private static final int MEDUSA_MONEY = 600;
    private static final int MEDUSA_ITEM_CHANGE = 70;
    private static final int MEDUSA_HP_MIN = 8;
    private static final int MEDUSA_HP_MAX = 64;
    private static final int MEDUSA_DAMAGE_MIN = 4;
    private static final int MEDUSA_DAMAGE_MAX = 32;
    private static final int MEDUSA_AC = 2;

    private static final int NYMPH_EXPERIENCE = 37;
    private static final int NYMPH_MONEY = 111;
    private static final int NYMPH_ITEM_CHANGE = 50;
    private static final int NYMPH_HP_MIN = 3;
    private static final int NYMPH_HP_MAX = 24;
    private static final int NYMPH_DAMAGE_MIN = 0;
    private static final int NYMPH_DAMAGE_MAX = 0;
    private static final int NYMPH_AC = 9;


    @org.junit.Test
    public void testAirElemental() {
        // with default configs
        final MonsterImpl mon = new MonsterImpl(MonsterType.AIR_ELEMENTAL);

        assertEquals(AIR_ELEMENTAL_EXPERIENCE, mon.getLife().getExperience());
        assertEquals(AIR_ELEMENTAL_MONEY, mon.getMoney());
        assertEquals(AIR_ELEMENTAL_ITEM_CHANGE, mon.getItemChange());
        assertTrue(AIR_ELEMENTAL_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= AIR_ELEMENTAL_HP_MAX);
        assertTrue(AIR_ELEMENTAL_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= AIR_ELEMENTAL_DAMAGE_MAX);
        assertEquals(AIR_ELEMENTAL_AC, mon.getAC());

        assertFalse(mon.getSpecial().isDrainLife());
        assertFalse(mon.getSpecial().isFlyingRandom());
        assertTrue(mon.getSpecial().isFlyng());
        assertFalse(mon.getSpecial().isGreedy());
        assertTrue(mon.getSpecial().isHostile());
        assertFalse(mon.getSpecial().isInvisible());
        assertFalse(mon.getSpecial().isPoisonous());
        assertFalse(mon.getSpecial().isWeaken());

        mon.getLife().hurt(IPOTETICAL_DAMAGE);
        assertTrue(mon.getLife().isDead());

    }

    @org.junit.Test
    public void testBat() {
        // with default configs
        final MonsterImpl mon = new MonsterImpl(MonsterType.BAT);

        assertEquals(BAT_EXPERIENCE, mon.getLife().getExperience());
        assertEquals(BAT_MONEY, mon.getMoney());
        assertEquals(BAT_ITEM_CHANGE, mon.getItemChange());
        assertTrue(BAT_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= BAT_HP_MAX);
        assertTrue(BAT_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= BAT_DAMAGE_MAX);
        assertEquals(BAT_AC, mon.getAC());

        assertFalse(mon.getSpecial().isDrainLife());
        assertTrue(mon.getSpecial().isFlyingRandom());
        assertTrue(mon.getSpecial().isFlyng());
        assertFalse(mon.getSpecial().isGreedy());
        assertFalse(mon.getSpecial().isHostile());
        assertFalse(mon.getSpecial().isInvisible());
        assertFalse(mon.getSpecial().isPoisonous());
        assertFalse(mon.getSpecial().isWeaken());

        mon.getLife().hurt(IPOTETICAL_DAMAGE);
        assertTrue(mon.getLife().isDead());

    }

    @org.junit.Test
    public void testCentaur() {
        // with default configs
        final MonsterImpl mon = new MonsterImpl(MonsterType.CENTAUR);

        assertEquals(CENTAUR_EXPERIENCE, mon.getLife().getExperience());
        assertEquals(CENTAUR_MONEY, mon.getMoney());
        assertEquals(CENTAUR_ITEM_CHANGE, mon.getItemChange());
        assertTrue(CENTAUR_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= CENTAUR_HP_MAX);
        assertTrue(CENTAUR_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= CENTAUR_DAMAGE_MAX);
        assertEquals(CENTAUR_AC, mon.getAC());

        assertFalse(mon.getSpecial().isDrainLife());
        assertFalse(mon.getSpecial().isFlyingRandom());
        assertFalse(mon.getSpecial().isFlyng());
        assertFalse(mon.getSpecial().isGreedy());
        assertFalse(mon.getSpecial().isHostile());
        assertFalse(mon.getSpecial().isInvisible());
        assertFalse(mon.getSpecial().isPoisonous());
        assertFalse(mon.getSpecial().isWeaken());

        mon.getLife().hurt(IPOTETICAL_DAMAGE);
        assertTrue(mon.getLife().isDead());

    }

    @org.junit.Test
    public void testDragon() {
        // with default configs
        final MonsterImpl mon = new MonsterImpl(MonsterType.DRAGON);

        assertEquals(DRAGON_EXPERIENCE, mon.getLife().getExperience());
        assertEquals(DRAGON_MONEY, mon.getMoney());
        assertEquals(DRAGON_ITEM_CHANGE, mon.getItemChange());
        assertTrue(DRAGON_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= DRAGON_HP_MAX);
        assertTrue(DRAGON_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= DRAGON_DAMAGE_MAX);
        assertEquals(DRAGON_AC, mon.getAC());

        assertFalse(mon.getSpecial().isDrainLife());
        assertFalse(mon.getSpecial().isFlyingRandom());
        assertFalse(mon.getSpecial().isFlyng());
        assertFalse(mon.getSpecial().isGreedy());
        assertTrue(mon.getSpecial().isHostile());
        assertFalse(mon.getSpecial().isInvisible());
        assertFalse(mon.getSpecial().isPoisonous());
        assertFalse(mon.getSpecial().isWeaken());

        mon.getLife().hurt(IPOTETICAL_DAMAGE);
        assertTrue(mon.getLife().isDead());

    }
        @org.junit.Test
        public void testEmu() {
            // with default configs
            final MonsterImpl mon = new MonsterImpl(MonsterType.EMU);

            assertEquals(EMU_EXPERIENCE, mon.getLife().getExperience());
            assertEquals(EMU_MONEY, mon.getMoney());
            assertEquals(EMU_ITEM_CHANGE, mon.getItemChange());
            assertTrue(EMU_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= EMU_HP_MAX);
            assertTrue(EMU_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= EMU_DAMAGE_MAX);
            assertEquals(EMU_AC, mon.getAC());

            assertFalse(mon.getSpecial().isDrainLife());
            assertFalse(mon.getSpecial().isFlyingRandom());
            assertFalse(mon.getSpecial().isFlyng());
            assertFalse(mon.getSpecial().isGreedy());
            assertTrue(mon.getSpecial().isHostile());
            assertFalse(mon.getSpecial().isInvisible());
            assertFalse(mon.getSpecial().isPoisonous());
            assertFalse(mon.getSpecial().isWeaken());

            mon.getLife().hurt(IPOTETICAL_DAMAGE);
            assertTrue(mon.getLife().isDead());

    }
        @org.junit.Test
        public void testFireLizard() {
            // with default configs
            final MonsterImpl mon = new MonsterImpl(MonsterType.FIRE_LIZARD);

            assertEquals(FIRE_LIZARD_EXPERIENCE, mon.getLife().getExperience());
            assertEquals(FIRE_LIZARD_MONEY, mon.getMoney());
            assertEquals(FIRE_LIZARD_ITEM_CHANGE, mon.getItemChange());
            assertTrue(FIRE_LIZARD_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= FIRE_LIZARD_HP_MAX);
            assertTrue(FIRE_LIZARD_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= FIRE_LIZARD_DAMAGE_MAX);
            assertEquals(FIRE_LIZARD_AC, mon.getAC());

            assertFalse(mon.getSpecial().isDrainLife());
            assertFalse(mon.getSpecial().isFlyingRandom());
            assertFalse(mon.getSpecial().isFlyng());
            assertFalse(mon.getSpecial().isGreedy());
            assertTrue(mon.getSpecial().isHostile());
            assertFalse(mon.getSpecial().isInvisible());
            assertFalse(mon.getSpecial().isPoisonous());
            assertFalse(mon.getSpecial().isWeaken());

            mon.getLife().hurt(IPOTETICAL_DAMAGE);
            assertTrue(mon.getLife().isDead());

    }

        @org.junit.Test
        public void testGriffin() {
            // with default configs
            final MonsterImpl mon = new MonsterImpl(MonsterType.GRIFFIN);

            assertEquals(GRIFFIN_EXPERIENCE, mon.getLife().getExperience());
            assertEquals(GRIFFIN_MONEY, mon.getMoney());
            assertEquals(GRIFFIN_ITEM_CHANGE, mon.getItemChange());
            assertTrue(GRIFFIN_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= GRIFFIN_HP_MAX);
            assertTrue(GRIFFIN_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= GRIFFIN_DAMAGE_MAX);
            assertEquals(GRIFFIN_AC, mon.getAC());

            assertFalse(mon.getSpecial().isDrainLife());
            assertFalse(mon.getSpecial().isFlyingRandom());
            assertTrue(mon.getSpecial().isFlyng());
            assertFalse(mon.getSpecial().isGreedy());
            assertTrue(mon.getSpecial().isHostile());
            assertFalse(mon.getSpecial().isInvisible());
            assertFalse(mon.getSpecial().isPoisonous());
            assertFalse(mon.getSpecial().isWeaken());

            mon.getLife().hurt(IPOTETICAL_DAMAGE);
            assertTrue(mon.getLife().isDead());

    }

        @org.junit.Test
        public void testHobgoglin() {
            // with default configs
            final MonsterImpl mon = new MonsterImpl(MonsterType.HOBGOBLIN);

            assertEquals(HOBGOBLIN_EXPERIENCE, mon.getLife().getExperience());
            assertEquals(HOBGOBLIN_MONEY, mon.getMoney());
            assertEquals(HOBGOBLIN_ITEM_CHANGE, mon.getItemChange());
            assertTrue(HOBGOBLIN_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= HOBGOBLIN_HP_MAX);
            assertTrue(HOBGOBLIN_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= HOBGOBLIN_DAMAGE_MAX);
            assertEquals(HOBGOBLIN_AC, mon.getAC());

            assertFalse(mon.getSpecial().isDrainLife());
            assertFalse(mon.getSpecial().isFlyingRandom());
            assertFalse(mon.getSpecial().isFlyng());
            assertFalse(mon.getSpecial().isGreedy());
            assertTrue(mon.getSpecial().isHostile());
            assertFalse(mon.getSpecial().isInvisible());
            assertFalse(mon.getSpecial().isPoisonous());
            assertFalse(mon.getSpecial().isWeaken());

            mon.getLife().hurt(IPOTETICAL_DAMAGE);
            assertTrue(mon.getLife().isDead());

    }

        @org.junit.Test
        public void testIceCube() {
            // with default configs
            final MonsterImpl mon = new MonsterImpl(MonsterType.ICE_CUBE);

            assertEquals(ICE_CUBE_EXPERIENCE, mon.getLife().getExperience());
            assertEquals(ICE_CUBE_MONEY, mon.getMoney());
            assertEquals(ICE_CUBE_ITEM_CHANGE, mon.getItemChange());
            assertTrue(ICE_CUBE_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= ICE_CUBE_HP_MAX);
            assertTrue(ICE_CUBE_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= ICE_CUBE_DAMAGE_MAX);
            assertEquals(ICE_CUBE_AC, mon.getAC());

            assertFalse(mon.getSpecial().isDrainLife());
            assertFalse(mon.getSpecial().isFlyingRandom());
            assertFalse(mon.getSpecial().isFlyng());
            assertFalse(mon.getSpecial().isGreedy());
            assertFalse(mon.getSpecial().isHostile());
            assertFalse(mon.getSpecial().isInvisible());
            assertFalse(mon.getSpecial().isPoisonous());
            assertFalse(mon.getSpecial().isWeaken());

            mon.getLife().hurt(IPOTETICAL_DAMAGE);
            assertTrue(mon.getLife().isDead());

    }

        @org.junit.Test
        public void testJabberwock() {
            // with default configs
            final MonsterImpl mon = new MonsterImpl(MonsterType.JABBERWOCK);

            assertEquals(JABBERWOCK_EXPERIENCE, mon.getLife().getExperience());
            assertEquals(JABBERWOCK_MONEY, mon.getMoney());
            assertEquals(JABBERWOCK_ITEM_CHANGE, mon.getItemChange());
            assertTrue(JABBERWOCK_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= JABBERWOCK_HP_MAX);
            assertTrue(JABBERWOCK_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= JABBERWOCK_DAMAGE_MAX);
            assertEquals(JABBERWOCK_AC, mon.getAC());

            assertFalse(mon.getSpecial().isDrainLife());
            assertFalse(mon.getSpecial().isFlyingRandom());
            assertTrue(mon.getSpecial().isFlyng());
            assertFalse(mon.getSpecial().isGreedy());
            assertFalse(mon.getSpecial().isHostile());
            assertFalse(mon.getSpecial().isInvisible());
            assertFalse(mon.getSpecial().isPoisonous());
            assertFalse(mon.getSpecial().isWeaken());

            mon.getLife().hurt(IPOTETICAL_DAMAGE);
            assertTrue(mon.getLife().isDead());

    }
        @org.junit.Test
        public void testKobold() {
            // with default configs
            final MonsterImpl mon = new MonsterImpl(MonsterType.KOBOLD);

            assertEquals(KOBOLD_EXPERIENCE, mon.getLife().getExperience());
            assertEquals(KOBOLD_MONEY, mon.getMoney());
            assertEquals(KOBOLD_ITEM_CHANGE, mon.getItemChange());
            assertTrue(KOBOLD_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= KOBOLD_HP_MAX);
            assertTrue(KOBOLD_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= KOBOLD_DAMAGE_MAX);
            assertEquals(KOBOLD_AC, mon.getAC());

            assertFalse(mon.getSpecial().isDrainLife());
            assertFalse(mon.getSpecial().isFlyingRandom());
            assertFalse(mon.getSpecial().isFlyng());
            assertFalse(mon.getSpecial().isGreedy());
            assertTrue(mon.getSpecial().isHostile());
            assertFalse(mon.getSpecial().isInvisible());
            assertFalse(mon.getSpecial().isPoisonous());
            assertFalse(mon.getSpecial().isWeaken());

            mon.getLife().hurt(IPOTETICAL_DAMAGE);
            assertTrue(mon.getLife().isDead());

    }
        @org.junit.Test
        public void testLycanthrope() {
            // with default configs
            final MonsterImpl mon = new MonsterImpl(MonsterType.LYCANTHROPE);

            assertEquals(LYCANTHROPE_EXPERIENCE, mon.getLife().getExperience());
            assertEquals(LYCANTHROPE_MONEY, mon.getMoney());
            assertEquals(LYCANTHROPE_ITEM_CHANGE, mon.getItemChange());
            assertTrue(LYCANTHROPE_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= LYCANTHROPE_HP_MAX);
            assertTrue(LYCANTHROPE_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= LYCANTHROPE_DAMAGE_MAX);
            assertEquals(LYCANTHROPE_AC, mon.getAC());

            assertFalse(mon.getSpecial().isDrainLife());
            assertFalse(mon.getSpecial().isFlyingRandom());
            assertFalse(mon.getSpecial().isFlyng());
            assertFalse(mon.getSpecial().isGreedy());
            assertTrue(mon.getSpecial().isHostile());
            assertFalse(mon.getSpecial().isInvisible());
            assertFalse(mon.getSpecial().isPoisonous());
            assertFalse(mon.getSpecial().isWeaken());

            mon.getLife().hurt(IPOTETICAL_DAMAGE);
            assertTrue(mon.getLife().isDead());

    }

        @org.junit.Test
        public void testMedusa() {
            // with default configs
            final MonsterImpl mon = new MonsterImpl(MonsterType.MEDUSA);

            assertEquals(MEDUSA_EXPERIENCE, mon.getLife().getExperience());
            assertEquals(MEDUSA_MONEY, mon.getMoney());
            assertEquals(MEDUSA_ITEM_CHANGE, mon.getItemChange());
            assertTrue(MEDUSA_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= MEDUSA_HP_MAX);
            assertTrue(MEDUSA_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= MEDUSA_DAMAGE_MAX);
            assertEquals(MEDUSA_AC, mon.getAC());

            assertFalse(mon.getSpecial().isDrainLife());
            assertFalse(mon.getSpecial().isFlyingRandom());
            assertFalse(mon.getSpecial().isFlyng());
            assertFalse(mon.getSpecial().isGreedy());
            assertTrue(mon.getSpecial().isHostile());
            assertFalse(mon.getSpecial().isInvisible());
            assertTrue(mon.getSpecial().isPoisonous());
            assertFalse(mon.getSpecial().isWeaken());

            mon.getLife().hurt(IPOTETICAL_DAMAGE);
            assertTrue(mon.getLife().isDead());

    }
        @org.junit.Test
        public void testNymph() {
            // with default configs
            final MonsterImpl mon = new MonsterImpl(MonsterType.NYMPH);

            assertEquals(NYMPH_EXPERIENCE, mon.getLife().getExperience());
            assertEquals(NYMPH_MONEY, mon.getMoney());
            assertEquals(NYMPH_ITEM_CHANGE, mon.getItemChange());
            assertTrue(NYMPH_HP_MIN <= mon.getLife().getHealthPoints() && mon.getLife().getHealthPoints() <= NYMPH_HP_MAX);
            assertTrue(NYMPH_DAMAGE_MIN <= mon.attackDamage() && mon.attackDamage() <= NYMPH_DAMAGE_MAX);
            assertEquals(NYMPH_AC, mon.getAC());

            assertFalse(mon.getSpecial().isDrainLife());
            assertFalse(mon.getSpecial().isFlyingRandom());
            assertFalse(mon.getSpecial().isFlyng());
            assertTrue(mon.getSpecial().isGreedy());
            assertFalse(mon.getSpecial().isHostile());
            assertFalse(mon.getSpecial().isInvisible());
            assertFalse(mon.getSpecial().isPoisonous());
            assertFalse(mon.getSpecial().isWeaken());

            mon.getLife().hurt(IPOTETICAL_DAMAGE);
            assertTrue(mon.getLife().isDead());

    }
}
