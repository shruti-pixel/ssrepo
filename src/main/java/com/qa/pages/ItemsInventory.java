package com.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.testBase.TestBase;

public class ItemsInventory extends TestBase {
	
	// initilization of driver
	public ItemsInventory() throws FileNotFoundException {
		
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//input[@name='_stock_id_edit']")
	WebElement SelectItem;

	@FindBy(xpath = "//select[@id='stock_id']")
	WebElement newItem;

	@FindBy(xpath = "//input[@type='text'][@name='NewStockID']")
	WebElement ItemCode;

	@FindBy(xpath = "//input[@name='description']")
	WebElement name;

	@FindBy(xpath = "//input[@type='checkbox'][@name='editable']")
	WebElement checkbox;

	// actions performed
	public String getTitle() {
		return driver.getTitle();

	}

	// click items&inventory
	public void clickOnitemsAndInventoryLink() throws FileNotFoundException {
		

	}

	public void fillTheForm(String selectItem, String cname, String category) {
		SelectItem.sendKeys(selectItem);
		name.sendKeys(cname);
		Select select = new Select(driver.findElement(By
				.xpath("//select[@id='category_id']")));
		select.selectByValue(category);

		checkbox.click();
	}


	}

