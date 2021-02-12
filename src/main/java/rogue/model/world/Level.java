package rogue.model.world;

import java.util.Map;
import java.util.stream.Stream;

import rogue.model.Entity;

public interface Level {
    int getWidth();
    int getHeight();
    Stream<Tile> getTileStream();
    Map<Entity, Tile> getEntityMap();
    int distance(Tile t1, Tile t2);
    void moveEntity(Entity e, Tile t) throws CannotMoveException;
    void shiftEntity(Entity e, Direction d, int i) throws CannotMoveException;
    void removeEntity(Entity e) throws CannotRemoveException;
}
