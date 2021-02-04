package model.creature;

public final class PlayerLifeTest {

    private PlayerLifeTest() { }

    public static void main(final String[] args) {
        final PlayerLife pl = new PlayerLifeImpl(10, 0, 0);
        System.out.println("Experience: " + pl.getExperience());
        System.out.println("Strength: " + pl.getStrength());
        System.out.println("Health points: " + pl.getHealthPoints());
        pl.hurt(5);
        System.out.println("Experience: " + pl.getExperience());
        System.out.println("Strength: " + pl.getStrength());
        System.out.println("Health points: " + pl.getHealthPoints());
        pl.increaseExperience(10);
        pl.powerUp(5);
        System.out.println("Experience: " + pl.getExperience());
        System.out.println("Strength: " + pl.getStrength());
        System.out.println("Health points: " + pl.getHealthPoints());

    }

}
