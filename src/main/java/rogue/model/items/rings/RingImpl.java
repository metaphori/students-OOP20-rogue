package rogue.model.items.rings;

import rogue.model.creature.Player;
import rogue.model.items.Equipment;

public class RingImpl implements Ring {

    private final RingType ring;

    public RingImpl(final RingType ring) {
        this.ring = ring;
    }

    public void consume(final Equipment equipment) {
        this.ring.getConsumer().accept(equipment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean use(final Player player) {
        return player.getEquipment().attachRing(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getChance() {
        return this.ring.getChance();
    }

}
