package rogue.model.items.rings;

import rogue.model.creature.Player;

public class RingImpl implements Ring {

    private final RingType ring;

    public RingImpl(final RingType ring) {
        this.ring = ring;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean use(final Player player) {
        player.getEquipment().save();
        this.ring.getConsumer().accept(player);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getChance() {
        return this.ring.getChance();
    }

}
