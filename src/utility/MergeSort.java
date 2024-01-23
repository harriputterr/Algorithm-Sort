package utility;

import java.util.*;

public class MergeSort {
	
	public static <T> void mergeSort(Comparable<T>[] array, Comparator<? super T> comp) {

        int length = array.length;
        if (length <= 1) return; //base case

        int middle = length / 2;
        Comparable<T>[] leftArray = new Comparable[middle];
        Comparable<T>[] rightArray = new Comparable[length - middle];

        int i = 0; //left array
        int j = 0; //right array

        for(; i < length; i++) {
            if(i < middle) {
                leftArray[i] = array[i];

            }
            else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray, comp);
        mergeSort(rightArray, comp);
        merge(leftArray, rightArray, array, comp);
    }
    public static <T> void merge(Comparable<T>[] leftArray, Comparable<T>[] rightArray, Comparable<T>[] array, Comparator<? super T> comp) {

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices
//        (i)Original Array, (l)leftArray , (r)rightArray

        //check the conditions for merging
        while(l < leftSize && r < rightSize) {
            if(comp.compare((T)leftArray[l], (T)rightArray[r]) > 0) {//leftArray[l] < rightArray[r]
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
    
    public static <T> void mergeSort(Comparable<T>[] array) {

        int length = array.length;
        if (length <= 1) return; //base case

        int middle = length / 2;
        Comparable<T>[] leftArray = new Comparable[middle];
        Comparable<T>[] rightArray = new Comparable[length - middle];

        int i = 0; //left array
        int j = 0; //right array

        for(; i < length; i++) {
            if(i < middle) {
                leftArray[i] = array[i];

            }
            else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }
    public static <T> void merge(Comparable<T>[] leftArray, Comparable<T>[] rightArray, Comparable<T>[] array) {

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices
//        (i)Original Array, (l)leftArray , (r)rightArray

        //check the conditions for merging
        while(l < leftSize && r < rightSize) {
            if(leftArray[l].compareTo((T)rightArray[r]) > 0) {//leftArray[l] < rightArray[r]
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
