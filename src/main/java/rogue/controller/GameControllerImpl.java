package rogue.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class GameControllerImpl {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rogueMenuImage;

    @FXML
    private TextField nameTextField;

    /**
     * 
     */
    @FXML
    void initialize() {
        assert rogueMenuImage != null : "fx:id=\"rogueMenuImage\" was not injected: check your FXML file 'sample.fxml'.";
        assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
