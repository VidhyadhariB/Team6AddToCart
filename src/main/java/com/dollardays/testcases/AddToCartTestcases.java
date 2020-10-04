package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.AddToCartPage;
import com.dollardays.pages.LoginPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class AddToCartTestcases extends BaseTest {

	
	//Rupali Testcases//

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

			WebElement e = driver.findElement(By.xpath("//li[1]//a[1]//div[1]//img[1]"));
			//WebElement e = addtocart.getimage1();
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
		public void TC_20_Validate_addtocart_by_clicking_on_buy_nowbutton_from_adv_banner_without_login(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
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
		@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
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

		}

		//Verify add to cart by clicking on shop all button from home page
		@DDDataProvider(datafile = "testdata/Team6_AddToCart_data.xlsx", sheetName = "AddTOCartPPE",  testcaseID = "TC1", runmode = "Yes")
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		public void TC_24_addtocartvalidate_shopallbtn_clickonimage(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
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
		public void TC_25_addtocartvalidate_clickonimage(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
			
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

