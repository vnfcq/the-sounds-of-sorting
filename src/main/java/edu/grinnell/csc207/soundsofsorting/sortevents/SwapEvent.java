package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    private final int i;
    private final int j;

    public SwapEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public void apply(T[] arr) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return List.of(i, j);
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
}
