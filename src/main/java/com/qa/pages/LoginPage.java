package com.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class LoginPage extends TestBase {

	// page Object or Object Repository
	@FindBy(name = "user_name_entry_field")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "SubmitUser")
	WebElement submitbutn;

	@FindBy(xpath = "//*[@id='_page_body']/form/center[1]/table/tbody/tr[1]/td/a/img")
	WebElement FAimage;

	// initialzing webelement
	public LoginPage() throws FileNotFoundException {

		PageFactory.initElements(driver, this);
	}

	// validate title
	public String validateLoginPage() {
		return driver.getTitle();
	}

	// validate image
	public boolean faImage() {
		return FAimage.isDisplayed();
	}

	// login success means going to next page

	public Sales login(String un, String pw) throws FileNotFoundException {
		username.sendKeys(un);
		password.sendKeys(pw);

		submitbutn.click();

		return new Sales();

	}
}
