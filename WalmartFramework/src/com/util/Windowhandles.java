package com.util;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;

public class Windowhandles {
	

	    public void switchToWindow(WebDriver driver)
	    {
	        String newWindow = driver.getWindowHandle();
	        driver.switchTo().window(newWindow);
	    }



	    public void windowHandles(WebDriver driver)
	    {
	        Iterator<String> handles = driver.getWindowHandles().iterator();
	        while(handles.hasNext()){
	            String child = handles.next();
	            driver.switchTo().window(child);
	        }
	    }


	}


