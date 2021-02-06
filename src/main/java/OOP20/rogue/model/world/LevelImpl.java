package OOP20.rogue.model.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import OOP20.rogue.model.Entity;

public class LevelImpl implements Level {
    private final int height;
    private final int width;
    private Map<Tile, Coordinates> levelMap = new HashMap<>();
    private BiMap<Tile, Entity> entityMap = HashBiMap.create();

    public final Stream<Tile> getTileStream() {
        List<Tile> ts = new ArrayList<>();
        this.levelMap.forEach((tile, coords) -> ts.add(tile));

        return ts.stream();
    }

    public final void moveEntity(final Entity e, final Tile t) throws CannotMoveException {
        if (entityMap.get(t) != null) {
            throw new CannotMoveException("There's already an entity in this position!");
        }

        if (t.isWall()) {
            throw new CannotMoveException("Wall!");
        }

        // remove entity if already present
        if (entityMap.containsValue(e)) {
            entityMap.inverse().remove(e);
        }

        entityMap.put(t, e);
    }

    public final int distance(final Tile t1, final Tile t2) {
        Coordinates c1 = levelMap.get(t1);
        Coordinates c2 = levelMap.get(t2);
        return Math.abs(c1.getX() - c2.getX()) + Math.abs(c1.getY() - c2.getY());
    }

    // TODO
    private void generate() {
        IntStream.range(0, this.height).forEach(x -> {
            IntStream.range(0, this.width).forEach(y -> {
                this.levelMap.put(new TileImpl(Material.BRICKS, false), new Coordinates(x, y));
            });
        });
    };

    public LevelImpl(final int height, final int width) {
        this.height = height;
        this.width = width;
        this.generate();
    }
}