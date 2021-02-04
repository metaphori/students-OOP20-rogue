package OOP20.rogue.model.world;

public interface Entity {
    Coordinates getPosition();
    void setPosition(int x, int y) throws CannotMoveException;
}