package rogue.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import rogue.model.World;
import rogue.model.WorldImpl;
import rogue.model.creature.Player;
import rogue.model.world.Direction;
import rogue.view.WorldScene;

/**
 * the {@link World} controller.
 */
public class WorldController {
    private final World world;
    private final WorldScene worldScene;

    /**
     * @param player the player instance
     */
    public WorldController(final Player player) {
        this.world = new WorldImpl(player);
        this.worldScene = new WorldScene(world);
    }

    /**
     * @return the current level view
     */
    public final WorldScene getWorldScene() {
        return worldScene;
    }

    /**
     * move player and perform a game round.
     * @param event the key press event
     */
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
        if (world.round(direction)) {
            worldScene.drawTiles();
        }

        // always update entities
        worldScene.drawEntities();
    }
}
