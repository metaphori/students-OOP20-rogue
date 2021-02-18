package rogue.model.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Table;

import javafx.util.Pair;
import rogue.model.Entity;
import rogue.model.creature.Combat;
import rogue.model.creature.CombatImpl;
import rogue.model.creature.Creature;
import rogue.model.creature.Monster;
import rogue.model.creature.Player;
import rogue.model.items.Item;
import rogue.model.items.inventory.InventoryIsFullException;

public class LevelImpl implements Level {
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;
    private static final int VINE_PROBABILITY = 5;

    private final Random random = new Random();
    private final Combat combat = new CombatImpl();
    private final Table<Integer, Integer, Tile> tileMap = HashBasedTable.create();
    private Entity player = null;
    private final BiMap<Entity, Tile> entityMap = HashBiMap.create();

    // freeTiles cache
    private final List<Tile> freeTiles = new ArrayList<>();

    // get a random tile from the freeTiles list
    private final Supplier<Tile> getRandomFreeTile = () -> freeTiles.get(random.nextInt(freeTiles.size()));

    // can place an entity in tile t?
    private final Predicate<Tile> canPlaceEntity = t -> !t.isWall() && !entityMap.containsValue(t);

    // remove entity from the map
    private final Consumer<Entity> removeEntity = e -> {
        freeTiles.add(entityMap.get(e));
        entityMap.remove(e);
    };

    // place entity e in tile t
    private final BiConsumer<Entity, Tile> placeEntity = (e, t) -> {
        removeEntity.accept(e);
        entityMap.put(e, t);
        freeTiles.remove(t);
    };

    private final BiFunction<Entity, Direction, Tile> getRelativeTile = (e, d) -> {
        Tile currentTile = entityMap.get(e);
        Coordinates currentCoordinates = new Coordinates(currentTile.getX(), currentTile.getY());
        Coordinates finalCoordinates = currentCoordinates.shift(d);
        Tile finalTile = tileMap.get(finalCoordinates.getX(), finalCoordinates.getY());

        return finalTile;
    };

    // useless
    // private final BiFunction<Entity, Direction, Entity> getRelativeEntity = (e,
    // d) -> entityMap.inverse().get(getRelativeTile.apply(e, d));

    // place entity e in a random tile
    private final Consumer<Entity> spawn = e -> placeEntity.accept(e, getRandomFreeTile.get());

    // move an entity e in direction d
    private final BiConsumer<Entity, Direction> shiftEntity = (e, d) -> {
        Tile currentTile = entityMap.get(e);
        Coordinates currentCoordinates = new Coordinates(currentTile.getX(), currentTile.getY());
        Coordinates finalCoordinates = currentCoordinates.shift(d);
        Tile finalTile = tileMap.get(finalCoordinates.getX(), finalCoordinates.getY());

        placeEntity.accept(e, finalTile);
    };

    // generate the level map
    private final Runnable generate = () -> {
        var cave = new CaveGenerator(WIDTH, HEIGHT).getCave();

        // tileMap
        IntStream.range(0, WIDTH).forEach(x -> {
            IntStream.range(0, HEIGHT).forEach(y -> {
                var isWall = cave[x][y];
                var madeOf = random.nextInt(VINE_PROBABILITY) != 0 ? Material.BRICKS : Material.VINES;

                var t = new TileImpl(this, x, y, madeOf, isWall);

                // redundant but not slow as fuck
                tileMap.put(x, y, t);

                // cache free tiles
                if (!isWall) {
                    freeTiles.add(t);
                }
            });
        });

        // door to next level
        var door = getRandomFreeTile.get();
        freeTiles.remove(door);
        door.setDoor();
    };

    // nearest direction to player
    private final Function<Entity, Direction> nearestDirectionToPlayer = e -> {
        int east = entityMap.get(player).getX() - entityMap.get(e).getX();
        int west = entityMap.get(e).getX() - entityMap.get(player).getX();
        int south = entityMap.get(player).getY() - entityMap.get(e).getY();
        int north = entityMap.get(e).getY() - entityMap.get(player).getY();

        Pair<Direction, Integer> xDirection = east > 0 ? new Pair<>(Direction.EAST, east)
                : new Pair<>(Direction.WEST, west);
        Pair<Direction, Integer> yDirection = south > 0 ? new Pair<>(Direction.SOUTH, south)
                : new Pair<>(Direction.NORTH, north);

        return xDirection.getValue() > yDirection.getValue() ? xDirection.getKey() : yDirection.getKey();
    };

    public final int getWidth() {
        return WIDTH;
    }

    public final int getHeight() {
        return HEIGHT;
    }

    public final Stream<Tile> getTileStream() {
        return tileMap.values().stream();
    }

    public final Map<Entity, Tile> getEntityMap() {
        return entityMap;
    }

    public final void spawnEntity(final Entity e) {
        spawn.accept(e);
    }

    public final void spawnEntities(final List<Entity> l) {
        l.forEach(spawn);
    }

    public final boolean moveEntities(final Direction d) {
        // we can edit this from inside lambdas
        var nextLevel = new AtomicBoolean(false);

        entityMap.forEach((e, t) -> {
            // interact
            if (e instanceof Creature) {
                // TODO monster movement
                Tile nextTile = e instanceof Player
                    ? getRelativeTile.apply(e, d)
                    : getRelativeTile.apply(e, ((Monster) e).monsterMove(nearestDirectionToPlayer.apply(e)));

                if (nextTile.getMaterial() == Material.DOOR) {
                    nextLevel.set(true);
                }

                Entity relativeEntity = entityMap.inverse().get(nextTile);

                if (relativeEntity instanceof Creature) {
                    combat.attack((Creature) e, (Creature) relativeEntity);
                } else if (e instanceof Player && relativeEntity instanceof Item) {
                    try {
                        ((Player) e).getInventory().addItem((Item) relativeEntity);
                    } catch (InventoryIsFullException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else if (relativeEntity == null) {
                    // move entity if tile is empty
                    placeEntity.accept(e, nextTile);
                }
            }
        });

        return nextLevel.get();
    }

    public LevelImpl(final List<Entity> list, final Player player) {
        this.player = player;
        generate.run();
        spawnEntities(list);
    }
}