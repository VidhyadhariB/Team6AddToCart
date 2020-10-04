package com.dollardays.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dollardays.testcases.BaseTest;

public class HomePageB4login extends BaseTest{
	// page Factory (or) Object Repository
	WebDriver driver;

	public HomePageB4login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[2]/a/img")
	WebElement Wishlistimg;
	
	public WebElement Wishlistimg() {
		return Wishlistimg;
	}
	
	public boolean verifyWishlistimg() throws InterruptedException {
		Thread.sleep(5000);
		Wishlistimg.click();
		Thread.sleep(5000);
		return DropDownmenu.isDisplayed();
				
	}
	
	@FindBy(xpath="//ul[@class='dropdown-menu']")
	WebElement DropDownmenu;
	

	@FindBy(linkText="Learn More")
	WebElement WLLearnMore;
	
	public WebElement WLLearnMore() {
		return WLLearnMore;
	}
	
	public String validateWLLearnMoreTitle() throws InterruptedException {
		Wishlistimg.click();
		Thread.sleep(5000);
		WLLearnMore.click();
		Thread.sleep(5000);
		return driver.getTitle();
	}
	@FindBy(linkText="Create a Wishlist")
	WebElement CreateaWishlist;
	
	public String validateCreateaWishlistTitle() throws InterruptedException {
		Wishlistimg.click();
		Thread.sleep(5000);
		CreateaWishlist.click();
		Thread.sleep(5000);
		return driver.getTitle();
		
	}
	@FindBy(linkText="Donate Today")
	WebElement WLDonatetoday;
	
	public String validateWLDonatetodayTitle() throws InterruptedException {
		Wishlistimg.click();
		Thread.sleep(5000);
		WLDonatetoday.click();
		Thread.sleep(5000);
		return driver.getTitle();

}





























}