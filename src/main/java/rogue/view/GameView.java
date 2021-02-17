package rogue.view;

import java.awt.Dimension;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rogue.controller.inventory.InventoryController;
import rogue.controller.inventory.InventoryControllerImpl;
import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;
import rogue.view.inventory.InventoryViewImpl;

public class GameView {

    private final Stage stage = new Stage();
    private final Parent root;
    private final Scene scene;

    private void loadStatusBar() {
        final Pane pane = (Pane) this.scene.lookup("#statusBarPane");
        System.out.print(pane);

        pane.getChildren().add(new StatusBarViewImpl().getNode());
    }

    private void loadInventory() throws IOException {
        final Pane pane = (Pane) this.scene.lookup("#inventory");
        System.out.println(pane);
        final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layout/InventoryView.fxml"));
        pane.getChildren().add(loader.load());

        final Player player = new PlayerFactoryImpl().create();
        final InventoryController inventoryController = new InventoryControllerImpl(player);

        final InventoryViewImpl controller = loader.getController();
        controller.init(inventoryController);
    }

    public GameView() throws IOException {
        /*
         * Calculate scene size
         */
        final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        final double width = screenSize.getWidth();
        final double height = screenSize.getHeight();

        this.root = FXMLLoader.load(ClassLoader.getSystemResource("layout/MainView.fxml"));
        this.scene = new Scene(root, width, height);

        this.loadStatusBar();
        this.loadInventory();

        stage.setScene(this.scene);
        stage.getIcons().add(new Image(ClassLoader.getSystemResource("images/rogueIcon.png").toExternalForm()));
        stage.setTitle("Rogue");
        stage.setResizable(true);
        stage.show();
    }

//    public GameView() throws IOException {
//        this.root.getChildren().add(new StatusBarViewImpl().getNode());
//        final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layout/InventoryView.fxml"));
//        this.root.getChildren().add(loader.load());
//
//        final Player player = new PlayerFactoryImpl().create();
//        final InventoryController inventoryController = new InventoryControllerImpl(player);
//
//        final InventoryViewImpl controller = loader.getController();
//        controller.init(inventoryController);
//
//        stage.setScene(this.scene);
//        stage.getIcons().add(new Image(ClassLoader.getSystemResource("images/rogueIcon.png").toExternalForm()));
//        stage.setTitle("Rogue");
//        stage.setResizable(true);
//        stage.show();
//    }

}
