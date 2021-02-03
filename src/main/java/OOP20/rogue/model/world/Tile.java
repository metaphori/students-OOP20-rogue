package OOP20.rogue.model.world;

enum Material {
    BRICKS, DIRT, LADDER
}

public class Tile {
    private Material material;
    private boolean isWall;

    private Entity entity;

    public Entity getEntity() {
        return this.entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Tile(final Material material, final boolean isWall) {
        this.material = material;
        this.isWall = isWall;
    }

    public String toString() {
        return this.material + ": " + this.isWall;
    }
}
