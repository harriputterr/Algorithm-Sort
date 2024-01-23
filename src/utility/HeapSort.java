package utility;
import java.util.*;

public class HeapSort {
	
	public static <T> void heapSort(Comparable<T>[] array) {
        int n = array.length;

        // Build a max-heap from the given array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the current root (largest element) with the last element in the heap
            Comparable<T> temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call the max heapify function on the reduced heap
            heapify(array, i, 0);
        }
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void heapify(Comparable<T>[] array, int n, int i) {
        int largest = i; // Set the current node as the largest
        int left = 2 * i + 1; // Calculate the index of the left child
        int right = 2 * i + 2; // Calculate the index of the right child

        // If the left child is larger than the current largest
        if (left < n && array[left].compareTo((T) array[largest]) < 0) {
            largest = left;
        }

        // If the right child is larger than the current largest so far
        if (right < n && array[right].compareTo((T) array[largest]) < 0) {
            largest = right;
        }

        // If the largest element is not at the current node
        if (largest != i) {
            Comparable<T> swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
	}
	
	public static <T> void heapSort(Comparable<T>[] array, Comparator<? super T> comp) {
        int n = array.length;

        // Build a max-heap from the given array using the custom comparator
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, comp);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the current root (largest element) with the last element in the heap
            Comparable<T> temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call the max heapify function on the reduced heap using the custom comparator
            heapify(array, i, 0, comp);
        }
    }

    // To heapify a subtree rooted with the node at index i within the array
    public static <T> void heapify(Comparable<T>[] array, int n, int i, Comparator<? super T> comp) {
        int largest = i; // Set the current node as the largest
        int left = 2 * i + 1; // Calculate the index of the left child
        int right = 2 * i + 2; // Calculate the index of the right child

        // If the left child is larger than the current largest
        if (left < n && comp.compare((T) array[left], (T) array[largest]) < 0) {
            largest = left;
        }

        // If the right child is larger than the current largest so far
        if (right < n && comp.compare((T) array[right], (T) array[largest]) < 0) {
            largest = right;
        }

        // If the largest element is not at the current node
        if (largest != i) {
            Comparable<T> swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree using the custom comparator
            heapify(array, n, largest, comp);
        }
    }
}
