package propertyFileReading;

import java.io.*;
import java.util.*;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		
		String path=System.getProperty("user.dir") + "\\Test Data\\Config.properties";
		
		FileInputStream fis= new FileInputStream(path);
		
		Properties obj= new Properties();
		
		obj.load(fis);
	/*	
		System.out.println(obj.getProperty("url"));
		System.out.println(obj.getProperty("email"));
		System.out.println(obj.getProperty("password"));
		System.out.println(obj.getProperty("OrderID"));
		
	*/	
		
		// read keys from properties
		
		// method 1
		Set<Object> keys = obj.keySet();
		System.out.println(keys);
		
		// method 2
		Set<String> keyss = obj.stringPropertyNames();
		System.out.println(keyss);
		
		// read values from properties
		
		Collection<Object> values = obj.values();
		System.out.println(values);
		
		fis.close();
		
	}

}
