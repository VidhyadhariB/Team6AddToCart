package com.dollardays.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
	WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "sm_menu_ham")
	private WebElement menuButton;
	
	public WebElement getMenuButton() {
		return menuButton;
	}
	
	@FindBy(xpath="//h3[contains(text(),'Now Trending')]")
	private WebElement nowTrendingLabel;
	
	public WebElement getNowTrendingLabel() {
		return nowTrendingLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Back to School')]")
	public WebElement backToSchoolLabel;
	
	public WebElement getBackToSchoolLabel() {
		return backToSchoolLabel;
	}
	
	@FindBy(xpath="//*[contains(text(),'Masks, Sanitizer and PPE')]")
	public WebElement maskSanitizerPPELabel;
	public WebElement getMaskSanitizerPPELabel() {
		return maskSanitizerPPELabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Forward Backpacks')]")
	private WebElement forwardBackpacksLabel;
	
	public WebElement forwardBackpacksLabel() {
		return forwardBackpacksLabel;
	}
	
	@FindBy(xpath="//*[contains(text(),'Categories')]")
	private WebElement catagoriesLabel;
	
	public WebElement getCatagoriesLabel() {
		return catagoriesLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Baby')]")
	private WebElement babyLabel;
	
	public WebElement getBabyLabel() {
	 	return babyLabel;
	}
	
	@FindBy(xpath="//*[@class='menu-header highlight-cat']/h3")
	private WebElement babyOnSubMenuBabyLabel;
	
	public WebElement getBabyOnSubMenuBabyLabel() {
	 	return babyOnSubMenuBabyLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Backpacks')]")
	private WebElement backpacksLabel;
	
	public WebElement getBackpacksLabel() {
	 	return backpacksLabel;
	}
	@FindBy(xpath="//a[contains(text(),'Closeout Corner')]")
	private WebElement closeoutCornerLabel;
	public WebElement getCloseoutCornerLabel() {
	 	return closeoutCornerLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Clothing & Shoes')]")
	private WebElement clothingShoesLabel;
	public WebElement getClothingShoesLabel() {
	 	return clothingShoesLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Electronics')]")
	private WebElement electronicsLabel;
	public WebElement getElectronicsLabel() {
	 	return electronicsLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Food')]")
	private WebElement foodLabel;
	public WebElement getFoodLabel() {
	 	return foodLabel;
	}
		
	@FindBy(xpath="//a[contains(text(),'Hardware, Tools & Outdoors')]")
	private WebElement hardwareToolsOutdoorsLabel;
	public WebElement getHardwareToolsOutdoorsLabel() {
	 	return hardwareToolsOutdoorsLabel;
	}	
	
	@FindBy(xpath="//a[contains(text(),'Holiday & Party')]")
	private WebElement holidayPartyLabel;
	public WebElement getHolidayPartyLabel() {
	 	return holidayPartyLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Home & Kitchen')]")
	private WebElement homeKitchenLabel;
	public WebElement getHomeKitchenLabel() {
	 	return homeKitchenLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Personal Care')]")
	private WebElement personalCareLabel;
	public WebElement getPersonalCareLabel() {
	 	return personalCareLabel;
	}
		
	@FindBy(xpath="//a[contains(text(),'Pet Supplies')]")
	private WebElement petSuppliesLabel;
	public WebElement getPetSuppliesLabel() {
	 	return petSuppliesLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'PPE & Masks')]")
	private WebElement pPEMasksLabel;
	public WebElement getPPEMasksLabel() {
	 	return pPEMasksLabel;
	}
			
	@FindBy(xpath="//a[contains(text(),'School & Office')]")
	private WebElement schoolOfficeLabel;
	public WebElement getSchoolOfficeLabel() {
	 	return schoolOfficeLabel;
	}
		
	@FindBy(xpath="//a[contains(text(),'Toys & Games')]")
	private WebElement toysGamesLabel;
	public WebElement getToysGamesLabel() {
	 	return toysGamesLabel;
	}
		
	@FindBy(xpath="//*[contains(text(),'Programs')]")
	private WebElement programsLabel;
	public WebElement getProgramsLabel() {
	 	return programsLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'For Nonprofits')]")
	private WebElement forNonprofitsLabel;
	public WebElement getForNonprofitsLabel() {
	 	return forNonprofitsLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'For Educators')]")
	private WebElement forEducatorsLabel;
	public WebElement getForEducatorsLabel() {
	 	return forEducatorsLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'For Retailers')]")
	private WebElement forRetailersLabel;
	public WebElement getForRetailersLabel() {
	 	return forRetailersLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'For Emergency Preparedness')]")
	private WebElement forEmergencyPreparednessLabel;	
	public WebElement getForEmergencyPreparednessLabel() {
	 	return forEmergencyPreparednessLabel;
	}
	
	@FindBy(xpath="//*[contains(text(),'Help & Settings')]")
	private WebElement helpSettingsLabel;
	public WebElement getHelpSettingsLabel() {
	 	return helpSettingsLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Your Account')]")
	private WebElement yourAccountLabel;
	public WebElement getYourAccountLabel() {
	 	return yourAccountLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	private WebElement contactUsLabel;
	public WebElement getContactUsLabel() {
	 	return contactUsLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'FAQs')]")
	private WebElement fAQsLabel;
	public WebElement getFAQsLabel() {
	 	return fAQsLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Return Policy')]")
	private WebElement returnPolicyLabel;
	public WebElement getReturnPolicyLabel() {
	 	return returnPolicyLabel;
	}
	
	@FindBy(xpath="//a[contains(text(),'Shipping Policy')]")
	private WebElement shippingPolicyLabel;
	public WebElement getShippingPolicyLabel() {
	 	return shippingPolicyLabel;
	}	
	
	public void clickMenuButton() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(menuButton));
		getMenuButton().click();
	}
	
	public boolean verifyNowTrendingLabel() {
		return getNowTrendingLabel().isDisplayed();	
	}
	
	public boolean verifyBackToSchoolLabel() {	
		return getBackToSchoolLabel().isDisplayed();			
	}
	
	public boolean verifyMaskSanitizerPPELabel() {
		return getMaskSanitizerPPELabel().isDisplayed();	
	}
	
	public boolean verifyForwardBackpacksLabel() {
		return forwardBackpacksLabel().isDisplayed();	
	}	
	
	public boolean verifyCatagoriesLabel() {
		return getCatagoriesLabel().isDisplayed();	
	}	
	
	public boolean verifyBabyLabel() {
		return getBabyLabel().isDisplayed();	
	}	
	
	public boolean verifyBackpacksLabel() {
		return getBackpacksLabel().isDisplayed();	
	}
	
	public boolean verifyCloseoutCornerLabel() {
		return getCloseoutCornerLabel().isDisplayed();	
	}
	
	public boolean verifyClothingShoesLabel() {
		return getClothingShoesLabel().isDisplayed();	
	}
	
	public boolean verifyElectronicsLabel() {
		return getElectronicsLabel().isDisplayed();	
	}
	
	public boolean verifyFoodLabel() {
		return getFoodLabel().isDisplayed();	
	}
	
	
	
	public boolean verifyHardwareToolsOutdoorsLabel() {
		return hardwareToolsOutdoorsLabel.isDisplayed();	
		}
	public boolean verifyHolidayPartyLabel() {
		return holidayPartyLabel.isDisplayed();	
		}
	public boolean verifyHomeKitchenLabel() {
		return homeKitchenLabel.isDisplayed();	
		}	
	public boolean verifyPersonalCareLabel() {
		return personalCareLabel.isDisplayed();	
		}
	public boolean verifyPetSuppliesLabel() {
		return petSuppliesLabel.isDisplayed();	
		}
	public boolean verifyPPEMasksLabel() {
		return pPEMasksLabel.isDisplayed();	
		}
	public boolean verifySchoolOfficeLabel() {
		return schoolOfficeLabel.isDisplayed();	
		}
	public boolean verifyToysGamesLabel() {
		return toysGamesLabel.isDisplayed();	
		}
	public boolean verifyProgramsLabel() {
		return programsLabel.isDisplayed();	
		}
	public boolean verifyForNonprofitsLabel() {
		return forNonprofitsLabel.isDisplayed();	
		}
	public boolean verifyForEducatorsLabel() {
		return forEducatorsLabel.isDisplayed();	
		}
	public boolean verifyForRetailersLabel() {
		return forRetailersLabel.isDisplayed();	
		}
	public boolean verifyForEmergencyPreparednessLabel() {
		return forEmergencyPreparednessLabel.isDisplayed();	
		}
	public boolean verifyHelpSettingsLabel() {
		return helpSettingsLabel.isDisplayed();	
		}
	public boolean verifyYourAccountLabel() {
		return yourAccountLabel.isDisplayed();	
		}
	public boolean verifyContactUsLabel() {
		return contactUsLabel.isDisplayed();	
		}
	public boolean verifyFAQsLabel() {
		return fAQsLabel.isDisplayed();	
		}
	public boolean verifyReturnPolicyLabel() {
		return returnPolicyLabel.isDisplayed();	
		}
	public boolean verifyShippingPolicyLabel() {
		return shippingPolicyLabel.isDisplayed();	
		}	
	
	public void clickBackToSchool() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(backToSchoolLabel));
		backToSchoolLabel.click();
	}
	public void clickMaskSanitizerPPE() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(maskSanitizerPPELabel));
		maskSanitizerPPELabel.click();
	}
	public void clickForwardBackpacks() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(forwardBackpacksLabel));
		forwardBackpacksLabel.click();
	}
	public void clickBaby() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(babyLabel));
		babyLabel.click();
	}
	public void clickfAQs() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(fAQsLabel));
		fAQsLabel.click();
	}
}
