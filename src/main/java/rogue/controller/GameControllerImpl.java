package rogue.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import rogue.model.creature.Player;
import rogue.model.creature.PlayerFactoryImpl;
import rogue.model.items.food.FoodImpl;
import rogue.model.items.food.FoodType;
import rogue.model.items.inventory.Inventory;
import rogue.model.items.inventory.InventoryIsFullException;
import rogue.model.items.inventory.OutOfInventoryException;
import rogue.model.items.potion.Potion;
import rogue.model.items.potion.PotionImpl;
import rogue.model.items.potion.PotionType;

public class GameControllerImpl implements GameController, Initializable {

    private static final String NO_NAME_MESSAGE = "PLEASE ENTER A NAME";
    private static final String INVALID_NAME_MESSAGE = "PLEASE ENTER A VALID NAME";
    private static final String VALID_NAME = "ENTERING DUNGEON ...";
    private static final int NAME_MAX_LENGTH = 15;

    @FXML private Label insertNameLabel;
    @FXML private TextField nameTextField;
    private String playerName;

    private boolean validName(final String name) {
        if (name.length() <= NAME_MAX_LENGTH) {
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == ' ') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Text area event to get player's name.
     * @param event to check.
     * @throws IOException 
     */
    @FXML
    public void onNameEnter(final KeyEvent event) throws IOException, InventoryIsFullException {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (nameTextField.getText() != null && !(nameTextField.getText().isEmpty())) {
                if (validName(nameTextField.getText())) {
                    this.playerName = nameTextField.getText();
                    /*
                     * Valid name entered, start game.
                     */
                    insertNameLabel.setText(VALID_NAME);
                    start(event);
                } else {
                    insertNameLabel.setText(INVALID_NAME_MESSAGE);
                }
            } else {
                insertNameLabel.setText(NO_NAME_MESSAGE);
            }
        }
    }

    /**
     * @return player's name
     */
    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * Creates MainView.
     * @param event that triggeres start.
     * @throws InventoryIsFullException 
     * @throws OutOfInventoryException 
     */
    public void start(final KeyEvent event) throws IOException, InventoryIsFullException {
        final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layout/InventoryView.fxml"));
        final Parent root = loader.load();

        final Player player = new PlayerFactoryImpl().create();


        final InventoryControllerImpl controller = loader.getController();
        controller.initPlayer(player);

        final Stage stage = (Stage) nameTextField.getScene().getWindow();
        final Scene newScene = new Scene(root, 260, 400);
        stage.setScene(newScene);
    }

    /**
     * 
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
    }

}
