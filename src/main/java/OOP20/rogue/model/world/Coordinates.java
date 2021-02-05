package OOP20.rogue.model.world;

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

    public final void shift(final Direction direction, final int howMuch) {
        switch (direction) {
            case NORTH:
                this.y -= howMuch;
                break;
            case EAST:
                this.x += howMuch;
                break;
            case SOUTH:
                this.y += howMuch;
                break;
            case WEST:
                this.y -= howMuch;
                break;
            default:
                break;
        }
    }

    public Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}