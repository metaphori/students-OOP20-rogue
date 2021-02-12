package rogue.view;

import java.util.Optional;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import rogue.controller.PlayerInputController;

/**
 * Manages keyboard inputs.
 */
public final class PlayerKeyboardInput {

    private Optional<KeyCode> keyPressed = Optional.empty();
    private Optional<PlayerInputController> listener = Optional.empty();

    /**
     * Creates a new PlayerKeyboardInput which manages keyboard inputs.
     * @param scene
     *          the scene from which listen keyboard inputs
     */
    public PlayerKeyboardInput(final Scene scene) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, this::onKeyPressed);
        scene.addEventHandler(KeyEvent.KEY_RELEASED, this::onKeyReleased);
    }

    private void onKeyPressed(final KeyEvent event) {
        this.keyPressed = Optional.of(event.getCode());
    }

    private void onKeyReleased(final KeyEvent event) {
        this.keyPressed = Optional.empty();
    }

    // TODO
    private void computeDirection() {
    }

    private void notifyListener() {
    }

}
