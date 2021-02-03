package OOP20.rogue.model.world;

import OOP20.rogue.model.Entity;

public interface Tile {
    Entity getEntity();

    void setEntity(Entity entity);

    String toString();
}
