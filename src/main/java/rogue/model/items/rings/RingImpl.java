package rogue.model.items.rings;

import rogue.model.creature.Player;
import rogue.model.items.Equipment;
import rogue.model.items.Memento;

public final class RingImpl implements Ring {

    private Memento memento;
    private final RingType ring;

    public RingImpl(final RingType ring) {
        this.ring = ring;
    }

    @Override
    public int getChance() {
        return this.ring.getChance();
    }

    @Override
    public boolean use(final Player player) {
        if (player.getEquipment().getRing().isEmpty()) {
            this.memento = player.getEquipment().save();
            this.ring.getConsumer().accept(player.getEquipment());
            player.getEquipment().attachRing(this);
            return true;
        }
        return false;
    }

    @Override
    public void stopUsing(final Player player) {
        player.getEquipment().detachRing(this.memento);
    }

}
