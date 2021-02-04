package OOP20.rogue.model.world;

public interface Level {
    Tile getTile(int x, int y);
    Coordinates getPosition(Tile t);
}
