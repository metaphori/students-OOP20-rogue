package rogue.controller;

import java.io.IOException;

import javafx.scene.input.KeyEvent;
import rogue.model.items.inventory.InventoryIsFullException;

public interface GameController {

    /**
     * Get the text entered in the Menu's text area.
     * @return player's name.
     */
    String getPlayerName();

    /**
     * Creates the MainView.
     * @param event that triggered the start method.
     */
    void start(KeyEvent event) throws IOException, InventoryIsFullException;
}
