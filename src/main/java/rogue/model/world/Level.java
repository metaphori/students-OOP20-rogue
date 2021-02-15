package rogue.model.world;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import rogue.model.Entity;

public interface Level {
    int getWidth();
    int getHeight();
    Stream<Tile> getTileStream();
    Map<Entity, Tile> getEntityMap();
    Optional<Entity> shiftEntity(Entity e, Direction d, int i) throws CannotMoveException;
    void removeEntity(Entity e) throws CannotRemoveException;
    void placeEntities(List<Entity> l) throws CannotPlaceException;
    int distance(Entity e1, Entity e2);
}
