package rogue.model.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import rogue.model.items.armor.ArmorImpl;
import rogue.model.items.armor.ArmorType;
import rogue.model.items.food.FoodImpl;
import rogue.model.items.food.FoodType;
import rogue.model.items.potion.PotionImpl;
import rogue.model.items.potion.PotionType;
import rogue.model.items.rings.RingImpl;
import rogue.model.items.rings.RingType;
import rogue.model.items.scroll.ScrollImpl;
import rogue.model.items.scroll.ScrollType;
import rogue.model.items.weapons.BaseWeapon;
import rogue.model.items.weapons.WeaponType;


public class ItemFactoryImpl implements ItemFactory {
    private static final int MIN_ITEMS = 5;
    private static final int MAX_ITEMS = 7;
    private static final int ITEM_COUNT_DIFF = MAX_ITEMS - MIN_ITEMS;

    private static final int ARMOR = 0;
    private static final int FOOD = 1;
    private static final int POTION = 2;
    private static final int RING = 3;
    private static final int SCROLL = 4;
    private static final int WEAPON = 5;

    private final Random rand = new Random();

    /**
     * @param quantity of wanted items.
     * @return List containing randomly generated items.
     */
    public List<Item> getItems(final int quantity) {
        final ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            final int itemIndex = rand.nextInt(6);
            switch (itemIndex) {
                case ARMOR:
                    items.add(new ArmorImpl(Arrays.asList(ArmorType.values()).stream().skip((int) (Arrays.asList(ArmorType.values()).size() * Math.random())).findAny().get()));
                    break;
                case FOOD:
                    items.add(new FoodImpl(Arrays.asList(FoodType.values()).stream().skip((int) (Arrays.asList(FoodType.values()).size() * Math.random())).findAny().get()));
                    break;
                case POTION:
                    items.add(new PotionImpl(Arrays.asList(PotionType.values()).stream().skip((int) (Arrays.asList(PotionType.values()).size() * Math.random())).findAny().get()));
                    break;
                case RING:
                    items.add(new RingImpl(Arrays.asList(RingType.values()).stream().skip((int) (Arrays.asList(RingType.values()).size() * Math.random())).findAny().get()));
                    break;
                case SCROLL:
                    items.add(new ScrollImpl(Arrays.asList(ScrollType.values()).stream().skip((int) (Arrays.asList(ScrollType.values()).size() * Math.random())).findAny().get()));
                    break;
                case WEAPON:
                    items.add(new BaseWeapon(Arrays.asList(WeaponType.values()).stream().skip((int) (Arrays.asList(WeaponType.values()).size() * Math.random())).findAny().get()));
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        return items;
    }


    public final List<Item> getItems() {
        var itemCount = rand.nextInt(ITEM_COUNT_DIFF);
        return getItems(MIN_ITEMS + itemCount);
    }
}
