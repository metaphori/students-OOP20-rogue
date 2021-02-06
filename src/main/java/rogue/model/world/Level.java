package rogue.model.world;

import java.util.stream.Stream;

import rogue.model.Entity;

public interface Level {
    Stream<Tile> getTileStream();
    int distance(Tile t1, Tile t2);
    void moveEntity(Entity e, Tile t) throws CannotMoveException;
    void removeEntity(Entity e) throws CannotRemoveException;
}
