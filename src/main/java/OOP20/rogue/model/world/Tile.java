package OOP20.rogue.model.world;

public interface Tile {
    Entity getEntity();

    void setEntity(Entity entity);

    Coordinates getPosition();

    String toString();
}
