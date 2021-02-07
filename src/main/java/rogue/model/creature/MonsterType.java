package rogue.model.creature;

import javafx.util.Pair;

public enum MonsterType {

    /** 
     * Air Elemental.
     */
    AIR_ELEMENTAL(new MonsterLife((int) (Math.random() * (32 - 4) + 3), 20), 2, new Pair<>(4, 24), new SpecialImpl(), 0/*, new item()*/),

    /** 
     * Bat.
     */
    BAT(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 1), 3, new Pair<>(1, 2), new SpecialImpl(), 0/*, new item()*/),

    /** 
     * Centaur.
     */
    CENTAUR(new MonsterLife((int) (Math.random() * (32 - 4) + 4), 1), 4, new Pair<>(4, 32), new SpecialImpl(), 51/*, new item()*/),

    /** 
     * Dragon.
     */
    DRAGON(new MonsterLife((int) (Math.random() * (80 - 10) + 10), 5000), -1, new Pair<>(4, 40), new SpecialImpl(), 15_000/*, new item()*/),

    /** 
     * Emu.
     */
    EMU(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 2), 7, new Pair<>(1, 2), new SpecialImpl(), 0/*, new item()*/),

    /** 
      * Fire Salamander.
      */
    FIRE_SALAMENDER(new MonsterLife((int) (Math.random() * (36 - 8) + 8), 80), 2, new Pair<>(3, 18), new SpecialImpl(), 0/*, new item()*/),

    /** 
     * Griffin.
     */
    GRIFFIN(new MonsterLife((int) (Math.random() * (104 - 13) + 13), 2000), 2, new Pair<>(5, 25), new SpecialImpl(), 6000/*, new item()*/),

    /** 
     * Hobgoblin.
     */
    HOBGOBLIN(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 3), 5, new Pair<>(1, 8), new SpecialImpl(), 9/*, new item()*/),

    /** 
     * Ice cube.
     */
    ICE_CUBE(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 5), 9, new Pair<>(2, 16), new SpecialImpl(), 15/*, new item()*/),

    /** 
     * Kobold.
     */
    KOBOLD(new MonsterLife((int) (Math.random() * (8 - 1) + 1), 1), 6,  new Pair<>(2, 12), new SpecialImpl(), 3/*, new item()*/);


    private final MonsterLife life;
    private final int ac;
    private final Pair<Integer, Integer> damage;
    private final Special special;
    private final int money;
    //private final Item item;

    MonsterType(final MonsterLife life, final int ac, final Pair<Integer, Integer> damage, final SpecialImpl specialImpl, final int money/*, Item item*/) {
        this.life = life;
        this.ac = ac;
        this.damage = damage;
        this.special = specialImpl;
        this.money = money;
        //this.item = item;
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

}
