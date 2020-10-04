package com.dollardays.testcases;

	import java.io.UnsupportedEncodingException;
	import java.security.GeneralSecurityException;
	import java.util.Hashtable;

	import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

	import com.aventstack.extentreports.Status;
	import com.dollardays.commons.Base64;
	import com.dollardays.listners.ExtentTestManager;
	import com.dollardays.pages.LoginPage;
	import com.dollardays.pages.Team7DDPaginationPage;
	import com.dollardays.pages.Team7DDSearchPage;
	import com.dollardays.pages.Team7DDSortByPage;
	import com.dollardays.utilities.DDDataProvider;
	import com.dollardays.utilities.TestUtil;


	public class Team7DDSortByTestcase extends BaseTest {


	@DDDataProvider(datafile = "testdata/Team7Testdata.xlsx", sheetName = "SortBy&View" , testcaseID = "", runmode = "Yes" )
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void SortBy_View(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException {
	
	System.out.println(datatable.get("TestCase"));
	ExtentTestManager.getTest().log(Status.INFO, "Testcase: " + (datatable.get("TCID"))+ "-----"+(datatable.get("TestCase")));
	
	LoginPage loginPage = new LoginPage(driver);
	loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
	ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
	
	Thread.sleep(1000);
	
	Team7DDSortByPage SortbyPage = new Team7DDSortByPage(driver);
	SortbyPage.getSearchBar().sendKeys(datatable.get("ProductName"));
	ExtentTestManager.getTest().log(Status.PASS,"Step 2: Successfully entered valid product name in the Search Bar :" +datatable.get("ProductName"));
	
	SortbyPage.getsearchBtn().click();
	ExtentTestManager.getTest().log(Status.PASS, "Step 3 : Successfully clicked on the search button");
	Thread.sleep(2000);
	
	SortbyPage.getSortDropDown().click();
	ExtentTestManager.getTest().log(Status.PASS, "Step 4 : Successfully clicked on the SortBy dropdown button");
	Thread.sleep(5000);
	
	SortbyPage.SelectSortBy(datatable.get("SortBy"));
	ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Successfully selected the dropdown Option :" +(datatable.get("SortBy")));
	Thread.sleep(2000);
	
	System.out.println("Selected Sort By Option is:: "+SortbyPage.getSortBy("SortBy"));
	ExtentTestManager.getTest().log(Status.PASS, "Step 6 : Actual Option selected from SortBy dropdown is :" +SortbyPage.getSortBy("SortBy"));
	
	SortbyPage.getViewDropDown().click();
	Thread.sleep(5000);
	ExtentTestManager.getTest().log(Status.PASS, "Step 7: Successfully clicked on the View dropdown button");
	
	SortbyPage.SelectViewBy(datatable.get("ViewBy"));
	ExtentTestManager.getTest().log(Status.PASS, "Step 8 : Successfully clicked on the ViewBy dropdown option:" +(datatable.get("ViewBy")));
	Thread.sleep(5000);
	
	System.out.println("Selected View By Option is:: "+SortbyPage.getViewBy("ViewBy"));
	ExtentTestManager.getTest().log(Status.PASS, "Step 9 : Actual Option selected from SortBy dropdown is :" +SortbyPage.getViewBy("ViewBy"));
	
	ExtentTestManager.getTest().log(Status.PASS, "Step 10 : Total No.of items displayed in the first page are: " +SortbyPage.getPageItemsCount().size());
	Thread.sleep(5000);
	Assert.assertEquals(SortbyPage.getPageItemsCount().size(), Integer.parseInt(datatable.get("ViewBy")),"Total No.of items displayed in first page not equals to the Viewby option selected");
	
		
	loginPage.getUserDrodown().click();
	Thread.sleep(1000);
	
	loginPage.getLogoutBtn().click();
	ExtentTestManager.getTest().log(Status.PASS, "Step 11 : Clicked on LogOut");

	}
	}
