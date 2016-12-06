package Quiz3;

public class QuickSort {
    private int[] array;
    private int length;

    public void sort(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }

        /////////////////////
        array = inputArr;
        length = array.length - 1;
        quickSort(0, length);
        System.out.println(array);
        /////////////////////
    }

    private void quickSort(int low, int high) {
        ////////////////////////
        int pivot_index = (low + high) / 2;
        int pivot = array[pivot_index];
        int i = low;
        int j = high;


        // Divide into two arrays
        while (i < j) {
            if (pivot > array[i])
                i++;
            if (pivot < array[j])
                j--;
            if (pivot < array[i] && pivot > array[j])
                swap(i, j);
        }

        // call quickSort() method recursively
        if (low < high){
            quickSort(low, pivot_index - 1);
            quickSort(pivot_index + 1, high);
        }
        //////////////////////////
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
