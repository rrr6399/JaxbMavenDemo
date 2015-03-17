package org.austinjug.jaxb.model;

public class Circle extends Shape{
	private double radius;
	private Point center;
	
	@Override
	public Double getArea() {
		return Math.PI * getRadius() * getRadius();
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
}
