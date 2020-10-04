package com.dollardays.testcases;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SearchPage;

public class BaseTest extends MT {
	public static Logger APPLICATION_LOGS = Logger.getLogger(BaseTest.class);
	public WebDriver driver = null;
	public Properties props = null;
	public FileInputStream fileInputStream = null;

	public void readPropertyData() throws Exception {

		props = new Properties();

		try {

			fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\application.proerties");
			props.load(fileInputStream);

		} catch (Exception e) {
			throw new Exception("Property file is not found");
		}

	}

	public void openBrowser() throws Exception {
		try {

			switch (props.getProperty("driver")) {

			case "firefox":
				FirefoxProfile customProfile = new FirefoxProfile();
				customProfile.setPreference("dom.disable_beforeunload", true);

				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//geckodriver.exe");
				driver = new FirefoxDriver(customProfile);
				Thread.sleep(1000);
				driver.manage().window().maximize();
				break;

			case "chromeDriver":
				ChromeOptions options = new ChromeOptions();

//				options.addArguments("--silent");
//				options.addArguments("--disable-extensions");
//				options.addArguments("test-type");
//				options.addArguments("--ignore-certificate-errors");
//				options.addArguments("no-sandbox");
				options.addArguments("--headless");
//				options.addArguments("excludeSwitches");
//				options.addArguments("enable-logging");

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//servers//chromedriver.exe");

				ChromeDriverService service = ChromeDriverService.createDefaultService();
				// System.setProperty("webdriver.chrome.silentOutput", "true");
				System.setProperty(service.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
				driver = new ChromeDriver(service, options);
				driver.manage().window().maximize();
				break;

			case "IE":
				// IEDriver.ieDriver();
				break;

			default:
				// FirefoxDriver.firefox_launch();
				break;
			}

		} catch (Exception e) {
			throw new Exception("Driver Not Found");
		}

		Thread.sleep(1000);

	}

	public void getUrl() {
		try {

			driver.get(props.getProperty("env.baseUrl"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void setUpBrowser() throws Exception {

		readPropertyData();
		openBrowser();
		getUrl();

	}

	/**
	 * This function runs all the preconditions required for the test.
	 * 
	 * @param datatable
	 * @throws InterruptedException
	 * @throws UnsupportedEncodingException
	 * @throws GeneralSecurityException
	 */
	public void runPreConditions(Hashtable<String, String> datatable)
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException {

		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, "Pre condition.");
		ExtentTestManager.getTest().log(Status.INFO, "Login.");
		Thread.sleep(1000);

		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Login Successful.");

		ExtentTestManager.getTest().log(Status.INFO, "Search and open Product description page.");
		SearchPage searchpage = new SearchPage(driver);
		Thread.sleep(1000);
		searchpage.getSearchBar().sendKeys("backpack");// li[contains(text(),'SKU #2344871')]
		Thread.sleep(1000);
		searchpage.getsearchBtn().click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"//a[@href='/i2323196-wholesale-15-forward-classic-school-backpack-with-side-mesh-pocket-4-colors.html'][contains(text(),'15\" Forward Classic School Backpack with Side Mesh')]"))
				.click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Search and open Product description page successful.");

	}

	@AfterMethod
	public void quit() {
		driver.close();
		driver.quit();
	}

}
