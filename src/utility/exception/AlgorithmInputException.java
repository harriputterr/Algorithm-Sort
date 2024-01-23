package utility.exception;

public class AlgorithmInputException extends Exception{
	@Override
	public String toString() {
		return "Error: Please make sure that Sorting Algorithm Input "
       			+ "is one of the following:\n"
       			+ "b or B ~ Bubble Sort\n"
       			+ "s or S ~ Selection Sort\n"
       			+ "i or I ~ Insertion Sort\n"
       			+ "m or M ~ Merge Sort\n"
       			+ "q or Q ~ Quick Sort\n"
       			+ "z or Z ~ Special Algorithm Heap Sort\n";
	}
}
