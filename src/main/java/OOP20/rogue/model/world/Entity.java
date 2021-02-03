package OOP20.rogue.model.world;

public interface Entity {
    void move(Direction where, int howMuch) throws CannotMoveException;
}