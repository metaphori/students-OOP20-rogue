package rogue.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class GameControllerImpl implements GameController {

    private static final String INVALID_NAME_MESSAGE = "PLEASE ENTER A VALID NAME";

    @FXML private Text insertNameText;
    @FXML private TextField nameTextField;
    private String playerName;

    /**
     * Text area event to get player's name.
     * @param event to check.
     */
    @FXML
    public void onNameEnter(final KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (nameTextField.getText() != null && !(nameTextField.getText().isEmpty())) {
                this.playerName = nameTextField.getText();
                /*
                 * Valid name entered, start game.
                 */
                start();
            } else {
                insertNameText.setText(INVALID_NAME_MESSAGE);
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
