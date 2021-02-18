package rogue.controller.menu;

import java.io.IOException;

import rogue.controller.StatusBarControllerImpl;
import rogue.model.creature.PlayerFactoryImpl;
import rogue.view.GameView;
import rogue.view.StatusBarViewImpl;

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
