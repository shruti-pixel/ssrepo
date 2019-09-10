package com.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qa.pages.ItemsInventory;
import com.qa.pages.LoginPage;
import com.qa.pages.Sales;
import com.qa.testBase.TestBase;

public class ItemsInventoryTest extends TestBase{
LoginPage loginpage;
ItemsInventory itemsInventory;
Sales sales;



	public ItemsInventoryTest() throws FileNotFoundException {
	initialization();
	 loginpage=new LoginPage();

	 sales = loginpage.login(props.getProperty("username"),props.getProperty("password"));

	 itemsInventory= new ItemsInventory();

	}
	
	
	
	

	

	@Test(priority=2)
   public void verifyfillForm(){
	   itemsInventory.fillTheForm("abc", "shruti", "systems");  
	   
   } 
@AfterTest
public void teardown(){
	driver.quit();
	
}
		
		
	}

