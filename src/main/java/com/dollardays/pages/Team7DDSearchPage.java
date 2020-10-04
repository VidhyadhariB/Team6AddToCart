package com.dollardays.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;

public class Team7DDSearchPage {

	WebDriver driver;

	public Team7DDSearchPage(WebDriver driver) {
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
	
	//@FindBy(xpath="//*[@id='aspnetForm']/div[7]/div[@class='failed-search-results bd']")
	@FindBy(xpath="//div[@class='failed-search-results bd']")
	private WebElement noDataFoundMsg;

	public WebElement getnoDataFoundMsg() {
		return noDataFoundMsg;
	}
	
	@FindAll(@FindBy(xpath = "//div[@class='select-bar pagination-bar']//a[contains(@class,'page-link')]"))
	private List<WebElement> pageCount;

	public List<WebElement> getPageCount() {
		return pageCount;
	}
	
	@FindBy(xpath = "//a[@title='Next Page']")
	private WebElement nextBtn;

	public WebElement getNextBtn() {
		return nextBtn;
	}
	
	@FindBy(xpath = "//a[@title='Last Page']")
	private WebElement lastPageBtn;

	public WebElement getLastPageBtn() {
		return lastPageBtn;
	}
	
	@FindBy(xpath = "//a[@title='First Page']")
	private WebElement firstPageBtn;

	public WebElement getfirstPageBtn() {
		return firstPageBtn;
	}
	
	@FindBy(xpath = "//li[@class='active page-item']")
	private WebElement lastBtntext;

	public WebElement getLastBtntext() {
		return lastBtntext;
	}
	
	//@FindAll(@FindBy(xpath = "//div[contains(@class,'prod-tile')]"))
	@FindAll(@FindBy(xpath="//*[@class='row baseinfo-eq-height']/following::div[@class='col-sm-6 col-lg-3 col-md-4 col-xs-6 prod-tile']"))
	private List<WebElement> pageItemsCount;

	public List<WebElement> getPageItemsCount() {
		return pageItemsCount;
	}
	
	
	@FindBy(xpath = "//h3[contains(text(),'CATEGORY')]")
	private WebElement CategoryCount;

	public WebElement getCategoryCount() {
	return CategoryCount;
	}
	
	@FindBy(xpath = "//div[@id='rfk_search_container']")
	private WebElement SearchAutoSuggestion;
	
	public WebElement getSearchAutoSuggestion() {
		return SearchAutoSuggestion;
	}
	
	@FindBy(xpath = "//input[@placeholder='Search for items in bulk']")
	private WebElement Defaultsearchtext;

	public WebElement getDefaultsearchtext() {
	return Defaultsearchtext;
	}
	
	public String CategoryCountValue() throws InterruptedException {
		String Categorydetails = getCategoryCount().getText();
		int size = Categorydetails.length();
		String Cnt = Categorydetails.substring(10,size-9);
		return Cnt;

		}
	
	
	
	public String getSearchWithValue() throws InterruptedException {
		
		String msg=null;
		String result = getnoDataFoundMsg().getText();
		System.out.println("-->"+result);
		
		if(result.contains("No Results Found")) {
			msg = getnoDataFoundMsg().getText();
			
		}else {
			msg = getsearchCount().getText();
		}
		System.out.println(msg);
		return msg;
	}
	

	
	public void getItemCount() throws InterruptedException {
		getLastPageBtn().click();
		Thread.sleep(1000);
		String valuecount = getLastBtntext().getText();
		System.out.println("Total Number of Pages Retrieved are " +valuecount);
		getfirstPageBtn().click();
		Thread.sleep(1000);
        int  itemcount=0;
		for(int i=1;i<=Integer.parseInt(valuecount);i++) {
		   	Thread.sleep(3000);
			System.out.println("Page "+ i + "  contains " + getPageItemsCount().size() + " items");
			ExtentTestManager.getTest().log(Status.PASS, "Page Number "+ i + "  contains " + getPageItemsCount().size() + "items");
		    itemcount=itemcount+getPageItemsCount().size();
			Thread.sleep(3000);
			if (i<= Integer.parseInt(valuecount)-1)
			{
			 getNextBtn().click();
			}
		}
	System.out.println("Total Number dispalyed items are:" +itemcount);
	}
	
	public int getTotalPageItemCount() throws InterruptedException {
				
		String pagecount = getLastBtntext().getText();
		getfirstPageBtn().click();
		Thread.sleep(1000);
        int  itemcount=0;
		for(int i=1;i<=Integer.parseInt(pagecount);i++) {
		   	Thread.sleep(3000);
			itemcount=itemcount+getPageItemsCount().size();
			Thread.sleep(3000);
			if (i<= Integer.parseInt(pagecount)-1)
			{
			 getNextBtn().click();
			}
		}
		return itemcount;
	}
	
}