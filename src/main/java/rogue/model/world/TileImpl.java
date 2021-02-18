package rogue.model.world;

class TileImpl implements Tile {
    private final Level level;
    private final int x, y;
    private Material material;
    private final boolean isWall;

    public final Level getLevel() {
        return level;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public final Material getMaterial() {
        return material;
    }

    public final boolean isWall() {
        return isWall;
    }

    public final void setDoor() {
        material = Material.DOOR;
    }

    TileImpl(final Level level, final int x, final int y, final Material madeOf, final boolean isWall) {
        this.level = level;
        this.x = x;
        this.y = y;
        this.material = madeOf;
        this.isWall = isWall;
    }
}
