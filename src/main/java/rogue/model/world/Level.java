package rogue.model.world;

import java.util.List;
import java.util.stream.Stream;

import rogue.model.Entity;

public interface Level {
    int getWidth();

    int getHeight();

    Stream<Tile> getTileStream();

    void spawnEntity(Entity e);

    void spawnEntities(List<Entity> l);

    boolean moveEntities(Direction d);

}
