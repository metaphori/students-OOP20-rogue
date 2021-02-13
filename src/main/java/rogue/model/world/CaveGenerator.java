package rogue.model.world;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

// https://gamedevelopment.tutsplus.com/tutorials/generate-random-cave-levels-using-cellular-automata--gamedev-9664
class CaveGenerator {
    private static final int CHANCE_TO_START_ALIVE = 20;
    private static final int BIRTH_LIMIT = 3;
    private static final int DEATH_LIMIT = 2;
    private static final int STEP_COUNT = 5;
    private static final Random RANDOM = new Random();
    private boolean[][] cave;

    public boolean[][] getCave() {
        return cave;
    }

    private void initialize() {
        IntStream.range(0, cave.length).forEach(x -> {
            IntStream.range(0, cave[0].length).forEach(y -> {
                cave[x][y] = RANDOM.nextInt(100) < CHANCE_TO_START_ALIVE;
            });
        });
    }

    // Returns the number of cells in a ring around (x, y) that are alive.
    private int countAliveNeighbors(final int x, final int y) {
        AtomicInteger count = new AtomicInteger(0); // we can edit this from lambdas

        IntStream.range(-1, 2).forEach(i -> {
            IntStream.range(-1, 2).forEach(j -> {
                int neighborX = x + i, neighborY = y + j;

                // If we're looking at the middle point
                if (i == 0 && j == 0) {
                    // Do nothing, we don't want to add ourselves in!
                }
                // In case the index we're looking at it off the edge of the map
                else if (neighborX < 0 || neighborY < 0 || neighborX >= cave.length || neighborY >= cave[0].length) {
                    count.incrementAndGet();
                }
                // Otherwise, a normal check of the neighbour
                else if (cave[neighborX][neighborY]) {
                    count.incrementAndGet();
                }
            });
        });

        return count.get();
    }

    private void doSimulationStep() {
        boolean[][] newCave = new boolean[cave.length][cave[0].length];

        // Loop over each row and column of the map
        IntStream.range(0, cave.length).forEach(x -> {
            IntStream.range(0, cave[0].length).forEach(y -> {
                int neighborCount = countAliveNeighbors(x, y);

                // The new value is based on our simulation rules
                // First, if a cell is alive but has too few neighbors, kill it.
                if (cave[x][y]) {
                    if (neighborCount < DEATH_LIMIT) {
                        newCave[x][y] = false;
                    } else {
                        newCave[x][y] = true;
                    }
                }
                //Otherwise, if the cell is dead now, check if it has the right number of neighbours to be 'born'
                else {
                    if (neighborCount > BIRTH_LIMIT) {
                        newCave[x][y] = true;
                    } else {
                        newCave[x][y] = false;
                    }
                }
            });
        });

        cave = newCave;
    }

    CaveGenerator(final int width, final int height) {
        cave = new boolean[width][height];
        initialize();
        IntStream.range(0, STEP_COUNT).forEach(i -> doSimulationStep());
    }
}
