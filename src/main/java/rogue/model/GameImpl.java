package rogue.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

import rogue.model.creature.MonsterFactory;
import rogue.model.creature.MonsterFactoryImpl;
import rogue.model.creature.Player;
import rogue.model.items.ItemFactory;
import rogue.model.items.ItemFactoryImpl;
import rogue.model.world.Direction;
import rogue.model.world.Level;
import rogue.model.world.LevelImpl;
import rogue.model.world.Tile;

public class GameImpl implements Game {
    private static final MonsterFactory MONSTER_FACTORY = new MonsterFactoryImpl();
    private static final ItemFactory ITEM_FACTORY = new ItemFactoryImpl();

    private Level currentLevel;
    private Player player;

    private final Runnable nextLevel = () -> {
        var entityList = new ArrayList<Entity>();
        entityList.add(player);
        entityList.addAll(MONSTER_FACTORY.createMonsterList(player.getLife().getLevel()));
        entityList.addAll(ITEM_FACTORY.getItems());

        currentLevel = new LevelImpl(entityList, player);
    };

    public final Stream<Tile> getTiles() {
        return currentLevel.getTileStream();
    }

    public final Map<Entity, Tile> getEntityMap() {
        return currentLevel.getEntityMap();
    }

    /**
     * round.
     * 
     * @param direction player movement direction
     * @return nextLevel?
     */
    public final boolean round(final Direction direction) {
        boolean nextlvl = false;
        if (currentLevel.moveEntities(direction)) {
            nextLevel.run(); // change level
            nextlvl = true;
        }
        if (player.getInventory().getScrollContainer().getActiveScroll().isPresent()) {
            player.getInventory().getScrollContainer().updateEffectDuration(1);
        }

        return nextlvl;
    }

    public final int getWidth() {
        return currentLevel.getWidth();
    }

    public final int getHeight() {
        return currentLevel.getHeight();
    }

    public GameImpl(final int depth, final Player player) {
        this.player = player;
        // spawn player
        nextLevel.run();
    }
}