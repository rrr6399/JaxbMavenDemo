package org.austinjug.jaxb.util;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.austinjug.jaxb.model.Circle;
import org.austinjug.jaxb.model.Polygon;
import org.austinjug.jaxb.model.Rectangle;
import org.austinjug.jaxb.model.Shape;
import org.austinjug.jaxb.model.ShapeList;
import org.w3c.dom.Document;

public class JaxbTransformer {

	private static JAXBContext jaxBContext;

	public static synchronized JAXBContext getJaxBContext() throws JAXBException, ClassNotFoundException {
		if (jaxBContext == null) {
			jaxBContext = JAXBContext.newInstance(new Class[]{ShapeList.class, Shape.class, Circle.class, Rectangle.class, Polygon.class});
		}
		return jaxBContext;
	}

	public String toXML(Object jaxbElement) throws Exception {
		StringWriter stringWriter = new StringWriter();
		JAXBContext context = getJaxBContext();
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
		marshaller.marshal(jaxbElement, stringWriter);
		return stringWriter.toString();
	}

	public String toXMLWithCData(Object jaxbElement) throws Exception {
		StringWriter stringWriter = new StringWriter();
		JAXBContext context = getJaxBContext();
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		Document document = docBuilderFactory.newDocumentBuilder().newDocument();
		marshaller.marshal(jaxbElement, document);

		Transformer transformer = this.getTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
		return stringWriter.toString();

	}

	Transformer getTransformer() throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS, "Description");
		return transformer;
	}

	public ShapeList toShape(String xmlString) throws Exception {
		StringReader reader = new StringReader(xmlString);
		JAXBContext context = JaxbTransformer.getJaxBContext();
		ShapeList shape = (ShapeList) context.createUnmarshaller().unmarshal(reader);
		return shape;
	}

	public void generateSchema() throws Exception {
		JAXBContext context = JaxbTransformer.getJaxBContext();
		context.generateSchema(new ShapeSchemaResolver());
	}

}
