package OOP20.rogue.model.world;

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

    public Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}