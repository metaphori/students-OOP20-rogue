package rogue.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import rogue.model.Game;
import rogue.model.GameImpl;
import rogue.model.creature.Player;
import rogue.model.world.Direction;
import rogue.view.WorldScene;

public class WorldController {
    private static final int DEPTH = 5;
    private final Game game;
    private final WorldScene worldScene;

    public WorldController(final Player player) {
        this.game = new GameImpl(DEPTH, player);
        this.worldScene = new WorldScene(game);
    }

    public final WorldScene getWorldScene() {
        return worldScene;
    }

    public final void movePlayer(final KeyEvent event) {
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

        // update tiles only if level is changed
        if (game.round(direction)) {
            worldScene.drawTiles();
        }

        // always update entities
        worldScene.drawEntities();
    }
}
