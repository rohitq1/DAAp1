import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    public static void main(String[] args) {

        int arraySize = 10000; 
        int[] array = new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(arraySize);
        }
        int[] bubbleSortArray = Arrays.copyOf(array, array.length);
        int[] selectionSortArray = Arrays.copyOf(array, array.length);
        int[] insertionSortArray = Arrays.copyOf(array, array.length);

        long startTime = System.nanoTime();
        Arrays.sort(array);
        long endTime = System.nanoTime();
        long durationArraysSort = endTime - startTime;
        System.out.println("Time taken by Arrays.sort() in milliseconds: " + durationArraysSort / 1_000_000.0);

        startTime = System.nanoTime();
        bubbleSort(bubbleSortArray);
        endTime = System.nanoTime();
        long durationBubbleSort = endTime - startTime;
        System.out.println("Time taken by bubble sort in milliseconds: " + durationBubbleSort / 1_000_000.0);

        startTime = System.nanoTime();
        selectionSort(selectionSortArray);
        endTime = System.nanoTime();
        long durationSelectionSort = endTime - startTime;
        System.out.println("Time taken by selection sort in milliseconds: " + durationSelectionSort / 1_000_000.0);

        startTime = System.nanoTime();
        insertionSort(insertionSortArray);
        endTime = System.nanoTime();
        long durationInsertionSort = endTime - startTime;
        System.out.println("Time taken by insertion sort in milliseconds: " + durationInsertionSort / 1_000_000.0);
    }

    private static void bubbleSort(int[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break; 
            }
        }
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
           
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
