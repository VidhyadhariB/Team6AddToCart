package com.dollardays.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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



public class AddToCartPPETestcase extends BaseTest {

	//Validate clear cart hyper link in the shopping cart page
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_23_validate_clear_cart_hyperlink_in_the_shopping_cart_page (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Login with Valid credentials");
		loginPage.invokeLogin();//Login 
		//loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver); //object creation for addToCartPage to get the methods
		addtocart.clearcart();
		ExtentTestManager.getTest().log(Status.PASS, "Step  : Clear the shopping cart  ");

	

		//Validatin the shopping cart
		if(driver.findElement(By.xpath("//h1[contains(text(),'Your Shopping Cart is empty.')]")).isDisplayed())
			ExtentTestManager.getTest().log(Status.PASS, "Step  : Cart is cleared successfully and test case is passed");
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step  : Cart is not cleared and test case is failed");
		}

	}

	//Validate the user is able to add one item to the cart from PPE and Mask category through product page and verify cart icon
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddToCartPPE",  testcaseID = "TC1", runmode = "yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_22_validate_the_user_is_able_to_add_one_item_from_ppe_category_throught_product_page_and_verify_cart_icon(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Login with Valid credentials");
		//loginPage.invokeLogin();
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);


		AddToCartPage addtocart = new AddToCartPage(driver);
		addtocart.clearcart();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		addtocart.MenuPPE();

		WebElement item1 = addtocart.getItem();
		String s = item1.getAttribute("data-sku");
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on product and page should redirect to product page " +s);
		item1.click();


		addtocart.getAddToMyCartbtn().click();	//Identify add to my cart button and click
		
		addtocart.HandleAddtocartPopup();

		addtocart.getCarticon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step  : Click on cart icon and should redirect to shopping cart page ");//Identify cart icon and click
		WebElement cartitem = addtocart.getcartaddeditems();
		String s1 = (cartitem.getText()).substring(6);
		//Validating the product added in the cart
		System.out.println("The item in the cart" +s1);
		if(s.equals(s1)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step  : Correct product added to the shopping cart. The test case is passed");
			//System.out.println("Correct item added");
		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step  : Wrong product placed in the shopping cart.Test case is failed");
			//System.out.println("Wrong item added");
		}

		
		

	}

	//Validate the user is able to add one item to the cart from PPE and Mask category and verify cart icon
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_21_Validate_the_user_is_able_to_add_one_item_to_the_cart_from_PPE_and_Mask_category_and_verify_cart_icon (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Clear the cart");
		addtocart.clearcart();
		addtocart.MenuPPE();
				WebElement item = addtocart.getItemaddtocart();
		String s = item.getAttribute("data-sku");
		item.click();
		addtocart.HandleAddtocartPopup();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on cart icon and should redirect to shopping cart page");
		addtocart.getCarticon().click();

		WebElement cartitem = addtocart.getcartaddeditems();
		String s1 = cartitem.getText().substring(6);
		
		if(s.equals(s1)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Correct product added in the shopping cart. Test case is passed");
			//System.out.println("Correct item added");
		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Wrong product placed in shopping cart. Test case is failed");
			//System.out.println("Wrong item added");
		}


	}


	//Validate the user is able to add multiple items to the cart from PPE and Mask page and verify the cart icon
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_04_validate_the_user_is_able_to_add_multiple_items_from_PPE_and_Mask_page_and_verify_shopping_cart (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver); //object creation for addToCartPage to get the methods
		ExtentTestManager.getTest().log(Status.PASS, "Step : Clear the cart ");
		addtocart.clearcart();
		
		addtocart.MenuPPE();
		List<WebElement> multipleitems = new ArrayList<WebElement>();
		multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[1]/div/div[2]/div/input[5]")));
		multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[2]/div/div[2]/div/input[5]")));
		multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[6]/div/div[2]/div/input[5]")));
		multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[7]/div/div[2]/div/input[5]")));
		List<String> skus = new ArrayList<String>();
		for(WebElement text:multipleitems) {
			
			skus.add(text.getAttribute("data-sku"));
			Thread.sleep(1000);
			ExtentTestManager.getTest().log(Status.PASS, "Step : click on one item to be added to the cart");
			text.click();
			Thread.sleep(1000);
			
			addtocart.HandleAddtocartPopup();

		}
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on cart icon and the page should redirect to shopping cart page");
		addtocart.getCarticon().click();
		List<WebElement>cartitems = new ArrayList<WebElement>();
		cartitems.addAll(driver.findElements(By.xpath("//*[contains(text(),'SKU #')]")));
		List<String> cartskus = new ArrayList<String>();
		for(WebElement cartitemtext:cartitems) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : The products added in the shopping and and their corresponding SKU's " +cartitemtext.getText());
			//System.out.println("This is cart" +cartitemtext.getText());
			cartskus.add((cartitemtext.getText()).substring(6));
			Thread.sleep(1000);
		}
		Collections.sort(skus);
		Collections.sort(cartskus);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Correct Products added in the shopping cart page. Test case is passed" );//+(skus.equals(cartskus))
		//System.out.println(skus.equals(cartskus));
	}


	//Validate update cart hyper link in the shopping cart page
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_05_Validate_update_cart_hyper_link_in_the_shopping_cart_page (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);



		AddToCartPage addtocart = new AddToCartPage(driver); //object creation for addToCartPage to get the methods
		ExtentTestManager.getTest().log(Status.PASS, "Step : Clear the cart ");
		addtocart.clearcart();
		//ExtentTestManager.getTest().log(Status.PASS, "Step : Click on menu icon and click on Mask , Sanitizer and PPE ");
		addtocart.MenuPPE();
		List<WebElement> multipleitems = new ArrayList<WebElement>();
		multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[1]/div/div[2]/div/input[5]")));
		multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[2]/div/div[2]/div/input[5]")));
		multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[6]/div/div[2]/div/input[5]")));
		multipleitems.add(driver.findElement(By.xpath("//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[7]/div/div[2]/div/input[5]")));
		List<String> skus = new ArrayList<String>();
		for(WebElement text:multipleitems) {
			
			//System.out.println("This is" + text.getAttribute("data-sku"));
			skus.add(text.getAttribute("data-sku"));
			Thread.sleep(1000);
			ExtentTestManager.getTest().log(Status.PASS, "Step : Click on one items");
			text.click();
			Thread.sleep(1000);
			//ExtentTestManager.getTest().log(Status.PASS, "Step : Pop up is handled");
			addtocart.HandleAddtocartPopup();

		}

		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on cart icon and the page should redirect to shopping cart page");
		addtocart.getCarticon().click();
		List<WebElement>cartitems = new ArrayList<WebElement>();
		cartitems.addAll(driver.findElements(By.xpath("//*[contains(text(),'SKU #')]")));
		List<String> cartskus = new ArrayList<String>();
		for(WebElement cartitemtext:cartitems) {
			//ExtentTestManager.getTest().log(Status.PASS, "Step : The products added in the shopping and and their corresponding SKU's " +cartitemtext.getText());
			//System.out.println("This is cart" +cartitemtext.getText());
			cartskus.add((cartitemtext.getText()).substring(6));
			Thread.sleep(1000);
		}
		Collections.sort(skus);
		Collections.sort(cartskus);
		//ExtentTestManager.getTest().log(Status.PASS, "Step : Correct Products added in the shopping cart page. Test case is passed" +(skus.equals(cartskus)));
		//System.out.println(skus.equals(cartskus));


		List<WebElement>qtytxtbox = new ArrayList<WebElement>();
		qtytxtbox.addAll(driver.findElements(By.xpath("//*[@class='form-quantity']")));
		List<Integer> count = new ArrayList<Integer>();
		int i=5;
		for(WebElement qty:qtytxtbox) {
			System.out.println("The value of  qty text boxes" +Integer.parseInt(qty.getAttribute("value")));
			qty.clear();

			qty.sendKeys(Integer.toString(i));
			i++;
			//System.out.println("the value given in the text boxes " +Integer.parseInt(qty.getAttribute("value")));
		}
		driver.findElement(By.xpath("//input[@id='ctl00_cphContent_btnUpdateCart']")).click();


		qtytxtbox.clear();
		qtytxtbox.addAll(driver.findElements(By.xpath("//*[@class='form-quantity']")));
		for(WebElement qty:qtytxtbox) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : The quantity text box in the shopping cart page is edited and click on update cart . The values in each qty is  " +Integer.parseInt(qty.getAttribute("value")));
			//System.out.println("The updated value of  qty text boxes" +Integer.parseInt(qty.getAttribute("value")));
		}
	}


	//Validate the case quantity in the shopping cart page
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_06_Validate_the_case_quantity_text_box_with_valid_data_in_the_shopping_cart_page(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Clear the cart ");
		addtocart.clearcart();

		//ExtentTestManager.getTest().log(Status.PASS, "Step : Click on menu icon and click on Mask , Sanitizer and PPE ");
		addtocart.MenuPPE();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on add to cart button which is on the product ");				
		WebElement item = addtocart.getItemaddtocart();
		String s = item.getAttribute("data-sku");
		//ExtentTestManager.getTest().log(Status.PASS, "Step : The product to be added sku is " +s);
		//System.out.println("This is item added" +s);
		item.click();
		//ExtentTestManager.getTest().log(Status.PASS, "Step : Handle the pop up ");
		addtocart.HandleAddtocartPopup();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on cart icon and the page should redirect to the shopping cart page ");
		addtocart.getCarticon().click();

		WebElement cartitem = addtocart.getcartaddeditems();
		String s1 = cartitem.getText().substring(6);
		System.out.println("This is added in the cart:" +s1);
		if(s.equals(s1)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Verifying the cart shopping page ");
			//System.out.println("Correct item added");
		}

		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Wrong product added tot he shopping cart");
			//System.out.println("Wrong item added");
		}
		ExtentTestManager.getTest().log(Status.PASS, "Step : Clear the Quantity text box before giving the valid data ");
		addtocart.getcartqtytxtbox().clear();
		WebElement value = addtocart.getcartqtytxtbox();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Enter 5 in the Quantity text box");
		value.sendKeys("5");
		String a = value.getAttribute("value").substring(1);
		//System.out.println("The quantity given in the Qty txt box : " +a);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on update button ");
		driver.findElement(By.xpath("//*[@class=' btn btn-update']")).click();

		WebElement value2 = addtocart.getcartqtytxtbox();
		String b = value2.getAttribute("value");
		ExtentTestManager.getTest().log(Status.PASS, "Step : The value in the quantity textbox in the shopping cart page is" +b);
		//System.out.println("The value in the qty text box after" +b);
		if(a.equals(b) ) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : quantity textbox is accepting the valid data. Test case is passed ");
			//System.out.println("Case qty text box is accepting valid data and Test case is passed");

		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step : The Quantity text box is not accepting valid data. Test case is failed ");

			//System.out.println("Test case is failed");
		}

	}


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
		addtocart.getupdatebtn().click();
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
		addtocart.getupdatebtn().click();

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
		addtocart.getupdatebtn().click();
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

		loginPage.getSignIn().click();
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

	//Validate # of cases text box in the product page with valid data
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_11_validate_no_of_cases_textbox_with_valid_data (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

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
		ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Enter 5 in the # no of cases textbox ");
		addtocart.getquantitytxtbox().sendKeys("5");//entering 5 in the quantity textbox

		addtocart.getAddToMyCartbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 6 : Click on add to my cart button ");

		//Handle the pop up
		WebDriverWait wait = new WebDriverWait(driver,30);

		addtocart.HandleAddtocartPopup();

		addtocart.getCarticon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 7 : Click on carticon ");
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//a[contains(text(),'Premium 75% Alcohol Wipes')]")).isDisplayed()) {
			System.out.println("Item added to the cart");
		}
		else {
			System.out.println("Wrong item placed in the cart");
		}
	}

	//Validate # of cases text box in the product page with invalid data
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_12_Validate_the_number_of_case_text_box_in_the_product_page(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Identifying menu icon and click
		addtocart.MenuPPE();

		WebElement item1 = addtocart.getItem();
		String s = item1.getAttribute("data-sku");
		System.out.println("The item added" +s);
		item1.click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4 : Click on  product ");
		addtocart.getquantitytxtbox().clear();//Clearing the qty textbox to zero before adding the quantity
		ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Enter 5 in the # no of cases textbox ");

		addtocart.getquantitytxtbox().sendKeys("ffegeh");//entering invalid data in the quantity textbox
		System.out.println("Test case is passed");

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
		Thread.sleep(1000);
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

		Thread.sleep(1000);
		System.out.println("Test case is passed");



	}//Vidhyadhari code
	

	//Rupali Testcases

	//Validate add to cart buy now button from smaller case packs from homepage banner.
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_15_ValidateAddToCart_BuyNow_smallercasepacks(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		AddToCartPage addtocart = new AddToCartPage(driver);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Click on the right arrow on the advertising banner");

		addtocart.getbannerrightarrow().click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Click on the right arrow on the next advertising banner again");

		addtocart.getbannerrightarrow().click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Click Buy Now link on the smallercasepacks advertising banner");

		addtocart.getbuynowbtn().click();
		WebElement item = addtocart.getoneitem();
		String s = item.getAttribute("data-sku");
		System.out.println("Item added in the cart "+s);
		item.click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Click on Add To My Cart");

		addtocart.HandleAddtocartPopup();
		addtocart.getCarticon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 6  : Show the product in the shopping cart");

		WebElement cartitem = addtocart.getcartitem();
		String h = cartitem.getText().substring(6);
		System.out.println("The item added at the cart   "+h);

		cartitem.click();
		if(s.equals(h)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step 7  : Correct item added and Test case is passed");

		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step 8  : Wrong item added and Test case is failed");
		}

		//Thread.sleep(2000);

	}

	//Validate add to cart buy now button from 3 ply face mask from homepage banner.
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_16_ValidateAddToCart_BuyNow_3PlyFaceMask(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		AddToCartPage addtocart = new AddToCartPage(driver);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Click on the right arrow on the banner");

		addtocart.getbannerrightarrow().click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Click Buy Now link on the 3PlyFace Mask advertising banner");

		addtocart.getbuynowbtn().click();
		WebElement item = addtocart.getItem();

		String s = item.getAttribute("data-sku");
		System.out.println("Item added in the cart "+s);
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Click on Add To My Cart");

		item.click();
		addtocart.getAddToMyCartbtn().click();
		addtocart.HandleAddtocartPopup();
		addtocart.getCarticon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Show the product in the shopping cart");

		WebElement cartitem = addtocart.getcartaddeditems();
		String h = cartitem.getText().substring(6);
		System.out.println("The item added at the cart   "+h);

		cartitem.click();
		if(s.equals(h)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step 6  : Correct item added and Test case is passed");

		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step 7  : Wrong item added and Test case is failed");
		}
	}

	//Validate add to cart buy now button from premium alcohol wipes from homepage banner.
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_17_ValidateAddToCart_BuyNow_PremiumAlcoholWipes(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 3 : ValidateAddToCart_FromBuyNow_PremiumAlcoholWipes");

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		AddToCartPage addtocart = new AddToCartPage(driver);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Click Buy Now link on the PremiumAlcoholWipes advertising banner");

		addtocart.getbuynowbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Click on Add To My Cart");

		//addtocart.getAddToMyCartbtn().click();
		WebElement i = addtocart.getitemsku();
		String s = i.getAttribute("data-sku");
		System.out.println("Item to be added to the cart "+s);
		addtocart.getAddToMyCartbtn().click();

		addtocart.HandleAddtocartPopup();
		addtocart.getCarticon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Show the product in the shopping cart");

		WebElement cartitem = addtocart.getaddeditems();
		String h = cartitem.getText().substring(6);
		System.out.println("The item at the cart   "+h);

		cartitem.click();
		if(s.equals(h)) {
			System.out.println("Testcase is passed");
		}
		else {
			System.out.println("Test case is failed");
		}
	}

	//Validate add to my cart button functionality is adding item to the shoping cart when clicking on search bar without entering any text on the dollardays home page
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_18_ValidateAddToCartFromSearchbarWithnoData(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Validate Add To Cart From Searchbar Without entering any Data");
		AddToCartPage addToCart = new AddToCartPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.invokeLogin();
		WebDriverWait wait = new WebDriverWait (driver, 30);

		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Click on Searchbar without any data");
		addToCart.getsearchbar().click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search for items in bulk']")));
		//driver.findElement(By.xpath("//input[@placeholder='Search for items in bulk']")).click();
		//driver.findElement(By.xpath("//div[@class='rfk_results']//li[1]")).click();

		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Click on a selected visible");
		addToCart.getselectedItem().click();
		Thread.sleep(5000);
		AddToCartPage addtocart = new AddToCartPage(driver);
		//driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_divProductInfo\"]/div/div/div[1]/div[3]/div/div[3]/div[1]/div/div/div[3]/button")).click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Click on Add To My Cart button");
		addtocart.getAddToMyCartbtn().click();
		addtocart.HandleAddtocartPopup();

		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Click on Cart icon to verify the item added");
		addToCart.getclickcart().click();
		Thread.sleep(1000);

	}

	//Validate add to my cart button functionality is adding item to the shoping cart when clicking on search bar with valid text on the dollardays home page
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)

	public void TC_19_ValidateAddToCartFromSearchbarWithValidData(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		ExtentTestManager.getTest().log(Status.PASS, "Testcase 2 : ValidateAddToCartFromSearchbarWithValidData");
		AddToCartPage addtocart = new AddToCartPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.invokeLogin();
		WebDriverWait wait = new WebDriverWait (driver, 30);
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Click on Searchbar with valid data ");
		addtocart.getsearchbar().sendKeys("pen");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search for items in bulk']")));

		//WebElement e = driver.findElement(By.xpath("//li[1]//a[1]//div[1]//img[1]"));
		WebElement e = addtocart.getimage1();
		String s = e.getText();
		e.click();

		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Click on an item related to pen");
		addtocart.getselectedItem().click();
		String expectedTitle = "Wholesale Liqui-Mark Ballpoint Pens - 10 Count, Blue, Medium (SKU 2290272) DollarDays";
		String actualTitle = "";
		Thread.sleep(1000);

		// get the actual value of the title
		actualTitle = driver.getTitle();
		// compare the actual title of the page with the expected one and print
		if (actualTitle.contentEquals(expectedTitle)){
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");

		}
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Click on Add To My Cart");
		addtocart.getAddToMyCartbtn().click();
		Thread.sleep(5000);

		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Show the product in the shopping cart");
		addtocart.getclickcart().click();
		Thread.sleep(5000);
	}

	//RajShree Testcases
	
	//Validate Add to cart button without login
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_01_Validate_addtocart_by_clicking_on_buy_nowbutton_from_adv_banner_without_login(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		AddToCartPage addtocart = new AddToCartPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Click on Buy Now button from Advertising Banner   ");
		addtocart.getbuynowbtn().click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.PASS, "Step 2 : Click on log in to buy button . ");

		WebElement i = addtocart.getitemsku();
		String s = i.getAttribute("data-sku");
		System.out.println("Item to be added to the cart "+s);
		addtocart.getlogintobuy().click();

		ExtentTestManager.getTest().log(Status.PASS, "Step 3 : User Sign In with valid credentials.");
		Thread.sleep(1000);

		loginpage.getUsername().sendKeys("vidyancc@gmail.com");
		loginpage.getPassword().sendKeys(Base64.decrypt("c2FpYmFiYTE="));
		loginpage.getLoginBtn().click();

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='cart_newbtn btn dd-btn-secondary btn-quick-view bold jqatc fsig gtmAddCart btn-group-lg']")));
		Thread.sleep(2000);

		ExtentTestManager.getTest().log(Status.PASS, "Step 4 : Click on Add to Cart. ");

		addtocart.getAddToMyCartbtn().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn noreturnmodal-btn dismiss_modal']")));

		addtocart.HandleAddtocartPopup();

		Thread.sleep(3000);

		ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Click on View Cart. ");
		addtocart.getCarticon().click();

		WebElement cartitem = addtocart.getaddeditems();
		String h = cartitem.getText().substring(6);
		System.out.println("The item at the cart   "+h);

		cartitem.click();
		if(s.equals(h)) {
			System.out.println("Testcase is passed");
		}
		else {
			System.out.println("Test case is failed");
		}
	}

	//Shraddha Testcases
	
	//Verify back to school button is working or not by clicking on that
/*	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_21_addtocartvalidate(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		//loginPage.invokeLogin();
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);


		AddToCartPage addtocart = new AddToCartPage(driver);

		addtocart.getMenuIcon().click();

		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Click on main menu");
		Thread.sleep(500);


		addtocart.getbacktoschool().click();
		Assert.assertTrue(driver.getTitle().equals("Wholesale School & Office Supplies – Bulk School Supplies - DollarDays"));
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on back to school menu sucssesfully and displayed back to school stuffs for purchase,School & Office logo,Sort  ");
		Thread.sleep(500);
	}

	//Verify add to cart by adding item in the cart
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_22_addtocartvalidate(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		//loginPage.invokeLogin();
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtcart = new AddToCartPage(driver);


		addtcart.getMenuIcon().click();
		//driver.findElement(By.id("sm_menu_ham")).click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Clicked on main menu");
		Thread.sleep(500);


		addtcart.getbacktoschool().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on back to school menu ");
		Thread.sleep(500);

		addtcart.getaddtocart().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on add to cart button ");
		Thread.sleep(500);


		addtcart.getcartmenu().click();
		Assert.assertTrue(driver.getTitle().equals("View Unplaced Order - DollarDays"));
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : verified add to cart button by clicking on that and Item is added in the cart sucssesfully ");
		Thread.sleep(500);

		addtcart.getclearcartbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 6  : Clicked on clear cart ");
		Thread.sleep(1000);

		addtcart.getpopupbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 7  : Clicked on ok button and cart is empty");
		Thread.sleep(500);
	}

	//Verify Update quantity text box buy using up arrow down arrow and update button in the view cart
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_23_addtocartvalidate(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		//loginPage.invokeLogin();
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);


		AddToCartPage addtcart = new AddToCartPage(driver);

		addtcart.getMenuIcon().click();

		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Clicked on main menu");
		Thread.sleep(500);


		addtcart.getbacktoschool().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on back to school menu ");
		Thread.sleep(500);

		addtcart.getaddtocart().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on add to cart button ");
		Thread.sleep(500);


		addtcart.getcartmenu().click();
		//Assert.assertTrue(driver.getTitle().equals("View Unplaced Order - DollarDays"));
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Item is added in the cart ");
		Thread.sleep(500);

		addtcart.getupdatemenu().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 6  : Clicked on update button");
		Thread.sleep(1000);

		addtcart.getcaseqtydownarrow().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 7  : Clicked on down arrow");
		Thread.sleep(1000);

		addtcart.getcaseqtyuparrow().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 8  : Clicked on up arrow");
		Thread.sleep(1000);

		addtcart.getupdatecartbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 9  : Clicked on update cart");
		Thread.sleep(1000);

		addtcart.getclearcartbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 10  : Clicked on clear cart ");
		Thread.sleep(1000);

		addtcart.getpopupbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 11  : Clicked on ok button and cart is empty");
		Thread.sleep(500);

	}*/

	//Verify add to cart by clicking on shop all button from home page
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_02_addtocartvalidate_shopallbtn_clickonimage(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		//loginPage.invokeLogin();
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtcart = new AddToCartPage(driver);

		addtcart.getbtsshopall().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Clicked on shop all back to school banner");
		Thread.sleep(500);

		addtcart.getwritingtoolimage().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on writing tool click on image");
		Thread.sleep(500);

		addtcart.getitemimage().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on selected item ");
		Thread.sleep(500);

		addtcart.getaddtomycart().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on add to my cart button ");
		Thread.sleep(500);

		addtcart.getviewcartitem().click();
		Assert.assertTrue(driver.getTitle().equals("View Unplaced Order - DollarDays"));
		ExtentTestManager.getTest().log(Status.PASS, "Step 6  : Item is added in the cart sucssesfully ");
		Thread.sleep(500);

		addtcart.getclearcartbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 7  : Clicked on clear cart ");
		Thread.sleep(1000);

		addtcart.getpopupbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 8  : Clicked on ok button and cart is empty");
		Thread.sleep(1000);




	}

	//Verify add to cart by clicking on click on images from home page
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_03_addtocartvalidate_clickonimage(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		//loginPage.invokeLogin();
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);


		AddToCartPage addtocart = new AddToCartPage(driver);

		addtocart.getclickonimage().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : clicked on click on image");
		Thread.sleep(500);

		addtocart.getclickonimageaddtocartbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Clicked on add to cart button ");
		Thread.sleep(2000);
		addtocart.HandleAddtocartPopup();

		addtocart.getcartmenu().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Clicked on cart menu and selected item is added in the cart for checkout ");
		Thread.sleep(1000);

		addtocart.getclearcartbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on clear cart ");
		Thread.sleep(1000);

		addtocart.getpopupbtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 6  : Clicked on ok button and cart is empty");
		Thread.sleep(1000);
	}

}	

