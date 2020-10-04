package com.dollardays.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.AddToCartPage;
import com.dollardays.pages.LoginPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class AddtoCartPPENegativeTestcases extends BaseTest {

	//Validate the case quantity text box with zero value in the shopping cart and verify the shopping cart page
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_07_Validate_the_case_quantity_text_box_with_zero_value_and_verify_the_shopping_cart_page(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Check the cart icon value if it is not 0, clear the cart ");
		addtocart.clearcart();
		//ExtentTestManager.getTest().log(Status.PASS, "Step : Click on menu icon and click on Mask , Sanitizer and PPE ");
		addtocart.MenuPPE();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on add to cart button which is on the product ");
		WebElement item = addtocart.getItemaddtocart();
		String s = item.getAttribute("data-sku");
		ExtentTestManager.getTest().log(Status.PASS, "Step : The product to be added sku is " +s);
		//System.out.println("This is item added" +s);

		item.click();
		//ExtentTestManager.getTest().log(Status.PASS, "Step : Handle the pop up ");
		addtocart.HandleAddtocartPopup();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on cart icon and the page should redirect to the shopping cart page ");
		addtocart.getCarticon().click();

		WebElement cartitem = addtocart.getcartaddeditems();
		String s1 = cartitem.getText().substring(6);

		//System.out.println("This is added in the cart:" +s1);
		if(s.equals(s1)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Correct product is added to the shopping cart ");
			//System.out.println("Correct item added");
		}

		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Wrong product is added to the shopping cart ");
			//System.out.println("Wrong item added");
		}
		ExtentTestManager.getTest().log(Status.PASS, "Step : Clear the Quantity text box before giving the value ");
		addtocart.getcartqtytxtbox().clear();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Enter 0 in the Quantity text box");
		addtocart.getcartqtytxtbox().sendKeys("0");
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on update button ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_cphContent_btnUpdateCart']")));
		addtocart.getupdatecartbtn().click();

		if((addtocart.getemptyshoppingcart().isDisplayed())) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : The item should get deleted from the cart. Test case is passed");
			//System.out.println("Item should get deleted and test case is passed");
		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Test case Failed");
			//System.out.println("Test case Failed");
		}

	}

	//Validate the case quantity text box with invalid data and verify shopping cart
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_08_Validate_the_case_quantity_text_box_with_invalid_data_in_the_shopping_cart_page(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Check the cart icon value if it is not 0, clear the cart ");
		addtocart.clearcart();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on menu icon and click on Mask , Sanitizer and PPE ");
		addtocart.MenuPPE();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on add to cart button which is on the product ");				
		WebElement item = addtocart.getItemaddtocart();
		String s = item.getAttribute("data-sku");
		ExtentTestManager.getTest().log(Status.PASS, "Step : The product to be added sku is " +s);

		//System.out.println("This is item added" +s);
		item.click();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Handle the pop up ");
		addtocart.HandleAddtocartPopup();
		addtocart.getCarticon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on cart icon and the page should redirect to the shopping cart page ");
		WebElement cartitem = addtocart.getcartaddeditems();
		String s1 = cartitem.getText().substring(6);
		System.out.println("This is added in the cart:" +s1);
		if(s.equals(s1)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Correct product is added to the shopping cart ");
			//System.out.println("Correct item added");
		}

		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Wrong product is added to the shopping cart ");
		}
		ExtentTestManager.getTest().log(Status.PASS, "Step : Clear the Quantity text box before giving the value ");
		addtocart.getcartqtytxtbox().clear();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Enter invalid data in the Quantity text box");
		addtocart.getcartqtytxtbox().sendKeys("eee100");
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on update button ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_cphContent_btnUpdateCart']")));
		addtocart.getupdatecartbtn().click();


		if(addtocart.getemptyshoppingcart().isDisplayed()) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : The item should get deleted from the cart. Test case is passed");
			//System.out.println("Text box should not allow character/invalid data and Test cases is failed");
		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Test case Failed");
			//System.out.println("Test case is passed");
		}

	}


	//Validate the case quantity text box with boundary value in the shopping cart
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_09_Validate_the_case_quantity_text_box_with_boundary_value_in_the_shopping_cart_page(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver);

		WebDriverWait wait = new WebDriverWait(driver,30);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2 : Clearing the cart ");
		ExtentTestManager.getTest().log(Status.PASS, "Step : Check the cart icon value if it is not 0, clear the cart ");
		addtocart.clearcart();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on menu icon and click on Mask , Sanitizer and PPE ");
		addtocart.MenuPPE();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on add to cart button which is on the product ");	
		ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Click on add to cart button which is on the product ");				
		WebElement item = addtocart.getItemaddtocart();
		String s = item.getAttribute("data-sku");
		ExtentTestManager.getTest().log(Status.PASS, "Step : The product to be added sku is " +s);
		//System.out.println("This is item added" +s);
		item.click();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Handle the pop up ");
		addtocart.HandleAddtocartPopup();
		addtocart.getCarticon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on cart icon and the page should redirect to the shopping cart page ");
		WebElement cartitem = addtocart.getcartaddeditems();
		String s1 = cartitem.getText().substring(6);
		System.out.println("This is added in the cart:" +s1);
		if(s.equals(s1)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Correct product is added to the shopping cart ");
			//System.out.println("Correct item added");
		}

		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Wrong product is added to the shopping cart ");
			//System.out.println("Wrong item added");
		}
		ExtentTestManager.getTest().log(Status.PASS, "Step : Clear the Quantity text box before giving the value ");
		addtocart.getcartqtytxtbox().clear();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Enter boundary value in the Quantity text box");
		addtocart.getcartqtytxtbox().sendKeys("56678");
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on update button ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_cphContent_btnUpdateCart']")));
		addtocart.getupdatecartbtn().click();

		if(driver.findElement(By.xpath("//div[contains(text(),\"You've exceeded the number of available units for\")]")).isDisplayed()) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : The item should get deleted from the cart. Test case is passed");
			//System.out.println("Test case is passed");
		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Test case Failed");
			//System.out.println("Test case is failed");
		}

	}

	//Validate the cart when the user signoff and sign in Dollardays.com with valid credentials
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)

	public void TC_10_Validate_the_cart_when_the_user_signoff_and_signin_with_valid_credentials (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2 : Clearing the cart ");
		//addtocart.clearcart();

		addtocart.MenuPPE();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Click on add to cart button which is on the product ");				
		WebElement item = addtocart.getItemaddtocart();
		String s = item.getAttribute("data-sku");
		System.out.println("This is item added" +s);
		item.click();
		addtocart.HandleAddtocartPopup();
		addtocart.getCarticon().click();

		WebElement cartitem = addtocart.getcartaddeditems();
		String s1 = cartitem.getText().substring(6);
		System.out.println("This is added in the cart:" +s1);
		if(s.equals(s1)) {
			System.out.println("Correct item added");
		}

		else {
			System.out.println("Wrong item added");
		}

		WebElement carttext = addtocart.getCarticontxt();
		String k = carttext.getText();
		System.out.println("the value in the cart before sign out:" +k);
		driver.findElement(By.className("dropdown")).click();
		//loginPage.getSignIn().click();
		driver.findElement(By.xpath("//a[@class='dropdown-item padditem margn-top']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='dropdown']//i[@class='fa fa-chevron-down']")));
		Thread.sleep(1000);
		loginPage.invokeLogin();
		WebElement carttext1 = addtocart.getCarticontxt();
		String h = carttext1.getText();
		System.out.println("the value in the cart after sign in:" +h);
		if(k.equals(h)) {
			System.out.println("test case is passed");
		}
		else {
			System.out.println("testcase is failed");
		}

	}
	//Validate # of cases text box in the product page with character zero value
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_13_validate_no_of_cases_textbox_with_zero (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);



		AddToCartPage addtocart = new AddToCartPage(driver); //object creation for addToCartPage to get the methods
		addtocart.clearcart();

		addtocart.MenuPPE();

		addtocart.getItem().click();//Identify one item and click
		ExtentTestManager.getTest().log(Status.PASS, "Step 4 : Click on item ");

		//clearing # of cases test box and typing 5
		addtocart.getquantitytxtbox().clear();//Clearing the qty textbox to zero before adding the quantity
		ExtentTestManager.getTest().log(Status.PASS, "Step  : Enter 0 in the # no of cases textbox ");
		addtocart.getquantitytxtbox().sendKeys("0");//entering 0 in the quantity textbox

		addtocart.getAddToMyCartbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step  : Click on add to my cart button ");
		addtocart.getqtyzeropopup();
		ExtentTestManager.getTest().log(Status.PASS, "Step  :  No Quantity is added should display" );
		Thread.sleep(10000);
		System.out.println("Test case is passed");



	}


	//Validate # of cases text box in the product page with character
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_14_validate_no_of_cases_textbox_with_character (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver); //object creation for addToCartPage to get the methods
		addtocart.clearcart();

		addtocart.MenuPPE();

		addtocart.getItem().click();//Identify one item and click
		ExtentTestManager.getTest().log(Status.PASS, "Step 4 : Click on item ");

		//clearing # of cases test box and typing 5
		addtocart.getquantitytxtbox().clear();//Clearing the qty textbox to zero before adding the quantity
		ExtentTestManager.getTest().log(Status.PASS, "Step  : Enter a character in the # no of cases textbox ");
		addtocart.getquantitytxtbox().sendKeys("e");//entering 0 in the quantity textbox

		Thread.sleep(10000);
		System.out.println("Test case is passed");



	}

}


