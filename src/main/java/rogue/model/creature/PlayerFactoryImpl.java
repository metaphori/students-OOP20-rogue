package rogue.model.creature;

import java.util.Objects;

import rogue.model.items.inventory.Inventory;
import rogue.model.items.inventory.InventoryImpl;
import rogue.model.items.Equipment;
import rogue.model.items.EquipmentImpl;

/** 
 * An implementation for {@link PlayerFactory} which encapsulates the 
 * implementation of {@link Player}.
 */
public class PlayerFactoryImpl implements PlayerFactory {

    private static class PlayerImpl extends AbstractCreature<PlayerLife> implements Player {

        private final Inventory inventory;
        private final Equipment equipment;

        protected PlayerImpl(final PlayerLife life) {
            super(life);
            this.inventory = new InventoryImpl(this);
            this.equipment = new EquipmentImpl(this);
        }

        @Override
        public Inventory getInventory() {
            return this.inventory;
        }

        @Override
        public Equipment getEquipment() {
            return this.equipment;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player create() {
        return createByLife(new PlayerLifeImpl.Builder().build());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player createByLife(final PlayerLife life) {
        return new PlayerImpl(Objects.requireNonNull(life));
    }

}
