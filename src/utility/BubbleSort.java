package utility;

import java.util.*;

import com.teamsonia.*;
import com.teamsonia.shapes.*;
/**
 * The BubbleSort class provides methods for sorting arrays using the bubble sort algorithm. 
 */
public class BubbleSort  {

	 /**
     * Sorts an array of elements using the bubble sort algorithm with a custom comparator.
     *
     * @param array The array to be sorted.
     * @param comp  The comparator used to compare elements.
     * @param <T>   The type of elements in the array.
     */
	@SuppressWarnings("unchecked")
	public static <T> void bubbleSort(Comparable<T>[] array, Comparator<? super T> comp) {
		
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comp.compare((T) array[j], (T) array[j+1]) < 0) { // how is casting happening here?
                    Comparable<T> tempElement = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempElement;
                }
            }
        }
    }
	
	/**
     * Sorts an array of elements using the bubble sort algorithm.
     *
     * @param array The array to be sorted.
     * @param <T>   The type of elements in the array.
     */
	@SuppressWarnings("unchecked")
	public static <T> void bubbleSort(Comparable<T>[] array) {
		
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((array[j]).compareTo((T)array[j+1]) < 0) {
                    Comparable<T> tempElement = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempElement;
                }
            }
        }
    }
	
	
}
