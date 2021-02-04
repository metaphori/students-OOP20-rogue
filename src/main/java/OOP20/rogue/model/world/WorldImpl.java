package OOP20.rogue.model.world;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WorldImpl implements World {
    // 50x50 world seems ok I guess
    private static final int WORLD_SIZE_X = 50;
    private static final int WORLD_SIZE_Y = 50;

    private List<Level> levels = new ArrayList<>();

    public Level getLevel(int i) {
        return this.levels.get(i);
    }

    public WorldImpl(final int depth) {
        IntStream.range(0, depth).forEach(i -> {
            this.levels.add(new LevelImpl(WORLD_SIZE_X, WORLD_SIZE_Y));
        });
    }
}