package rogue.model.creature;

import rogue.model.items.weapons.Weapon.Use;

public class CombatImpl implements Combat {

    private static final int DICE = 19;
    private static final int POISON_DAMAGE_MAX = 2;
    private static final int FLYING_MONSTER_MALUS = 2;

    private int getModStrength(final Player player) {
        return (player.getLife().getStrength() - 10) / 2;
    }

    private int playerAttackRoll(final Player player) {
        return (int) (Math.random() * DICE) + 1 + player.getEquipment().getWeapon().getAccuracy() + this.getModStrength(player);
    }

    private int monsterAttackRoll() {
        return (int) (Math.random() * DICE) + 1;
    }

    private boolean hit(final int attackRoll, final int enemyAC) {
        return DICE - attackRoll <= enemyAC;
    }

    private int poisonDamage() {
        return (int) (Math.random() * POISON_DAMAGE_MAX);
    }

    private void playerAttack(final Player player, final Monster monster) {
        monster.getSpecial().becomeHostile();
        if (monster.getSpecial().isFlyng()) {
            if (this.hit(playerAttackRoll(player) - FLYING_MONSTER_MALUS, monster.getAC())) {
                monster.getLife().hurt(player.getEquipment().getWeapon().getDamage(Use.HANDLED));
            }
        } else {
            if (this.hit(playerAttackRoll(player), monster.getAC())) {
                monster.getLife().hurt(player.getEquipment().getWeapon().getDamage(Use.HANDLED));
            }
        }
    }

    private void monsterAttack(final Monster monster, final Player player) {
        if (this.hit(monsterAttackRoll(), player.getEquipment().getArmor().getAC())) {
            player.getLife().hurt(monster.attackDamage());
            if (monster.getSpecial().isDrainLife()) {
                monster.getLife().setHealthPoints(monster.getLife().getHealthPoints() + monster.attackDamage());
            } else if (monster.getSpecial().isPoisonous()) {
                player.getLife().hurt(this.poisonDamage());
            }
        }
    }

    /**
     * 
     * @param attacker
     *          who made the attack
     * @param defender
     *         who defends himself from the attack
     */
    @Override
    public void attack(final Creature<?> attacker, final Creature<?> defender) {
        if (attacker instanceof Player) {
            playerAttack((Player) attacker, (Monster) defender);
        } else {
            monsterAttack((Monster) attacker, (Player) defender);
        }
    }
}
