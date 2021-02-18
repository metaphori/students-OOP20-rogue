package rogue.model.world;

class Coordinates {
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

    public final Coordinates shift(final Direction direction) {
        Coordinates c = new Coordinates(this.x, this.y);

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

    Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}