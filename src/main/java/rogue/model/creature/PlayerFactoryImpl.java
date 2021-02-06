package rogue.model.creature;

import java.util.Objects;

import rogue.model.items.Inventory;
import rogue.model.items.InventoryImpl;

public class PlayerFactoryImpl implements PlayerFactory {

    private class PlayerImpl extends AbstractCreature<PlayerLife> implements Player {

        private final Inventory inventory;
        private final Equipment equipment;

        protected PlayerImpl(final PlayerLife life) {
            super(life);
            this.inventory = new InventoryImpl(this);
            this.equipment = new EquipmentImpl();
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
