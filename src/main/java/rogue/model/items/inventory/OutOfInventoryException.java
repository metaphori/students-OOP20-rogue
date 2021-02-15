package rogue.model.items.inventory;

public class OutOfInventoryException extends Exception {

    private static final long serialVersionUID = -4154450610441652376L;

    OutOfInventoryException(final String message) {
        super(message);
    }

}
