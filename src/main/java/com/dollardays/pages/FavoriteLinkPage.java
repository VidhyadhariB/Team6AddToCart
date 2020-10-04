package com.dollardays.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FavoriteLinkPage {

	@FindBy(xpath = "//*[@id='aspnetForm']/header/div/div/div/div[3]/div/ul/li[1]/a/img ")
	private WebElement profileIcon;

	@FindBy(xpath = "//*[@id='aspnetForm']/header/div/div/div/div[3]/div/ul/li[1]/ul/li[5]/a  ")
	private WebElement favoriteLink;

	@FindBy(xpath = "//*[@id='aspnetForm']/div[5]/div[2]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/input[5]  ")
	private WebElement addToCart;
	

	@FindBy(xpath = "//*[@id='noreturnmodal']/div/div/div[2]/button")
	private WebElement iAcceptpopup;

	@FindBy(xpath = "//*[@id='sm_menu_ham']   ")
	private WebElement menubtn;

	@FindBy(xpath = "//*[@id='header-main']/div/div/div[2]/div[1]/div[1]/input")
	private WebElement searchTxBox;

	@FindBy(xpath = "//*[@id='header-main']/div/div/div[2]/div[1]/div[1]/div/div/button")
	private WebElement searchTxBoxBtn;

	@FindBy(xpath = "//*[@id='central-content']/div[3]/div[1]/div/div/div[1]/div/div[3]/div[1]/a")
	private WebElement iteambtn;

	@FindBy(xpath = "//*[@id='example1']/div[2]/span/div")
	private WebElement heartIcon;

	@FindBy(xpath = "//*[@id='aspnetForm']/header/div/div/div/div[3]/div/ul/li[3]/div/a/img ")
	private WebElement cartIcon;

	@FindBy(xpath = "//*[@id='aspnetForm']/div[6]/div/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h6  ")
	private WebElement SkuCodefromcart;

	@FindBy(xpath = "//*[@id='aspnetForm']/div[5]/div[2]/div[2]/div/div[1]/div/div/div[1]/div/div[3]/div[1]/p")
	private WebElement skuCode;

	@FindBy(xpath = "//*[@id='aspnetForm']/div[5]/div[1]/div/div/div/div[2]/div/div/div[1]/div/div/div/select")
	private WebElement sortBybx;

	@FindBy(xpath = "//*[@id='aspnetForm']/div[5]/div[2]/div[2]/div/div[1]/div/div/div[1]/div/div[3]/div[2]/h3 ")
	private WebElement FirstItem;

	@FindBy(xpath = "//*[@id='aspnetForm']/div[5]/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div[3]/div[2]/h3 ")
	private WebElement SecondItem;

	@FindBy(xpath = "//*[@id='aspnetForm']/div[5]/div[2]/div[2]/div/div[1]/div/div/div[3]/div/div[3]/div[2]/h3 ")
	private WebElement ThirdItem;

	@FindBy(xpath="//a[@href='/logout.aspx'][@class='dropdown-item padditem margn-top']")
	private WebElement ClickSignOut;

	public FavoriteLinkPage(WebDriver driver) {
		// super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickProfileIconButton() {

		profileIcon.click();
	}

	public void clickfavoriteLink() {

		favoriteLink.click();
	}

	public void clickaddToCart() {

		addToCart.click();
	}

	public void clickiAcceptpopup() {

		iAcceptpopup.click();
	}

	public void clickcartIcon() {

		cartIcon.click();
	}

	public String getskuCode() {

		String skuCodeText = skuCode.getText();
		return skuCodeText;
	}

	public String getskuCodefromCart() {
		String skuCodeText1 = SkuCodefromcart.getText();
		return skuCodeText1;
	}

	public void clickSortBy(String dropDownValue) {

		Select sortbyprice = new Select(sortBybx);

		sortbyprice.selectByVisibleText(dropDownValue);

	}

	// public void clickSortByCaseQuantity() {
	// Select sortByCaseQuantity=new Select(sortBybx);
	// sortByCaseQuantity.selectByIndex(3);
	// }

	public String getFirstItem() {
		String firstItem = FirstItem.getText();
		return firstItem;
	}

	public String getSecondItem() {
		String secondItem = SecondItem.getText();
		return secondItem;
	}

	public String getThirdItem() {
		String thirdItem = ThirdItem.getText();
		return thirdItem;
	}
	public void ClickSignOut() {

		ClickSignOut.click();
	}

}