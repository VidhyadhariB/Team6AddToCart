package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SubmitARequestPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.PropertyUtil;
import com.dollardays.utilities.TestUtil;
import com.dollardays.utilities.VideoRecorder_utlity;
import com.dollardays.utilities.Xls_Reader;

import junit.framework.Assert;



public class SubmitARequestTestcase extends BaseTest{
	@DDDataProvider(datafile = "testdata/Team4Testdata.xlsx", sheetName = "SubmitRequestPage",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC1_submitARequestPage(Hashtable<String, String> datatable) throws Exception{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		ExtentTestManager.getTest().log(Status.INFO, "step1:User has logged In");
		Thread.sleep(1000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		VideoRecorder_utlity.stopRecord();//End point of video recording
	
 		SubmitARequestPage submitarequestpage = new  SubmitARequestPage(driver);
		submitarequestpage.signInBtn().click();
		submitarequestpage.submitARequestLink().click();
		submitarequestpage.phoneNumTextBox().click();
		submitarequestpage.phoneNumTextBox().sendKeys(datatable.get("Phone Number"));
		Select Dropdown = new Select(submitarequestpage.selectARequestType());
		Dropdown.selectByVisibleText(datatable.get("Select RequestType"));
		submitarequestpage.OrderNoTxtBox().click();
		submitarequestpage.OrderNoTxtBox().sendKeys(datatable.get("Order Number"));
		submitarequestpage.messageTextBox();
		submitarequestpage.messageTextBox().sendKeys(datatable.get("Message"));
		/* JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollTo(0, 250)");
		driver.switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(submitarequestpage.iamnotARobotCheckBox()));
		submitarequestpage.iamnotARobotCheckBox().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		submitarequestpage.submitBtn().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		submitarequestpage.submitARequestSuccessMessage().click();
		String expectedText = "Case created successfully.";
		String actualText = submitarequestpage.submitARequestSuccessMessage().getText();
		Assert.assertEquals(actualText,expectedText);
		ExtentTestManager.getTest().log(Status.INFO, "Request is created successfully"); */
		ExtentTestManager.getTest().log(Status.INFO, "Step2:TC1_submit a request test case is Passed");
		
}
	
	@DDDataProvider(datafile = "testdata/Team4Testdata.xlsx", sheetName = "SubmitRequestPage",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)	
    public void TC2_findallLinks_submitRequestPage(Hashtable<String, String> datatable) throws Exception{
	VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
	ExtentTestManager.getTest().log(Status.INFO, "login tstcase");
	Thread.sleep(1000);
	LoginPage loginPage = new LoginPage(driver);
	loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
	VideoRecorder_utlity.stopRecord();//End point of video recording
		
	SubmitARequestPage submitarequestpage = new  SubmitARequestPage(driver);
	submitarequestpage.signInBtn().click();
	submitarequestpage.submitARequestLink().click();
	//Store all the "a" tagname WebElements to links variable.
    java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
    System.out.println(links.size());
    //Iterate over all the "links" WebElements using java for-each loop
    for (WebElement link : links) {
        //print the text of each link variable using Selenium's getText() method.
        System.out.println(link.getText());
    }
    ExtentTestManager.getTest().log(Status.INFO, "TC2_find all links in submit request page test case is Passed ");
	}
    @DDDataProvider(datafile = "testdata/Team4Testdata.xlsx", sheetName = "SubmitRequestPage",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)	
    public void TC3_helpmessage_submitRequestPage(Hashtable<String, String> datatable) throws Exception{
	VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
	ExtentTestManager.getTest().log(Status.INFO, "login tstcase");
	Thread.sleep(1000);
	LoginPage loginPage = new LoginPage(driver);
	loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
	VideoRecorder_utlity.stopRecord();//End point of video recording
		
	SubmitARequestPage submitarequestpage = new  SubmitARequestPage(driver);
	submitarequestpage.signInBtn().click();
	submitarequestpage.submitARequestLink().click(); 
	submitarequestpage.helpmessage().click();
	String ActualText=(submitarequestpage.helpmessage().getText());
	System.out.println(ActualText);
	String ExpectedText="We’re here to help you! Please provide us with as much information as possible in the fields below. The more detailed your request, the faster our Customer Care Team will be able to assist you.";
	if(ActualText==ExpectedText) {
		System.out.println("help meaage is displayed correctly");
	}
	ExtentTestManager.getTest().log(Status.INFO, "TC3_help message test case is passed");
	
	
	
	
}
}
		
	