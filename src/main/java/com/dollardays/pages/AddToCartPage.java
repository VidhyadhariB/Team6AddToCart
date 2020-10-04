package com.dollardays.pages;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Properties;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.testcases.BaseTest;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class AddToCartPage {
	//Instantiation of the webdriver 
	WebDriver driver;

	//Creating the constructor to call all the Webelements in this page .Ex : menuicon,ppe etc

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}	
	@FindBy(xpath = "//*[@id=\"sm_menu_ham\"]")
	private WebElement menuicon;

	public WebElement getMenuIcon() {
		return menuicon;
	}
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[1]/ul/li[2]/a")
	private WebElement ppemask;

	public WebElement getPPEmask() {
		return ppemask;
	}
	@FindBy(xpath = "//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[1]/div/div[3]/div[1]/a")
	private WebElement item;

	public WebElement getItem() {    
		return item;     
	}

	@FindBy(xpath = "//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div[1]/div/div[2]/div/input[5]")
	private WebElement itemaddtocart;

	public WebElement getItemaddtocart() {    
		return itemaddtocart;
	}

	@FindBy(xpath = "//button[@class='cart_newbtn btn dd-btn-secondary btn-quick-view bold jqatc fsig gtmAddCart btn-group-lg']")
	private WebElement addtomycartbtn;

	public WebElement getAddToMyCartbtn() {
		return addtomycartbtn;

	}
	@FindBy(xpath = "//img[@class='header-cart']")  
	private WebElement carticon;

	public WebElement getCarticon() {
		return carticon;

	}

	@FindBy(xpath = "//span[@id='ctl00_ddiPageHeader_liViewCartDesktop']")  
	private WebElement carticontxt;

	public WebElement getCarticontxt() {
		return carticontxt;
	}
	@FindBy(xpath =" //input[@name='picquantity'] ")
	private WebElement quantitytxtbox;

	public WebElement getquantitytxtbox() {
		return quantitytxtbox;
	}
	/*@FindBy(xpath = "noreturnmodal_msg")
	private WebElement popuptxt;

	public WebElement getpopuptxt() {
		return popuptxt;
	

	}*/
	@FindBy(xpath = "//button[@class='btn btn-primary btn-cartclear']")
	private WebElement clearcartpopup;

	public WebElement getclearcartpopup() {
		return clearcartpopup;
	}
	
	@FindBy(id = "ctl00_cphContent_btnClearCart")
	private WebElement clearcart;

	public WebElement getclearcart() {
		return clearcart;
	}
	@FindBy(xpath = "//*[@id=\"noreturnmodal\"]/div/div/div[2]/button")
	private WebElement addtocartpopup;

	public WebElement getaddtocartpopup() {
		return addtocartpopup;
	}
	@FindBy(xpath = "//h1[contains(text(),'Your Shopping Cart is empty.')]")
	private WebElement  emptyshopping;

	public WebElement getemptyshoppingcart() {
		return emptyshopping;


	}
	@FindBy(xpath = "//a[contains(@class,'btn btn-update')]")
	private WebElement updatebtn;

	public WebElement getupdatebtn() {
		return updatebtn;
	}
	


	@FindBy(xpath = "//*[@class='form-quantity']")
	private WebElement cartqtytxtbox;

	public WebElement getcartqtytxtbox() {
		return cartqtytxtbox;
	}
	
	@FindBy(xpath = "//div[@id='confirmationBox']//div[@class='modal-body']")
	private WebElement qtyzeropopup;

	public WebElement getqtyzeropopup() {
		return qtyzeropopup;

	}
	@FindBy(xpath = "//a[@class='dropdown-item padditem margn-top']")
	private WebElement qtyboundaryvalue;

	public WebElement getqtyboundaryvaluepopup() {
		return qtyboundaryvalue;
	}
	@FindBy(xpath = "//*[contains(text(),'SKU #')]")
	private WebElement cartaddeditems;

	public WebElement getcartaddeditems() {
		return cartaddeditems;
	}
	
	
	@FindBy(xpath = "//h6[contains(text(),'SKU # 2350143')]")
	private WebElement addeditems;

	public WebElement getaddeditems() {
		return addeditems;
	}
	
	
	
	
	@FindBy(xpath = "//input[@placeholder='Search for items in bulk']")
	private WebElement searchbar;

	public WebElement getsearchbar() {
		return searchbar;
	}
	
	@FindBy(xpath = "//li[1]//a[1]//div[1]//img[1]")
	private WebElement item3;

	public WebElement getitem3() {
		return item3;
	}
	
	
	
	
	//Rupali Pages 
	
@FindBy (xpath ="//input[@type='button' and @data-sku='2349770']") //Click on Selected item
	
	private WebElement oneitem;

	public WebElement getoneitem() {
		return oneitem;
	}
	
@FindBy (xpath ="//h6[contains(text(),'SKU # 2349770')]") //Click on Selected item
	
	private WebElement cartitem;

	public WebElement getcartitem() {
		return cartitem;
	}
	
	
	@FindBy (xpath ="//div[@class='rfk_results']//li[1]") //Click on Selected item
	
	private WebElement selectedItem;

	public WebElement getselectedItem() {
		return selectedItem;
	}
	
	@FindBy (xpath ="//li[@class='itemid']") //item sku
	
	private WebElement itemsku;

	public WebElement getitemsku() {
		return itemsku;
	}
	
	@FindBy (xpath ="//button[@class='btn noreturnmodal-btn dismiss_modal']") //Click on I Accept button on the popup
	private WebElement addtomycartpopup;
		
	public WebElement getaddtomycartpopup() {
		return addtomycartpopup;
	}
	@FindBy (xpath = "//li[1]//a[1]//div[1]//img[1]")
	private WebElement image1;
	
	public WebElement getimage1() {
		return image1;
	}
	@FindBy (xpath = "//img[@class='header-cart']") //Click on cart icon on the top right corner of a page
	private WebElement clickcarticon;
	
	public WebElement getclickcart() { 
		return clickcarticon;
	}
	@FindBy (xpath = "//div[@class='item active']") //Click Buy Now link on the Premium Alcohol Wipes on the home page
	private WebElement buynowbtn;
	
	public WebElement getbuynowbtn() {
		return buynowbtn;
	}
	@FindBy (xpath ="//i[@class='fa fa-chevron-right']")// Click on the right arrow on the advertising banner on the home page
	private WebElement bannerrightarrow;
	
	public WebElement getbannerrightarrow() {
		return bannerrightarrow;
	}
	
	@FindBy (xpath = "//div[@class='col-md-9 col-sm-8']//div[2]//div[1]//div[2]//div[1]//input[5]")//Click on Add To Cart from 3PlyFaceMask selected item
	private WebElement clickaddtocart2;
	
	public WebElement getaddtocart2() {
		return clickaddtocart2;
	}
	@FindBy (xpath ="//img[@class='img-responsive fullwide']") //Click on Buy Now link from Smaller Case Packs advertising banner
	private WebElement clickbuysmallercasepacks;
	
	public WebElement getbuysmallercasepacks() {
		return clickbuysmallercasepacks;
	}
	@FindBy (xpath ="//input[@class='btn btn-quick-view jqatc fsig']") //Click on Add To Cart button from 2PlyFaceMask selected product
	private WebElement clickaddtomycart3;
	
	public WebElement getaddtomycart3() {
		return clickaddtomycart3;
	}
	// Rajshree pages
	
	@FindBy(xpath = "//a[@class='cart_newbtn btn']")
	private WebElement  logintobuy;

	public WebElement getlogintobuy() {
		return logintobuy;
	}
	
	//Shraddha pages
	
	@FindBy(xpath = "//a[contains(text(),'Back to School')]")
	private WebElement backtoschool;

	public WebElement getbacktoschool() {
		return backtoschool;
	}

	@FindBy(xpath = "//div[@class='col-md-9 col-sm-8']//div[2]//div[1]//div[2]//div[1]//input[5]")
	private WebElement addtocart;

	public WebElement getaddtocart() {
		return addtocart;
	}

	@FindBy(xpath = "//img[@class='header-cart']")
	private WebElement cartmenu;

	public WebElement getcartmenu() {
		return cartmenu;

	}


	@FindBy(xpath = "//input[@id='quantity-15668094']")
	private WebElement caseqty;

	public WebElement getcaseqty() {
		return caseqty;
	}

	@FindBy(xpath = "//div[@class='row']//div[2]//div[2]//span[1]//a[1]")
	private WebElement updatemenu;  

	public WebElement getupdatemenu() {
		return updatemenu;
	}

	@FindBy(xpath = "//div[@class='col-sm-2 col-xs-7']//div[2]//div[2]//img[1]")
	private WebElement caseqtydownarrow;  

	public WebElement getcaseqtydownarrow() {
		return caseqtydownarrow;
	}

	@FindBy(xpath = "//div[@class='col-sm-2 col-xs-7']//div[2]//div[1]//img[1]")
	private WebElement caseqtyuparrow;  

	public WebElement getcaseqtyuparrow() {
		return caseqtyuparrow;
	}
	@FindBy(xpath = "//input[@id='ctl00_cphContent_btnUpdateCart']")

	private WebElement updatecartbtn;  

	public WebElement getupdatecartbtn() {
		return updatecartbtn;
	}
	@FindBy(xpath = "//input[@id='ctl00_cphContent_btnClearCart']")

	private WebElement clearcartbtn;  

	public WebElement getclearcartbtn() {
		return clearcartbtn;
	}

	@FindBy(xpath = "//button[@class='btn btn-primary btn-cartclear']")

	private WebElement popupbtn;  

	public WebElement getpopupbtn() {
		return popupbtn;
	}

	@FindBy(xpath = "//div[17]//a[1]//img[1]")

	private WebElement clickonimage;  

	public WebElement getclickonimage() {
		return clickonimage;
	}
	@FindBy(xpath = "//div[@class='row baseinfo-eq-height']//div[1]//div[1]//div[2]//div[1]//input[5]")
	private WebElement clickonimageaddtocartbtn;

	public WebElement getclickonimageaddtocartbtn() {
		return clickonimageaddtocartbtn;
	}
	@FindBy(xpath = "//img[@class='header-cart']")
	private WebElement cartmenubtn;

	public WebElement getcartmenubtn() {
		return cartmenubtn;

	}
	@FindBy(xpath = "//div[@class='mid-banner-warp-full']//img[@class='lazy']\r\n")  

	private WebElement btsshopall;

	public WebElement getbtsshopall() {
		return btsshopall;
	}

	@FindBy(xpath = "//div[@class='school-program-warp']//div[2]//a[1]//figure[1]//img[1]")  

	private WebElement writingtoolimage ;

	public WebElement getwritingtoolimage() {
		return writingtoolimage;
	}
	@FindBy(xpath = "//div[contains(@class,'right-penal')]//div[3]//div[1]//div[1]//div[2]//a[1]//div[1]//img[1]")  

	private WebElement itemimage ;

	public WebElement getitemimage() {
		return itemimage;
	}

	@FindBy(xpath = "//button[@class='cart_newbtn btn dd-btn-secondary btn-quick-view bold jqatc fsig gtmAddCart btn-group-lg']")  

	private WebElement addtomycart ;

	public WebElement getaddtomycart() {
		return addtomycart;
	}
	@FindBy(xpath = "//img[@class='header-cart']")  

	private WebElement viewcartitem ;

	public WebElement getviewcartitem() {
		return viewcartitem;
	}

	public void checkcart() throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		Thread.sleep(1000);
		//getSignIn().click();
		getMenuIcon().click();
		getbacktoschool().click();
		getaddtocart().click();
		getcartmenu().click();
		getcaseqty().click();
		getupdatemenu().click();
		getcaseqtydownarrow().click();
		getcaseqtyuparrow().click();
		getupdatecartbtn().click();
		getclearcartbtn().click();
		getpopupbtn().click();
		getclickonimage().click();
		getclickonimageaddtocartbtn().click();
		getcartmenubtn().click();
		getbtsshopall().click();
		getwritingtoolimage().click();
		getitemimage().click();
		getaddtomycart().click();
		getviewcartitem().click();
	

}

	


	public void clearcart() throws InterruptedException{

		getCarticon().click();
		Thread.sleep(1000);
		WebElement carttext = getCarticontxt();
		String h = carttext.getText();
		System.out.println("the value in the cart:" +h);
		if(Integer.parseInt(h)>0) {
			getclearcart().click();
			WebDriverWait wait = new WebDriverWait(driver,30);
			String clearcartpopupmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-cartclear']"))).getText();
			ExtentTestManager.getTest().log(Status.PASS, "Step : Pop up message is" +clearcartpopupmessage );
			//System.out.println("Pop up message for clear cart::: " + clearcartpopupmessage);
			ExtentTestManager.getTest().log(Status.PASS, "Step : Click on clear cart confirmation pop up");	
			getclearcartpopup().click();
		}
		else {
			System.out.println("The cart is already empty");
		}

	}
	
	public void MenuPPE() throws InterruptedException{
		getMenuIcon().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: click on Menu Icon ");
		Thread.sleep(1000);
		getPPEmask().click();//Identify Mask,sanitiser and PPE and click
		ExtentTestManager.getTest().log(Status.PASS, "Step 3 : Click on PPE Mask tab ");
		Thread.sleep(1000);
	}

	public void HandleAddtocartPopup()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"noreturnmodal\"]/div/div/div[2]/button")));
		String addtocartpopuptext = driver.findElement(By.id("noreturnmodal_msg")).getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step : Click on add to cart button and should display I accept button with pop up message as " + addtocartpopuptext);
		getaddtocartpopup().click();

	}
	public void searchbar() throws InterruptedException{
		//AddToCartPage addtocart = new AddToCartPage(driver);
		//driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/header/div/div/div/div[2]/div[1]/div[1]/input")).click();//searchbar
		getsearchbar().click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rfk_search_container\"]/div[3]/ul/li[1]/a/div[2]")));
		getitem3().click();
		
		
	}
	
}
	
	
	
	










