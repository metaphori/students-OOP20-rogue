package rogue.model.events;

/**
 * An interface which allows to publish events.
 */
public interface EventPublisher {

    /**
     * Posts a new event.
     * @param event
     *          the {@link EntityEvent} to publish
     */
    void post(EntityEvent event);

}
