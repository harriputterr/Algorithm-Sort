package utility;
import java.util.*;
public class QuickSort {
	
	public static <T> void quickSort(Comparable<T>[] array, Comparator<? super T> comp) {
		quickSortSubMethod( array, 0, array.length -1, comp);
	}
	public static <T> void quickSortSubMethod( Comparable<T>[] array, int start, int end, Comparator<? super T> comp) {

        if (end <= start) return; //base case

        int pivot = partition(array, start, end, comp);
        quickSortSubMethod(array, start, pivot - 1, comp);
        quickSortSubMethod(array, pivot + 1, end, comp);
    }
    public static <T> int partition(Comparable<T>[] array, int start, int end, Comparator<? super T> comp) {

        Comparable<T> pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end; j++) {
            if (comp.compare((T) array[j], (T) pivot) > 0) { // How is casting happening here?
                i++;
                Comparable<T> temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        Comparable<T> temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }
    
    public static <T> void quickSort(Comparable<T>[] array) {
		quickSortSubMethod( array, 0, array.length -1);
	}
	public static <T> void quickSortSubMethod( Comparable<T>[] array, int start, int end) {

        if (end <= start) return; //base case

        int pivot = partition(array, start, end);
        quickSortSubMethod(array, start, pivot - 1);
        quickSortSubMethod(array, pivot + 1, end);
    }
    public static <T> int partition(Comparable<T>[] array, int start, int end) {

        Comparable<T> pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end; j++) {
            if (array[j].compareTo((T) pivot) > 0) { // How is casting happening here?
                i++;
                Comparable<T> temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        Comparable<T> temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }
}
