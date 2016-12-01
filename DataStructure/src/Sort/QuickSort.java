package Sort;

/**
 * Created by shinsy1023 on 2016. 11. 28..
 */

public class QuickSort {
    private int[] array;
    private int length;

    public void sort(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        array = inputArr;
        length = array.length - 1;
        quickSort(0, length);
    }

    private void quickSort(int low, int high) {
        if (low >= high)
            return;

    	int pivot = (low + high) / 2 + 1;
    	int i = low;
        int j = high;



        // Divide into two arrays
        while (i <= j) {
            if (i == j)
                break;
            if (array[i] >= array[pivot] && array[j] <= array[pivot]) {
                swap(i, j);
                i = low;
                j = high;
            }
            if (array[i] < array[pivot])
                i++;
            if (array[j] > array[pivot])
                j--;
        }

        // call quickSort() method recursively
        if (low < high) {
            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}