package com.dollardays.pages;

	import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

	import com.aventstack.extentreports.Status;
	import com.dollardays.listners.ExtentTestManager;

	public class Team7DDPaginationPage {

		WebDriver driver;

		public Team7DDPaginationPage(WebDriver driver) {
			//this.driver = driver;
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
		
		@FindBy(xpath="//div[@class='select-bar pagination-bar']//i[@class='fa fa-caret-right']")
		private WebElement nxtBtn;
		
		public WebElement getnxtBtn() {
			return nxtBtn;
		}
		
		
		@FindAll(@FindBy(xpath = "//div[contains(@class,'prod-tile')]"))
		
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
		
		//@FindBy(xpath="//div[@class='select-bar pagination-bar']//i[@class='fa fa-caret-left']")
		@FindBy(xpath="//div[@class='select-bar pagination-bar']//li[@class='disabled page-item']//a[@class='page-link']")
		//@FindBy(xpath="//*[@id=\"aspnetForm\"]/div[6]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div[2]/div/ul/li[2]/a")
		private WebElement PreviousPage;
		
		public WebElement getPreviousPage() {
			return PreviousPage;
		}
		
		
		@FindBy (xpath = "//div[@class='select-bar pagination-bar']//li[@class='disabled page-item']//a[@class='page-link']")
		private WebElement nextpage;

		public WebElement getnextpage() {
		return nextpage;
		}
		
		public int CategoryCountValue() throws InterruptedException {
			String Categorydetails = getCategoryCount().getText();
			int size = Categorydetails.length();
			int Cnt = Integer.parseInt(Categorydetails.substring(10,size-9));
			return (Cnt);

			}
		
		public void previousPage()
				{
			System.out.println(PreviousPage.isEnabled());						
		 	if(PreviousPage.isEnabled())
			{
				System.out.println("Previous Button is enabled");
				ExtentTestManager.getTest().log(Status.FAIL, "Previous pagebutton is enabled");
			}
			else {
				System.out.println("Previous Button is disabled");	
				ExtentTestManager.getTest().log(Status.PASS, "Previous button is Disabled");
			}
			
		}
		
		public void nextpage()
		{

		if(nextpage.isEnabled())
		{
		System.out.println("Next Button is enabled");
		ExtentTestManager.getTest().log(Status.FAIL, "Next pagebutton is enabled");
		}
		else {
		System.out.println("Next Button is disabled");
		ExtentTestManager.getTest().log(Status.PASS, "Next button is Disabled");
		}
		}
		
		
		public int totalItemCount() throws InterruptedException
		{
			getLastPageBtn().click();
			Thread.sleep(1000);
			String valuecount=getLastBtntext().getText();
			System.out.println("Total No.of Pages Retrieved are :"+valuecount);
			getfirstPageBtn().click();
			Thread.sleep(1000);
			int itemcount=0;
			for(int i=1;i<=Integer.parseInt(valuecount);i++)
			{
				Thread.sleep(1000);			
				System.out.println("Page "+ i + "  contains " + getPageItemsCount().size() + " items");
				ExtentTestManager.getTest().log(Status.PASS, "Page Number "+ i + "  contains " + getPageItemsCount().size() + " items");
			    itemcount=itemcount+ getPageItemsCount().size();
			    Thread.sleep(1000);
			    //j=Integer.parseInt(valuecount)-1;
			    if (getnxtBtn().isEnabled()==true)			  
			    	getNextBtn().click();	
			     Thread.sleep(1000);
			    }			    
			System.out.println("Total No.of Items displayed in all Pages are :" +itemcount);
 
			return itemcount;
		}
		
		public Boolean itemCountCompare(int categoryCount,int pageItemCount)
		{
			Boolean status;
						
			 if (categoryCount==pageItemCount)
			{
						status= true;
				System.out.println("Item count dispalyed against category matched the total items dispalyed in pages");
				
			}
			else
			{
				status=false;
				System.out.println("Item count dispalyed against category not matched the total items dispalyed in pages");
			}
			return 	status;
		}
		

	
		
	/*	public int getTotalPageItemCount() throws InterruptedException {
					
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
		}*/
		
	}
