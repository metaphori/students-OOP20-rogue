package rogue.view;

import static javafx.scene.input.KeyCode.*;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import rogue.controller.PlayerInputController;

/**
 * Manages keyboard inputs.
 */
public final class PlayerKeyboardInput {
    
    private static final Logger LOG = LoggerFactory.getLogger(PlayerKeyboardInput.class);

    private Optional<KeyCode> keyPressed = Optional.empty();
    private Optional<PlayerInputController> listener = Optional.empty();

    /**
     * Creates a new PlayerKeyboardInput which manages keyboard inputs.
     * @param scene
     *          the scene from which listen keyboard inputs
     */
    public PlayerKeyboardInput(final Scene scene) {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, this::onKeyPressed);
        scene.addEventHandler(KeyEvent.KEY_RELEASED, this::onKeyPressed);
    }

    private void onKeyPressed(final KeyEvent event) {
        this.keyPressed = Optional.of(event.getCode());
        this.computeDirection();
    }

    private Point2D computeDirection() {
        final KeyCode key = this.keyPressed.get();
        if (key == LEFT || key == H) {
            LOG.info("left");
        } else if (key == RIGHT || key == L) {
            LOG.info("right");
        } else if (key == UP || key == K) {
            LOG.info("up");
        } else if (key == DOWN || key == J) {
            LOG.info("down");
        }
        return Point2D.ZERO;
    }

}
