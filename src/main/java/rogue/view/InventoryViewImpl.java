package rogue.view;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

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
import rogue.controller.InventoryController;
import rogue.controller.InventoryControllerImpl;
import rogue.model.creature.Player;
import rogue.model.events.EventSubscriber;
import rogue.model.events.InventoryEvent;
import rogue.model.items.inventory.Inventory;
import rogue.model.items.inventory.OutOfInventoryException;
import rogue.model.items.scroll.ScrollImpl;
import rogue.model.items.scroll.ScrollType;


public class InventoryViewImpl implements Initializable, EventSubscriber {

    private static final int NUM_COLS = 4;
    private static final int NUM_ROWS = 5;
    private static final int QUANTITY_FONT_SIZE = 17;
    private static final String FONT = "verdana";

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private GridPane inventoryGrid;
    @FXML  private GridPane ringAndScrollGrid;

    private InventoryController controller;
    private Player player;
    private Optional<Integer> swapping = Optional.empty();

    /*
     * Background images for InventoryView
     */
    private final BackgroundImage emptyB = new BackgroundImage(new Image(ClassLoader.getSystemResource("images/emptyIcon.png").toExternalForm(), 32, 32, false, true),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT); 


    /**
     * Pass the player to the controller.
     * @param player
     */
    public void init(final Player player) {
        this.player = player;
        this.controller = new InventoryControllerImpl(this.player);
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
     * Creates a javafx text with the given string.
     * @param string to put in the text
     * @return the wanted text.
     */
    public Text createText(final String string) {
        final Text ret = new Text();
        ret.setFont(Font.font(FONT, FontWeight.BOLD, FontPosture.REGULAR, QUANTITY_FONT_SIZE));
        ret.setFill(Color.ORANGE);
        ret.setStrokeWidth(1); 
        ret.setStroke(Color.BLACK);
        ret.setText(string);
        return ret;
    }
    /**
     * Updates the entire View to the current inventory status.
     * @param event 
     * @throws OutOfInventoryException 
     */
    @Subscribe
    public void update(final InventoryEvent<Inventory> event) throws OutOfInventoryException {
        /*
         * Remove everything in the current InventoryGrid in order to update it.
         * Also removes everything in the current ScrollContainerGrid.
         */
        inventoryGrid.getChildren().clear();
        ringAndScrollGrid.getChildren().clear();
        /*
         * Populate the inventoryGrid and reset swapping
         */
        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                gridInsert(i, j, player);
            }
        }
        swapping = Optional.empty();
        /*
         * Make scrollContainer.
         */
        final Pane pane = new StackPane();
        if (!player.getInventory().getScrollContainer().getActiveScroll().isEmpty()) {
            final ItemImageGenerator itemI = new ItemImageGeneratorImpl();
            pane.setBackground(new Background(new BackgroundImage(itemI.getImage(new ScrollImpl(ScrollType.SCROLL_I)),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT)));
            pane.getChildren().add(createText(String.valueOf(player.getInventory().getScrollContainer().getActiveScrollDuration())));
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
            /*
             * Check current item slot and update pane image and quantity text.
             */
            pane.setBackground(new Background(new BackgroundImage(itemI.getImage(player.getInventory().getItem(invIndex).get()),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT)));
            pane.getChildren().add(createText(String.valueOf(player.getInventory().getAmount(invIndex))));
            //String.valueOf(player.getInventory().getAmount(invIndex))
        } else {
            /*
             * empty slot.
             */
            pane.setBackground(new Background(emptyB));
        }
        /*
         * Set each slots events.
         */
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
                controller.onPrimaryClick(col, row);
            }
            /*
             * REMOVE ITEM
             */
            if (button.equals(MouseButton.SECONDARY)) {
                /*
                 * Remove eventual swapping event
                 */
                swapping = Optional.empty();
                controller.onSecondaryClick(col, row);
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
                    pane.getChildren().add(createText("SWAP"));
                } else {
                    controller.onMiddleClick(col, row, swapping.get());
                    swapping = Optional.empty();
                }
            }
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
            this.player.getInventory().register(this);
            this.player.getInventory().getScrollContainer().register(this);
            try {
                update(new InventoryEvent<>(this.player.getInventory()));
            } catch (OutOfInventoryException e) {
                e.printStackTrace();
            }
        });
    }
}
