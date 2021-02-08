package rogue.model.items.inventory;

import java.util.Optional;

import rogue.model.items.scroll.Scroll;

public interface ScrollContainer {
    //TODO ScrollContainerImpl

    void activateScroll(Scroll scroll);

    boolean removeActiveScroll();

    Optional<Scroll> getActiveScroll();

    boolean updateEffectDuration(int amount);
}
