package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public void testSort(Function<Integer[], java.util.List<SortEvent<Integer>>> sort) {
        Integer[][] cases = new Integer[][] {
                new Integer[] {},
                new Integer[] {1},
                new Integer[] {1, 2, 3, 4, 5},
                new Integer[] {5, 4, 3, 2, 1},
                new Integer[] {1, 2, 3, 2, 1}
        };

        for (Integer[] c : cases) {
            Integer[] arr = Arrays.copyOf(c, c.length);
            Integer[] expected = Arrays.copyOf(c, c.length);
            Arrays.sort(expected);

            sort.apply(arr); // ignore events for Part 1
            assertArrayEquals(expected, arr);
        }
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }

    @Test
    public void testCocktailShakerSort() {
        testSort(Sorts::cocktailShakerSort);
    }
}