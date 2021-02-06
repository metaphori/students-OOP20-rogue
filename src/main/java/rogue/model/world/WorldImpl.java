package rogue.model.world;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WorldImpl implements World {
    // terminal inspired world size
    private static final int WORLD_SIZE_X = 80;
    private static final int WORLD_SIZE_Y = 24;

    private List<Level> levels = new ArrayList<>();

    public final Level getLevel(final int i) {
        return this.levels.get(i);
    }

    public WorldImpl(final int depth) {
        IntStream.range(0, depth).forEach(i -> {
            this.levels.add(new LevelImpl(WORLD_SIZE_X, WORLD_SIZE_Y));
        });
    }
}