package com.jxx.demo.properties;

import junit.framework.*;

//import javax.servlet.ServletContext;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class JPropertiesTest extends TestCase {
	JProperties jProperties;

	String key = "helloworld.title";

	String value = "Hello World!";

	public void testLoadProperties() throws Exception {
		URL url = Thread.currentThread().getContextClassLoader()
		.getResource("LocalStrings.properties");
		System.out.println(url.getFile());
		
		
		String name = null;
		Properties p = new Properties();

		name = "D:\\workz6\\MyProject\\src\\com\\jxx\\demo\\LocalStrings.properties";
		p = JProperties.loadProperties(name, JProperties.BY_PROPERTIES);
		assertEquals(value, p.getProperty(key));

		name = "com.jxx.demo.LocalStrings";
		p = JProperties.loadProperties(name, JProperties.BY_RESOURCEBUNDLE);
		assertEquals(value, p.getProperty(key));
		assertEquals(value, ((JProperties.ResourceBundleAdapter) p)
				.getString(key));

		name = "D:\\workz6\\MyProject\\src\\com\\jxx\\demo\\LocalStrings.properties";
		p = JProperties.loadProperties(name,
				JProperties.BY_PROPERTYRESOURCEBUNDLE);
		assertEquals(value, p.getProperty(key));
		assertEquals(value, ((JProperties.ResourceBundleAdapter) p)
				.getString(key));

		name = "\\com\\jxx\\demo\\LocalStrings.properties";
		p = JProperties.loadProperties(name, JProperties.BY_SYSTEM_CLASSLOADER);
		assertEquals(value, p.getProperty(key));

		name = "\\com\\jxx\\demo\\LocalStrings.properties";//LocalStrings.properties 也行
		p = JProperties.loadProperties(name, JProperties.BY_CLASSLOADER);
		assertEquals(value, p.getProperty(key));

		name = "../LocalStrings.properties";
		p = JProperties.loadProperties(name, JProperties.BY_CLASS);
		assertEquals(value, p.getProperty(key));
	}

}