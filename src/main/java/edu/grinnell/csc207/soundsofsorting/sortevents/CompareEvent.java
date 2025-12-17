package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T> {
    private final int i;
    private final int j;

    public CompareEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public void apply(T[] arr) {
        // Comparing does not mutate the array.
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return List.of(i, j);
    }

    @Override
    public boolean isEmphasized() {
        return false;
    }
}
