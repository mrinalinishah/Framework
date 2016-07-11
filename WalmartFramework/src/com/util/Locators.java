
package com.util;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class Locators {
	public static HashMap<String,String> loca=new HashMap<>();
	
	
	public static void getElements(){
		Properties p=new Properties();
		FileReader reader;
		try {
			reader = new FileReader("locators.properties");
			p.load(reader);	
			Enumeration e=p.propertyNames();
			while(e.hasMoreElements()){
				String key=(String)e.nextElement();
				loca.put(key, p.getProperty(key));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

		
	


}
