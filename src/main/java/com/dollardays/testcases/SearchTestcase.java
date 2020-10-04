package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
//import java.util.Base64;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.Team7DDSearchPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

import junit.framework.Assert;

public class SearchTestcase extends BaseTest{

	/*
	
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes",productname="Food")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_01_searchWithValidDta(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		SearchPage searchpage = new SearchPage(driver);
		
		searchpage.getSearchBar().sendKeys("backpack");
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		
		String categoryCount = searchpage.getsearchCount().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+categoryCount+"'");
		
		Thread.sleep(500);
		loginPage.getUserDrodown().click();
		Thread.sleep(500);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
	}

	
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_02_searchWithInvalidDta(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 2 : Verify Search functionality with Invalid data");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		SearchPage searchpage = new SearchPage(driver);
		
		searchpage.getSearchBar().sendKeys("ffffgf");
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		
		String nodatafound = searchpage.getnoDataFoundMsg().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+nodatafound+"'");
		
		Thread.sleep(500);
		loginPage.getUserDrodown().click();
		Thread.sleep(500);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
	}
	*/
	
	/*	@DDDataProvider(datafile = "testdata/Team7TestData.xlsx", sheetName = "SearchBar",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void searchPageWithNavigationLinks(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		System.out.println("My Data Table is : " +datatable);
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 3 : Validate Product Navigation Pages ");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		//loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		loginPage.invokeLogin();
		Thread.sleep(1000);
		SearchPage searchpage = new SearchPage(driver);
		String Searchvalue=datatable.get("ProductName");
		searchpage.getSearchBar().sendKeys(Searchvalue);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		try {
			
			searchpage.getItemCount();
			Thread.sleep(1000);
			
		}catch (Exception e) {
			searchpage.getItemCount();
			Thread.sleep(1000);
		}  
		
		
		
	} */
	
/*	@DDDataProvider(datafile = "testdata/Team7TestData.xlsx", sheetName = "SearchBar",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void searchPageWithNavigationLinks(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		System.out.println("My Data Table is : " +datatable);
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 3 : Validate Product Navigation Pages ");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		//loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		loginPage.invokeLogin();
		Thread.sleep(1000);
		SearchPage searchpage = new SearchPage(driver);
		String Searchvalue=datatable.get("ProductName");
		searchpage.getSearchBar().sendKeys(Searchvalue);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		try {
			
			searchpage.getItemCount();
			Thread.sleep(1000);
			
		}catch (Exception e) {
			searchpage.getItemCount();
			Thread.sleep(1000);

		}
		
}
*/	
	@DDDataProvider(datafile = "testdata/Team7Testdata.xlsx", sheetName = "SearchBar" , testcaseID = "TC1", runmode = "Yes" )
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_01_SearchWithValidProductname(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException {
	//System.out.println(datatable.get("TestCase"));
	ExtentTestManager.getTest().log(Status.PASS, "Testcase: Verify Searchbar ");
	LoginPage loginPage = new LoginPage(driver);
	//ExtentTestManager.getTest().log(Status.PASS, "Step 1: Login with valid Credentials");
	loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
	Thread.sleep(1000);
	Team7DDSearchPage searchpage = new Team7DDSearchPage(driver);
	String Searchvalue = datatable.get("ProductName");
	searchpage.getSearchBar().sendKeys(Searchvalue);
	ExtentTestManager.getTest().log(Status.PASS,"Step 2: Successfully valid product name entered");
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='rfk_search_container']")));
	ExtentTestManager.getTest().log(Status.PASS,"Step 3: Successfully Autosuggestionbox displayed");
	searchpage.getsearchBtn().click();
	ExtentTestManager.getTest().log(Status.PASS, "Step 4 : clicked on the search button");
	Thread.sleep(500);
	String Cnt = searchpage.CategoryCountValue();
	System.out.println("Total no.of Results displayed are : " + Cnt);
	loginPage.getUserDrodown().click();
	Thread.sleep(1000);
	loginPage.getLogoutBtn().click();
	ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Clicked on LogOut");

	}
	
}


