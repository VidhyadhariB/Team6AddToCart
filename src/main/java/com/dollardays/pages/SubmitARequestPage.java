package com.dollardays.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitARequestPage {
	
	WebDriver driver;
	
	public SubmitARequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/a/img")
	private WebElement signInBtn;

	public WebElement signInBtn() {
	return signInBtn;
	
	}
	@FindBy(linkText = "Submit A Request")
	private WebElement submitARequestLink;

	public WebElement submitARequestLink() {
	return submitARequestLink;
	
	}
	@FindBy(xpath = "//*[@id=\"ctl00_cphContent_txtemail\"]")
	private WebElement emailTextBox;

	public WebElement emailTextBox() {
	return emailTextBox;
	
	}	
	@FindBy(xpath = "//*[@id=\"ctl00_cphContent_txtPhone\"]")
	private WebElement phoneNumTextBox;

	public WebElement phoneNumTextBox() {
	return phoneNumTextBox;
	
	}	
	@FindBy(xpath = "//*[contains(@class,'form-control blg_cc_month')]")
	private WebElement selectARequestType;

	public WebElement selectARequestType() {
	return selectARequestType;
	
	}
	@FindBy(xpath = "//*[@id=\"ctl00_cphContent_txtOrderNo\"]")
	private WebElement OrderNoTxtBox;

	public WebElement OrderNoTxtBox() {
	return OrderNoTxtBox;
	
	}
	@FindBy(xpath = "//*[@id=\"ctl00_cphContent_txtNote\"]")
	private WebElement messageTextBox;

	public WebElement messageTextBox() {
	return messageTextBox;
	
	}
	
	@FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
	private WebElement iamnotARobotCheckBox;

	public WebElement iamnotARobotCheckBox(){
	return iamnotARobotCheckBox;
	
	}
	@FindBy(xpath = "//*[@id=\"ctl00_cphContent_btnCreate\"]")
	private WebElement submitBtn;

	public WebElement submitBtn(){
	return submitBtn;
	}
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[6]/div/div[1]/div/div/div")
	private WebElement submitARequestSuccessMessage;

	public WebElement submitARequestSuccessMessage(){
	return submitARequestSuccessMessage;
	}
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[6]/div/div[2]/div/div/p")
	private WebElement helpmessage;

	public WebElement helpmessage(){
	return helpmessage;
	}
		
}
