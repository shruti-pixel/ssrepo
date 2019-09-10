package com.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.testBase.TestBase;

public class PurchasePage extends TestBase {

	// find the elements
	@FindBy(xpath = "//a[@class='menu_option'][@accesskey='S']")
	WebElement suppliersLink;

	@FindBy(xpath = "//td[@class='titletext']")
	WebElement suppliersTitle;

	@FindBy(xpath = "//td[contains(text(),'Basic Data')]")
	WebElement basicDatalabel;

	@FindBy(xpath = "//input[@type='text' and @name='supp_name']")
	WebElement supplierName;

	@FindBy(xpath = "//input[@name='supp_ref']")
	WebElement SuppRefName;

	@FindBy(xpath = "//input[@name='gst_no']")
	WebElement gst_No;

	@FindBy(xpath = "//input[@name='website']")
	WebElement website;

	@FindBy(xpath = "//select[@id='curr_code' and @class='combo']")
	WebElement SuppCurrency;

	@FindBy(xpath = "//select[@id='tax_group_id']")
	WebElement taxGroup;

	@FindBy(xpath = "//input[@name='supp_account_no']")
	WebElement ourCustomerNo;

	// initialization

	public PurchasePage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public String verifyPurchasePageTitle() {
		return driver.getTitle();
	}

	public void clickOnSupplierLink() {
		suppliersLink.click();
	}

	public String basicDatalabel() {
		return basicDatalabel.getText();
	}

	public void fillSupplerForm(String uname, String suppRefName, String gstNo,
			String websiteName,String curr, String custno) {
		supplierName.clear();
		supplierName.sendKeys(uname);
		
		System.out.println(uname);
		
		SuppRefName.clear();
		SuppRefName.sendKeys(suppRefName);
		System.out.println(suppRefName);
		gst_No.clear();
		gst_No.sendKeys(gstNo);
		
		System.out.println(gstNo);
		website.clear();
		website.sendKeys(websiteName);
		System.out.println(websiteName);
		SuppCurrency.clear();
		SuppCurrency.sendKeys(curr);
		  ourCustomerNo.clear();
       ourCustomerNo.sendKeys(custno);
       System.out.println(custno);
       
      
       
       
	}
	

	public void selectSupplyCuurency() {

		Select select = new Select(SuppCurrency);
		
		select.selectByValue("CA Dollars");

	}

	public void selecttaxGrup(int tax) {
		Select selecttax = new Select(taxGroup);
		selecttax.selectByIndex(tax);
	}
}
