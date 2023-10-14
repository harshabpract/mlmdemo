package com.bpract.mlmdemo.testscripts;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.mlmdemo.pages.DemoAdminBlogPage;
import com.bpract.mlmdemo.pages.DemoHomePage;
import com.bpract.mlmdemo.pages.DemoLoginPage;

public class DemoAdminBlogTest extends TestHelper{
	DemoLoginPage demologinpage;
	DemoHomePage demohomepage;
	DemoAdminBlogPage demoadminblogpage;
	
	@BeforeMethod
    @Parameters({"browser"})
    public void initialization(String browser) {
        driver = launchBrowser(browser);
    }
//	@Test
	public void verifyBlogCategoryWithValidData() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickBlogMenu();
		demoadminblogpage = new DemoAdminBlogPage(driver);
		demoadminblogpage.clickBlogCategoryBtn();
		Assert.assertTrue(demoadminblogpage.getBlogCatPageMsg().contains("Blog Category"));
		Reporter.log("Blog category Page Message Found!!",true);
		demoadminblogpage.clickBlogCategoryBtn();
		Assert.assertTrue(demoadminblogpage.getAddCategoryMsg().contains("Add Category"));
		Reporter.log("Add category Page Message Found!!",true);
		demoadminblogpage.blogCategoryDetails("cat name2", "cat description2");
		demoadminblogpage.searchInAdminBlogCategory("cat name2");
		
	}
//	@Test
	public void verifyPrivateBlogWithValidData() throws InterruptedException, AWTException {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickBlogMenu();
		demoadminblogpage = new DemoAdminBlogPage(driver);
		demoadminblogpage.clickCreatePostBtn();
		demoadminblogpage.pvtBlogDetails("HarshaTitle1", "sponsor", "jeep", "HarshaMetaKey1", "HarshaMetaDes1", "HarshaDescription1", "Harshashort1", "C:\\Users\\MY pc\\Desktop\\img\\doc3.pdf", "C:\\Users\\MY pc\\Desktop\\img\\3.jpg");
		demoadminblogpage.searchInAdminBlog("HarshaTitle1");
	}
	@Test
	public void verifyPublicBlogWithValidData() throws InterruptedException, AWTException {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickBlogMenu();
		demoadminblogpage = new DemoAdminBlogPage(driver);
		demoadminblogpage.clickCreatePostBtn();
		demoadminblogpage.publicRadioBtn();
		demoadminblogpage.publicBlogDetails("HarshaTitle2", "sponsor", "HarshaMetaKey2", "HarshaMetaDes2", "HarshaDescription2", "Harshashort2", "C:\\Users\\MY pc\\Desktop\\img\\doc3.pdf", "C:\\Users\\MY pc\\Desktop\\img\\3.jpg");
		demoadminblogpage.searchInAdminBlog("HarshaTitle2");
		
	}
	
	
	

}
