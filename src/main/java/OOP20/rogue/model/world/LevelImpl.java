package OOP20.rogue.model.world;

import java.util.stream.IntStream;

public class LevelImpl implements Level {
    private Tile[][] tileMatrix;

    public Tile getTile(int x, int y) {
        return tileMatrix[x][y];
    }

    // TODO
    private void generate() {
        IntStream.range(0, this.tileMatrix.length).forEach(row -> {
            IntStream.range(0, this.tileMatrix[0].length).forEach(col -> {
                tileMatrix[row][col] = new TileImpl(Material.BRICKS, false);
            });
        });
    };

    public LevelImpl(final int height, final int width) {
        this.tileMatrix = new Tile[height][width];
        this.generate();
    }
}