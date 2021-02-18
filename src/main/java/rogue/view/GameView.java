package rogue.view;

import java.awt.Dimension;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rogue.controller.StatusBarControllerImpl;
import rogue.controller.inventory.InventoryController;
import rogue.controller.inventory.InventoryControllerImpl;
import rogue.model.Game;
import rogue.model.GameImpl;
import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;
import rogue.view.inventory.InventoryViewImpl;

public class GameView {

    private final Stage stage = new Stage();
    private final Scene scene;
    private final Player player = new PlayerFactoryImpl().create();
    private void loadStatusBar() {
        final HBox box = (HBox) this.scene.lookup("#top");
        // TODO temporary --> to test!
        final StatusBarViewImpl sbv = new StatusBarViewImpl();
        new StatusBarControllerImpl(sbv, player);
        box.getChildren().add(sbv.getNode());
    }

    private void loadInventory() throws IOException {
        final VBox box = (VBox) this.scene.lookup("#inventory");
        final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layout/InventoryView.fxml"));
        box.getChildren().add(loader.load());
        // TODO temporary --> to test!
        final InventoryController inventoryController = new InventoryControllerImpl(player);
        final InventoryViewImpl controller = loader.getController();
        controller.init(inventoryController);
    }

    private void loadWorld() {
        final VBox box = (VBox) this.scene.lookup("#world");
        final Game game = new GameImpl(4, player);
        box.getChildren().add(new WorldScene(game).getNode());
    }

    public GameView() throws IOException {
        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layout/MainView.fxml"));
        this.scene = new Scene(root);

        this.loadStatusBar();
        this.loadWorld();
        this.loadInventory();

        stage.setScene(this.scene);
        stage.getIcons().add(new Image(ClassLoader.getSystemResource("images/rogueIcon.png").toExternalForm()));
        stage.setTitle("Rogue");
        stage.setResizable(true);
        stage.show();
    }

}
