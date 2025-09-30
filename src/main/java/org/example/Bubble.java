package org.example;

/**
 * Сортировка пузырьком
 * O(n^2)
 */
public class Bubble implements IntArraySorter {

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j <= array.length - i; j++) {
                int a = array[j-1];
                int b = array[j];
                if (a > b) {
                    array[j] = a;
                    array[j-1] = b;
                }
            }
        }
    }
}
