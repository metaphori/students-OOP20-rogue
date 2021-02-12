package rogue;

import java.awt.Dimension;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Launcher extends Application {

    /**
     * Create Menu.
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        /*
         * Calculate scene size
         */
        final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        final double width = screenSize.getWidth() / 3;
        final double height = screenSize.getHeight() / 2.5;

        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layout/MainMenu.fxml"));
        final Scene scene = new Scene(root, width, height);

        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("images/rogueIcon.png").toExternalForm()));
        primaryStage.setTitle("Rogue");
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch();
    }
}
