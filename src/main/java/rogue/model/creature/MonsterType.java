package rogue.model.creature;

import javafx.util.Pair;
import rogue.model.items.potion.PotionImpl;
import rogue.model.items.potion.PotionType;

public enum MonsterType {

    /** 
     * Air Elemental.
     */
    AIR_ELEMENTAL(new MonsterLife((int) (Math.random() * (32 - 4) + 4), 20), 2, new Pair<>(4, 24),
            new SpecialImpl(true, true, false, false, false, false, false, false), 0, new PotionImpl(PotionType.POTION_III), 20),

    /** 
     * Bat.
     */
    BAT(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 1), 3, new Pair<>(1, 2),
            new SpecialImpl(false, true, false, false, true, false, false, false), 0),

    /** 
     * Centaur.
     */
    CENTAUR(new MonsterLife((int) (Math.random() * (32 - 4) + 4), 17), 4, new Pair<>(4, 32), new SpecialImpl(), 51, new PotionImpl(PotionType.POTION_III), 10),

    /** 
     * Dragon.
     */
    DRAGON(new MonsterLife((int) (Math.random() * (80 - 10) + 10), 5000), -1, new Pair<>(4, 40), new SpecialImpl(true), 15_000, new PotionImpl(PotionType.POTION_V), 100),

    /** 
     * Emu.
     */
    EMU(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 2), 7, new Pair<>(1, 2), new SpecialImpl(true), 0),

    /** 
      * Fire Lizard.
      */
    FIRE_ELEMENTAL(new MonsterLife((int) (Math.random() * (36 - 8) + 8), 80), 2, new Pair<>(3, 18), new SpecialImpl(true), 0, new PotionImpl(PotionType.POTION_III), 40),

    /** 
     * Griffin.
     */
    GRIFFIN(new MonsterLife((int) (Math.random() * (104 - 13) + 13), 2000), 2, new Pair<>(5, 25),
             new SpecialImpl(true, true, false, false, false, false, false, false), 6000, new PotionImpl(PotionType.POTION_IV), 80),

    /** 
     * Hobgoblin.
     */
    HOBGOBLIN(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 3), 5, new Pair<>(1, 8), new SpecialImpl(true), 9, new PotionImpl(PotionType.POTION_I), 30),

    /** 
     * Ice cube.
     */
    ICE_CUBE(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 5), 9, new Pair<>(2, 12), new SpecialImpl(), 15, new PotionImpl(PotionType.POTION_II), 60),

    /** 
     * Jabberwock.
     */
    JABBERWOCK(new MonsterLife((int) (Math.random() * (120 - 15) + 15), 3000), 6,  new Pair<>(3, 24),
            new SpecialImpl(false, true, false, false, false, false, false, false), 9000, new PotionImpl(PotionType.POTION_V), 60),

    /** 
     * Kobold.
     */
    KOBOLD(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 1), 6,  new Pair<>(2, 12), new SpecialImpl(true), 3),

    /** 
     * Lycanthrope.
     */
    LYCANTHROPE(new MonsterLife((int) (Math.random() * (16 - 2) + 2), 10), 3,  new Pair<>(2, 12), new SpecialImpl(true), 30, new PotionImpl(PotionType.CORRUPT_POTION_I), 30),

    /** 
     * Medusa.
     */
    MEDUSA(new MonsterLife((int) (Math.random() * (64 - 8) + 8), 200), 2,  new Pair<>(4, 32),
            new SpecialImpl(true, false, false, false, false, false, true, false), 600, new PotionImpl(PotionType.CORRUPT_POTION_I), 70),

    /** 
     * Nymph.
     */
    NYMPH(new MonsterLife((int) (Math.random() * (24 - 3) + 3), 37), 9,  new Pair<>(0, 0),
            new SpecialImpl(false, false, true, false, false, false, false, false), 111,  new PotionImpl(PotionType.POTION_V), 50),

    /** 
     * Orc.
     */
    ORC(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 5), 6,  new Pair<>(1, 8),
            new SpecialImpl(false, false, true, false, false, false, false, false), 500),

    /** 
     * Phanthom.
     */
    PHANTHOM(new MonsterLife((int) (Math.random() * (64 - 8) + 8), 120), 3,  new Pair<>(4, 16),
            new SpecialImpl(true, false, false, true, false, false, false, false), 0),

    /** 
     * Quaqqa.
     */
    QUAQQA(new MonsterLife((int) (Math.random() * (24 - 3) + 3), 15), 3,  new Pair<>(2, 10),
            new SpecialImpl(), 0),

    /** 
     * Ratfolk.
     */
    RATFOLK(new MonsterLife((int) (Math.random() * (16 - 2) + 2), 9), 3,  new Pair<>(1, 6), new SpecialImpl(), 27, new PotionImpl(PotionType.POTION_II), 60),

    /** 
     * Snake.
     */
    SNAKE(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 2), 5,  new Pair<>(1, 3),
            new SpecialImpl(true, false, false, false, false, false, true, false), 6),

    /** 
     * Troll.
     */
    TROLL(new MonsterLife((int) (Math.random() * (48 - 6) + 6), 120), 4,  new Pair<>(3, 24),
            new SpecialImpl(true), 360,  new PotionImpl(PotionType.POTION_IV), 70),

    /** 
     * Unicorn.
     */
    UNICORN(new MonsterLife((int) (Math.random() * (56 - 7) + 7), 190), 3,  new Pair<>(4, 36),
            new SpecialImpl(), 570,  new PotionImpl(PotionType.CORRUPT_POTION_II), 100),

    /** 
     * Vampire.
     */
    VAMPIRE(new MonsterLife((int) (Math.random() * (64 - 8) + 8), 350), 1,  new Pair<>(1, 10),
           new SpecialImpl(true, false, false, false, false, false, false, true), 1050,  new PotionImpl(PotionType.POTION_IV), 100),

    /** 
     * Wraith.
     */
    WRAITH(new MonsterLife((int) (Math.random() * (40 - 5) + 5), 55), 4,  new Pair<>(1, 6), new SpecialImpl(), 0,  new PotionImpl(PotionType.CORRUPT_POTION_I), 60),

    /** 
     * Xill.
     */
    XILL(new MonsterLife((int) (Math.random() * (72 - 8) + 8), 50), 2,  new Pair<>(3, 24),
            new SpecialImpl(true), 150,  new PotionImpl(PotionType.POTION_IV), 20),

    /** 
     * Yeti.
     */
    YETI(new MonsterLife((int) (Math.random() * (32 - 4) + 4), 100), 6,  new Pair<>(2, 12),
           new SpecialImpl(), 900,  new PotionImpl(PotionType.POTION_III), 40),

    /** 
     * Zombie.
     */
    ZOMBIE(new MonsterLife((int) (Math.random() * (24 - 3) + 3), 6), 8,  new Pair<>(2, 16),
            new SpecialImpl(true, false, false, false, false, true, false, false), 16,  new PotionImpl(PotionType.CORRUPT_POTION_II), 50);


    private final MonsterLife life;
    private final int ac;
    private final Pair<Integer, Integer> damage;
    private final Special special;
    private final int money;
    private final PotionImpl item;
    private final int itemChange;

    MonsterType(final MonsterLife life, final int ac, final Pair<Integer, Integer> damage, final SpecialImpl special, final int money,
        final PotionImpl item, final int itemChange) {
        this.life = life;
        this.ac = ac;
        this.damage = damage;
        this.special = special;
        this.money = money;
        this.item = item;
        this.itemChange = itemChange;
    }

    MonsterType(final MonsterLife life, final int ac, final Pair<Integer, Integer> damage, final SpecialImpl special, final int money) {
        this.life = life;
        this.ac = ac;
        this.damage = damage;
        this.special = special;
        this.money = money;
        this.item = null;
        this.itemChange = 0;
    }

    public MonsterLife getLife() {
        return this.life;
    }

    public int getAC() {
        return this.ac;
    }

    public Pair<Integer, Integer> getDamage() {
        return this.damage;
    }

    public Special getSpecial() {
        return this.special;
    }

    public int getMoney() {
        return this.money;
    }

    public PotionImpl getItem() {
        return this.item;
    }

    public int getItemChange() {
        return this.itemChange;
    }

}
