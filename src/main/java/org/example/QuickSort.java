package org.example;

/**
 * Быстрая сортировка
 * в среднем O(n*Log n)
 * в худшем O(n^2)
 */
public class QuickSort implements IntArraySorter {

    @Override
    public void sort(int[] array) {
        sortSub(array, 0, array.length - 1);

    }

    private void sortSub(int[] toSort, int startIdx, int endIdx) {
        if (startIdx >= endIdx) return;

        int pivot = toSort[endIdx];
        int lp = startIdx;
        int rp = endIdx;
        while (lp < rp) {
            while (toSort[lp] <= pivot && lp < rp) {
                lp++;
            }
            while (toSort[rp] >= pivot && lp < rp) {
                rp--;
            }
            swap(toSort, lp, rp);
        }
        swap(toSort, lp, endIdx);
        sortSub(toSort, startIdx, rp - 1);
        sortSub(toSort, rp + 1, endIdx);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
