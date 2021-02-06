package OOP20.rogue.model.world;

import OOP20.rogue.model.Entity;

public interface Level {
    Tile getTile(Coordinates c);
    void moveEntity(Entity e, Tile t) throws CannotMoveException;
}
