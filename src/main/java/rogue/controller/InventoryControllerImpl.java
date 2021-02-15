package rogue.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import rogue.model.creature.Player;
import rogue.model.items.inventory.OutOfInventoryException;
import rogue.model.items.scroll.ScrollImpl;
import rogue.model.items.scroll.ScrollType;
import rogue.view.ItemImageGenerator;
import rogue.view.ItemImageGeneratorImpl;

public class InventoryControllerImpl implements Initializable {

    private static final int NUM_COLS = 4;
    private static final int NUM_ROWS = 5;
    private static final int QUANTITY_SIZE = 17;

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private GridPane inventoryGrid;
    @FXML  private GridPane ringAndScrollGrid;

    private Player player;
    private Optional<Integer> swapping = Optional.empty();
    /*
     * Background images for InventoryView
     */
    private final BackgroundImage emptyB = new BackgroundImage(new Image(ClassLoader.getSystemResource("images/emptyIcon.png").toExternalForm(), 32, 32, false, true),
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
         * Also removes everything in the current ScrollContainerGrid.
         */
        inventoryGrid.getChildren().clear();
        ringAndScrollGrid.getChildren().clear();
        /*
         * Populate the inventoryGrid
         */
        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                gridInsert(i, j, player);
            }
        }
        /*
         * Make scrollContainer.
         */
        final Pane pane = new StackPane();
        if (!player.getInventory().getScrollContainer().getActiveScroll().isEmpty()) {
            final ItemImageGenerator itemI = new ItemImageGeneratorImpl();
            pane.setBackground(new Background(new BackgroundImage(itemI.getImage(new ScrollImpl(ScrollType.SCROLL_I)),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT)));
            final Text turns = new Text();
            turns.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, QUANTITY_SIZE));
            turns.setFill(Color.ORANGE);
            turns.setStrokeWidth(1); 
            turns.setStroke(Color.BLACK);
            turns.setText(String.valueOf(player.getInventory().getScrollContainer().getActiveScrollDuration()));
            pane.getChildren().add(turns);
        } else {
            pane.setBackground(new Background(emptyB));
        }
        ringAndScrollGrid.add(pane, 1, 0);


    }

    private void gridInsert(final int col, final int row, final Player player) throws OutOfInventoryException {
        final int invIndex = indexConv(col, row);
        final Pane pane = new StackPane();
        if (!player.getInventory().getItem(invIndex).isEmpty()) {
            /*
             * Set quantity text options.
             */
            final ItemImageGenerator itemI = new ItemImageGeneratorImpl();
            final Text quantity = new Text();
            quantity.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, QUANTITY_SIZE));
            quantity.setFill(Color.ORANGE);
            quantity.setStrokeWidth(1); 
            quantity.setStroke(Color.BLACK);
            /*
             * Check current item slot and update pane image and quantity text.
             */
            pane.setBackground(new Background(new BackgroundImage(itemI.getImage(player.getInventory().getItem(invIndex).get()),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT)));
            quantity.setText(String.valueOf(player.getInventory().getAmount(invIndex)));
            pane.getChildren().add(quantity);
        } else {
            /*
             * empty slot.
             */
            pane.setBackground(new Background(emptyB));
        }
        /*
         * Set each slots events.
         */
        final EventBus eventBus = new EventBus();
        final EventListener listener = new EventListener();
        eventBus.register(listener);
        pane.setOnMouseClicked(e -> {
            final MouseButton button = e.getButton();
            /*
             * Use item
             */
            if (button.equals(MouseButton.PRIMARY)) {
                /*
                 * Remove eventual swapping event
                 */
                swapping = Optional.empty();
                try {
                    if (!player.getInventory().useItem(invIndex)) {
                        System.out.println("Cannot use: " + (player.getInventory().getItem(invIndex).isEmpty() ? "EMPTY ITEM" 
                                : player.getInventory().getItem(invIndex).get()));
                    }
                } catch (OutOfInventoryException e1) {
                    e1.printStackTrace();
                }
                eventBus.post("Update event");
            }
            /*
             * REMOVE ITEM
             */
            if (button.equals(MouseButton.SECONDARY)) {
                /*
                 * Remove eventual swapping event
                 */
                swapping = Optional.empty();
                /*
                 * remove item
                 */
                try {
                    if (!player.getInventory().remove(invIndex)) {
                        System.out.println("Cannot remove empty slot.");
                    }
                } catch (OutOfInventoryException e1) {
                    e1.printStackTrace();
                }
                eventBus.post("Update event");
            }
            /*
             * SWAP
             */
            if (button.equals(MouseButton.MIDDLE)) {
                if (swapping.isEmpty()) {
                    /*
                     * make clicked slot swapping slot.
                     */
                    swapping = Optional.of(invIndex);
                    pane.getChildren().clear();
                    final Text swap = new Text();
                    swap.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, QUANTITY_SIZE));
                    swap.setFill(Color.ORANGE);
                    swap.setStrokeWidth(1);
                    swap.setStroke(Color.BLACK);
                    swap.setText("SWAP");
                    pane.getChildren().add(swap);
                } else {
                    /*
                     * execute swap.
                     */
                    try {
                        player.getInventory().swap(invIndex, swapping.get());
                    } catch (OutOfInventoryException e1) {
                        e1.printStackTrace();
                    }
                    /*
                     * reset swapping event and update inventory.
                     */
                    swapping = Optional.empty();
                    eventBus.post("Update event");
                }
            }
        });
        inventoryGrid.add(pane, col, row);
    }

    /**
     * Initialize the InventoryView.
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        Platform.runLater(() -> {
            /*
             * Update inventoryGrid and ringAndScrollGrid constraints.
             */
            final ColumnConstraints colConstraintsRS = new ColumnConstraints();
            colConstraintsRS.setHgrow(Priority.NEVER);
            ringAndScrollGrid.getColumnConstraints().add(colConstraintsRS);

            final RowConstraints rowConstraintsRS = new RowConstraints();
            rowConstraintsRS.setVgrow(Priority.NEVER);
            ringAndScrollGrid.getRowConstraints().add(rowConstraintsRS);

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

    public class EventListener {

        /**
         * Update the inventory's view.
         * @param event
         * @throws OutOfInventoryException
         */
        @Subscribe
        public void updateEvent(final String event) throws OutOfInventoryException {
           update(player);
        }
    }
}
