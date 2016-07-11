package com.util;

import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	public String URL;
	public String Browser;
	public String WaitTimeout;
	public boolean Screenshot;
    public boolean TakeScreenShot;
	
	public Configuration(){

		readProps();
	}
	public void readProps()
	{
		Properties p=new Properties();
		try {
			FileReader reader=new FileReader("config.properties");
			p.load(reader);
			URL=p.getProperty("url");
			Browser=p.getProperty("browser");
	        WaitTimeout = p.getProperty("wait");
	        Screenshot=p.getProperty("takeScreenShot") != null;
	        TakeScreenShot = Boolean.valueOf(p.getProperty("takeScreenShot"));
			} 
		catch (Exception e) 
		 	{
			e.printStackTrace();
		 	} 
			
	}
	
	}
	

