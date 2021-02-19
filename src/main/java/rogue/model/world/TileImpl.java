package rogue.model.world;

class TileImpl implements Tile {
    private final int x, y;
    private Material material;
    private final boolean isWall;

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

    TileImpl(final int x, final int y, final Material madeOf, final boolean isWall) {
        this.x = x;
        this.y = y;
        this.material = madeOf;
        this.isWall = isWall;
    }
}
