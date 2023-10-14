package com.bpract.mlmdemo.testscripts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.mlmdemo.pages.DemoHomePage;
import com.bpract.mlmdemo.pages.DemoLoginPage;
import com.bpract.mlmdemo.pages.DemoProfilePage;

public class DemoProfileTest extends TestHelper{
	
	DemoProfilePage demoprofilepage;
	DemoLoginPage demologinpage;
	DemoHomePage demohomepage;
	
	
	@BeforeMethod
    @Parameters({"browser"})
    public void initialization(String browser) {
        driver = launchBrowser(browser);
    }
	
	
	//@Test
	public void verifyEditInfoWithValidData() throws InterruptedException{
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("harsha@bpract.com", "11223344");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard",true);
		demohomepage.clickMyProfileBtn();
		demoprofilepage = new DemoProfilePage(driver);
		Assert.assertTrue(demoprofilepage.getactivityHistoryMsg().contains("Your Activity History"));
		Reporter.log("You are on profile!!!", true);
		
		demoprofilepage.clickEditInfoMenu();
		Assert.assertTrue(demoprofilepage.getEditInfoPageMsg().contains("Social Media Scope"));
		Reporter.log("You are on edit info page!!!",true);
		
		demoprofilepage.editinfo("harsha", "pp", "female", "Angola", "kerala", "palakkad", "788787", "home", "7894561233");
		demoprofilepage.clickSaveBtn();
	}
	
	//@Test
	public void verifyPasswordUpdationIsWorking() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("harsha@bpract.com", "11223344");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard",true);
		demohomepage.clickMyProfileBtn();
		demoprofilepage = new DemoProfilePage(driver);
		Assert.assertTrue(demoprofilepage.getactivityHistoryMsg().contains("Your Activity History"));
		Reporter.log("You are on profile!!!", true);
		demoprofilepage.clickSettingsBtn();
		demoprofilepage.settingsPassworUpdate("12345678", "12345678");
		demoprofilepage.clickSettingsPwdSubmitBtn();
	}
	//@Test
	public void verifyPasswordUpdationFieldOnlyAcceptMin8CharaLength() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("harsha@bpract.com", "11223344");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard",true);
		demohomepage.clickMyProfileBtn();
		demoprofilepage = new DemoProfilePage(driver);
		Assert.assertTrue(demoprofilepage.getactivityHistoryMsg().contains("Your Activity History"));
		Reporter.log("You are on profile!!!", true);
		demoprofilepage.clickSettingsBtn();
		demoprofilepage.settingsPassworUpdate("1234", "1234");
		demoprofilepage.clickSettingsPwdSubmitBtn();
		Assert.assertTrue(demoprofilepage.getPwdLengthMsg().contains("Password must be at least 8 characters"));
		Reporter.log("Password length validation displayed!!!",true);
	}
	
	//@Test
	public void verifyUpdatePwdWithBlankFields() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("harsha@bpract.com", "11223344");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard",true);
		demohomepage.clickMyProfileBtn();
		demoprofilepage = new DemoProfilePage(driver);
		Assert.assertTrue(demoprofilepage.getactivityHistoryMsg().contains("Your Activity History"));
		Reporter.log("You are on profile!!!", true);
		demoprofilepage.clickSettingsBtn();
		demoprofilepage.settingsPassworUpdate("", "");
		demoprofilepage.clickSettingsPwdSubmitBtn();
		Assert.assertTrue(demoprofilepage.getPwdBlankMsg().contains("Password must be at least 8 characters"));
		Reporter.log(" blank Password validation displayed!!!",true);
		
	}
	//@Test  //checking whether the entered values displayed on profile page
	public void verifyProfileInfo() throws InterruptedException{
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("harsha@bpract.com", "11223344");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard",true);
		demohomepage.clickMyProfileBtn();
		demoprofilepage = new DemoProfilePage(driver);
		Assert.assertTrue(demoprofilepage.getactivityHistoryMsg().contains("Your Activity History"));
		Reporter.log("You are on profile!!!", true);
		
		demoprofilepage.clickEditInfoMenu();
		Assert.assertTrue(demoprofilepage.getEditInfoPageMsg().contains("Social Media Scope"));
		Reporter.log("You are on edit info page!!!",true);
		
		demoprofilepage.updateEditInfo("harsha", "pp", "female", "Angola", "kerala", "palakkad", "788787", "home", "7894561233");
		demoprofilepage.clickProfileBtn();
		
		Assert.assertTrue(demoprofilepage.getFirstnameLastnameMsg().contains("harsha pp"));
		Reporter.log("getFirstnameLastnameMsg updated successfully!!!",true);
		Assert.assertTrue(demoprofilepage.getGenderMsg().contains("female"));
		Reporter.log("getGenderMsg updated successfully!!!",true);
		Assert.assertTrue(demoprofilepage.getMobileMsg().contains("7894561233"));
		Reporter.log("getMobileMsg updated successfully!!!",true);
		Assert.assertTrue(demoprofilepage.getZipcodeMsg().contains("788787"));
		Reporter.log("getZipcodeMsg updated successfully!!!",true);
		Assert.assertTrue(demoprofilepage.getAddressMsg().contains("home"));
		Reporter.log("getAddressMsg updated successfully!!!",true);
		Assert.assertTrue(demoprofilepage.getcityMsg().contains("palakkad"));
		Reporter.log("Edit info updated successfully!!!",true);
	}
//	@Test
	public void verifyProfileWithCoinAddress() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("harsha@bpract.com", "11223344");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard",true);
		demohomepage.clickMyProfileBtn();
		demoprofilepage = new DemoProfilePage(driver);
		Assert.assertTrue(demoprofilepage.getactivityHistoryMsg().contains("Your Activity History"));
		Reporter.log("You are on profile!!!", true);
		demoprofilepage.clickSettingsBtn();
		Assert.assertTrue(demoprofilepage.getCoinAddressFieldMsg().contains("Change Coin Address"));
		Reporter.log("getCoinAddressFieldMsg displayed",true);
		demoprofilepage.clearUpdateCoinAddress("AAAA", "BBBB", "CCCC", "DDDD");
		demoprofilepage.clickCoinAddressSaveBtn();
		
		
	}
	@Test
	public void uploadUserProfileImage() throws AWTException, InterruptedException {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("harsha@bpract.com", "11223344");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard",true);
		demohomepage.clickMyProfileBtn();
		demoprofilepage = new DemoProfilePage(driver);
		Assert.assertTrue(demoprofilepage.getactivityHistoryMsg().contains("Your Activity History"));
		Reporter.log("You are on profile!!!", true);
		demoprofilepage.clickEditInfoMenu();
		Assert.assertTrue(demoprofilepage.getEditInfoPageMsg().contains("Social Media Scope"));
		Reporter.log("You are on edit info page!!!",true);
		demoprofilepage.profileImgUpload("C:\\Users\\MY pc\\Desktop\\img\\logo2.png");
		
	}
	

}
