package rogue.view;

import javafx.scene.image.Image;
import rogue.model.items.Item;
import rogue.model.items.armor.Armor;
import rogue.model.items.food.Food;
import rogue.model.items.food.FoodType;
import rogue.model.items.potion.Potion;
import rogue.model.items.rings.Ring;
import rogue.model.items.scroll.Scroll;
import rogue.model.items.weapons.BaseWeapon;

/**
 * An implementation for an {@link ItemImageGenerator}.
 *
 */
public class ItemImageGeneratorImpl implements ItemImageGenerator {

    /**
     * Get the corresponding of the given item.
     * @param item to get image of.
     * @return the image of the requested item.
     */
    public Image getImage(final Item item) {
        if (item instanceof Food) {
            /*
             * Food item
             */
            /*
             * BREAD
             */
            if (((Food) item).getFood() == FoodType.BREAD) {
                return new Image(ClassLoader.getSystemResource("images/food/breadIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * CAKE
             */
            if (((Food) item).getFood() == FoodType.CAKE) {
                return new Image(ClassLoader.getSystemResource("images/food/cakeIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * SOUP
             */
            if (((Food) item).getFood() == FoodType.SOUP) {
                return new Image(ClassLoader.getSystemResource("images/food/soupIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * HAMBURGER
             */
            if (((Food) item).getFood() == FoodType.HAMBURGER) {
                return new Image(ClassLoader.getSystemResource("images/food/hamburgerIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * CHEESE
             */
            if (((Food) item).getFood() == FoodType.CHEESE) {
                return new Image(ClassLoader.getSystemResource("images/food/cheeseIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * STEAK
             */
            if (((Food) item).getFood() == FoodType.STEAK) {
                return new Image(ClassLoader.getSystemResource("images/food/steakIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * APPLE
             */
            if (((Food) item).getFood() == FoodType.APPLE) {
                return new Image(ClassLoader.getSystemResource("images/food/appleIcon.png").toExternalForm(), 32, 32, false, true);
            }
        }
        if (item instanceof Potion) {
            /*
             * Potion item
             */
            /*
             * Check for max potion
             */
            if (((Potion) item).getHpValue() == 100) {
                return new Image(ClassLoader.getSystemResource("images/potion/potionMaxIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * if not max health return the normal potion image
             */
            return new Image(ClassLoader.getSystemResource("images/potion/potionIcon.png").toExternalForm(), 32, 32, false, true);
        }
        if (item instanceof Scroll) {
            /*
             * Scroll item, all scrolls have the same icon
             */
            return new Image(ClassLoader.getSystemResource("images/scroll/scrollIcon.png").toExternalForm(), 32, 32, false, true);
        }
        if (item instanceof Armor) {
            /*
             * Armor item
             */
            return new Image(ClassLoader.getSystemResource("images/armor/armorIcon.png").toExternalForm(), 32, 32, false, true);
        }
        if (item instanceof BaseWeapon) {
            /*
             * Weapon item
             */
            return new Image(ClassLoader.getSystemResource("images/weapon/weaponIcon.png").toExternalForm(), 32, 32, false, true);
        }
        if (item instanceof Ring) {
            /*
             * Ring item
             */
            return new Image(ClassLoader.getSystemResource("images/ring/ringIcon.png").toExternalForm(), 32, 32, false, true);
        }
        return new Image(ClassLoader.getSystemResource("images/emptyIcon.png").toExternalForm(), 32, 32, false, true);
    }
}
