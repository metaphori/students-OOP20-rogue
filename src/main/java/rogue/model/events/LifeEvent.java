package rogue.model.events;

import javafx.util.Pair;
import rogue.model.creature.Life;
import rogue.model.creature.LifeParameter;

/**
 * A class representing the change of life.
 *
 * @param <L> the type of life affected by the change
 */
public final class LifeEvent<L extends Life> implements Event {

    private final Pair<LifeParameter, Integer> changed;
    private final L life;

    /**
     * Creates a new LifeEvent.
     * @param life
     *          the life which changed
     */
    public LifeEvent(final L life, final Pair<LifeParameter, Integer> changed) {
        this.changed = changed;
        this.life = life;
    }

    public Pair<LifeParameter, Integer> getChanged() {
        return this.changed;
    }

    /**
     * 
     * @return the life
     */
    public L getLife() {
        return this.life;
    }

    @Override
    public String toString() {
        return life.toString();
    }

}
