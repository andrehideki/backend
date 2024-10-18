package sort;

import java.util.Arrays;

public class CommonSorter {

    protected void swap(Integer[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[i+1] = aux;
    }

    protected void print(Integer[] array) {
        for (Integer i: Arrays.asList(array)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
