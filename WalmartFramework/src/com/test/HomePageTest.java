package com.test;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.util.PageDriver;

public class HomePageTest extends BaseTest {

	HomePage hp;
	@BeforeClass
	public void initialize()
		{
		hp=new HomePage(driver);
		}
	@DataProvider(name="signindata")
	public Object [][] getdata()
		{
		return new Object [][]{{"aa","aa"},{"bb","bb"},{"cc","cc"}};		
		}
	@Test(dataProvider="signindata",enabled=false)
	public void signintest (String uname,String pwd)
		{
		boolean actual=hp.signin(uname, pwd);
		 Assert.assertTrue(actual);			
		}
	@Test(enabled=false)
	public void topmenutest()
		{
		int actual=hp.topmenu();
		Assert.assertEquals(actual, 8);
		}
	@Test(enabled=false)
	public void imagetest() throws Exception
		{
		int num;		
		num = hp.image();
		Assert.assertEquals(num,7);
		}
	@Test(enabled=false)
	public void inalidccounttest()
		{
		String actual=hp.invalidaccount();
		Assert.assertEquals(actual, "Sign in to your account");
		}
	@Test(enabled=false)
	public void searchboxtest()
		{
		String s=hp.searchbox();
		Assert.assertEquals(s, "Toys");
		}

	@Test(enabled=false)
	public void alldepartmentstest()
		{
		 hp.alldepartments();		 
		}
	@Test(enabled=false)
	public void getmylocalstoretest()
		{
			String actual=hp.getmylocalstore();
			String expected="http://www.walmart.com/store/";
			Assert.assertEquals(actual, expected);
		}
	@Test(enabled=false)
	public void pickituptodaytest()
	{
		String actual=hp.pickituptoday();
		String expected="http://www.walmart.com/browse/all/all/0?cat_id=0&facet=pickup_and_delivery:FREE%20Pickup%20Today";
		Assert.assertEquals(actual, expected);
	}
	@Test(enabled=false)
	public void hoveralldepartmentstest()
	{
		String actual=hp.hoveralldepartments();
		String expected="http://www.walmart.com/?adid=22222222224226138098&wmlspartner=wmtlabs&wl0=10350711651&wl1=e&wl2=walmart&wl3=64003623973&veh=sem";
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void stroefindertest()
	{
		String expected=hp.storefinder();
		String actual="http://www.walmart.com/store/finder?location=Fremont";
		Assert.assertEquals(actual, expected);
	}
	@AfterClass
	public void quit()
		{
		driver.quit();
		}
	
}
