package Sort;

/**
 * Created by shinsy1023 on 2016. 11. 28..
 */

public class MergeSort {
    private int[] array;
    private int[] helper;

    private int size;

    public void sort(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        array = inputArr;
        helper = new int[array.length];
        size = array.length - 1;
        mergesort(0, size);
    }

    private void mergesort(int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            mergesort(low, (high + low) / 2);
            mergesort(((high + low) / 2) + 1, high);
            merge(low, (high + low) / 2, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }
        int i = low;
	    int j = middle + 1;
	    int k = high;

        // Copy the smallest value from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high){
            System.out.printf("%d  %d    %d\n", i, j, low);
            if (helper[i] < helper[j]) {
                array[low] = helper[i];
                i++;
            }
            else {
                array[low] = helper[j];
                j++;
            }
            low++;
        }

        // Copy the rest of the left side of the array into the target array
        if (i <= middle)
            for(; low <= high; i++) {
                array[low] = helper[i];
                low++;
            }
        else if(j <= high)
            for(; low <= high; j++) {
                array[low] = helper[j];
                low++;
            }
        //11 15 28 33 38 39 40 43 44 45 52 68 77 98
    }
}