package com.bpract.mlmdemo.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.mlmdemo.pages.DemoHomePage;
import com.bpract.mlmdemo.pages.DemoLoginPage;
import com.bpract.mlmdemo.pages.DemoUserOnlineStorePage;

public class DemoUserOnlineStoreTest extends TestHelper{
	DemoLoginPage demologinpage;
	DemoHomePage demohomepage;
	DemoUserOnlineStorePage demouseronlinestorepage;
	@BeforeMethod
    @Parameters({"browser"})
    public void initialization(String browser) {
        driver = launchBrowser(browser);
    }
	@Test
	public void verifyProductCheckout() throws InterruptedException{
		demologinpage =  new DemoLoginPage(driver);
		demologinpage.login("harsha@bpract.com", "11223344");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard",true);
		demohomepage.clickOnlineStoreMenu();
		demohomepage.clickProductSubscriptionMenu();
		demouseronlinestorepage = new DemoUserOnlineStorePage(driver);
		Assert.assertTrue(demouseronlinestorepage.getProductSubscriptionMsg().contains("Product Subscription"));
		Reporter.log("Product Subscription dashbord",true);
		demouseronlinestorepage.selMonth("3 month");
		Assert.assertTrue(demouseronlinestorepage.getOrdersummeryMsg().contains("Order Summary"));
		Reporter.log("Order Summery!!!!",true);
	}

}
