package com.dollardays.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.HomePageB4login;
import com.dollardays.pages.WishlistPageB4login;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class WishlistPageB4loginTestcase extends BaseTest {
	WishlistPageB4login Wishlist;
	@DDDataProvider(datafile = "testdata/testdatateam8.xlsx", sheetName = "Sheet4",  testcaseID = "", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class,priority=8)
	public void VerifysearchbyorganizationtextfieldfunctionalityInvaliddata(Hashtable<String, String> datatable) throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist Searchbar Test Case with Invalid Input");
		WishlistPageB4login Wishlist= new WishlistPageB4login(driver);
		boolean flag=Wishlist.Searchbartest(datatable.get("Input"));
		Assert.assertTrue(flag);
		ExtentTestManager.getTest().log(Status.PASS, "No Matching Wishlist found");
	}
	
	@DDDataProvider(datafile = "testdata/testdatateam8.xlsx", sheetName = "Sheet3",  testcaseID = "", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class,priority=7)
	public void VerifyCityStateandorzipcodefieldfunctionalityInvaliddata(Hashtable<String, String> datatable) throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist City/state/zipcode Searchbar Test Case with Invalid Input");
		WishlistPageB4login Wishlist= new WishlistPageB4login(driver);
		boolean flag=Wishlist.CityStateZipTextfield(datatable.get("Input"));		
		Assert.assertTrue(flag);
		ExtentTestManager.getTest().log(Status.PASS, "No Matching Wishlist found");
	}
		
	@DDDataProvider(datafile = "testdata/testdatateam8.xlsx", sheetName = "Sheet2",  testcaseID = "", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class,priority=9)
	public void VerifyCityStateandorzipcodefieldfunctionalityvaliddata(Hashtable<String, String> datatable) throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Wishlist City/state/zipcode Searchbar Test Case with valid Input");
		WishlistPageB4login Wishlist= new WishlistPageB4login(driver);
		boolean flag=Wishlist.CityStateZipTextfieldValidInput(datatable.get("Input"));
		Thread.sleep(3000);
		Assert.assertTrue(flag);
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.PASS, "Wishlist Results displayed");	
				
	}
	
	@Test(priority=1)
	public void verifyCreateawishlistbtn() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Create a Wishlist Button Test Case ");	
		HomePageB4login Home=new HomePageB4login(driver);
		Home.Wishlistimg().click();
		Thread.sleep(1000);
		Home.WLLearnMore().click();
		Thread.sleep(1000);
		Wishlist =new WishlistPageB4login(driver);
		String title=Wishlist.ValidateCreateawishlistbtn();
		Thread.sleep(1000);
		Assert.assertEquals(title, "Login or Register - DollarDays");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Create a Wishlist Button Works as expected");	
	}
	
	@Test(priority=2)
	public void VerifyViewallprojectsbutton() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Verify Viewall projects button Test Case ");	
		HomePageB4login Home=new HomePageB4login(driver);
		Home.Wishlistimg().click();
		Thread.sleep(1000);
		Home.WLLearnMore().click();
		Thread.sleep(1000);
		Wishlist =new WishlistPageB4login(driver);
		Thread.sleep(1500);
		boolean flag=Wishlist.InspectViewallprojectsbtn();
		Thread.sleep(1000);
		Assert.assertTrue(flag);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "All project Ads displayed");	
		
	}
	
	@Test(priority=3)
	public void InspectAnnArborPublicSchoolsadDonatenowbtn() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Test case to test Donate Now Button in Ann Arbor Public Schools ad ");	
		HomePageB4login Home=new HomePageB4login(driver);
		Home.Wishlistimg().click();
		Thread.sleep(1000);
		Home.WLLearnMore().click();
		Thread.sleep(1000);
		Wishlist =new WishlistPageB4login(driver);
		String title=Wishlist.InspectDonateNowbtnAnn();
		Thread.sleep(1000);
		Assert.assertEquals(title, "Wish List for Ann Arbor Public Schools");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Clicking on Donatenow navigated to aaps Wishlist page");	
		
	}
	
	@Test(priority=4)
	public void InspectEdicationreliefpacksadDonatenowbtn() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Test case to test Donate Now Button in Education Relief Packs ad ");	
		HomePageB4login Home=new HomePageB4login(driver);
		Home.Wishlistimg().click();
		Thread.sleep(1000);
		Home.WLLearnMore().click();
		Thread.sleep(1000);
		Wishlist =new WishlistPageB4login(driver);
		String title=Wishlist.InspectDonDonateNowbtnEf();
		Thread.sleep(1000);
		Assert.assertEquals(title, "Wish List for Arlington Kiwanis Foundation");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Clicking on Donatenow navigated to educationrelief Wishlist page");	
	}
	
	@Test(priority=5)
	public void InspectPolkcountrymidschooladDonatenowbtn() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Test case to test Donate Now Button in Polk County Middle School 7th Grade ad ");	
		HomePageB4login Home=new HomePageB4login(driver);
		Home.Wishlistimg().click();
		Thread.sleep(1000);
		Home.WLLearnMore().click();
		Thread.sleep(1000);
		Wishlist =new WishlistPageB4login(driver);
		String title=Wishlist.InspectDonateNowbtnPCMS();
		Thread.sleep(1000);
		Assert.assertEquals(title, "Wish List for Polk County Middle School 7th Grade");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Clicking on Donatenow navigated to 7thgradepcmsupplies Wishlist page");	
	}
	@Test(priority=6)
	public void VerifyWishlistcartbuttontestcase() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Test case to test Wishlistcart submenu in wishlist Dropdown");	
		HomePageB4login Home=new HomePageB4login(driver);
		Home.Wishlistimg().click();
		Thread.sleep(1000);
		Home.WLLearnMore().click();
		Thread.sleep(1000);
		Wishlist =new WishlistPageB4login(driver);
		Thread.sleep(1500);
		String title=Wishlist.VerifyWishlistcartbtn();
		Thread.sleep(1500);
		Assert.assertEquals(title, "Wish List cart for Polk County Middle School 7th Grade");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Clicking on wishlist cart submenu navigated to Wishlist Acrt Page");
	}
	

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

