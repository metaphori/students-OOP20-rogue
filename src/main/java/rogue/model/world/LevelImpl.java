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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOG = LoggerFactory.getLogger(Level.class);
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
        if (entityMap.containsKey(e)) {
            removeEntity.accept(e);
        }

        entityMap.put(e, t);
        freeTiles.remove(t);
    };

    private final BiFunction<Entity, Direction, Tile> getRelativeTile = (e, d) -> {
        final Tile currentTile = entityMap.get(e);
        final Coordinates currentCoordinates = new Coordinates(currentTile.getX(), currentTile.getY());
        final Coordinates finalCoordinates = currentCoordinates.shift(d);
        final Tile finalTile = tileMap.get(finalCoordinates.getX(), finalCoordinates.getY());

        return finalTile;
    };

    // useless
    // private final BiFunction<Entity, Direction, Entity> getRelativeEntity = (e,
    // d) -> entityMap.inverse().get(getRelativeTile.apply(e, d));

    // place entity e in a random tile
    private final Consumer<Entity> spawn = e -> placeEntity.accept(e, getRandomFreeTile.get());

    // generate the level map
    private final Runnable generate = () -> {
        final var cave = new CaveGenerator(WIDTH, HEIGHT).getCave();

        // tileMap
        IntStream.range(0, WIDTH).forEach(x -> {
            IntStream.range(0, HEIGHT).forEach(y -> {
                final var isWall = cave[x][y];
                final var madeOf = random.nextInt(VINE_PROBABILITY) != 0 ? Material.BRICKS : Material.VINES;

                final var t = new TileImpl(this, x, y, madeOf, isWall);

                // redundant but not slow
                tileMap.put(x, y, t);

                // cache free tiles
                if (!isWall) {
                    freeTiles.add(t);
                }
            });
        });

        // door to next level
        final var door = getRandomFreeTile.get();
        freeTiles.remove(door);
        door.setDoor();
    };

    // nearest direction to player
    private final Function<Entity, Direction> nearestDirectionToPlayer = e -> {
        final int east = entityMap.get(player).getX() - entityMap.get(e).getX();
        final int west = entityMap.get(e).getX() - entityMap.get(player).getX();
        final int south = entityMap.get(player).getY() - entityMap.get(e).getY();
        final int north = entityMap.get(e).getY() - entityMap.get(player).getY();

        final Pair<Direction, Integer> xDirection = east > 0
            ? new Pair<>(Direction.EAST, east)
            : new Pair<>(Direction.WEST, west);
        final Pair<Direction, Integer> yDirection = south > 0
            ? new Pair<>(Direction.SOUTH, south)
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
        final var nextLevel = new AtomicBoolean(false);

        entityMap.forEach((e, t) -> {
            // interact
            if (e instanceof Creature) {
                // TODO monster movement
                final Tile nextTile = e instanceof Player
                    ? getRelativeTile.apply(e, d)
                    : getRelativeTile.apply(e, ((Monster) e).monsterMove(nearestDirectionToPlayer.apply(e)));

                if (nextTile.getMaterial() == Material.DOOR) {
                    nextLevel.set(true);
                    removeEntity.accept(e);
                }

                final Entity relativeEntity = entityMap.inverse().get(nextTile);

                if (relativeEntity instanceof Creature) {
                    combat.attack((Creature) e, (Creature) relativeEntity);
                } else if (e instanceof Player && relativeEntity instanceof Item) {
                    try {
                        // pick up item
                        ((Player) e).getInventory().addItem((Item) relativeEntity);
                        removeEntity.accept(relativeEntity);
                        placeEntity.accept(e, nextTile);
                    } catch (InventoryIsFullException e1) {
                        LOG.info("Inventory full!");
                    }
                } else if (relativeEntity == null && canPlaceEntity.test(nextTile)) {
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