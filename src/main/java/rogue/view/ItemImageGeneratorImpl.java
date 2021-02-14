package rogue.view;

import javafx.scene.image.Image;
import rogue.model.items.Item;
import rogue.model.items.food.FoodImpl;
import rogue.model.items.food.FoodType;
import rogue.model.items.potion.PotionImpl;

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
             * Bread
             */
            if (((FoodImpl) item).getFood() == FoodType.BREAD) {
                return new Image(ClassLoader.getSystemResource("images/food/bread.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * CAKE
             */
            if (((FoodImpl) item).getFood() == FoodType.CAKE) {
                return new Image(ClassLoader.getSystemResource("images/food/cake.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * SOUP
             */
            if (((FoodImpl) item).getFood() == FoodType.SOUP) {
                return new Image(ClassLoader.getSystemResource("images/food/soup.png").toExternalForm(), 32, 32, false, true);
            }
            /*
             * HAMBURGER
             */
            if (((FoodImpl) item).getFood() == FoodType.SOUP) {
                return new Image(ClassLoader.getSystemResource("images/food/hamburger.png").toExternalForm(), 32, 32, false, true);
            }
        }
        if (item.getClass().equals(PotionImpl.class)) {
            /*
             * Potion item, potion has the same icon. except for maxhealth potion
             */
            return new Image(ClassLoader.getSystemResource("images/potionIcon.png").toExternalForm(), 32, 32, false, true);
        }
        return new Image(ClassLoader.getSystemResource("images/emptyIcon.png").toExternalForm(), 32, 32, false, true);
    }
}
