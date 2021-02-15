package rogue.model.events;

import rogue.model.creature.Life;

/**
 * A class representing the change of life.
 *
 * @param <L> the type of life affected by the change
 */
public class LifeEvent<L extends Life> implements EntityEvent {

    private final L life;

    /**
     * Creates a new LifeEvent.
     * @param life
     *          the life which has changed
     */
    public LifeEvent(final L life) {
        this.life = life;
    }

    /**
     * 
     * @return the life
     */
    public L getLife() {
        return this.life;
    }

}
