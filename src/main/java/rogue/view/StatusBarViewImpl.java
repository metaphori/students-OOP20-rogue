package rogue.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Controls the status bar.
 */
public final class StatusBarViewImpl implements StatusBarView {

    private Parent root;

    public StatusBarViewImpl() {
        try {
            this.root = FXMLLoader.load(ClassLoader.getSystemResource("layout/StatusBar.fxml"));
        } catch (IOException e) {
            final Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error dialog");
            alert.setContentText("An error occurred when trying to set the StatusBar layout");
            alert.showAndWait();
        }
    }

    @Override
    public void setMaxHealthPoints(final int max) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setCurrentHealthPoints(final int healthPoints) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setCoins(final int coins) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setLevel(final int level) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setStrength(final int strength) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setExperience(final int experience) {
        // TODO Auto-generated method stub
    }

    public Node getNode() {
        return this.root;
    }

}
