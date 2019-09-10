package com.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.ItemsInventory;
import com.qa.pages.LoginPage;
import com.qa.pages.Manufactoring;
import com.qa.pages.PurchasePage;
import com.qa.pages.Sales;
import com.qa.testBase.TestBase;

public class SalesTest extends TestBase {
	LoginPage loginpage;
	Sales sales;
	PurchasePage puchasePage;
	/*ItemsInventory itemsAndInventory;
	  Manufactoring manufacturing;
    */
	public SalesTest() throws FileNotFoundException {
		super();
	}
	
	@BeforeMethod
	public void loginTest() throws FileNotFoundException{
		initialization();
		
		loginpage=new LoginPage();
 	   sales=new Sales();
 	    puchasePage=new PurchasePage();
 	
 	   /* itemsAndInventory= new ItemsInventory();
 	
 	    manufacturing=new Manufactoring();
 	    */
 	   sales=loginpage.login(props.getProperty("username"),props.getProperty("password"));
		
	}
@Test(priority=1)
public void salesTitleTest() throws FileNotFoundException{
	puchasePage	= sales.clickOnPurchaseLink();
	  String actual = sales.salesTitle();
	  String expected="Main Menu";
	  Assert.assertEquals(actual, expected,"sales title expected is");
	  
}




	
@AfterMethod
public void tearDown(){
	driver.quit();
}
	
	 
	
}

	

