package rogue.model.world;

enum Direction {
    NORTH, EAST, SOUTH, WEST
}

public class Coordinates {
    private int x, y;

    public final int getX() {
        return x;
    }

    public final void setX(final int x) {
        this.x = x;
    }

    public final int getY() {
        return y;
    }

    public final void setY(final int y) {
        this.y = y;
    }

    public final Coordinates shift(final Direction direction, final int howMuch) {
        Coordinates c = new Coordinates(this.x, this.y);

        switch (direction) {
            case NORTH:
                c.y -= howMuch;
                break;
            case EAST:
                c.x += howMuch;
                break;
            case SOUTH:
                c.y += howMuch;
                break;
            case WEST:
                c.y -= howMuch;
                break;
            default:
                break;
        }

        return c;
    }

    public Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}