package rogue.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class GameControllerImpl implements GameController {

    private static final String NO_NAME_MESSAGE = "PLEASE ENTER A NAME";
    private static final String INVALID_NAME_MESSAGE = "PLEASE ENTER A VALID NAME";
    private static final int NAME_MAX_LENGTH = 15;

    @FXML private Text insertNameText;
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
                    start();
                }
                insertNameText.setText(INVALID_NAME_MESSAGE);
            } else {
                insertNameText.setText(NO_NAME_MESSAGE);
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
    }

}
