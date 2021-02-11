package rogue.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public final class StatusBar extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Group root = FXMLLoader.load(ClassLoader.getSystemResource("layout/StatusBar.fxml"));
        final Scene scene = new Scene(root);

        final Label level = (Label) scene.lookup("#level");
        level.setText("a");

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
