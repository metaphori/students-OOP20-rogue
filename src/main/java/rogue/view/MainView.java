package rogue.view;

import java.awt.Dimension;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import rogue.controller.menu.MenuController;
import rogue.controller.menu.MenuControllerImpl;
import rogue.model.Game;
import rogue.model.GameImpl;
import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;
import rogue.view.menu.MenuViewImpl;

public final class MainView extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        /*
         * Calculate scene size
         */
        final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        final double width = screenSize.getWidth() / 3;
        final double height = screenSize.getHeight() / 2.5;
        /*
         * Load Menu fxml.
         */
        final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layout/MainMenu.fxml"));
        final Parent root = loader.load();
        /*
         * Pass the MenuController to The view.
         */
        final MenuController menuController = new MenuControllerImpl();
        final MenuViewImpl controller = loader.getController();
        controller.init(menuController);
        /*
         * Create MenuView
         */
        final Scene scene = new Scene(root, width, height);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("images/rogueIcon.png").toExternalForm()));
        primaryStage.setTitle("Rogue");
        primaryStage.setResizable(true);
        primaryStage.show();

        // TODO
        Player player = new PlayerFactoryImpl().create();
        Game game = new GameImpl(5, player);
        new WorldScene(game).show();
    }

    public static void main(final String[] args) {
        launch();
    }

}
