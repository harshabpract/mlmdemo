package com.bpract.mlmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.mlmdemo.utilities.WaitUtility;

public class DemoLoginPage {
	WebDriver driver;
	
	@FindBy(name="email")
	WebElement loginEmail;
	@FindBy(name="password")
	WebElement loginPassword;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(),\"Login\")]")
	WebElement loginButton;
	@FindBy(xpath="//div[contains(text(),\"Wrong credentials!\")]")
	WebElement wrongCredentialMsg;
	@FindBy(xpath="//*[contains(text() , \"Forgot password?\")]")
	WebElement forgotPasswordLink;
	@FindBy(xpath="//*[contains(text(),\"Hi, Welcome Back\")]")
	WebElement resetpwdBackBtnMsg;
	@FindBy(xpath="//a[contains(text(),\"Get started\")]")
	WebElement getStartedLink;
	
	@FindBy(xpath="//p[contains(text(),\"Email is required\")]")
	WebElement emailRequiredMsg;
	@FindBy(xpath="//p[contains(text(),\"Password is required\")]")
	WebElement passwordRequiredMsg;
	@FindBy(xpath="//p[contains(text(),\"Email must be a valid email address\")]")
	WebElement invalidEmailMsg;
	
	
	
	
	WaitUtility waitutility = new WaitUtility();
	
	
	public DemoLoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
	
	public void enterEmail(String strEmail) {
		loginEmail.sendKeys(strEmail);
	}
	public void enterPassword(String strPassword) {
		loginPassword.sendKeys(strPassword);
	}
	public void clickLoginBtn() {
		loginButton.click();
	}
	
	public DemoHomePage login(String strEmail, String strPassword) {
		this.enterEmail(strEmail);
		this.enterPassword(strPassword);
		this.clickLoginBtn();
		return new DemoHomePage(driver);
	}
	public String getwrongCredentialMsg() {
		// TODO Auto-generated method stub
		waitutility.waitForAnElement(wrongCredentialMsg, driver);
		String wrongCredentialMsgText = wrongCredentialMsg.getText();
		return wrongCredentialMsgText;
	}
	
	public void clickForgotPassword() {
		forgotPasswordLink.click();
		 
	}
	public String getLoginPageWelcomeMsg() {
		waitutility.waitForAnElement(resetpwdBackBtnMsg, driver);
		String LoginPageWelcomeMsgText = resetpwdBackBtnMsg.getText();
		return LoginPageWelcomeMsgText;
				
	}
	
	public void clickGetStarted() {
		getStartedLink.click();
	}
	public String getEmailRequiredMsg() {
		waitutility.waitForAnElement(emailRequiredMsg, driver);
		String emailRequiredMsgText = emailRequiredMsg.getText();
		return emailRequiredMsgText;
	}
	
	public String getPasswordRequiredMsg() {
		waitutility.waitForAnElement(passwordRequiredMsg, driver);
		String passwordRequiredMsgText = passwordRequiredMsg.getText();
		return passwordRequiredMsgText;
		
	}
	
	public String getInvalidEmailMsg() {
		waitutility.waitForAnElement(invalidEmailMsg, driver);
		String invalidEmailMsgText = invalidEmailMsg.getText();
		return invalidEmailMsgText;
	}
}
