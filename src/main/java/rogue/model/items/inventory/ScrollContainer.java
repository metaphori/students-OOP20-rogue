package rogue.model.items.inventory;

import java.util.Optional;

import rogue.model.items.scroll.Scroll;

public interface ScrollContainer {

    /**
     * Activate a scroll.
     * @param scroll to activate.
     */
    void activateScroll(Scroll scroll);

    /**
     * Remove an active scroll.
     * @return true if active scroll was successfully removed, false if
     * there's no active scroll to remove.
     */
    boolean removeActiveScroll();

    /**
     * Get the currently active scroll.
     * @return Optional.empty() if no active scroll, Optional.of(Scroll) otherwise
     */
    Optional<Scroll> getActiveScroll();

    /**
     * Update the currently active scroll duration.
     * @return true if correctly updated, false if there's no active scroll to update.
     * @param amount to subtract to the scroll's duration.
     */
    boolean updateEffectDuration(int amount);

}
