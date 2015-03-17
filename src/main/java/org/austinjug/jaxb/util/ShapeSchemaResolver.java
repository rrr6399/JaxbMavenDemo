package org.austinjug.jaxb.util;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class ShapeSchemaResolver extends SchemaOutputResolver {

	@Override
	public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException
	{
		File file = new File("C:/Users/Rob/Desktop"+"/"+suggestedFileName);
		StreamResult result = new StreamResult(file);
		result.setSystemId(file.toURI().toURL().toString());
		return result;
	}
	
}
