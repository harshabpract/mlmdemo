package com.bpract.mlmdemo.testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.mlmdemo.pages.DemoAdminCreateTicketPage;
import com.bpract.mlmdemo.pages.DemoCreateTicketPage;
import com.bpract.mlmdemo.pages.DemoHomePage;
import com.bpract.mlmdemo.pages.DemoLoginPage;

public class DemoCreateTicketTest extends TestHelper {
	DemoCreateTicketPage democreateticketpage;
	DemoHomePage demohomepage;
	DemoLoginPage demologinpage;
	DemoAdminCreateTicketPage demoadmincreateticketpage;
	
	@BeforeMethod
    @Parameters({"browser"})
    public void initialization(String browser) {
        driver = launchBrowser(browser);
    }
//	@Test
	public void verifyNavigateToSupportTicketDashboardInUserSide() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("harsha@bpract.com", "11223344");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickHelpCenterMenu();
		demohomepage.clickSupportTicketsMenu();
		democreateticketpage = new DemoCreateTicketPage(driver);
		Assert.assertTrue(democreateticketpage.getTicketDashboardMsg().contains("Support Tickets"));
		Reporter.log("Successfully navigate to ticket dashboard!!!");
		democreateticketpage.clickCreateTicketBtn();
		Assert.assertTrue(democreateticketpage.getCreateTicketMsg().contains("Create Ticket"));
		Reporter.log("create ticket!!!",true);
	}
//	@Test
	public void verifyTicketCanBeCreatedInUserSide() throws InterruptedException{
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("harsha@bpract.com", "11223344");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickHelpCenterMenu();
		demohomepage.clickSupportTicketsMenu();
		democreateticketpage = new DemoCreateTicketPage(driver);
		Assert.assertTrue(democreateticketpage.getTicketDashboardMsg().contains("Support Tickets"));
		Reporter.log("Successfully navigate to ticket dashboard!!!", true);
		democreateticketpage.clickCreateTicketBtn();
		democreateticketpage = new DemoCreateTicketPage(driver);
		Assert.assertTrue(democreateticketpage.getCreateTicketMsg().contains("Create Ticket"));
		Reporter.log("create ticket!!!",true);
		democreateticketpage.sendCreateTicket("department1", "normal", "category", "New user ticket", "C:\\Users\\MY pc\\Desktop\\img\\3.jpg", "Harsha");
//		dinamic table example
		democreateticketpage.getSubjectFromUserTicketTable("New user ticket");
	}
//	@Test
	public void verifyUserTicketWithBlankFields() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("harsha@bpract.com", "11223344");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickHelpCenterMenu();
		demohomepage.clickSupportTicketsMenu();
		democreateticketpage = new DemoCreateTicketPage(driver);
		Assert.assertTrue(democreateticketpage.getTicketDashboardMsg().contains("Support Tickets"));
		Reporter.log("Successfully navigate to ticket dashboard!!!");
		democreateticketpage.clickCreateTicketBtn();
		democreateticketpage = new DemoCreateTicketPage(driver);
		Assert.assertTrue(democreateticketpage.getCreateTicketMsg().contains("Create Ticket"));
		Reporter.log("create ticket!!!",true);
		democreateticketpage.clickSendRequestBtn();
		Assert.assertTrue(democreateticketpage.getBlankDepartmentMsg().contains("Please Select a department"));
		Reporter.log("Blank Department Msg displayed!!!",true);
		Assert.assertTrue(democreateticketpage.getBlankPriorityMsg().contains("Please Select a priority"));
		Reporter.log("Blank Priority Msg displayed!!!",true);
		Assert.assertTrue(democreateticketpage.getBlankCategoryMsg().contains("Please Select a category"));
		Reporter.log("Blank Category Msg displayed!",true);
		Assert.assertTrue(democreateticketpage.getBlankSubjectMsg().contains("Subject is required"));
		Reporter.log("Blank Subject Msg displayed!",true);
		Assert.assertTrue(democreateticketpage.getBlankDescriptionMsg().contains("Description Is Required"));
		Reporter.log("Blank Description Msg displayed!!",true);
		
	}
	
//admin
//	@Test
	public void verifyFieldBlankvalidationDisplayedInAdminside() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickAdminHelpcenterMenu();
		democreateticketpage = new DemoCreateTicketPage(driver);
		Assert.assertTrue(democreateticketpage.getAdminHelpCenterMsg().contains("Help Center"));
		Reporter.log("welcome to help center",true);
		democreateticketpage.clickAdminCreateTicketBtn();
//		democreateticketpage.enterAdmTicketDetails("", "", "", "", "", "", "");
		democreateticketpage.clickAdmAddBtn();
		Assert.assertTrue(democreateticketpage.getAdminUserRequiredMsg().contains("User is required"));
		Reporter.log("User field  Required Message displayed!!!",true);
		Assert.assertTrue(democreateticketpage.getAdminSubjectRequiredMsg().contains("Subject is required"));
		Reporter.log("Subject Required Message displayed!!!",true);
		Assert.assertTrue(democreateticketpage.getadmDescriptionReqMsg().contains("Description Name Is Required"));
		Reporter.log("Description required message displayed",true);
		Assert.assertTrue(democreateticketpage.getAdmPriorityReqMsg().contains("Priority is required"));
		Reporter.log("Priority Required Message displayed!!!",true);
		Assert.assertTrue(democreateticketpage.getadmDepartmentReqMsg().contains("Department is required"));
		Reporter.log("Department Required Message displayed!!!",true);
		Assert.assertTrue(democreateticketpage.getadmCategoryReqMsg().contains("Category is required"));
		Reporter.log("Category Required Message displayed!!!",true);
		Assert.assertTrue(democreateticketpage.getadmStatusReqMsg().contains("Status is required"));
		Reporter.log("Status Required Message displayed!!!",true);
	}
//	@Test
	public void verifyValidAdminCreateTicket() throws InterruptedException {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickAdminHelpcenterMenu();
		demoadmincreateticketpage = new DemoAdminCreateTicketPage(driver);
		Assert.assertTrue(demoadmincreateticketpage.getAdminHelpCenterMsg().contains("Help Center"));
		Reporter.log("welcome to help center",true);
		demoadmincreateticketpage.clickCreateTicketBtn();
		demoadmincreateticketpage.adminCreateTicket("jessica","ticket" ,"My aug description" ,"low" ,"test" ,"bug" ,"Open" , "C:\\Users\\MY pc\\Desktop\\sample doc\\mysample.pdf");
		demoadmincreateticketpage.searchInAdminTicketDashboard("jessica", "ticket");
//		Assert.assertTrue(demoadmincreateticketpage.getUsernameFromTicketTable().contains("jessica"));
//		Reporter.log("Created user found!", true);
//		Assert.assertTrue(demoadmincreateticketpage.getSubjectFromTicketTable().contains("my ticket new aug"));
//		Reporter.log("Created subject found!", true);
		
	}
//	@Test
	public void verifyValidAdminCreateDepartment() throws InterruptedException{
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickAdminHelpcenterMenu();
		demoadmincreateticketpage = new DemoAdminCreateTicketPage(driver);
		Assert.assertTrue(demoadmincreateticketpage.getAdminHelpCenterMsg().contains("Help Center"));
		Reporter.log("welcome to help center",true);
		demoadmincreateticketpage.clickDepartmentCreateMenu();
		demoadmincreateticketpage.clickDepartmentCreateBtn();
		Assert.assertTrue(demoadmincreateticketpage.getAddDepartmentPageMsg().contains("Add Department"));
		Reporter.log("Add Department Page!!!",true);
		demoadmincreateticketpage.createDepartmentDetails("dep name 3", "department des 3", "Yes", "3");
		demoadmincreateticketpage.searchInAdminTicketDepartment("dep name 3");
	}
	@Test
	public void verifyValidAdminCreateCategories() throws InterruptedException {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickAdminHelpcenterMenu();
		demoadmincreateticketpage = new DemoAdminCreateTicketPage(driver);
		Assert.assertTrue(demoadmincreateticketpage.getAdminHelpCenterMsg().contains("Help Center"));
		Reporter.log("welcome to help center",true);
		demoadmincreateticketpage.clickTktCategoriesmenu();
		demoadmincreateticketpage.clickTktCategoryAddBtn();
		Assert.assertTrue(demoadmincreateticketpage.getTktCategoriesPageMsg().contains("Add Category"));
		Reporter.log("Add Category page!!!",true);
		demoadmincreateticketpage.createTktCategories("harsha5", "My description5", "Yes");
		demoadmincreateticketpage.searchInAdminTicketCategory("harsha5");
	}
//	@Test
	public void verifyBlankAdminCreatePriority() {
		demologinpage = new DemoLoginPage(driver);
		demologinpage.login("info@cloudlumen.com", "12345678");
		demohomepage = new DemoHomePage(driver);
		Assert.assertTrue(demohomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("welcome to dashboard!!!",true);
		demohomepage.clickAdminCommunicationMenu();
		demohomepage.clickAdminHelpcenterMenu();
		demoadmincreateticketpage = new DemoAdminCreateTicketPage(driver);
		Assert.assertTrue(demoadmincreateticketpage.getAdminHelpCenterMsg().contains("Help Center"));
		Reporter.log("welcome to help center",true);
		demoadmincreateticketpage.clickPriorityMenu();
		demoadmincreateticketpage.clickPriorityAddBtn();
		Assert.assertTrue(demoadmincreateticketpage.getAddPriorityMsg().contains("Add Priority"));
		Reporter.log("Add Priority Page!!!", false);
		demoadmincreateticketpage.clickPrioritySubmitBtn();
		Assert.assertTrue(demoadmincreateticketpage.getPriorityRequireMsg().contains("Name is required"));
		Reporter.log("Name is required validation displayed!!",true);
		Assert.assertTrue(demoadmincreateticketpage.getPriorityColorRequiredMsg().contains("Color is required"));
		Reporter.log("Color is required validation displayed!!",true);
		Assert.assertTrue(demoadmincreateticketpage.getPriorityDescriptionRequiredMsg().contains("Description is required"));
		Reporter.log("Description is required validation displayed!!",true);
	}
	

}
