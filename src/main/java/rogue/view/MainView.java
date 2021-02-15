package rogue.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import rogue.model.world.World;
import rogue.model.world.WorldImpl;

public final class MainView extends Application {

    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layout/MainMenu.fxml"));
        final Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("images/rogueIcon.png").toExternalForm()));
        primaryStage.setTitle("Rogue");
        primaryStage.setResizable(false);
        primaryStage.show();

        final World w = new WorldImpl(7);
        new LevelStage(w.getLevel(0)).show();
    }

    public static void main(final String[] args) {
        launch();
    }

}
