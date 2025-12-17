package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    private final int index;
    private final T value;

    /**
     * Constructs a copy event with the given index and value.
     *
     * @param index an integer
     * @param value a T object
     */
    public CopyEvent(int index, T value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public void apply(T[] arr) {
        arr[index] = value;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return List.of(index);
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
}
