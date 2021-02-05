package OOP20.rogue.model.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import OOP20.rogue.model.Entity;

public class LevelImpl implements Level {
    private final int height;
    private final int width;
    private List<List<Tile>> tileMap = new ArrayList<>();
    private Map<Coordinates, Entity> entityMap = new HashMap<>();

    public final Tile getTile(final Coordinates c) {
        return tileMap.get(c.getX()).get(c.getY());
    }

    public final void moveEntity(final Entity e, final Coordinates c) throws CannotMoveException {
        if (entityMap.get(c) != null) {
            throw new CannotMoveException("There's already an entity in this position!");
        }

        if (getTile(c).isWall()) {
            throw new CannotMoveException("Wall!");
        }

        entityMap.remove(e.getPosition());
        entityMap.put(c, e);
    }

    // TODO
    private void generate() {
        IntStream.range(0, this.height).forEach(x -> {
            List<Tile> currentRow = new ArrayList<>();
            IntStream.range(0, this.width).forEach(y -> {
                currentRow.add(new TileImpl(Material.BRICKS, false));
            });
            tileMap.add(currentRow);
        });
    };

    public LevelImpl(final int height, final int width) {
        this.height = height;
        this.width = width;
        this.generate();
    }
}