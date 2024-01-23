package com.teamsonia;

import java.util.Comparator;

import com.teamsonia.shapes.Shape;

/**
 * Prints the required data on the console.
 */
public class Print {
	
	/**
	 * Prints Chosen Algorithm, Compare Type, Benchmarking result, First, Last and every 1000 value from the sorted array.
	 * @param array The sorted array.
	 * @param benchmarkingResult Benchmarking results of the algorithm.
	 * @param compareType The Compare Type that was used.
	 * @param algorithm The algorithm that was used.
	 */
	public static void print(Shape[]array, long benchmarkingResult, String compareType, String algorithm) {
		
		/**
		 * String variable to store the chosen Compare Type.
		 */
		String ct = "";
		/**
		 * String variable to store the chosen Algorithm.
		 */
		String algo = "";
		
		// Switch block to interpret chosen Compare Type.
		switch (compareType) {
	    case "v":
	    	ct = "Volume";
	    	break;
	    case "a":
	    	ct = "Base Area";
	    	break;
	    case "h":
	    	ct = "Height";
	        break;
		}
		
		// Switch block to interpret chosen Algorithm Type.
		switch (algorithm) {
	    case "b":
	    	algo = "Bubble";
	    	break;
	    case "s":
	    	algo = "Selection";
	    	break;
	    case "i":
	    	algo = "Insertion";
	    	break;
	    case "m":
	    	algo = "Merge";
	    	break;
	    case "q":
	    	algo = "Quick";
	    	break;
	    case "z":
	    	algo = "Heap";
	    	break;
		}
		
		//Print Statements making use of variables to display meaningful results.
		System.out.println("Chosen Algorithm:    " + algo
				+"\nChosen Compare Type: "+ct+"\n\n");
		System.out.println("The benchmarking result: " + benchmarkingResult + " ms\n\n");
		System.out.println("First Sorted Value:\n" + array[0] + "\n\n");
		System.out.println("Last Sorted Value:\n" + array[array.length - 1] + "\n\n");
		System.out.println("Below are the attributes of every 1000th position in this Shape Array:\n");
		for (int i = 1000; i < array.length - 1; i+=1000) {
			System.out.print("\n"+i + " Index No.\n");
			System.out.println(array[i]+ "\n");
		}
		
	}
}
