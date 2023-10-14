package com.bpract.mlmdemo.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.mlmdemo.pages.DemoLoginPage;
import com.bpract.mlmdemo.pages.DemoResetPasswordPage;

public class DemoForgotPasswordTest extends TestHelper  {
	
	DemoLoginPage demologinpage;
	DemoResetPasswordPage demoresetpasswordpage;
	
	@BeforeMethod
    @Parameters({"browser"})
    public void initialization(String browser) {
        driver = launchBrowser(browser);
    }
	
	@Test
	public void verifyValidEmailAddress() {
		demologinpage =new DemoLoginPage(driver);
		demologinpage.clickForgotPassword();
		demoresetpasswordpage = new DemoResetPasswordPage(driver);
		Assert.assertTrue(demoresetpasswordpage.getpasswordResetPageMsg().contains("Forgot your password?"));
		Reporter.log("You are in Forgot Password Page!!!", true);
		demoresetpasswordpage.forgotpassword("namita@bpract.com");
		Assert.assertTrue(demoresetpasswordpage.getPwRequestSentMsg().contains("Request sent successfully"));
		Reporter.log("Successfully sent password reset message", true);
	}
	
	@Test
	public void verifyResetPasswordBackButton() {
		demologinpage =new DemoLoginPage(driver);
		demologinpage.clickForgotPassword();
		demoresetpasswordpage = new DemoResetPasswordPage(driver);
		Assert.assertTrue(demoresetpasswordpage.getpasswordResetPageMsg().contains("Forgot your password?"));
		Reporter.log("You are in Forgot Password Page!!!", true);
		
		
		demoresetpasswordpage.clickRestPwdBackButton();
		demologinpage =new DemoLoginPage(driver);
		Assert.assertTrue(demologinpage.getLoginPageWelcomeMsg().contains("Hi, Welcome Back"));
		Reporter.log("successfully get login page welcome message!!");
		
	}
	
	
	

}
