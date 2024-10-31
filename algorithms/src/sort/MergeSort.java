package sort;

import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public void merge(Integer array[], int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Integer[] arrayTemp1 = new Integer[n1];
        Integer[] arrayTemp2 = new Integer[n2];



        for (int i = 0; i < n1; ++i)
            arrayTemp1[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            arrayTemp2[j] = array[middle + 1 + j];

        System.out.println("temp 1: " + Arrays.asList(arrayTemp1));
        System.out.println("temp 2: " + Arrays.asList(arrayTemp2));

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (arrayTemp1[i] <= arrayTemp2[j]) {
                array[k] = arrayTemp1[i];
                i++;
            }
            else {
                array[k] = arrayTemp2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = arrayTemp1[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = arrayTemp2[j];
            j++;
            k++;
        }

        System.out.println("merged: " + Arrays.asList(array));
    }

    public void sortAsc(Integer [] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sortAsc(array, left, middle);
            sortAsc(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

//    public void sortDesc(Integer [] array) {
//        for (int i=0;i<array.length;i++) {
//            int highest = i;
//            for (int j=i+1;j<array.length;j++) {
//                if (array[j] > array[highest]) {
//                    highest = j;
//                }
//            }
//            int aux = array[i];
//            array[i] = array[highest];
//            array[highest] = aux;
//        }
//    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {37, 27, 43, 10};
        MergeSort sorter = new MergeSort();
        sorter.sortAsc(array, 0, array.length - 1);
        List<Integer> list = Arrays.asList(array);
        System.out.println(list);


//        sorter.sortDesc(array);
//        list = Arrays.asList(array);
//        System.out.println(list);
    }
}
