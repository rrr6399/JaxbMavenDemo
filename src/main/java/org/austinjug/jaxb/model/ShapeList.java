package org.austinjug.jaxb.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Shape_List")
@XmlType(name = "Shape_List_Type")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShapeList {

	@XmlElementWrapper(name = "Shapes")
	@XmlElement(name = "Shape")
	private List<Shape> shapes = new ArrayList<>();

	public ShapeList() {
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}

	public void addShape(Shape shape) {
		this.shapes.add(shape);
	}

}
