package rogue.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class GameControllerImpl implements Initializable {

    @FXML private Text insertNameText;
    @FXML private TextField nameTextField;
    private String playerName;

    /**
     * 
     * @param event
     */
    @FXML
    public void onNameEnter(final KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (nameTextField.getText() != null && !(nameTextField.getText().isEmpty())) {
                this.playerName = nameTextField.getText();
                System.out.println("Player name is: " + this.playerName);
            } else {
                insertNameText.setText("PLEASE ENTER A VALID NAME");
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
     * 
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
    }
}
