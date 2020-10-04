package com.dollardays.pages;

	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Reporter;

	import com.aventstack.extentreports.Status;
	import com.dollardays.listners.ExtentTestManager;


	public class Team7DDSortByPage {



	WebDriver driver;

	public Team7DDSortByPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath = "//*[@id='header-main']/div/div/div[2]/div[1]/div[1]/input")
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[2]/div[1]/div[1]/input")
	private WebElement searchBar;

	public WebElement getSearchBar() {
	return searchBar;
	}

	//@FindBy(xpath = "//*[@id='header-main']/div/div/div[2]/div[1]/div[1]/div/div/button")
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[2]/div[1]/div[1]/div/div/button/i")
	private WebElement searchBtn;

	public WebElement getsearchBtn() {
	return searchBtn;
	}

	@FindBy(xpath = "//*[@id='facetrefinements']/aside[1]/div/h3/span[@class='sku-count']")
	private WebElement searchCount;

	public WebElement getsearchCount() {
	return searchCount;
	}

	@FindBy(xpath = "//*[@id='aspnetForm']/div[7]/div[@class='failed-search-results bd']")
	private WebElement noDataFoundMsg;

	public WebElement getnoDataFoundMsg() {
	return noDataFoundMsg;
	}

	@FindBy(xpath = "//div[@id='rfk_search_container']")
	private WebElement SearchAutoSuggestion;

	public WebElement getSearchAutoSuggestion() {
	return SearchAutoSuggestion;
	}



	@FindBy(xpath = "//select[@class='ddlSortOption']")
	private WebElement SortDropDown;

	public WebElement getSortDropDown() {
	return SortDropDown;
	}
	
	@FindBy(xpath = "//select[@class='formlink']")
	private WebElement ViewDropDown;

	public WebElement getViewDropDown() {
	return ViewDropDown;
	}
	
	
	@FindBy(xpath = "//*[@id=\'aspnetForm\']/div[6]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/select/option[1]")
	private WebElement ViewDropDown1;

	public WebElement getViewDropDown1() {
	return ViewDropDown1;
	}
	
	@FindAll(@FindBy(xpath = "//div[contains(@class,'prod-tile')]"))
	
	private List<WebElement> pageItemsCount;

	public List<WebElement> getPageItemsCount() {
		return pageItemsCount;
	}
	
	

			
	 public void SelectSortBy(String SortOption) {
	  Select SortByObj = new Select(SortDropDown);
	  SortByObj.selectByVisibleText(SortOption);
	 
	 }
	
		
	 public String getSortBy(String SortOption) {
	  Select SortByObj = new Select(SortDropDown);
	  System.out.println("The dropdown selected is: " +SortByObj.getFirstSelectedOption().getText());
		return	  SortByObj.getFirstSelectedOption().getText();
	 	 
	 }
	 
		
	 public void SelectViewBy(String ViewOption) {
	  Select ViewByObj = new Select(ViewDropDown);
	  ViewByObj.selectByVisibleText(ViewOption);
	 
	 }

	 
	 
		
	 public String getViewBy(String ViewOption) {
	  Select ViewByObj = new Select(ViewDropDown);
	   System.out.println("The dropdown selected is: " +ViewByObj.getFirstSelectedOption().getText());
		return	  ViewByObj.getFirstSelectedOption().getText();
	 	 
	 }
	
	 
	 
	}
	

