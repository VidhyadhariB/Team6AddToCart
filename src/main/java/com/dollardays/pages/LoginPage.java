package com.dollardays.pages;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dollardays.commons.Base64;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath = "//a[normalize-space(.)='Sign in']")
	@FindBy(className = "dropdown")
	private WebElement signIn;

	public WebElement getSignIn() {
		return signIn;
	}

	@FindBy(xpath = "//a[normalize-space(.)='Sign In']")
	private WebElement dropdownsignIn;

	public WebElement getDropdownsignIn() {
		return dropdownsignIn;
	}

	@FindBy(xpath = "//*[@id='inputLoginUsername']")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	@FindBy(xpath = "//*[@id='inputLoginPassword']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//button[normalize-space(.)='Sign in']")
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//@FindBy(xpath = "//*[@id='header-main']/div/div/div[3]/div/ul/li[1]/a")
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/a/span")
	private WebElement userDrodown;

	public WebElement getUserDrodown() {
		return userDrodown;
	}	
	
	@FindBy(xpath = "//a[normalize-space(.)='Sign Out']")
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}	
	

	public void login(String username, String password) throws InterruptedException {
		Thread.sleep(1000);
		getSignIn().click();
		getDropdownsignIn().click();
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		Thread.sleep(500);
		getPassword().submit();
		//getLoginBtn().click();
		String expectedTitle = "DollarDays | Bulk Goods for Nonprofits, Businesses & Schools | Wholesale Products";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, " Successfully Logged into the HomePage");
	}
	
	public void invokeLogin() throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		Thread.sleep(1000);
		getSignIn().click();
		getDropdownsignIn().click();
		getUsername().sendKeys("srikanthtesting100@gmail.com");
		getPassword().sendKeys(Base64.decrypt("cGFzc3dvcmQxMjM="));
		getPassword().submit();
		//getLoginBtn().click();
	}

}
