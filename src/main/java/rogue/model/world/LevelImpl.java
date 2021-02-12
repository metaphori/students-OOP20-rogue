package rogue.model.world;

import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Table;

import rogue.model.Entity;
import rogue.model.creature.PlayerFactoryImpl;

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

    public final void moveEntity(final Entity e, final Tile t) throws CannotMoveException {
        if (entityMap.inverse().get(t) != null) {
            throw new CannotMoveException("There's already an entity in this position!");
        }

        if (t.isWall()) {
            throw new CannotMoveException("Wall!");
        }

        // remove entity if already present
        if (entityMap.containsKey(e)) {
            entityMap.remove(e);
        }

        entityMap.put(e, t);
    }

    public final void shiftEntity(final Entity e, final Direction d, final int i) throws CannotMoveException {
        if (!entityMap.containsKey(e)) {
            throw new CannotMoveException("There's already an entity in this position!");
        }

        Tile currentTile = entityMap.get(e);
        Coordinates currentCoordinates = new Coordinates(currentTile.getX(), currentTile.getY());
        Coordinates finalCoordinates = currentCoordinates.shift(d, i);
        Tile finalTile = tileMap.get(finalCoordinates.getX(), finalCoordinates.getY());

        moveEntity(e, finalTile);
    }

    public final void removeEntity(final Entity e) throws CannotRemoveException {
        if (!entityMap.containsKey(e)) {
            throw new CannotRemoveException("Entity already absent!");
        }

        entityMap.remove(e);
    }

    public final int distance(final Tile t1, final Tile t2) {
        return Math.abs(t1.getX() - t2.getX()) + Math.abs(t1.getY() - t2.getY());
    }

    // TODO: REDO THIS FUCKING MESS FOR GOD'S SAKE
    private void generate() throws CannotMoveException {
        // levelMap
        IntStream.range(0, HEIGHT).forEach(x -> {
            IntStream.range(0, WIDTH).forEach(y -> {
                boolean isWall = x == 0 || x == WIDTH - 1 || y == 0 || y == HEIGHT - 1;
                Material madeOf = x != WIDTH / 4 || y != HEIGHT / 4
                        ? random.nextInt(VINE_PROBABILITY) != 0 ? Material.BRICKS : Material.VINES
                        : Material.DOOR;

                // redundant but not slow as fuck
                tileMap.put(x, y, new TileImpl(this, x, y, madeOf, isWall));
            });
        });

        // entities
        moveEntity(new PlayerFactoryImpl().create(), tileMap.get(WIDTH / 2, HEIGHT / 2));
    };

    LevelImpl() throws CannotMoveException {
        this.generate();
    }
}