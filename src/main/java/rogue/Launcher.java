package rogue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Launcher extends Application {

    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;

    /**
     * Create Menu.
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layout/MainMenu.fxml"));
        final Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("images/rogueIcon.png").toExternalForm()));
        primaryStage.setTitle("Rogue");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch();
    }
}
