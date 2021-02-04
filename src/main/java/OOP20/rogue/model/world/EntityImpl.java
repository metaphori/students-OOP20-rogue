package OOP20.rogue.model.world;

public class EntityImpl implements Entity {
    private Tile tile;

    public EntityImpl(final Tile tile) {
        this.tile = tile;
    }

    public Coordinates getPosition() {
        return this.tile.getPosition();
    }

    public void setPosition(int x, int y) throws CannotMoveException {
        if (this.tile.getLevel().getTile(x, y).getEntity() != null)
            throw new CannotMoveException();

        this.tile.setEntity(null);
        this.tile.getLevel().getTile(x, y).setEntity(this);
    }
}
