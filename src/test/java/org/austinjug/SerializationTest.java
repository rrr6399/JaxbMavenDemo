package org.austinjug;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.austinjug.jaxb.model.Circle;
import org.austinjug.jaxb.model.Point;
import org.austinjug.jaxb.model.Polygon;
import org.austinjug.jaxb.model.ShapeList;
import org.austinjug.jaxb.util.JaxbTransformer;
import org.junit.Test;

public class SerializationTest {
	JaxbTransformer transformer = new JaxbTransformer();
	
	public SerializationTest() {
	}

	@Test
	public void testSerialization() throws Exception {
		ShapeList shapeList = this.createList();
		System.out.println(transformer.toXML(shapeList));
	}

	@Test
	public void testSerializationWithCData() throws Exception {
		ShapeList shapeList = this.createList();
		System.out.println(transformer.toXMLWithCData(shapeList));
	}

	private ShapeList createList() {
		ShapeList shapeList = new ShapeList();

		Polygon polygon = new Polygon();
		polygon.setColor(Color.WHITE);
		polygon.setDescription("<HTML><H1>My Polygon</H1></HTML>");
		polygon.setId("poly1");
		List<Point> points= new ArrayList<>();
		points.add(new Point(0,0));
		points.add(new Point(0,1));
		points.add(new Point(1,1));
		points.add(new Point(1,0));
		points.add(new Point(0,0));
		polygon.setPoints(points);
		shapeList.addShape(polygon);

		Circle circle = new Circle();
		circle.setCenter(new Point(10,20));
		circle.setRadius(100);
		shapeList.addShape(circle);

		return shapeList;
	}

	@Test
	public void testSchemaGeneration() throws Exception {
		transformer.generateSchema();
	}
	
}
