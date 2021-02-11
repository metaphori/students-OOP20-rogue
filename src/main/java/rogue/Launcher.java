package rogue;

import javafx.application.Application;
import javafx.stage.Stage;
import rogue.view.MainView;

public final class Launcher extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        new MainView(primaryStage);
    }

    public static void main(final String[] args) {
        launch();
    }
}
