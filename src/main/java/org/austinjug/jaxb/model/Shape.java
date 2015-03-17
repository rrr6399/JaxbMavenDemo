package org.austinjug.jaxb.model;

import java.awt.Color;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.austinjug.jaxb.util.ColorAdapter;

@XmlRootElement(name = "Shape")
@XmlType(name = "Shape_Type")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Shape {

	@XmlElement(name = "ID")
	private String id;

	@XmlElement(name = "Color")
	@XmlJavaTypeAdapter(ColorAdapter.class)
	private Color color = Color.pink;

	@XmlElement(name = "Date_Created")
	private Date created = new Date();

	@XmlElement(name = "Area")
	private Double area;

	@XmlElement(name = "Description")
	private String description;

	public Shape() {
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public abstract Double getArea();

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
