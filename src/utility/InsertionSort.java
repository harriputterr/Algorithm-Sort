package utility;
import java.util.*;

public class InsertionSort {
	public static <T> void insertionSort(Comparable<T>[] array, Comparator<? super T> comp) {
        for (int i = 1; i < array.length; i++) {
            Comparable<T> temp = array[i];
            int j = i - 1;

            while (j >= 0 && comp.compare((T) array[j],(T) temp) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
	
	public static <T> void insertionSort(Comparable<T>[] array) {
        for (int i = 1; i < array.length; i++) {
            Comparable<T> temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo((T) temp) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
}
