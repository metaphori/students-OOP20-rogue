package OOP20.rogue.model.world;

enum Material {
    BRICKS, DIRT, LADDER
}

public class TileImpl implements Tile {
    private Level level;
    private Material material;
    private boolean isWall;
    private Entity entity;

    public Level getLevel() {
        return level;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Coordinates getPosition() {
        return this.level.getPosition(this);
    }

    public TileImpl(final Level level, final Material material, final boolean isWall) {
        this.level = level;
        this.material = material;
        this.isWall = isWall;
    }

    public String toString() {
        return this.material + ": " + this.isWall;
    }
}
