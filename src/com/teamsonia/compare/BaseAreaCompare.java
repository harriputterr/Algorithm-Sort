package com.teamsonia.compare;

import java.util.Comparator;

import com.teamsonia.shapes.Shape;

/**
 * This class is used to sort the Shape array on the basis of the Base Area.
 */
public class BaseAreaCompare implements Comparator<Shape> {

	@Override
	public int compare(Shape s1, Shape s2) {
		return Double.compare(s1.baseArea(), s2.baseArea());
	}
	
}
