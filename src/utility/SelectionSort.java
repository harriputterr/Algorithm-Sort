package utility;
import java.util.*;

public class SelectionSort {
	public static <T> void selectionSort(Comparable<T>[] array, Comparator<? super T> comp) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (comp.compare((T) array[min], (T) array[j]) < 0) { 
                    min = j;
                }
            }
            if (min != i) {
                Comparable<T> temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }
	
	@SuppressWarnings("unchecked")
	public static <T> void selectionSort(Comparable<T>[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[min].compareTo((T) array[j]) < 0) { 
                    min = j;
                }
            }
            if (min != i) {
                Comparable<T> temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }
}
