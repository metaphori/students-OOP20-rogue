package OOP20.rogue.model.world;

import java.util.Vector;
import java.util.stream.IntStream;

public class LevelImpl implements Level {
    /* 0 | 1 | 2 | 3
     * 4 | 5 | 6 | 7
     * 8 | 9 ...
     */
    private Vector<Tile> tileMatrix = new Vector<>();
    private int height;
    private int width;

    public Tile getTile(int x, int y) {
        return tileMatrix.get(x*y);
    }

    public Coordinates getPosition(Tile t) {
        int index = tileMatrix.indexOf(t);
        return new Coordinates(index % this.width, index % this.height);
    }

    // TODO
    private void generate() {
        IntStream.range(0, this.height*this.width).forEach(index -> {
            tileMatrix.set(index, new TileImpl(this, Material.BRICKS, false));
        });
    };

    public LevelImpl(final int height, final int width) {
        this.height = height;
        this.width = width;
        this.generate();
    }
}