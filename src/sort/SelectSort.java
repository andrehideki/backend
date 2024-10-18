package sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SelectSort {

    public void sortAsc(Integer [] array) {
        for (int i=0;i<array.length;i++) {
            int smallest = i;
            for (int j=i+1;j<array.length;j++) {
                if (array[j] < array[smallest]) {
                    smallest = j;
                }
            }
            int aux = array[i];
            array[i] = array[smallest];
            array[smallest] = aux;
        }
    }

    public void sortDesc(Integer [] array) {
        for (int i=0;i<array.length;i++) {
            int highest = i;
            for (int j=i+1;j<array.length;j++) {
                if (array[j] > array[highest]) {
                    highest = j;
                }
            }
            int aux = array[i];
            array[i] = array[highest];
            array[highest] = aux;
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {5,4,3,2,1};
        SelectSort sorter = new SelectSort();
        sorter.sortAsc(array);
        List<Integer> list = Arrays.asList(array);
        System.out.println(list);


        sorter.sortDesc(array);
        list = Arrays.asList(array);
        System.out.println(list);
    }
}
