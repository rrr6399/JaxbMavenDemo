package org.austinjug.jaxb.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Polygon")
@XmlType(name = "Polygon_Type")
public class Polygon extends Shape {

	@XmlElementWrapper(name = "Points")
	@XmlElement(name="Point")
	private List<Point> points;

	@Override
	public Double getArea() {
		return null;
	}

	public List<Point> getPoints() {
		return this.points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

}
