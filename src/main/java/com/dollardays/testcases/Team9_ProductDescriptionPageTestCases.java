package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SearchPage;
import com.dollardays.pages.Team9_ProductDescriptionPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;
import com.dollardays.utilities.VideoRecorder_utlity;



public class Team9_ProductDescriptionPageTestCases extends BaseTest{


	/**
	 * This function runs all the preconditions required for the test.
	 *
	 */
	public void runPreConditions(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.getTest().log(Status.INFO, "Pre condition.");
		ExtentTestManager.getTest().log(Status.INFO, "Login.");
		Thread.sleep(1000);
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Login Successful.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Search and open Product description page.");
		SearchPage searchpage = new SearchPage(driver);
		Thread.sleep(1000);
		searchpage.getSearchBar().sendKeys("Backpack");
		//searchpage.getSearchBar().sendKeys("backpack");
		Thread.sleep(1000);
		searchpage.getsearchBtn().click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@href='/i2323196-wholesale-15-forward-classic-school-backpack-with-side-mesh-pocket-4-colors.html'][contains(text(),'15\" Forward Classic School Backpack with Side Mesh')]")).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Search and open Product description page successful.");

	}
	
	/**
	 * This function runs all the Entry test cases.
	 *
	 */
	@DDDataProvider(datafile = "testdata/Team9_ProductDescriptionPage.xlsx", sheetName = "Entry",  testcaseID = "", runmode = "")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_DD_PDP_Entry_Cases(Hashtable<String, String> datatable) throws Exception{
		
		//VideoRecorder_utlity.startRecord("Entry" + datatable.get("TCID"));//Starting point of video recording

		ExtentTestManager.getTest().log(Status.PASS, datatable.get("TCID") + ": " +datatable.get("TestCase"));
		runPreConditions(datatable);
		
		Team9_ProductDescriptionPage pdp_page = new Team9_ProductDescriptionPage(driver);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 1 : Enter Quantity: " + datatable.get("Qty"));
		//1. CLEAR QTY NUM CASES BOX
		pdp_page.getNumCasesBox().clear();
		Thread.sleep(1000);
		//2. ENTER value
		pdp_page.getNumCasesBox().sendKeys(datatable.get("Qty"));
		Thread.sleep(1000);
		pdp_page.getNumCasesBox().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//3. VERIFY NOTHING HAPPENED BY READING QTY NUM CASES WEBELEMENT
		ExtentTestManager.getTest().log(Status.INFO, "Verify Quantity is not displayed." );
		Assert.assertEquals( pdp_page.getNumCasesBox().getText(),""  );
		Thread.sleep(1000);
		
		//VideoRecorder_utlity.stopRecord();//End point of video recording
	}


	/**
	 * This function runs all the Left Navigation test cases.
	 *
	 */
	@DDDataProvider(datafile = "testdata/Team9_ProductDescriptionPage.xlsx", sheetName = "Left Navigation",  testcaseID = "", runmode = "")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_DD_PDP_LeftNavigation_Cases(Hashtable<String, String> datatable) throws Exception{
		//VideoRecorder_utlity.startRecord("Left Navigation" + datatable.get("TCID"));//Starting point of video recording
	
		ExtentTestManager.getTest().log(Status.PASS, datatable.get("TCID") + ": " +datatable.get("TestCase"));
		runPreConditions(datatable);
		
		Team9_ProductDescriptionPage pdp_page = new Team9_ProductDescriptionPage(driver);
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click " + datatable.get("Action Type"));
		pdp_page.clickActionType(datatable.get("Action Type"));
		
		//VideoRecorder_utlity.stopRecord();//End point of video recording
	}
		
	
	/**
	 * This function runs all the Product description test cases.
	 *
	 */
	@DDDataProvider(datafile = "testdata/Team9_ProductDescriptionPage.xlsx", sheetName = "Product Details",  testcaseID = "", runmode = "")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_DD_PDP_ProductDetails_Cases(Hashtable<String, String> datatable) throws Exception{
		//VideoRecorder_utlity.startRecord("Product Details" + datatable.get("TCID"));//Starting point of video recording	
		ExtentTestManager.getTest().log(Status.PASS, datatable.get("TCID") + ": "+datatable.get("TestCase"));
		runPreConditions(datatable);
		
		Team9_ProductDescriptionPage pdp_page = new Team9_ProductDescriptionPage(driver);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Verify " + datatable.get("Verify Value"));
		pdp_page.VerifyValue(datatable.get("Verify Value"));
		
		//VideoRecorder_utlity.stopRecord();//End point of video recording

	}
	
	/**
	 * This function runs all the Quantity entry popup test cases.
	 *
	 */
	@DDDataProvider(datafile = "testdata/Team9_ProductDescriptionPage.xlsx", sheetName = "Popup",  testcaseID = "", runmode = "")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_DD_PDP_Quantity_Cases(Hashtable<String, String> datatable) throws Exception{
	
		//VideoRecorder_utlity.startRecord("Popup" + datatable.get("TCID"));//Starting point of video recording
	
		ExtentTestManager.getTest().log(Status.PASS, datatable.get("TCID") + ": " + datatable.get("TestCase"));
		runPreConditions(datatable);
		
		ExtentTestManager.getTest().log(Status.INFO, "Quantity is " + datatable.get("Qty"));
		
		// real test steps
		Team9_ProductDescriptionPage pdp_page = new Team9_ProductDescriptionPage(driver);
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "Step 1 : Enter Quantity: " + datatable.get("Qty"));
		pdp_page.enterNumCases(datatable.get("Qty"));
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "Displayed Calculated price is: " + pdp_page.getQtyCalculatedPrice().getText());
		ExtentTestManager.getTest().log(Status.INFO, "Expected Calculated price is: " + pdp_page.getExpectedCalcPrice(datatable.get("Qty")));
		//Assert.assertEquals(pdp_page.getQtyCalculatedPrice().getText(), pdp_page.getExpectedCalcPrice(datatable.get("Qty")));
	
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2 :Check/Uncheck Unlimited quantity.");
		pdp_page.handle_unlim_qty(datatable.get("Unlimited Check?"));
		Thread.sleep(1000);
		pdp_page.verify_checkbox(datatable.get("Unlimited Check?"));
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3 : Click on add to my cart button");	
		pdp_page.getAddToMyCartBtn().click();
		Thread.sleep(1000);
		pdp_page.verifyAddToMyCart(datatable.get("Qty"), datatable.get("Unlimited Check?"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4 : Close the popup if needed.");
		pdp_page.handlePopup(datatable.get("Close Popup?"));
		Thread.sleep(1000);
		
		//VideoRecorder_utlity.stopRecord();//End point of video recording
	}

}
