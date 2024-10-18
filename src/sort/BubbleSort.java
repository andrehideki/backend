package sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public void sortAsc(Integer [] array) {
        boolean swaped = true;
        while (swaped) {
            swaped = false;
            for (int i=0;i<array.length - 1;i++) {
                if (array[i] > array[i+1]) {
                    int aux = array[i];
                    array[i] = array[i+1];
                    array[i+1] = aux;
                    swaped = true;
                }
            }
        }
    }

    public void sortDesc(Integer [] array) {
        boolean swaped = true;
        while (swaped) {
            swaped = false;
            for (int i=0;i<array.length - 1;i++) {
                if (array[i] < array[i+1]) {
                    int aux = array[i];
                    array[i] = array[i+1];
                    array[i+1] = aux;
                    swaped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {5,4,3,2,1};
        BubbleSort sorter = new BubbleSort();
        sorter.sortAsc(array);
        List<Integer> list = Arrays.asList(array);
        System.out.println(list);


        sorter.sortDesc(array);
        list = Arrays.asList(array);
        System.out.println(list);
    }
}
