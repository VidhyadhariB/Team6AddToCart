package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
//import com.dollardays.common.CommonUtilities;
//import com.dollardays.common.ReadExcel;
//import com.dollardays.common.CommonUtilities;
//import com.dollardays.common.ReadExcel;
//import com.dollardays.common.CommonUtilities;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.FavoriteLinkPage;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SearchPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class FavoriteLinkTestcase extends BaseTest {
	@DDDataProvider(datafile = "testdata/Team4Testdata.xlsx", sheetName = "FavLink",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_01_addToCart(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify add to cart functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		FavoriteLinkPage favoriteLinkPage = new FavoriteLinkPage(driver);
		favoriteLinkPage.clickProfileIconButton();
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : clicking on favorite link");
		favoriteLinkPage.clickfavoriteLink();
		String code = favoriteLinkPage.getskuCode(); // Getting sku code in code
		// variable


Pattern p = Pattern.compile("\\d+"); // creating pattern with all
// numeric values

Matcher m = p.matcher(code); // collecting those values in variable m
int skuNumber = 0;

while (m.find()) {



skuNumber = Integer.parseInt(m.group()); // spliting the values and
		// getting only first
		// value (break)

break;
}

System.out.println("only number:" + skuNumber);

favoriteLinkPage.clickaddToCart(); // Clicking on add to cart
ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicking on add to cart btn");

// favoriteLinkPage.clickiAcceptpopup(); //clicking on popup to accept

favoriteLinkPage.clickcartIcon(); // Clicking on cart icon

String code2 = favoriteLinkPage.getskuCodefromCart();

System.out.println("This is sku code2 from cart page" + code2);
Pattern q = Pattern.compile("\\d+");
Matcher r = q.matcher(code);
int skuNumber2 = 0;
while (r.find()) {
// System.out.println(m.group());
skuNumber2 = Integer.parseInt(r.group());
break;
}

Assert.assertEquals(skuNumber, skuNumber2);




}
	@DDDataProvider(datafile = "testdata/Team4Testdata.xlsx", sheetName = "FavLink",  testcaseID = "TC2", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_02_SortBy_priceLowToHigh(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify price Low to High functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		FavoriteLinkPage favoriteLinkPage = new FavoriteLinkPage(driver);
		favoriteLinkPage.clickProfileIconButton();
		favoriteLinkPage.clickfavoriteLink();
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Clicking on favorite link");
		


		//driver.navigate().back();
		favoriteLinkPage.clickSortBy("Price per Unit (Low to high)");
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Clicking on Price low to high from dropdown box");
		// logger.debug("click sort by");
		String firstValue = favoriteLinkPage.getFirstItem();
		// logger.debug("click first item");
		String secondValue = favoriteLinkPage.getSecondItem();
		// logger.debug("click second item");
		String thirdValue = favoriteLinkPage.getThirdItem();
		// logger.debug("click Third item");
		System.out.println("items are " + firstValue + secondValue + thirdValue);

		Pattern v1 = Pattern.compile("\\d+");
		Matcher t1 = v1.matcher(firstValue);
		double value1 = 0.00;
		while (t1.find()) {
			System.out.println("t1.group() value prior conversion : " + t1.group());
			value1 = Float.parseFloat(t1.group());
			System.out.println("First iteam value is " + value1);
			break;
		}
		Pattern v2 = Pattern.compile("\\d+");
		Matcher t2 = v2.matcher(secondValue);
		double value2 = 0.00;
		while (t2.find()) {
			value2 = Float.parseFloat(t2.group());
			break;
		}
		Pattern v3 = Pattern.compile("\\d+");
		Matcher t3 = v3.matcher(thirdValue);
		double value3 = 0.00;
		while (t3.find()) {
			// System.out.println("t3.group() value prior conversion : " +
			// t3.group());
			value3 = Float.parseFloat(t3.group());
			// System.out.println("Thrid iteam value is " + value3);
			break;
		}

		if (value1 <= value2) {
			// System.out.println("In if 1....");

			// System.out.println("this is the value one "+value1);
			// System.out.println("this is the value two "+value2);
			// System.out.println("this is the value three "+value3);
			if (value2 <= value3) {
				System.out.println("(value2 <= value3)");
				Assert.assertTrue(true);

			} else {
				System.out.println("else..updated.");
				Assert.assertFalse(true);
				System.out.println("after assert false...");
			}
		} else {
			System.out.println("in last else....");
			Assert.assertFalse(true);
		}
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : compairing values");
}
	@DDDataProvider(datafile = "testdata/Team4Testdata.xlsx", sheetName = "FavLink",  testcaseID = "TC3", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_03_SortBy_priceHighToLow(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Sorting items in High to low price order");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		FavoriteLinkPage favoriteLinkPage = new FavoriteLinkPage(driver);
		favoriteLinkPage.clickProfileIconButton();
		favoriteLinkPage.clickfavoriteLink();
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Clicking on Favorite link");
		favoriteLinkPage.clickSortBy("Price per Unit (High to low)");
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Clicking on Price High to Low option from Dropdown ");
		
		
		
		// logger.debug("click sort by");
		String firstValue = favoriteLinkPage.getFirstItem();
		// logger.debug("click first item");
		String secondValue = favoriteLinkPage.getSecondItem();
		// logger.debug("click second item");
		String thirdValue = favoriteLinkPage.getThirdItem();
		// logger.debug("click Third item");
		System.out.println("items are " + firstValue + secondValue + thirdValue);

		Pattern v1 = Pattern.compile("\\d+");
		Matcher t1 = v1.matcher(firstValue);
		double value1 = 0.00;
		while (t1.find()) {
			System.out.println("t1.group() value prior conversion : " + t1.group());
			value1 = Float.parseFloat(t1.group());
			System.out.println("First iteam value is " + value1);
			break;
		}
		Pattern v2 = Pattern.compile("\\d+");
		Matcher t2 = v2.matcher(secondValue);
		double value2 = 0.00;
		while (t2.find()) {
			value2 = Float.parseFloat(t2.group());
			break;
		}
		Pattern v3 = Pattern.compile("\\d+");
		Matcher t3 = v3.matcher(thirdValue);
		double value3 = 0.00;
		while (t3.find()) {
			// System.out.println("t3.group() value prior conversion : " +
			// t3.group());
			value3 = Float.parseFloat(t3.group());
			// System.out.println("Thrid iteam value is " + value3);
			break;
		}

		if (value1 >= value2) {
			
			if (value2 >= value3) {
				System.out.println("(value2 >= value3)");
				Assert.assertTrue(true);

			} else {
				System.out.println("else..updated.");
				Assert.assertFalse(true);
				System.out.println("after assert false...");
			}
		} else {
			System.out.println("in last else....");
			Assert.assertFalse(true);
		}
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : Compairing Items ");
		}
}
