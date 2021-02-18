package rogue.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import rogue.model.Game;
import rogue.model.world.Direction;

public class MovePlayer {
    public static void movePlayer(KeyEvent event, Game game) {
        final KeyCode key = event.getCode();

        Direction direction = Direction.NONE;

        switch (key) {
            case LEFT:
            case H:
                direction = Direction.WEST;
                break;
            case RIGHT:
            case L:
                direction = Direction.EAST;
                break;
            case UP:
            case K:
                direction = Direction.NORTH;
                break;
            case DOWN:
            case J:
                direction = Direction.SOUTH;
                break;
            default:
                break;
        }

        game.round(direction);
    }
}
