package OOP20.rogue.model.world;

import java.util.stream.IntStream;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Table;

import OOP20.rogue.model.Entity;

public class LevelImpl implements Level {
    private final int height;
    private final int width;
    private Table<Integer, Integer, Tile> levelMap = HashBasedTable.create();
    private BiMap<Tile, Entity> entityMap = HashBiMap.create();

    public final Tile getTile(final Coordinates c) {
        return this.levelMap.get(c.getX(), c.getY());
    }

    public final void moveEntity(final Entity e, final Coordinates c) throws CannotMoveException {
        if (entityMap.get(c) != null) {
            throw new CannotMoveException("There's already an entity in this position!");
        }

        if (getTile(c).isWall()) {
            throw new CannotMoveException("Wall!");
        }

        entityMap.inverse().remove(e);
        entityMap.put(this.getTile(c), e);
    }

    // TODO
    private void generate() {
        IntStream.range(0, this.height).forEach(x -> {
            IntStream.range(0, this.width).forEach(y -> {
                this.levelMap.put(x, y, new TileImpl(Material.BRICKS, false));
            });
        });
    };

    public LevelImpl(final int height, final int width) {
        this.height = height;
        this.width = width;
        this.generate();
    }
}