package com.bpract.mlmdemo.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.mlmdemo.pages.DemoCommunicationPage;
import com.bpract.mlmdemo.pages.DemoHomePage;
import com.bpract.mlmdemo.pages.DemoLoginPage;

public class DemoCommunicationTest extends TestHelper{
	DemoLoginPage demologinpage;
	DemoHomePage demohomepage;
	DemoCommunicationPage democommunicationpage;
	@BeforeMethod
    @Parameters({"browser"})
    public void initialization(String browser) {
        driver = launchBrowser(browser);
    }
//	@Test
	public void verifyFAQcategory() throws InterruptedException {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickFaqMenu();
		democommunicationpage = new DemoCommunicationPage(driver);
		Assert.assertTrue(democommunicationpage.getFaqDashbordMsg().contains("FAQ's"));
		Reporter.log("FAQ Dashboard Page!!!",true);
		democommunicationpage.clickFaqCategoryBtn();
		democommunicationpage.clickFaqAddCategory();
		Assert.assertTrue(democommunicationpage.getAddFaqCategoryPageMsg().contains("Add FAQ's Category"));
		Reporter.log("Add Faq Category Page !!!!",true);
		democommunicationpage.FaqCategoryDetails("har cat13", "har cat desc9", "Enabled");
		democommunicationpage.searchInAdminFaqCategory("har cat13");

	}
//	@Test
	public void verifyFAQ() throws InterruptedException {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickFaqMenu();
		democommunicationpage = new DemoCommunicationPage(driver);
		Assert.assertTrue(democommunicationpage.getFaqDashbordMsg().contains("FAQ's"));
		Reporter.log("FAQ Dashboard Page!!!",true);
		democommunicationpage.clickFaqAddBtn();
		Assert.assertTrue(democommunicationpage.getAddFaqMsg().contains("Add FAQ's"));
		Reporter.log("Add FAQ's Message Found!!!",true);
		democommunicationpage.addFaqDetails("Faq Category One", "My question7??", "My answer7");
		democommunicationpage.searchInAdminFaq("My question7??");
	}
//Articles
//	@Test
	public void verifyArticlesCategoryWithValidData() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickArticlesMenu();
		democommunicationpage = new DemoCommunicationPage(driver);
		democommunicationpage.clickArticleCategoryMenu();
		democommunicationpage.clickAddArticleCategory();
		Assert.assertTrue(democommunicationpage.getAddArticleCategoryPageMsg().contains("Add Article Category"));
		Reporter.log("Add Article Category Page Message Found!!!",true);
		democommunicationpage.articleCategoryDetails("article cat name 22", "cat 22 description");
		democommunicationpage.searchInAdminArticleCategory("article cat name 22");
	}
//	@Test
	public void verifyCreateArticlesValidData() throws InterruptedException {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickArticlesMenu();
		democommunicationpage = new DemoCommunicationPage(driver);
		democommunicationpage.clickAddArticle();
		Assert.assertTrue(democommunicationpage.getAddArticleMsg().contains("Add Article"));
		Reporter.log("Add article message Found!!!",true);
		democommunicationpage.addArticleDetails("artcle name3", "cat3", "artcle name3 description");
		democommunicationpage.searchInAdminArticle("artcle name3");
	}
	

}
