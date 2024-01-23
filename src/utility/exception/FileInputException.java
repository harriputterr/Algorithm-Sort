package utility.exception;

import java.io.FileNotFoundException;

public class FileInputException extends FileNotFoundException{
	@Override
	public String toString() {
		return "Error: File Not Found\nPlease make sure to input correct file path.";
	}
}
