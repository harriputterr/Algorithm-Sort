package com.teamsonia.shapes;

/**
 * This class extends the Shape and represents a Cone.
 */
public class Cone extends Shape {

	private double radius;
	
	/**
	 * Getter for radius.
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}
	
	
	/**
	 * Empty Constructor/
	 */
	public Cone() {
		
	}
	
	/**
	 * Constructor to make Cone objects.
	 * @param height
	 * @param radius
	 */
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	@Override
	public double baseArea() {
		
		return PI*radius*radius;
	}

	@Override
	public double volume() {
		
		return (PI*radius*radius*getHeight())/3;
	}

	@Override
	public String toString() {

		return "Cone             [Base Area = " + baseArea() + ", Volume = " + volume() + ", Height = " + getHeight() + "]";
	}

	@Override
	public int compare(Shape o1, Shape o2) {
		
		return 0;
	}
	
	
}
