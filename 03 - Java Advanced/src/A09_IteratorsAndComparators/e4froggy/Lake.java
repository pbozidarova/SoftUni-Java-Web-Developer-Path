package A09_IteratorsAndComparators.e4froggy;

import java.util.Iterator;
import java.util.function.Consumer;

public class Lake implements Iterable<Integer> {
    private int[] lake;

    public Lake(int[] lake) {
        this.lake = lake;
    }

    @Override
    public Iterator<Integer> iterator() {

        return new LakeIteratorEven();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (int i = 1; i < lake.length; i += 2) {
            action.accept(lake[i]);
        }
    }

    private class LakeIteratorEven implements Iterator<Integer> {
        int index = -2;

        @Override
        public boolean hasNext() {
            return index < lake.length - 2;
        }

        @Override
        public Integer next() {
            index += 2;
            return lake[index];
        }
    }
}