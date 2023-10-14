package com.bpract.mlmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.mlmdemo.utilities.WaitUtility;

public class DemoRegisterPage {
	WebDriver driver;
	
	
	@FindBy(xpath="//h3[contains(text(),\"Register New Member \")]")
	WebElement registerNewMemberMsg;
	@FindBy(name="email")
	WebElement registerEmail;
	@FindBy(name="username")
	WebElement registerUsername;
	@FindBy(name="password")
	WebElement registerPassword;
	@FindBy(name="repassword")
	WebElement registerRepassword;
	@FindBy(name="referral")
	WebElement registerReferral;
	@FindBy(name="register")
	WebElement RegisterBtn;
	@FindBy(xpath="//p[contains(text(),\"Email is required\")]") //blank field test
	WebElement emailIsRequiredMsg;
	@FindBy(xpath="//p[contains(text(),\"User Name is required\")]")//blank field test
	WebElement usernameIsRequiredMsg;
	@FindBy(xpath="//p[contains(text(),\"Password must be at least 8 characters\")]")//blank field test
	WebElement passwordIsRequiredMsg;
	@FindBy(xpath="//p[contains(text(),\"Password must match\")]")//unique password
	WebElement pwdMustMatchMsg;
	@FindBy(xpath="//p[contains(text(),\"Email must be a valid email address\")]")
	WebElement invalidEmailMsg;
	
	WaitUtility waitutility = new WaitUtility();
	
	public DemoRegisterPage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	public String getRegisterNewMemberMsg() {
		waitutility.waitForAnElement(registerNewMemberMsg, driver);
		String registerNewMemberMsgText = registerNewMemberMsg.getText();
		return registerNewMemberMsgText;	
	}
	
	public void enterEmailAddress(String strEmail) {
		registerEmail.sendKeys(strEmail);	
	}
	public void enterUsername(String strUsername) {
		registerUsername.sendKeys(strUsername);
	}
	public void enterPassword(String strPassword) {
		registerPassword.sendKeys(strPassword);
	}
	public void enterRePassword(String strRepassword) {
		registerRepassword.sendKeys(strRepassword);
	}
	public void enterReferral(String strReferral) {
		registerReferral.sendKeys(strReferral);
	}
	public void clickRegisterBtn() {
		RegisterBtn.click();
	}
	
	public DemoHomePage register(String strEmail, String strUsername, String strPassword, String strRepassword,String strReferral) {
		this.enterEmailAddress(strEmail);
		this.enterUsername(strUsername);
		this.enterPassword(strPassword);
		this.enterRePassword(strRepassword);
		this.enterReferral(strReferral);
		this.clickRegisterBtn();
		return new DemoHomePage(driver);
	}
	
	public String getEmailIsRequiredMsg() {
		waitutility.waitForAnElement(emailIsRequiredMsg, driver);
		String emailIsRequiredMsgText = emailIsRequiredMsg.getText();
		return emailIsRequiredMsgText;
	}
	public String getuUernameIsRequiredMsg() {
		waitutility.waitForAnElement(usernameIsRequiredMsg, driver);
		String usernameIsRequiredMsgText = usernameIsRequiredMsg.getText();
		return usernameIsRequiredMsgText;
	}
	
	public String getPasswordIsRequiredMsg() {
		waitutility.waitForAnElement(passwordIsRequiredMsg, driver);
		String passwordIsRequiredMsgText = passwordIsRequiredMsg.getText();
		return passwordIsRequiredMsgText;
	}
	public String getPwdMustMatchMsg() {
		waitutility.waitForAnElement(pwdMustMatchMsg, driver);
		String pwdMustMatchMsgText = pwdMustMatchMsg.getText();
		return pwdMustMatchMsgText;
	}
	public String getInvalidEmailMsg() {
		waitutility.waitForAnElement(invalidEmailMsg, driver);
		String invalidEmailMsgText = invalidEmailMsg.getText();
		return invalidEmailMsgText;
	}

}
