package OOP20.rogue.model.world;

import java.util.Vector;
import java.util.stream.IntStream;

enum Material {
    BRICKS, DIRT, LADDER
}

public class LevelImpl implements Level {
    private class TileImpl implements Tile {
        private class EntityImpl implements Entity {
            public Coordinates getPosition() {
                return TileImpl.this.getPosition();
            }

            public void setPosition(final int x, final int y) throws CannotMoveException {
                if (LevelImpl.this.getTile(x, y).getEntity() != null) {
                    throw new CannotMoveException();
                }

                TileImpl.this.setEntity(null);
                LevelImpl.this.getTile(x, y).setEntity(this);
            }
        }

        private Material material;
        private boolean isWall;
        private Entity entity;

        public Entity getEntity() {
            return this.entity;
        }

        public void setEntity(final Entity entity) {
            this.entity = entity;
        }

        public Coordinates getPosition() {
            return LevelImpl.this.getPosition(this);
        }

        TileImpl(final Material material, final boolean isWall) {
            this.material = material;
            this.isWall = isWall;
        }

        public String toString() {
            return this.material + ": " + this.isWall;
        }
    }

    /*
     * 0 | 1 | 2 | 3
     * 4 | 5 | 6 | 7
     * 8 | 9 ...
     */
    private Vector<Tile> tileMatrix = new Vector<>();
    private int height;
    private int width;

    public final Tile getTile(final int x, final int y) {
        return tileMatrix.get(x * y);
    }

    public final Coordinates getPosition(final Tile t) {
        int index = tileMatrix.indexOf(t);
        return new Coordinates(index % this.width, index % this.height);
    }

    // TODO
    private void generate() {
        IntStream.range(0, this.height * this.width).forEach(index -> {
            tileMatrix.add(new TileImpl(Material.BRICKS, false));
        });
    };

    public LevelImpl(final int height, final int width) {
        this.height = height;
        this.width = width;
        this.generate();
    }
}