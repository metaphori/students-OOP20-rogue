package rogue.model.world;

/**
 * Coordinate management.
 */
class Coordinates {
    private int x, y;

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    /**
     * @param direction
     * @return the relative tile
     */
    public final Coordinates shift(final Direction direction) {
        final Coordinates c = new Coordinates(this.x, this.y);

        switch (direction) {
            case NORTH:
                c.y--;
                break;
            case EAST:
                c.x++;
                break;
            case SOUTH:
                c.y++;
                break;
            case WEST:
                c.x--;
                break;
            default:
                break;
        }

        return c;
    }

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     */
    Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}