package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import java.util.Map;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.JsonReader;
import com.dollardays.utilities.TestUtil;
import com.dollardays.utilities.VideoRecorder_utlity;

public class LoginTestcase extends BaseTest{

	@DDDataProvider(datafile = "testdata/Team7TestData.xlsx", sheetName = "SearchBar",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void invokeLogin(Hashtable<String, String> datatable) throws Exception{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		ExtentTestManager.getTest().log(Status.INFO, "login tstcase");
		Thread.sleep(1000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));		
		VideoRecorder_utlity.stopRecord();//End point of video recording
		
	}
	
	/* @DDDataProvider(datafile = "testdata/testdata.json", runmode = "", sheetName = "", testcaseID = "")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = JsonReader.class)
	public void invokeLogin1(Map<String, String> datatable) throws Exception{
		System.out.println("====>"+ datatable);
		System.out.println("Username====>"+ datatable.get("usernme"));
		
		System.out.println("Password====>"+ Base64.decrypt(datatable.get("password")));
		
	}*/
	
}

