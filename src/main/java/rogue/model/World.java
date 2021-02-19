package rogue.model;

import java.util.Map;
import java.util.stream.Stream;

import rogue.model.world.Direction;
import rogue.model.world.Tile;

public interface World {
    int getWidth();
    int getHeight();
    Stream<Tile> getTiles();
    Map<Entity, Tile> getEntityMap();
    boolean round(Direction direction);
}
