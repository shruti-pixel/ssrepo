package com.qa.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utility.UtilityTest;

public class TestBase {

public static WebDriver driver;
  public static Properties props;
	
 
 public TestBase() throws FileNotFoundException{
	
	 props =new Properties();
	 FileInputStream ip=new FileInputStream("src\\main\\java\\com\\qa\\config\\config.properties");
 try {
	props.load(ip);
} catch (IOException e) {
	
	e.printStackTrace();
}

 
 
 
 }
public static void initialization(){
	String browserName = props.getProperty("browser"); 
	if(browserName.equals("chrome")){
	System.setProperty("webdriver.chrome.driver", "E:\\chrome_driver\\chromedriver_win32 (2)\\chromedriver.exe");
	driver=new ChromeDriver();
	}else if(browserName.equals("firefox")){
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		driver=new FirefoxDriver();
			}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(UtilityTest.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(UtilityTest.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(props.getProperty("url"));
	
 } 


}
