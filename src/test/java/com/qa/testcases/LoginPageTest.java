  package com.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pages.LoginPage;
import com.qa.pages.Sales;
import com.qa.testBase.TestBase;

public class LoginPageTest extends TestBase{
LoginPage loginpage;
Sales sales;
	//
	LoginPageTest() throws FileNotFoundException{
		super();
	}
	
	@BeforeMethod
	public void loginTest() throws FileNotFoundException{
		initialization();
		loginpage= new LoginPage(); //initialization of login page
		 sales=new Sales();
	}
	@Test(priority=2)
	public void validateloginTest(){
	String title = loginpage.validateLoginPage();
	 String expected = "FrontAccounting 2.4.5 - Login";
		Assert.assertEquals(title, expected);
		}
	
	
	@Test(priority=3)
	public void faImageTest(){
		boolean flag = loginpage.faImage();
		Assert.assertTrue(flag);
		}
	
	@Test(priority=1)
	public void login() throws FileNotFoundException{
		sales = loginpage.login(props.getProperty("username"), props.getProperty("password"));
	
		
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit(); //quit the browser
	}
}
