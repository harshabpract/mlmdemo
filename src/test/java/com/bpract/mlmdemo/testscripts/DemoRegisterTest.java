package com.bpract.mlmdemo.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.mlmdemo.pages.DemoHomePage;
import com.bpract.mlmdemo.pages.DemoLoginPage;
import com.bpract.mlmdemo.pages.DemoRegisterPage;

public class DemoRegisterTest extends TestHelper {
	DemoRegisterPage demoregisterpage;
	DemoHomePage demohomepage;
	DemoLoginPage demologinpage;
	
	@BeforeMethod
    @Parameters({"browser"})
    public void initialization(String browser) {
        driver = launchBrowser(browser);
    }
	
	//@Test
	public void verifyRegisterPage() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.clickGetStarted();
		demoregisterpage = new DemoRegisterPage(driver);
		Assert.assertTrue(demoregisterpage.getRegisterNewMemberMsg().contains("Register New Member"));
		Reporter.log("successfully navigate to register page!!!",true);
		
	}
	
	//@Test
	
	public void verifyRegistrationWithValidData() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.clickGetStarted();
		demoregisterpage = new DemoRegisterPage(driver);
		Assert.assertTrue(demoregisterpage.getRegisterNewMemberMsg().contains("Register New Member"));
		Reporter.log("successfully navigate to register page!!!",true);
		demohomepage = demoregisterpage.register("harsha@bpract.com", "harsha123", "11223344", "11223344", "mlmadmin");
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("Register Successful!!!",true);
		
	}
	
	//@Test
	public void verifyRegistrationWithBlankFields() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.clickGetStarted();
		demoregisterpage = new DemoRegisterPage(driver);
		Assert.assertTrue(demoregisterpage.getRegisterNewMemberMsg().contains("Register New Member"));
		Reporter.log("successfully navigate to register page!!!",true);
		demoregisterpage.register("", "", "", "", "");
		Assert.assertTrue(demoregisterpage.getEmailIsRequiredMsg().contains("Email is required"));
		Reporter.log("Email required message displayed!!!",true);
		Assert.assertTrue(demoregisterpage.getuUernameIsRequiredMsg().contains("User Name is required"));
		Reporter.log("Username required message displayed!!!",true);
		Assert.assertTrue(demoregisterpage.getPasswordIsRequiredMsg().contains("Password must be at least 8 characters"));
		Reporter.log("Password required message displayed!!!",true);
		
		
	}
	
	//@Test
	public void verifyRegistrationWithUniquePasswordAndConfirmPassword() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.clickGetStarted();
		demoregisterpage = new DemoRegisterPage(driver);
		Assert.assertTrue(demoregisterpage.getRegisterNewMemberMsg().contains("Register New Member"));
		Reporter.log("successfully navigate to register page!!!",true);
		demohomepage = demoregisterpage.register("madhu123@bpract.com", "madhu123", "123456789", "11223344", "mlmadmin");
		Assert.assertTrue(demoregisterpage.getPwdMustMatchMsg().contains("Password must match"));
		Reporter.log("Password must match message displayed ",true);
		
	}
	
	@Test
	public void verifyUserRegistrationWithInvalidEmail() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.clickGetStarted();
		demoregisterpage = new DemoRegisterPage(driver);
		Assert.assertTrue(demoregisterpage.getRegisterNewMemberMsg().contains("Register New Member"));
		Reporter.log("successfully navigate to register page!!!",true);
		demohomepage = demoregisterpage.register("dddddd", "madhu123", "123456789", "11223344", "mlmadmin");
		Assert.assertTrue(demoregisterpage.getInvalidEmailMsg().contains("Email must be a valid email address"));
		Reporter.log("Invalid Email Message Displayed!!!",true);
		
	}
	
	

}
