package sort;

import java.util.Arrays;
import java.util.List;

public class InsertSort extends CommonSorter {

    public void sortAsc(Integer [] array) {
        for (int i=0;i<array.length -1; i++) {
            for (int j=i+1; j>=1; j--) {
                if (array[j] < array[j-1]) {
                    swap(array, j-1, j);
                }
            }
        }
    }

    public void sortDesc(Integer [] array) {
        for (int i=0;i<array.length -1; i++) {
            for (int j=i+1; j>=1; j--) {
                if (array[j] > array[j-1]) {
                    swap(array, j-1, j);
                }
            }
        }
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[] {5,4,3,2,1};
        InsertSort sorter = new InsertSort();
        sorter.sortAsc(array);
        List<Integer> list = Arrays.asList(array);
        System.out.println(list);


        sorter.sortDesc(array);
        list = Arrays.asList(array);
        System.out.println(list);
    }
}
