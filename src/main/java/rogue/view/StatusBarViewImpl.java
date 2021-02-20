package rogue.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import rogue.model.items.armor.Armor;
import rogue.model.items.weapons.Weapon;

/**
 * A simple class which controls the status bar where are displayed 
 * the player's life statistics.
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

    private void updateLabel(final String selector, final String value) {
        final Label lbl = (Label) this.scene.lookup(selector);
        lbl.setText(value);
    }

    @Override
    public void setLifeLabel(final BarLabel label, final int value) {
        this.updateLabel(label.getNameLabel(), Integer.toString(value));
    }

    @Override
    public void setWeaponLabel(final Weapon weapon) {
        this.updateLabel("#weapon", weapon.toString());
    }

    @Override
    public void setArmorLabel(final Armor armor) {
        this.updateLabel("#armor", armor.toString());
    }

    @Override
    public Node getNode() {
        return this.root;
    }

}
