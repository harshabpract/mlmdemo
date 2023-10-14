package com.bpract.mlmdemo.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.mlmdemo.pages.DemoHomePage;
import com.bpract.mlmdemo.pages.DemoLoginPage;


public class DemoLoginTest extends TestHelper{
	DemoLoginPage demologinpage;
	DemoHomePage demohomepage;
	
	@BeforeMethod
    @Parameters({"browser"})
    public void initialization(String browser) {
        driver = launchBrowser(browser);
    }
	
	@Test
	public void verifyUserLoginWithValidData() {
		demologinpage = new DemoLoginPage(driver);
		demohomepage = demologinpage.login("harsha@bpract.com", "12345678");
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("Login Success!!!", true);
	}
	
	//@Test
	public void verifyUserLoginWithInvalidPassword() {
		demologinpage = new DemoLoginPage(driver);
        demologinpage.login("info@cloudlumen.com", "111111111");
        Assert.assertTrue(demologinpage.getwrongCredentialMsg().contains("Wrong credentials!"));
        Reporter.log("Login Failed!", true);		
	}	
	
	//@Test
	public void verifyUserLoginWithBlankCredential() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("", "");
		Assert.assertTrue(demologinpage.getEmailRequiredMsg().contains("Email is required"));
		Reporter.log("email is required!!!!",true);
		Assert.assertTrue(demologinpage.getPasswordRequiredMsg().contains("Password is required"));
		Reporter.log("password is required",true);
	}
	//@Test
	public void verifyUserLoginWithInvalidEmailAddress() {//space in email
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("  info@cloudlumen.com", "12345678");
		Assert.assertTrue(demologinpage.getInvalidEmailMsg().contains("Email must be a valid email address"));
		Reporter.log("email wont accept space",true);
	}
	
	
}
