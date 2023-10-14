package com.bpract.mlmdemo.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.mlmdemo.utilities.WaitUtility;

public class DemoResetPasswordPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(text() , \"Forgot your password?\")]")
	WebElement passwordResetPageMsg;
	@FindBy(name="email")
	WebElement forgotPasswordMsg;
	@FindBy(name="ResetPassword")
	WebElement resetpasswordButton;
	@FindBy(xpath="//*[contains(text() , \"Request sent successfully\")]")
	WebElement pwRequestSentMsg;
	@FindBy(name="reset-back")
	WebElement resetPasswordBackbtn;
	
	
	@FindBy(xpath="//*[contains(text() , \"Email is required\")]")
	WebElement emailRequiredMsg;
	
	WaitUtility waitutility = new WaitUtility();
	
	public DemoResetPasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getpasswordResetPageMsg() {
		waitutility.waitForAnElement(passwordResetPageMsg, driver);
		String passwordResetPageMsgText = passwordResetPageMsg.getText();
		return passwordResetPageMsgText;
		
	}
	public void enteremailaddress(String strEmail) {
		forgotPasswordMsg.sendKeys(strEmail);
	}
	public void clickResetPasswordBtn() {
		resetpasswordButton.click();
	}
	public void forgotpassword(String strEmail) {
		this.enteremailaddress(strEmail);
		this.clickResetPasswordBtn();
	}
	
	public String getPwRequestSentMsg() {
		waitutility.waitForAnElement(pwRequestSentMsg, driver);
		String pwRequestSentText = pwRequestSentMsg.getText();
		return pwRequestSentText;
	}
	
	
	
	
	public String getEmailRequiredMsg() {
		waitutility.waitForAnElement(emailRequiredMsg, driver);
		String emailRequiredText = emailRequiredMsg.getText();
		return emailRequiredText;
		
		
	}
	
	public void clickRestPwdBackButton() {
		resetPasswordBackbtn.click();
	}
	
		
	
	
	

}
