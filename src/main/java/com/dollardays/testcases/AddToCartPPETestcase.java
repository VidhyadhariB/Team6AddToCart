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

public class AddToCartPPETestcase extends BaseTest {

	//Validate cart clear cart from shopping cart

	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_01_validate_clear_items_from_the_cart_from_shopping_cart_page (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver); //object creation for addToCartPage to get the methods
		addtocart.clearcart();
		ExtentTestManager.getTest().log(Status.PASS, "Step  : Clear the shopping cart  ");

		Thread.sleep(1000);

		//Validatin the shopping cart
		if(driver.findElement(By.xpath("//h1[contains(text(),'Your Shopping Cart is empty.')]")).isDisplayed())
			ExtentTestManager.getTest().log(Status.PASS, "Step  : Cart is cleared successfully and test case is passed");
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step  : Cart is not cleared and test case is failed");
		}

	}

	//Validate the user is able to add one item to the cart from product page and verify cart icon
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddToCartPPE",  testcaseID = "TC1", runmode = "yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_02_validate_cart_by_adding_one_item_from_product_page(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);


		AddToCartPage addtocart = new AddToCartPage(driver);
		addtocart.clearcart();
		WebDriverWait wait = new WebDriverWait(driver,30);
		//ExtentTestManager.getTest().log(Status.PASS, "Step  : Click on Menu icon ");
		//ExtentTestManager.getTest().log(Status.PASS, "Step  : Click on Mask, Sanitizer and PPE from Top categorie sub menu");
		addtocart.MenuPPE();

		WebElement item1 = addtocart.getItem();
		String s = item1.getAttribute("data-sku");
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on product and page should redirect to product page " +s);
		item1.click();


		addtocart.getAddToMyCartbtn().click();	//Identify add to my cart button and click
		//ExtentTestManager.getTest().log(Status.PASS, "Step : Click on add to my cart button and pop up message with accept button shoild display ");

		addtocart.HandleAddtocartPopup();

		addtocart.getCarticon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step  : Click on cart icon and should redirect to shopping cart page ");//Identify cart icon and click
		WebElement cartitem = addtocart.getcartaddeditems();
		String s1 = (cartitem.getText()).substring(6);
		//ExtentTestManager.getTest().log(Status.PASS, "Step  :The product added in the cart and sku of the product is :" +s1);
		System.out.println("The item in the cart" +s1);
		if(s.equals(s1)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step  : Correct product added to the shopping cart. The test case is passed");
			//System.out.println("Correct item added");
		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step  : Wrong product placed in the shopping cart.Test case is failed");
			//System.out.println("Wrong item added");
		}

		//Validating the product added in the cart
		//ExtentTestManager.getTest().log(Status.PASS, "Step 9 : Correct item added to the cart ");

	}

	//Validate the user is able to add one item to the cart from PPE and Mask category and verify cart icon
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_03_validate_cart_add_one_item_through_add_to_cart_button_on_product_from_PPE_and_Mask_category(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);

		AddToCartPage addtocart = new AddToCartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		ExtentTestManager.getTest().log(Status.PASS, "Step : Clear the cart");
		addtocart.clearcart();

		//ExtentTestManager.getTest().log(Status.PASS, "Step : Click on menu icon and click on mask, Sanitizer and PPE from the top categorie sub menu");
		addtocart.MenuPPE();
		//ExtentTestManager.getTest().log(Status.PASS, "Step : Click on add to cart button which is on the product ");				
		WebElement item = addtocart.getItemaddtocart();

		String s = item.getAttribute("data-sku");
		//ExtentTestManager.getTest().log(Status.PASS, "Step : Click on the product that to be added to the cart and sku of the item  is " +s);
		//System.out.println("This is item added" +s);
		item.click();
		//ExtentTestManager.getTest().log(Status.PASS, "Step : Pop up is handled ");
		addtocart.HandleAddtocartPopup();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on cart icon and should redirect to shopping cart page");
		addtocart.getCarticon().click();

		WebElement cartitem = addtocart.getcartaddeditems();
		String s1 = cartitem.getText().substring(6);
		//ExtentTestManager.getTest().log(Status.PASS, "Step : The product sku added in the shopping cart is " +s1);
		//System.out.println("This is added in the cart:" +s1);
		if(s.equals(s1)) {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Correct product added in the shopping cart. Test case is passed");
			//System.out.println("Correct item added");
		}
		else {
			ExtentTestManager.getTest().log(Status.PASS, "Step : Wrong product placed in shopping cart. Test case is failed");
			//System.out.println("Wrong item added");
		}


	}


	//Validate the user is able to add multiple items to the cart from PPE and Mask page and verify the shopping cart
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_04_validate_cart_by_adding_multiple_items_from_PPE_and_Mask_page_and_verify_shopping_cart (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

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
			//ExtentTestManager.getTest().log(Status.PASS, "Step : The products to be adde to the cart and their corresponding SKU's " +text.getAttribute("data-sku"));
			skus.add(text.getAttribute("data-sku"));
			Thread.sleep(1000);
			ExtentTestManager.getTest().log(Status.PASS, "Step : click on one item to be added to the cart");
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


	//Validate update cart button in shopping cart
	@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void TC_05_validate_updatecart_in_shopping_cart_page (Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{

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
			//ExtentTestManager.getTest().log(Status.PASS, "Step : The products to be adde to the cart and their corresponding SKU's " +text.getAttribute("data-sku"));
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


	//Validate the case quantity text box with valid data in the shopping cart
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

