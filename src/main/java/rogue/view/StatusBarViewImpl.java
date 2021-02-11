package rogue.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * A simple class which controls the status bar.
 */
public final class StatusBarViewImpl implements StatusBarView {

    private Parent root;
    private Scene scene;

    public StatusBarViewImpl() {
        try {
            this.root = FXMLLoader.load(ClassLoader.getSystemResource("layout/StatusBar.fxml"));
            this.scene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateLabel(final String selector, final int value) {
        final Label lbl = (Label) this.scene.lookup(selector);
        System.out.println(lbl);
        lbl.setText(Integer.toString(value));
    }

    @Override
    public void setMaxHealthPoints(final int max) {
        this.updateLabel("#maxHp", max);
    }

    @Override
    public void setCurrentHealthPoints(final int healthPoints) {
        this.updateLabel("#hp", healthPoints);
    }

    @Override
    public void setCoins(final int coins) {
        this.updateLabel("#gold", coins);
    }

    @Override
    public void setLevel(final int level) {
        this.updateLabel("#level", level);
    }

    @Override
    public void setStrength(final int strength) {
        this.updateLabel("#strength", strength);
    }

    @Override
    public void setExperience(final int experience) {
        this.updateLabel("#experience", experience);
    }

    public Node getNode() {
        return this.root;
    }

}
