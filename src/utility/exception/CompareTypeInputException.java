package utility.exception;

public class CompareTypeInputException extends Exception {
	@Override
	public String toString() {
		return "Error: Please make sure that Compare Type Input "
       			+ "is one of the following:\n"
       			+ "v or V ~ Volume\n"
       			+ "a or A ~ Base Area\n"
       			+ "h or H ~ Height\n";

	}
}
