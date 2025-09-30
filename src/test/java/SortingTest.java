import org.example.Bubble;
import org.example.IntArraySorter;
import org.example.QuickSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortingTest {

    IntArraySorter sorter = new QuickSort();

    @Test
    public void positiveSortingCase(){
        int[] toSort = {9, 2, 3, 4, 5, 6, 7, 8, 1};
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        sorter.sort(toSort);
        assertArrayEquals(toSort, sorted);
    }
}
