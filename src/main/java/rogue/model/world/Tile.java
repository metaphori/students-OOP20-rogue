package rogue.model.world;

public interface Tile {
    Level getLevel();
    int getX();
    int getY();
    Material getMaterial();
    boolean isWall();
}
