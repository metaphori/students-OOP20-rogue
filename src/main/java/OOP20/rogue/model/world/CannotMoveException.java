package OOP20.rogue.model.world;

public class CannotMoveException extends Exception {
    private static final long serialVersionUID = 1484670650603806971L;

    public CannotMoveException() {
    }

    public CannotMoveException(String message) {
        super(message);
    }
}
