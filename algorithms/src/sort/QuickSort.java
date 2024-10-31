package sort;

import java.util.Arrays;
import java.util.List;

public class QuickSort extends CommonSorter {

    public void sortAsc(Integer [] array, int start, int end) {
        Integer pivot = array[start];
        Integer left = start;
        Integer right = end;
        while (left <= right) {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        if (start < right) sortAsc(array, start, right);
        if (left < end) sortAsc(array, left, end);
    }

    public void sortDesc(Integer [] array, int start, int end) {
        Integer pivot = array[start];
        Integer left = start;
        Integer right = end;
        while (left <= right) {
            while (array[left] > pivot) left++;
            while (array[right] < pivot) right--;
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        if (start < right) sortDesc(array, start, right);
        if (left < end) sortDesc(array, left, end);
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {5,4,3,2,1};
        QuickSort sorter = new QuickSort();
        sorter.sortAsc(array, 0, array.length - 1);
        sorter.print(array);

        sorter.sortDesc(array, 0, array.length - 1);
        sorter.print(array);
    }
}
