package org.austinjug.jaxb.util;

import java.awt.Color;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ColorAdapter extends XmlAdapter<String, Color>
{

	@Override
	public Color unmarshal(String s)
	{
		return Color.decode(s);
	}

	@Override
	public String marshal(Color color)
	{
		String rgb = Integer.toHexString(color.getRGB());
		return "#" + rgb.substring(2, rgb.length());
	}
}
