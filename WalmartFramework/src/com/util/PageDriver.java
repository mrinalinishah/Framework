package com.util;

import java.io.IOException;


import java.util.List;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageDriver {
	WebDriver driver;
	WebElement element;
	Configuration configuration;
	 String WindowHandler;
	  Windowhandles WindowHandles = new Windowhandles();

	
	public PageDriver(Configuration config)
	{this.configuration=config;
	
	//	this.driver=new FirefoxDriver();
		initializeBrowser();
	
	}
	public void initializeBrowser()
	{
		String browser=configuration.Browser;
		switch (browser)
		{
		case "firefox":
			startFirefox();
			break;			
		case "chrome":
			startChrome();
			break;
		case "ie":
			startIE();
			break;
		default :
			startHTML();
			break;
		}
		driver.get(configuration.URL);
	}
	public void startFirefox()
		{
		this.driver=new FirefoxDriver();
		}
	public void startChrome()
		{	
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		this.driver=new ChromeDriver();
		}
	public void startIE()
		{
		System.setProperty("webdriver.ie.driver", "lib/ieDriverServer.exe");
		this.driver=new InternetExplorerDriver();
		}
	public void startHTML()
		{
			
		}
	
	
	public void get(String url)
	{
		driver.get(url);
	}
	
	public WebElement findElement(By by)
	{
		return driver.findElement(by);
		
	}
	public List<WebElement> findElements(By by)
	{
		return driver.findElements(by);
		
	}
	public String gerCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	 public String getMainWindowHandler() {
	        return WindowHandler;
	    }
	 public void getWindowHandles(boolean isSingleWindow) {

	        if(isSingleWindow)
	        {
	          WindowHandles.switchToWindow(driver);
	        }
	        else
	        {
	            WindowHandles.windowHandles(driver);
	        }
	    }

	public void implicitWait(long timeout) throws Exception {
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
            Thread.sleep(timeout);
            return;
        }
	public void presenceOfElementLocated(WebElement element)
	    {
	        //if (_browser != Browsers.HtmlUnit) {
	        try {
	            long timeout = Long.valueOf(configuration.WaitTimeout).longValue();
	            WebDriverWait wait = new WebDriverWait(driver, timeout);
	            wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }}
	public void takeScreenShot(){
		 Screenshot Screenshot = new Screenshot((TakesScreenshot) driver);
	     try {
			Screenshot.takeScreenShot(configuration.Screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 
      
    	public void quit()
	{
		driver.quit();
	}
		public void mouseOver(WebElement element) {
			Actions action=new Actions(driver);
	        action.moveToElement(element).build().perform();			
		}
		
		
		public void movetoelement(WebElement element) {
			Actions action=new Actions(driver);
	        action.moveToElement(element).click().build().perform();			
		}
			
		
		
			
		}

