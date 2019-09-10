package com.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.pages.PurchasePage;
import com.qa.pages.Sales;
import com.qa.testBase.TestBase;
import com.qa.utility.UtilityTest;

public class PurchasePageTest extends TestBase {
	LoginPage loginpage;
	Sales sales;
	PurchasePage puchasePage;
	UtilityTest utilityTest;

	public PurchasePageTest() throws FileNotFoundException {
		super();

	}

	@BeforeMethod
	public void loginTest() throws IOException {
		initialization();
		loginpage = new LoginPage(); // initialization of login page
		sales = new Sales();
		sales = loginpage.login(props.getProperty("username"),
				props.getProperty("password"));
		puchasePage = new PurchasePage();
		sales.clickOnPurchaseLink();
		puchasePage.clickOnSupplierLink();
		utilityTest = new UtilityTest();

	}

	@Test
	public void verifyPurchasePageTitleTest() {
		String actTitle = puchasePage.verifyPurchasePageTitle();
		String expTitle = "Suppliers";
		Assert.assertEquals(actTitle, expTitle);

	}

	@DataProvider
	public Object[][] getSupplyTestData() {
		Object[][] data = UtilityTest.getTestData("Sheet1");

		return data;
	}

	@Test(dataProvider = "getSupplyTestData")
	public void fillSupplerFormTest(String suppName, String supprefName,
			String GSTNo, String Website,String currency, String OurCustomerNo) throws InterruptedException {
		// puchasePage.fillSupplerForm("yogesh", "yogi", "1234",
		// "hawanna@gmail.com", "1278","euro");
		puchasePage.fillSupplerForm(suppName, supprefName, GSTNo, Website,currency,
				OurCustomerNo);
		Thread.sleep(400);
		puchasePage.selectSupplyCuurency();
		

	}
	@Test
 public void m1() throws InterruptedException{

		puchasePage.selectSupplyCuurency();
 }	
		
	

}
