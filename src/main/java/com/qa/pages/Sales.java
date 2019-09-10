package com.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class Sales extends TestBase {
	
	

	// driver initailization
	public Sales() throws FileNotFoundException {
	    
		PageFactory.initElements(driver, this);
	}

	/*@FindBy(xpath = "//td[@class='headingtext3']")
	WebElement sales_title;*/

	@FindBy(xpath = "/html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/div/a[2]")
	WebElement purchase_link;

	@FindBy(xpath = "//a[@class='menu_tab' and @accesskey='I']")
	WebElement items_and_inventory_link;

	@FindBy(xpath = "//a[@class='menu_tab' and @accesskey ='M']")
	WebElement manufacturing_link;
	
	@FindBy(xpath="//a[@class='menu_tab' ] [@accesskey='F']")
	WebElement Fixed_Assets;
	
	@FindBy(xpath="//a[@class='menu_tab'] [@accesskey='D']")
	WebElement Dimensions;
	

	// validate sales_title
	public String salesTitle() {
		
		return driver.getTitle();

	}

	// click purchase_link
	public PurchasePage clickOnPurchaseLink() throws FileNotFoundException{
		
		purchase_link.click();
		
		return  new PurchasePage();
		
	}
/*	//click items and inventory link
	 public ItemsInventory clickOnItemsAndInventory() throws FileNotFoundException{
		 items_and_inventory_link.click();
		return  new ItemsInventory();
		 
	 }

	 //click  the manufacturing page
	  public Manufactoring clickOnmanufacturing() throws FileNotFoundException{
		  manufacturing_link.click();
		  return new Manufactoring();
		  
	  }*/
}
