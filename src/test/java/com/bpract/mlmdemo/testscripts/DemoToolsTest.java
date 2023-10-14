package com.bpract.mlmdemo.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.mlmdemo.pages.DemoHomePage;
import com.bpract.mlmdemo.pages.DemoLoginPage;
import com.bpract.mlmdemo.pages.DemoToolsPage;

public class DemoToolsTest extends TestHelper {
	@BeforeMethod
    @Parameters({"browser"})
    public void initialization(String browser) {
        driver = launchBrowser(browser);
    }
	
	DemoToolsPage demotoolspage;
	DemoHomePage demohomepage;
	DemoLoginPage demologinpage;
	
//	@Test
	public void verifyValidDocumentCreation() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickToolsMenu();
		demohomepage.clickDocumentsSubMenu();
		demotoolspage = new DemoToolsPage(driver);
		Assert.assertTrue(demotoolspage.getDocumentPageMsg().contains("Documents"));
		Reporter.log("Successfully navigate document dashboard",true);
		demotoolspage.clickToolsFileUploadBtn();
		demotoolspage.createToolsDocument("My new doc", "20", "C:\\Users\\MY pc\\Desktop\\sample doc\\Archery - RED.pdf");
		demotoolspage.searchInDocTable("My new doc");
	}
	@Test
	public void verifyValidVideoCreation() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickToolsMenu();
		demohomepage.clickToolsVideoMenu();
		demotoolspage = new DemoToolsPage(driver);
		Assert.assertTrue(demotoolspage.getToolsVideoMsg().contains("Videos"));
		Reporter.log("Successfully navigate video dashboard",true);
		demotoolspage.clickAddVideobtn();
		Assert.assertTrue(demotoolspage.getVideoAddMsg().contains("Add Video"));
		Reporter.log("add video details page",true);
		demotoolspage.toolsVideoCreation("My new Video", "https://vimeo.com/524933864");
	}
}
