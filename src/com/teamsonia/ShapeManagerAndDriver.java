package com.teamsonia;
import java.lang.reflect.*;
import java.io.*;
import java.util.*;

import com.teamsonia.shapes.Shape;

import utility.*;
import utility.exception.AlgorithmInputException;
import utility.exception.CompareTypeInputException;
import utility.exception.FileInputException;


/**
 * ShapeManager.java This class is designed to arrange an array of shapes based on a user-provided comparison type and algorithm.
 * 
 * @author Team Sonia
 * @version October 20, 2023
 * Class Description: 
 * 
 */


public class ShapeManagerAndDriver {
	
	/**
	 * Static string variable to hold File Path.
	 */
	public static String filePath = "";
	/**
	 * Static string variable to hold Compare Type.
	 */
	public static String compareType = "";
	/**
	 * Static string variable to hold Algorithm.
	 */
	public static String algorithm = "";
	
	/**
	 * Shape Array List which will be copied and converted to an array.
	 */
	public static ArrayList<Shape> shapeList = new ArrayList<>(); 
	
	
	
	/**
	 * This is the Driver method. 
	 * @param args This represents our command line arguments in an array. 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception{
		
		//Stores and interprets user input.
		commandParsing(args);
		
		//Stores Array Length to an int variable.
		int arrayLength = convertToArray(filePath).length; 
		
		//Converts the ArrayList to an Array
		Shape[] shapeArray = Arrays.copyOf(convertToArray(filePath), arrayLength, Shape[].class);
		
		//Stores the benchmarking result.
		long benchmarkingResult = Benchmarking.benchmarking(compareType, algorithm, shapeArray);
		
		//Prints the data on the console.
		Print.print(shapeArray, benchmarkingResult, compareType, algorithm);

		
	}
	
	/**
	 * Command Parsing Method loads our static String variables with File Path, Compare Type and Algorithm from command line user input.
	 * @param args The commands passed in the Main method is received by this method.
	 * @throws CompareTypeInputException, AlgorithmInputException If provided wrong Compare Type or Algorithm Type values, it throws the respective exception and displays meaningful message to guide the user.
	 */
	public static void commandParsing(String[] args)  throws CompareTypeInputException, AlgorithmInputException{
		try {
			for(int i =0; i < args.length; i++) {
				char[] charArray = args[i].toCharArray();
				if (charArray[0] == '-' || charArray[0] == '–') { // These are different length of dashes.
					if (charArray[1] == 'f' || charArray[1] == 'F') {
						filePath = args[i].substring(2);
						try {
							//Tries to read the file. If the file is not found. FileNotFoundException is catched.
							BufferedReader reader = new BufferedReader(new FileReader(filePath));
						}
						catch (FileNotFoundException e) {
							try {
								//When the File isn't found it throws our customized Exception.
								throw new FileInputException();
							}
							catch(FileInputException f) {
								f.printStackTrace();
								//The application exits.
								System.exit(1);
							}
							
						}
					}
					if (charArray[1] == 't' || charArray[1] == 'T') {
						String value = String.valueOf(charArray[2]);
						switch (value.toLowerCase()) {
					    case "v": // Volume Compare
					    case "a": // Base Area Compare
					    case "h": // Height Compare. Uses CompareTo method logic defined in the Abstract class Shape.
					    	compareType = (args[i].substring(2)).toLowerCase();
					        break;
					    default:
					    	try {
					    		//Throws exception if the Compare Type input isn't found to be as expected.
					       		throw new CompareTypeInputException();
					       	}
					       	catch (CompareTypeInputException e) {
					       		e.printStackTrace();
					       		System.exit(1);
					       	}

						}
						
					}
					if (charArray[1] == 's' || charArray[1] == 'S') {
						
						String value = String.valueOf(charArray[2]);
						switch (value.toLowerCase()) {
					    case "b": // Bubble
					    case "s": // Selection
					    case "i": // Insertion
					    case "m": // Merge
					    case "q": // Quick
					    case "z": // Heap 
					    	algorithm = (args[i].substring(2)).toLowerCase();
					        break;
					    default:
					       	try {
					       		//Throws below exception if Algorithm Input isn't found to be as expected.
					       		throw new AlgorithmInputException();
					       	}
					       	catch (AlgorithmInputException e) {
					       		e.printStackTrace();
					       		System.exit(1);
					       	}
						}
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("Unknown Exception");
		}
		
	}
	
	/**
	 * Reads from the File and Converts it to an Array
	 * @param filePath Given by the user.
	 * @return Unsorted Shape Array in descending order.
	 */
	public static Shape[] convertToArray(String filePath) {
		//Stores all the data from the text file.
		String data = "";
		try {
			//Reads data from the file.
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			data = reader.readLine();
			reader.close();
			
			//Converts the object into tokens or words.
			StringTokenizer str = new StringTokenizer(data);
			
			//First token from the file is the number objects in it.
			int numObjects = Integer.parseInt(str.nextToken());
			
			//Reads through the data, compares and add data to the list.
			for(int i = 0; i < numObjects; i++) {
				Object o = null;
				String className = "com.teamsonia.shapes."+str.nextToken();
				Class cls = Class.forName(className);

				if(className.compareTo("com.teamsonia.shapes.Cylinder") == 0) {
					
					//Create the parameter type using reflection
					Class paramTypes[] = new Class[2];
					paramTypes[0] = Double.TYPE;
					paramTypes[1] = Double.TYPE;
					
					//Creates the constructor using the above generated parameter types.
					Constructor ct = cls.getConstructor(paramTypes);
					
					//Creates an object array.
					Object argList[] = new Object[2];
					argList[0] = new Double(Double.parseDouble(str.nextToken()));
					argList[1] = new Double(Double.parseDouble(str.nextToken()));
					
					//Instantiates the Object from the array to object o.
					o = ct.newInstance(argList);
				}
				if(className.compareTo("com.teamsonia.shapes.Pyramid") == 0) {
					Class paramTypes[] = new Class[2];
					paramTypes[0] = Double.TYPE;
					paramTypes[1] = Double.TYPE;
					
					Constructor ct = cls.getConstructor(paramTypes);
					
					Object argList[] = new Object[2];
					argList[0] = new Double(Double.parseDouble(str.nextToken()));
					argList[1] = new Double(Double.parseDouble(str.nextToken()));
					
					o = ct.newInstance(argList);
				}
				if(className.compareTo("com.teamsonia.shapes.Cone") == 0) {
					Class paramTypes[] = new Class[2];
					paramTypes[0] = Double.TYPE;
					paramTypes[1] = Double.TYPE;
					
					Constructor ct = cls.getConstructor(paramTypes);
					
					Object argList[] = new Object[2];
					argList[0] = new Double(Double.parseDouble(str.nextToken()));
					argList[1] = new Double(Double.parseDouble(str.nextToken()));
					
					o = ct.newInstance(argList);
				}
				if(className.compareTo("com.teamsonia.shapes.TriangularPrism") == 0) {
					Class paramTypes[] = new Class[2];
					paramTypes[0] = Double.TYPE;
					paramTypes[1] = Double.TYPE;
					
					Constructor ct = cls.getConstructor(paramTypes);
					
					Object argList[] = new Object[2];
					argList[0] = new Double(Double.parseDouble(str.nextToken()));
					argList[1] = new Double(Double.parseDouble(str.nextToken()));
					
					o = ct.newInstance(argList);
				}
				if(className.compareTo("com.teamsonia.shapes.OctagonalPrism") == 0) {
					Class paramTypes[] = new Class[2];
					paramTypes[0] = Double.TYPE;
					paramTypes[1] = Double.TYPE;
					
					Constructor ct = cls.getConstructor(paramTypes);
					
					Object argList[] = new Object[2];
					argList[0] = new Double(Double.parseDouble(str.nextToken()));
					argList[1] = new Double(Double.parseDouble(str.nextToken()));
					
					o = ct.newInstance(argList);
				}
				if(className.compareTo("com.teamsonia.shapes.PentagonalPrism") == 0) {
					Class paramTypes[] = new Class[2];
					paramTypes[0] = Double.TYPE;
					paramTypes[1] = Double.TYPE;
					
					Constructor ct = cls.getConstructor(paramTypes);
					
					Object argList[] = new Object[2];
					argList[0] = new Double(Double.parseDouble(str.nextToken()));
					argList[1] = new Double(Double.parseDouble(str.nextToken()));
					
					o = ct.newInstance(argList);
				}
				if(className.compareTo("com.teamsonia.shapes.SquarePrism") == 0) {
					Class paramTypes[] = new Class[2];
					paramTypes[0] = Double.TYPE;
					paramTypes[1] = Double.TYPE;
					
					Constructor ct = cls.getConstructor(paramTypes);
					
					Object argList[] = new Object[2];
					argList[0] = new Double(Double.parseDouble(str.nextToken()));
					argList[1] = new Double(Double.parseDouble(str.nextToken()));
					
					o = ct.newInstance(argList);
				}
				//Adds the object created each iteration.
				shapeList.add((Shape)o); // Compare this line of code with reflection demo.	
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//Copies and converts the ArrayList of shapes to array.
		Object[] objArray = shapeList.toArray();
		Shape[] shapeArray = Arrays.copyOf(objArray, objArray.length, Shape[].class);
		
		//Finally returns the array.
		return shapeArray;
	}
}
