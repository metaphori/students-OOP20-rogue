package rogue.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuView extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    /**
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

        final Scene scene = new Scene(root);

        primaryStage.setTitle("Rogue");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

