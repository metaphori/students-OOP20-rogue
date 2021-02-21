package rogue.view;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import rogue.model.creature.LifeParameter;
import rogue.model.items.armor.Armor;
import rogue.model.items.weapons.Weapon;

/**
 * A simple class which controls the status bar where are displayed 
 * the player's life statistics.
 */
public final class StatusBarViewImpl implements StatusBarView {

    private final Map<LifeParameter, String> labelsMap = new EnumMap<>(LifeParameter.class) { 
        private static final long serialVersionUID = 1L;
    {
        this.put(LifeParameter.MAX_HP, "#maxHp");
        this.put(LifeParameter.HP, "#hp");
        this.put(LifeParameter.COINS, "#gold");
        this.put(LifeParameter.LEVEL, "#level");
        this.put(LifeParameter.STRENGTH, "#strength");
        this.put(LifeParameter.EXPERIENCE, "#experience");
        this.put(LifeParameter.ARMOR, "#armor");
        this.put(LifeParameter.WEAPON, "#weapon");
        this.put(LifeParameter.FOOD, "#food");
    }};

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
    public void setLifeLabel(final LifeParameter label, final int value) {
        final var lblName = labelsMap.entrySet().stream()
            .filter(e -> e.getKey().equals(label))
            .map(e -> e.getValue())
            .findAny().get();
        this.updateLabel(lblName, Integer.toString(value));
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
