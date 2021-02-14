package rogue.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class MainView {

    private final Group root = new Group();
    private final Scene scene = new Scene(root);

    public MainView(final Stage stage) {
//        final Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
//        stage.setWidth(primaryScreenBounds.getWidth());
//        stage.setHeight(primaryScreenBounds.getHeight());

        final StatusBarViewImpl sb = new StatusBarViewImpl();
        root.getChildren().add(sb.getNode());

//        stage.setFullScreen(true);
//        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
