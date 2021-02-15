package rogue.model.world;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Table;

import rogue.model.Entity;

class CannotMoveException extends Exception {
    private static final long serialVersionUID = 1484670650603806971L;

    public CannotMoveException() {
    }

    public CannotMoveException(final String message) {
        super(message);
    }
}

class CannotRemoveException extends Exception {
    private static final long serialVersionUID = -5155914335574994788L;

    public CannotRemoveException() {
    }

    public CannotRemoveException(final String message) {
        super(message);
    }
}

class LevelImpl implements Level {
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;
    private static final int VINE_PROBABILITY = 5;

    private final Random random = new Random();
    private final Table<Integer, Integer, Tile> tileMap = HashBasedTable.create();
    private final BiMap<Entity, Tile> entityMap = HashBiMap.create();

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

    private Optional<Entity> moveEntity(final Entity e, final Tile t) throws CannotMoveException {
        Entity existingEntity = entityMap.inverse().get(t);
        if (existingEntity != null) {
            return Optional.of(existingEntity);
        }

        if (t.isWall()) {
            throw new CannotMoveException("Wall!");
        }

        // remove entity if already present
        if (entityMap.containsKey(e)) {
            entityMap.remove(e);
        }

        entityMap.put(e, t);

        return Optional.empty();
    }

    public final Optional<Entity> shiftEntity(final Entity e, final Direction d, final int i) throws CannotMoveException {
        if (!entityMap.containsKey(e)) {
            throw new CannotMoveException("Entity doesn't exist!");
        }

        Tile currentTile = entityMap.get(e);
        Coordinates currentCoordinates = new Coordinates(currentTile.getX(), currentTile.getY());
        Coordinates finalCoordinates = currentCoordinates.shift(d, i);
        Tile finalTile = tileMap.get(finalCoordinates.getX(), finalCoordinates.getY());

        return moveEntity(e, finalTile);
    }

    public final void removeEntity(final Entity e) throws CannotRemoveException {
        if (!entityMap.containsKey(e)) {
            throw new CannotRemoveException("Entity already absent!");
        }

        entityMap.remove(e);
    }

    public final int distance(final Entity e1, final Entity e2) {
        Tile t1 = entityMap.get(e1), t2 = entityMap.get(e2);
        return Math.abs(t1.getX() - t2.getX()) + Math.abs(t1.getY() - t2.getY());
    }

    private void generate() throws CannotMoveException {
        var cave = new CaveGenerator(WIDTH, HEIGHT).getCave();

        // tileMap
        IntStream.range(0, WIDTH).forEach(x -> {
            IntStream.range(0, HEIGHT).forEach(y -> {
                var isWall = cave[x][y];
                var madeOf = random.nextInt(VINE_PROBABILITY) != 0 ? Material.BRICKS : Material.VINES;

                // redundant but not slow as fuck
                tileMap.put(x, y, new TileImpl(this, x, y, madeOf, isWall));
            });
        });

        // entities
        // TODO: BROKEN PORCODIO
        //moveEntity(new PlayerFactoryImpl().create(), tileMap.get(WIDTH / 2, HEIGHT / 2));
    };

    LevelImpl() throws CannotMoveException {
        this.generate();
    }
}