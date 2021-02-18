package rogue.controller.menu;

import java.io.IOException;

import rogue.view.GameView;

public class MenuControllerImpl implements MenuController {

    /**
     * 
     */
    public void showGame() {
        try {
            new GameView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
