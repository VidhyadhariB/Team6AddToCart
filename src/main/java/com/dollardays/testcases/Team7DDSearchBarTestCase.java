package com.dollardays.testcases;




import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

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


public class Team7DDSearchBarTestCase extends BaseTest{
	
@DDDataProvider(datafile = "testdata/Team7Testdata.xlsx", sheetName = "SearchBar" , testcaseID = "", runmode = "Yes" )
@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
public void SearchWithProductname(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException {
System.out.println(datatable.get("TestCase"));
//ExtentTestManager.getTest().log(Status.PASS, "Testcase: Verify Searchbar ");
ExtentTestManager.getTest().log(Status.PASS, "Testcase: " + (datatable.get("TCID"))+ "-----"+(datatable.get("TestCase")));
LoginPage loginPage = new LoginPage(driver);
loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
Thread.sleep(1000);
Team7DDSearchPage searchpage = new Team7DDSearchPage(driver);
String defaulttext = searchpage.getDefaultsearchtext().getAttribute("placeholder");
System.out.println("Default text displayed in searcbar is :" +defaulttext);
ExtentTestManager.getTest().log(Status.PASS, "Step 2: Deafaul Search Bar Text displayed is:: " +defaulttext);
searchpage.getSearchBar().sendKeys(datatable.get("ProductName"));
ExtentTestManager.getTest().log(Status.PASS,"Step 3: The Product name entered in search is : "+datatable.get("ProductName"));
WebDriverWait wait = new WebDriverWait(driver,30);
wait.until(ExpectedConditions.visibilityOf( searchpage.getSearchAutoSuggestion()));		
ExtentTestManager.getTest().log(Status.PASS,"Step 4: Successfully Autosuggestionbox displayed");
searchpage.getsearchBtn().click();
ExtentTestManager.getTest().log(Status.PASS, "Step 5 : clicked on the search button");
Thread.sleep(500);
System.out.println("Total no.of Results displayed are : " +searchpage.CategoryCountValue());
ExtentTestManager.getTest().log(Status.PASS, "INFO:Total Number of items displayed are: " +searchpage.CategoryCountValue());
loginPage.getUserDrodown().click();
Thread.sleep(1000);
loginPage.getLogoutBtn().click();
ExtentTestManager.getTest().log(Status.PASS, "Step 6: Clicked on LogOut");

}

@DDDataProvider(datafile = "testdata/Team7TestData.xlsx", sheetName = "SearchBar",  testcaseID = "TC7", runmode = "No")
@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
public void SearchWithInvalidDta(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
	ExtentTestManager.getTest().log(Status.PASS, "Testcase : Verify Search functionality with Invalid data");
	LoginPage loginPage = new LoginPage(driver);
	ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
	loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
	Thread.sleep(1000);
	Team7DDSearchPage searchpage = new Team7DDSearchPage(driver);	
	searchpage.getSearchBar().sendKeys(datatable.get("ProductName"));
	ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Successfully entered search value in the search bar");
	
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


}
