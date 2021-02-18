package rogue.model.creature;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javafx.util.Pair;

/**
 * This class represents the standard strategy with which increase the level value.
 */
public final class StandardLevelIncreaseStrategy implements LevelIncreaseStrategy {

    enum ExpLevel {
        ONE(0), TWO(7), THREE(16), FOUR(30), FIVE(50), SIX(75), SEVEN(115), 
        EIGHT(170), NINE(250), TEN(355), ELEVEN(525), TWELVE(725), THIRTEEN(1050),
        FOURTEEN(1475), FIFTEEN(2125), SIXTEEN(3000), SEVENTEEN(4250), 
        EIGHTEEN(6000), NINETEEN(8500), TWENTY(12_000);

        private final int expValue;

        ExpLevel(final int expValue) {
            this.expValue = expValue;
        }

        private int getExpValue() {
            return this.expValue;
        }

    }

    private List<Pair<Integer, Integer>> values;

    public StandardLevelIncreaseStrategy() {
        this.values = Arrays.asList(ExpLevel.values()).stream()
            .map(i -> new Pair<>(i.getExpValue(), i.ordinal() + 1))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Integer> level(final int experience) {
        return this.values.stream()
            .filter(p -> p.getKey().equals(experience))
            .map(p -> p.getValue())
            .findFirst();
    }

}
