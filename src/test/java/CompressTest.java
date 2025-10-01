import org.example.CompressArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompressTest {

    @Test
    public void positiveSortingCase() {
        int[] array = {1, 4, 5, 2, 3, 9, 8, 11, 0};
        String expected = "0-5,8-9,11";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }

    @Test
    public void emptyArray() {
        int[] array = {};
        String expected = "";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }

    @Test
    public void singleElement() {
        int[] array = {5};
        String expected = "5";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }

    @Test
    public void allConsecutive() {
        int[] array = {1, 2, 3, 4, 5};
        String expected = "1-5";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }

    @Test
    public void allSeparate() {
        int[] array = {1, 3, 5, 7, 9};
        String expected = "1,3,5,7,9";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }

    @Test
    public void mixedRanges() {
        int[] array = {1, 2, 3, 5, 7, 8, 9, 11, 13, 14, 15};
        String expected = "1-3,5,7-9,11,13-15";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }

    @Test
    public void withNegativeNumbers() {
        int[] array = {-3, -2, -1, 0, 1, 3, 4};
        String expected = "-3-1,3-4";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }

    @Test
    public void largeGaps() {
        int[] array = {1, 2, 50, 51, 52, 100};
        String expected = "1-2,50-52,100";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }

    @Test
    public void rangeAtStart() {
        int[] array = {1, 2, 3, 4, 7};
        String expected = "1-4,7";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }

    @Test
    public void rangeAtEnd() {
        int[] array = {1, 5, 6, 7, 8};
        String expected = "1,5-8";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }

    @Test
    public void alreadySorted() {
        int[] array = {0, 1, 2, 3, 4, 5, 8, 9, 11};
        String expected = "0-5,8-9,11";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }

    @Test
    public void duplicatesNotExpectedButHandled() {
        // Поскольку сказано "неповторяющихся чисел", дубликатов быть не должно
        // Но на случай если появятся - текущая реализация обработает
        int[] array = {1, 2, 2, 3, 4}; // Дубликаты
        String expected = "1-4";
        String compress = CompressArray.compress(array);
        assertEquals(expected, compress);
    }
}