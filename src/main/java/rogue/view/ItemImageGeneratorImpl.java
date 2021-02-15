package rogue.view;

import javafx.scene.image.Image;
import rogue.model.items.Item;
import rogue.model.items.armor.ArmorImpl;
import rogue.model.items.food.FoodImpl;
import rogue.model.items.food.FoodType;
import rogue.model.items.potion.PotionImpl;
import rogue.model.items.rings.RingImpl;
import rogue.model.items.scroll.ScrollImpl;
import rogue.model.items.weapons.BaseWeapon;

public class ItemImageGeneratorImpl implements ItemImageGenerator {

    /**
     * @param item to get image of.
     * @return the image of the requested item.
     */
    public Image getImage(final Item item) {
        if (item.getClass().equals(FoodImpl.class)) {
            /*
             * Food item
             */
            /*
             * BREAD
             */
            if (((FoodImpl) item).getFood() == FoodType.BREAD) {
                return new Image(ClassLoader.getSystemResource("images/food/breadIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * CAKE
             */
            if (((FoodImpl) item).getFood() == FoodType.CAKE) {
                return new Image(ClassLoader.getSystemResource("images/food/cakeIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * SOUP
             */
            if (((FoodImpl) item).getFood() == FoodType.SOUP) {
                return new Image(ClassLoader.getSystemResource("images/food/soupIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * HAMBURGER
             */
            if (((FoodImpl) item).getFood() == FoodType.HAMBURGER) {
                return new Image(ClassLoader.getSystemResource("images/food/hamburgerIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * CHEESE
             */
            if (((FoodImpl) item).getFood() == FoodType.CHEESE) {
                return new Image(ClassLoader.getSystemResource("images/food/cheeseIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * STEAK
             */
            if (((FoodImpl) item).getFood() == FoodType.STEAK) {
                return new Image(ClassLoader.getSystemResource("images/food/steakIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * APPLE
             */
            if (((FoodImpl) item).getFood() == FoodType.APPLE) {
                return new Image(ClassLoader.getSystemResource("images/food/appleIcon.png").toExternalForm(), 32, 32, false, true);
            }
        }
        if (item.getClass().equals(PotionImpl.class)) {
            /*
             * Potion item
             */
            /*
             * Check for max potion
             */
            if (((PotionImpl) item).getHpValue() == 100) {
                return new Image(ClassLoader.getSystemResource("images/potion/potionMaxIcon.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * if not max health return the normal potion image
             */
            return new Image(ClassLoader.getSystemResource("images/potion/potionIcon.png").toExternalForm(), 32, 32, false, true);
        }
        if (item.getClass().equals(ScrollImpl.class)) {
            /*
             * Scroll item, all scrolls have the same icon
             */
            return new Image(ClassLoader.getSystemResource("images/scroll/scrollIcon.png").toExternalForm(), 32, 32, false, true);
        }
        if (item.getClass().equals(ArmorImpl.class)) {
            /*
             * Armor item
             */
            return new Image(ClassLoader.getSystemResource("images/armor/armorIcon.png").toExternalForm(), 32, 32, false, true);
        }
        if (item.getClass().equals(BaseWeapon.class)) {
            /*
             * Weapon item
             */
            return new Image(ClassLoader.getSystemResource("images/weapon/weaponIcon.png").toExternalForm(), 32, 32, false, true);
        }
        if (item.getClass().equals(RingImpl.class)) {
            /*
             * Ring item
             */
            return new Image(ClassLoader.getSystemResource("images/ring/ringIcon.png").toExternalForm(), 32, 32, false, true);
        }
        return new Image(ClassLoader.getSystemResource("images/emptyIcon.png").toExternalForm(), 32, 32, false, true);
    }
}
