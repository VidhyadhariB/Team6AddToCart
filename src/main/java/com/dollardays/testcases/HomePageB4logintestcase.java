package com.dollardays.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.HomePageB4login;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;



public class HomePageB4logintestcase extends BaseTest{
	
	HomePageB4login Home;
	
	@Test(priority=1)
	public void WishlistimgTest() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "WishlistimgClickTestcase");
		Thread.sleep(1000);
		Home= new HomePageB4login(driver);//Create an obj reference for HomepageB4login as Home
		 boolean flag=Home.verifyWishlistimg();// call predefined method from Homepage B4login element method
		Assert.assertTrue(flag);// test case comparison line
		ExtentTestManager.getTest().log(Status.PASS, "Wishlist Drp-Dwn Menu successfully displayed");
	}
	
	@Test(priority=2)
	public void WLLearnMorePageTitleTest() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "LearnMoreSubmenuClickTestcase");
		Thread.sleep(1000);
		Home= new HomePageB4login(driver);
		String title=Home.validateWLLearnMoreTitle();
		Assert.assertEquals(title,"Wishlist");	
		ExtentTestManager.getTest().log(Status.PASS, "Navigated to Wishlist Page");
	}
	@Test(priority=3)
	public void CreateawishlistPageTitleTest() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "CreateaWishlistSubmenuClickTestcase");
		Thread.sleep(1000);
		Home= new HomePageB4login(driver);
		String title=Home.validateCreateaWishlistTitle();
		Assert.assertEquals(title,"Login or Register - DollarDays");
		ExtentTestManager.getTest().log(Status.PASS, "Navigated to Sitelogin Page");
	}
	@Test(priority=4)
	public void DonatetodayPageTitleTest() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "DonateTodaySubmenuClickTestcase");
		Thread.sleep(1000);
		Home= new HomePageB4login(driver);
		String title=Home.validateWLDonatetodayTitle();
		Assert.assertEquals(title,"Wishlist");
		ExtentTestManager.getTest().log(Status.PASS, "Navigated to Wishlist Page");
	}
}
