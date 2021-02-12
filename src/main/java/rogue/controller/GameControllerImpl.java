package rogue.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

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
     */
    @FXML
    public void onNameEnter(final KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (nameTextField.getText() != null && !(nameTextField.getText().isEmpty())) {
                if (validName(nameTextField.getText())) {
                    this.playerName = nameTextField.getText();
                    /*
                     * Valid name entered, start game.
                     */
                     insertNameLabel.setText(VALID_NAME);
                    start();
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
     */
    public void start() {
        // TODO start method!
        System.out.println("ok!");
    }

    /**
     * 
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
    }

}
