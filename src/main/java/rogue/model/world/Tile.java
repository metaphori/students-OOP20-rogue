package rogue.model.world;

/**
 * a tile on the map.
 */
public interface Tile {
    /**
     * @return the x coordinate
     */
    int getX();

    /**
     * @return the y coordinate
     */
    int getY();

    /**
     * @return the tile's material
     */
    Material getMaterial();

    /**
     * set the tile's material as DOOR.
     */
    void setDoor();

    /**
     * @return if the tile is a wall
     */
    boolean isWall();
}
