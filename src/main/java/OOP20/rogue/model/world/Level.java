package OOP20.rogue.model.world;

import OOP20.rogue.model.Entity;

public interface Level {
    int distance(Tile t1, Tile t2);
    void moveEntity(Entity e, Tile t) throws CannotMoveException;
}
