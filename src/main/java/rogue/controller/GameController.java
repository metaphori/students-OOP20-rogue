package rogue.controller;

public interface GameController {

    /**
     * Get the text entered in the Menu's text area.
     * @return player's name.
     */
    String getPlayerName();

    /**
     * Creates the MainView.
     */
    void start();
}
