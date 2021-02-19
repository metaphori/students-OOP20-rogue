package rogue.controller;

import java.io.IOException;

import rogue.controller.inventory.InventoryController;
import rogue.controller.inventory.InventoryControllerImpl;
import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;
import rogue.view.GameView;
import rogue.view.StatusBarView;
import rogue.view.StatusBarViewImpl;

public class GameControllerImpl implements GameController {

    private final StatusBarView statusBarView;
    private final InventoryController inventoryController;
    private final WorldController worldController;

    public GameControllerImpl() {
        /*
         * User's player.
         */
        final Player player = new PlayerFactoryImpl().create();
        /*
         * Create controllers/views.
         */
        this.statusBarView = new StatusBarViewImpl();
        new StatusBarControllerImpl(statusBarView, player);

        this.inventoryController = new InventoryControllerImpl(player);

        this.worldController = new WorldController(player);
    }

    /**
     * 
     */
    public void showGame() {
        try {
            new GameView(statusBarView, inventoryController, worldController);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
