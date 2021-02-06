package rogue.model.world;

enum Material {
    BRICKS, DIRT, LADDER
}

class TileImpl implements Tile {
    private final Material material;
    private final boolean isWall;

    public final Material getMaterial() {
        return material;
    }

    public final boolean isWall() {
        return isWall;
    }

    TileImpl(final Material madeOf, final boolean isWall) {
        this.material = madeOf;
        this.isWall = isWall;
    }
}
