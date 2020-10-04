package com.dollardays.testcases;


	import static org.testng.Assert.assertEquals;

    import java.io.UnsupportedEncodingException;
	import java.security.GeneralSecurityException;
	import java.util.Hashtable;

    import org.testng.Assert;
    import org.testng.annotations.Test;

	import com.aventstack.extentreports.Status;
	import com.dollardays.commons.Base64;
	import com.dollardays.listners.ExtentTestManager;
	import com.dollardays.pages.LoginPage;
    import com.dollardays.pages.Team7DDPaginationPage;
    import com.dollardays.pages.Team7DDSearchPage;
	import com.dollardays.utilities.DDDataProvider;
	import com.dollardays.utilities.TestUtil;



	public class Team7DDPaginationTestcase extends BaseTest{
		
		
		
		
		@DDDataProvider(datafile = "testdata/Team7Testdata.xlsx", sheetName = "Pagination" , testcaseID = "TC1", runmode = "Yes" )
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		public void TC1_Pagination(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException {
		System.out.println(datatable.get("TestCase"));
		//ExtentTestManager.getTest().log(Status.PASS, "Testcase: Verify Searchbar ");
		ExtentTestManager.getTest().log(Status.PASS, "Testcase: " + (datatable.get("TCID"))+ "-----"+(datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);
		Team7DDPaginationPage paginationpage = new Team7DDPaginationPage(driver);
		String Searchvalue = datatable.get("ProductName");
		    paginationpage.getSearchBar().sendKeys(Searchvalue);
		ExtentTestManager.getTest().log(Status.PASS,"Step 2: Successfully entered valid product name in the Search Bar");
		paginationpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3 : successfully clicked on the search button");
		Thread.sleep(500);

		try {

		paginationpage.totalItemCount();
		Thread.sleep(1000);

		  }catch (Exception e) {
		paginationpage.totalItemCount();
		Thread.sleep(1000);
		  }
		int catcnt=paginationpage.CategoryCountValue();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4 : successfully clicked on the Page Hyperlinks Individually");
		System.out.println("Total no.of Results displayed against category are : " +paginationpage.CategoryCountValue());
		ExtentTestManager.getTest().log(Status.PASS, "INFO:Total Number of Search Results displayed against Category are :" +paginationpage.CategoryCountValue());
		int cnt=paginationpage.totalItemCount();

		System.out.println(" Total no.of search results displayed in pages are:" +cnt);
		ExtentTestManager.getTest().log(Status.PASS, "INFO:Total Number of Search Results displayed in Pages are :" +cnt);
		if(catcnt==cnt)
		{
		System.out.println("Item count dispalyed against category matched the total items dispalyed in pages");
		ExtentTestManager.getTest().log(Status.PASS, "Item count dispalyed against category matched the total items dispalyed in pages" );
		}
		else
		{
		System.out.println("Item count dispalyed against category not matched the total items dispalyed in pages");
		ExtentTestManager.getTest().log(Status.FAIL, "Item count dispalyed against category not matched the total items dispalyed in pages" );
		}

		loginPage.getUserDrodown().click();
		Thread.sleep(1000);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Clicked on LogOut");
		}
	
	
	/*	//Previous Page Button Verification
	
		@DDDataProvider(datafile = "testdata/Team7Testdata.xlsx", sheetName = "Pagination" , testcaseID = "TC1", runmode = "Yes" )
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		public void TC4_Pagination(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException {
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.PASS, "Testcase: " + (datatable.get("TCID"))+ "-----"+(datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);	
		PaginationPage paginationpage = new PaginationPage(driver);
		String Searchvalue = datatable.get("ProductName");
	    paginationpage.getSearchBar().sendKeys(Searchvalue);
		ExtentTestManager.getTest().log(Status.PASS,"Step 2: Successfully entered valid product name in the Search Bar");
		paginationpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3 : successfully clicked on the search button");
		Thread.sleep(2000);	
		paginationpage.previousPage();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4 : successfully verified previous button if it is enabled/disabled");
		Thread.sleep(1000);
	
		loginPage.getUserDrodown().click();
		Thread.sleep(1000);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Clicked on LogOut"); 
		
		
		}
				
		//Next Page Button Validation

		@DDDataProvider(datafile = "testdata/Team7Testdata.xlsx", sheetName = "Pagination" , testcaseID = "TC5", runmode = "Yes" )
		@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
		public void TC5_Pagination(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException {
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.PASS, "Testcase: " + (datatable.get("TCID"))+ "-----"+(datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);	
		PaginationPage paginationpage = new PaginationPage(driver);
		String Searchvalue = datatable.get("ProductName");
	    paginationpage.getSearchBar().sendKeys(Searchvalue);
		ExtentTestManager.getTest().log(Status.PASS,"Step 2: Successfully entered valid product name in the Search Bar");
		paginationpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3 : successfully clicked on the search button");
		Thread.sleep(2000);	
		paginationpage.getLastPageBtn().click();
		Thread.sleep(1000);
		paginationpage.nextpage();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4 : successfully verified previous button if it is enabled/disabled");
		Thread.sleep(1000);
	
		loginPage.getUserDrodown().click();
		Thread.sleep(1000);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5 : Clicked on LogOut"); 
		
		
		}*/
                                         

		}
		

