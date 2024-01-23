package com.teamsonia;

import com.teamsonia.compare.BaseAreaCompare;
import com.teamsonia.compare.VolumeCompare;
import com.teamsonia.shapes.Shape;

import utility.*;

/**
 * Sorts the array and stores the benchmarking results.
 * 
 */
public class Benchmarking {
	
	/**
	 * Stores the time before execution of benchmarking test.
	 */
	public static long   start;
	/**
	 * Stores the time after execution of benchmarking test.
	 */
	public static long   stop;
	
	/**
	 * 
	 * @param compareType Compare type given by the user.
	 * @param algorithm Algorithm to sort the array with, given by the user.
	 * @param array Array to be sorted.
	 * @return The benchmarking result,
	 */
	public static long benchmarking(String compareType, String algorithm, Shape[] array) {
		
		if (compareType.equals("v")) {
			switch (algorithm) {
		    case "b":
		    	start = System.currentTimeMillis();
		    	BubbleSort.bubbleSort(array, new VolumeCompare());
		    	stop = System.currentTimeMillis();
		    	break;
		    case "s":
		    	start = System.currentTimeMillis();
		    	SelectionSort.selectionSort(array, new VolumeCompare());
		    	stop = System.currentTimeMillis();
		    	break;
		    case "i":
		    	start = System.currentTimeMillis();
		    	InsertionSort.insertionSort(array, new VolumeCompare());
		    	stop = System.currentTimeMillis();
		    	break;
		    case "m":
		    	start = System.currentTimeMillis();
		    	MergeSort.mergeSort(array, new VolumeCompare());
		    	stop = System.currentTimeMillis();
		    	
		    	break;
		    case "q":
		    	start = System.currentTimeMillis();
		    	QuickSort.quickSort(array, new VolumeCompare());
		    	stop = System.currentTimeMillis();
		    	break;
		    case "z":
		    	start = System.currentTimeMillis();
		    	HeapSort.heapSort(array, new VolumeCompare());
		    	stop = System.currentTimeMillis();
		    	break;
			}
		}
		else if (compareType.equals("a")) {
			switch (algorithm) {
		    case "b":
		    	start = System.currentTimeMillis();
		    	BubbleSort.bubbleSort(array, new BaseAreaCompare());
		    	stop = System.currentTimeMillis();
		    	break;
		    case "s":
		    	start = System.currentTimeMillis();
		    	SelectionSort.selectionSort(array, new BaseAreaCompare());
		    	stop = System.currentTimeMillis();
		    	break;
		    case "i":
		    	start = System.currentTimeMillis();
		    	InsertionSort.insertionSort(array, new BaseAreaCompare());
		    	stop = System.currentTimeMillis();
		    	break;
		    case "m":
		    	start = System.currentTimeMillis();
		    	MergeSort.mergeSort(array, new BaseAreaCompare());
		    	stop = System.currentTimeMillis();
		    	break;
		    case "q":
		    	start = System.currentTimeMillis();
		    	QuickSort.quickSort(array, new BaseAreaCompare());
		    	stop = System.currentTimeMillis();
		    	break;
		    case "z":
		    	start = System.currentTimeMillis();
		    	HeapSort.heapSort(array, new BaseAreaCompare());
		    	stop = System.currentTimeMillis();
		    	break;
			}
		}
		else if (compareType.equals("h")) {
			switch (algorithm) {
		    case "b":
		    	start = System.currentTimeMillis();
		    	BubbleSort.bubbleSort(array);
		    	stop = System.currentTimeMillis();
		    	break;
		    case "s":
		    	start = System.currentTimeMillis();
		    	SelectionSort.selectionSort(array);
		    	stop = System.currentTimeMillis();
		    	break;
		    case "i":
		    	start = System.currentTimeMillis();
		    	InsertionSort.insertionSort(array);
		    	stop = System.currentTimeMillis();
		    	break;
		    case "m":
		    	start = System.currentTimeMillis();
		    	MergeSort.mergeSort(array);
		    	stop = System.currentTimeMillis();
		    	break;
		    case "q":
		    	start = System.currentTimeMillis();
		    	QuickSort.quickSort(array);
		    	stop = System.currentTimeMillis();
		    	break;
		    case "z":
		    	start = System.currentTimeMillis();
		    	HeapSort.heapSort(array);
		    	stop = System.currentTimeMillis();
		    	break;
			}
		}
		return stop - start;
	}
}
