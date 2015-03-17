package org.austinjug.jaxb.model;

public class Rectangle extends Shape {
	private double width;
	private double height;
	private Point center;

	public Rectangle() {
	}

	@Override
	public Double getArea() {
		return getWidth()*getHeight();
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Point getCenter() {
		return this.center;
	}


}
