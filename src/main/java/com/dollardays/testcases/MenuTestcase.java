package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.MenuPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;
public class MenuTestcase extends BaseTest{
		
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class, enabled=true, priority=1)//checking if all the menu items display correctly
	public void verifyMenuItemsTest(Hashtable<String, String> hash) throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		MenuPage menuPage = new MenuPage(driver);
		
		ExtentTestManager.getTest().log(Status.PASS, "Test Case 1: Main Menu Section");
		menuPage.clickMenuButton(); 
		menuPage.verifyNowTrendingLabel();	
		ExtentTestManager.getTest().log(Status.PASS,"Step 1: Verify Now Trending Label displays on main menu");
		
		menuPage.verifyBackToSchoolLabel();	
		ExtentTestManager.getTest().log(Status.PASS,"Step 2: Verify Back To School Label displays on main menu");
		
		menuPage.verifyMaskSanitizerPPELabel();
		ExtentTestManager.getTest().log(Status.PASS,"Step 3: Verify Mask Sanitizer and PPE Label displays on main menu");
		
		menuPage.forwardBackpacksLabel();
		ExtentTestManager.getTest().log(Status.PASS,"Step 4: Verify Forward Backpacks Label displays on main menu");
		
		menuPage.verifyCatagoriesLabel();
		menuPage.verifyBabyLabel();
		menuPage.verifyBackpacksLabel();
		menuPage.verifyClothingShoesLabel();
		menuPage.verifyElectronicsLabel();
		menuPage.verifyFoodLabel();
		menuPage.verifyHardwareToolsOutdoorsLabel();
		menuPage.verifyHolidayPartyLabel();
		menuPage.verifyHomeKitchenLabel();
		menuPage.verifyPersonalCareLabel();
		menuPage.verifyPetSuppliesLabel();
		menuPage.verifyPPEMasksLabel();
		menuPage.verifySchoolOfficeLabel();
		menuPage.verifyToysGamesLabel();
		menuPage.verifyProgramsLabel();
		menuPage.verifyForNonprofitsLabel();
		menuPage.verifyForEducatorsLabel();
		menuPage.verifyForRetailersLabel();
		menuPage.verifyForEmergencyPreparednessLabel();//
		menuPage.verifyHelpSettingsLabel();
		menuPage.verifyYourAccountLabel();
		menuPage.verifyContactUsLabel();
		menuPage.verifyFAQsLabel();
		menuPage.verifyReturnPolicyLabel();
		menuPage.verifyShippingPolicyLabel();	
		ExtentTestManager.getTest().log(Status.PASS,"Step 5: Verify all Label displays on main menu");
	}
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class, enabled=true, priority=2)//checking if Back To School page displays correctly
	public void verifyBackToSchoolTest(Hashtable<String, String> hash) throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		MenuPage menuPage = new MenuPage(driver);		
		ExtentTestManager.getTest().log(Status.PASS, "Test Case 2: Verify after clicking on Back to School Label user lands on the correct page");
		menuPage.clickMenuButton();
		menuPage.clickBackToSchool();
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on Back to School label on main menu");
		
		Assert.assertEquals(driver.getTitle(), "Wholesale School & Office Supplies – Bulk School Supplies - DollarDays","School & Office doesn't display");
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Verify after clicking on Back to School user lands on the correct page");
	}
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class, enabled=true, priority=3)//checking if Mask Sanitizer PPE page displays correctly
	public void verifyMaskSanitizerPPETest(Hashtable<String, String> hash) throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		
		ExtentTestManager.getTest().log(Status.PASS, "Test Case 3: Verify after clicking on Mask, Sanitizer and PPE Label user lands on the correct page");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(hash.get("UserName"), Base64.decrypt(hash.get("Password")));
		MenuPage menuPage = new MenuPage(driver);
		menuPage.clickMenuButton();
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on Menu button");		
	
	    menuPage.clickMaskSanitizerPPE();
		Assert.assertEquals(driver.getTitle(), "PPE & Masks - DollarDays","PPE & Masks - DollarDays doesn't display");
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Verify after clicking on Mask, Sanitizer and PPE user lands on the correct page");
	}
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class, enabled=true, priority=4)//checking if Forward Backpacks page displays correctly
	public void verifyForwardBackpacksTest(Hashtable<String, String> hash) throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		
		ExtentTestManager.getTest().log(Status.PASS, "Test Case 4: Verify after clicking on Forward Backpacks Label user lands on the correct page");
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.clickMenuButton();
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on Menu button");		
	
	    menuPage.clickForwardBackpacks();
		Assert.assertEquals(driver.getTitle(), "Wholesale Forward™ Backpacks - DollarDays","ForwardBackpacks doesn't display");
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Verify after clicking on Forward Backpacks user lands on the correct page");
	}
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class, enabled=true, priority=5)//checking if clicking on Baby displays Baby sub menu correctly
	public void verifyBabyTest(Hashtable<String, String> hash) throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		
		ExtentTestManager.getTest().log(Status.PASS, "Test Case 5: Verify after clicking on Baby Label submenu displays correctly");
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.clickMenuButton();
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on Menu button");		
	
	    menuPage.clickBaby();
	    Assert.assertTrue(menuPage.getBabyOnSubMenuBabyLabel().isDisplayed(),"Baby sub menu doesn't display");//verify Baby element displays on the sub menu page
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Verify after clicking on Baby Label submenu displays correctly");
	}
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class, enabled=true, priority=6)//checking if FAQ page displays correctly
	public void verifyfAQsTest(Hashtable<String, String> hash) throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		
		ExtentTestManager.getTest().log(Status.PASS, "Test Case 6: Verify after clicking on FAQs Label user lands on the correct page");
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.clickMenuButton();
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on Menu button");		
	
	    menuPage.clickfAQs();
	    Assert.assertEquals(driver.getTitle(),"FAQs - DollarDays","FAQs page doesn't display");
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Verify after clicking on FAQs user lands on the correct page");
	}
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class, enabled=true, priority=7)//checking if elements on FAQ page displays correctly
	public void verifyElementsOnfAQsTest(Hashtable<String, String> hash) throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		
		ExtentTestManager.getTest().log(Status.PASS, "Test Case 7: Verify after clicking on fAQs from main menu, the FAQs page displays all the elements correctly");
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.clickMenuButton();
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on Menu button");		
	
	    menuPage.clickfAQs();
	    Thread.sleep(1000);
	    Assert.assertTrue((driver.findElement(By.xpath("//h2[contains(text(),'Account')]")).isDisplayed()),"Account label not visible");//account label
		Assert.assertTrue((driver.findElement(By.xpath("//h2[contains(text(),'Orders')]")).isDisplayed()),"Orders label not visible");//Orders label
		Assert.assertTrue((driver.findElement(By.xpath("//h2[contains(text(),'Payments')]")).isDisplayed()),"Payments label not visible");//Payments label
		Assert.assertTrue((driver.findElement(By.xpath("//h2[contains(text(),'Shipping')]")).isDisplayed()),"Shipping label not visible");//Shipping label
		Assert.assertTrue((driver.findElement(By.xpath("//h2[contains(text(),'Drop-shipping')]")).isDisplayed()),"Drop-shipping label not visible");//Drop-shipping label
		Assert.assertTrue((driver.findElement(By.xpath("//h2[contains(text(),'California Proposition')]")).isDisplayed()),"California Proposition 65 label not visible");//California Proposition 65 label
		Assert.assertTrue((driver.findElement(By.xpath("//h2[contains(text(),'Wishlist')]")).isDisplayed()),"Wishlist label not visible");//Wishlist label
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Verify the FAQs page displays all the elements correctly");
	}
}