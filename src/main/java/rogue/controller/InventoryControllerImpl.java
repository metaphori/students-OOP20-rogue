package rogue.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import rogue.model.creature.Player;
import rogue.model.items.inventory.OutOfInventoryException;
import rogue.model.items.potion.PotionImpl;

public class InventoryControllerImpl implements Initializable {

    private static final int NUM_COLS = 4;
    private static final  int NUM_ROWS = 5;

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private GridPane inventoryGrid;

    private Player player;

    /*
     * Background images for InventoryView
     */
    private final BackgroundImage emptyB = new BackgroundImage(new Image(ClassLoader.getSystemResource("images/emptyIcon.png").toExternalForm(), 32, 32, false, true),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT); 
    private final BackgroundImage potionB = new BackgroundImage(new Image(ClassLoader.getSystemResource("images/potionIcon.png").toExternalForm(), 32, 32, false, true),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT); 

    /**
     * Method to get the player from GameController.
     * @param player that holds the inventory.
     */
    public void initPlayer(final Player player) {
        this.player = player;
    }

    /**
     * Gives the updated number for the Model inventory.
     * @param col 
     * @param row
     * @return index for the model inventory.
     */
    public int indexConv(final int col, final int row) {
        return row * 4 + col + 1;
    }

    /**
     * Updates the entire View to the current inventory status.
     * @param player that holds the inventory.
     * @throws OutOfInventoryException 
     */
    public void update(final Player player) throws OutOfInventoryException {
        /*
         * Remove everything in the current InventoryGrid in order to update it.
         */
        inventoryGrid.getChildren().clear();
        /*
         * Populate the inventoryGrid
         */
        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                gridInsert(i, j, player);
            }
        }
    }

    private void gridInsert(final int col, final int row, final Player player) throws OutOfInventoryException {
        final int invIndex = indexConv(col, row);
        final Pane pane = new StackPane();
        if (!player.getInventory().getItem(invIndex).isEmpty()) {
            if (player.getInventory().getItem(invIndex).get().getClass().equals(PotionImpl.class)) {
                pane.setBackground(new Background(potionB));
            }
        } else {
            pane.setBackground(new Background(emptyB));
        }
        pane.setOnMouseClicked(e -> {
            System.out.println("Mouse clicked the cell [" + col + ", " + row + "] , inv[" + invIndex + "]");
        });
        inventoryGrid.add(pane, col, row);
    }
    /**
     * 
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        Platform.runLater(() -> {
        /*
         * Update inventoryGrid constraints.
         */
        for (int i = 0; i < NUM_COLS; i++) {
            final ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.NEVER);
            inventoryGrid.getColumnConstraints().add(colConstraints);
        }

        for (int i = 0; i < NUM_ROWS; i++) {
            final RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.NEVER);
            inventoryGrid.getRowConstraints().add(rowConstraints);
        }
        /*
         * Create grid.
         */
        try {
            update(this.player);
        } catch (OutOfInventoryException e) {
            e.printStackTrace();
        }
        });
    }

}
