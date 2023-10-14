package com.bpract.mlmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.mlmdemo.utilities.PageUtility;
import com.bpract.mlmdemo.utilities.TableUtility;
import com.bpract.mlmdemo.utilities.WaitUtility;

public class DemoCreateTicketPage {
	WebDriver driver;
	@FindBy(xpath="//h4[contains(text(),\"Support Tickets\")]")
	WebElement ticketDashboardMsg;
	@FindBy(name="create-ticket")
	WebElement createTicketBtn;
	@FindBy(xpath="//h4[contains(text(),\"Create Ticket\")]")
	WebElement createTicketMsg;
	@FindBy(name="department_id")
	WebElement departmentDropdown;
	@FindBy(name="priority_id")
	WebElement priorityDropdown;
	@FindBy(name="category_id")
	WebElement categoryDropdown;
	@FindBy(name="subject")
	WebElement subject;
	@FindBy(name="attachments_url")
	WebElement attachedFile;
	@FindBy(xpath="//*[@id=\"description\"]/div/div[1]")
	WebElement description;
	@FindBy(name="sent-request")
	WebElement sendRequestBtn;
//	user ticket blank messages
	@FindBy(xpath="//p[contains(text(),\"Please Select a department\")]")
	WebElement blankDepartmentMsg;
	@FindBy(xpath="//p[contains(text(),\"Please Select a priority\")]")
	WebElement blankPriorityMsg;
	@FindBy(xpath="//p[contains(text(),\"Please Select a category\")]")
	WebElement blankCategoryMsg;
	@FindBy(xpath="//p[contains(text(),\"Subject is required\")]")
	WebElement blankSubjectMsg;
	@FindBy(xpath="//p[contains(text(),\"Description is required\")]")
	WebElement blankDescriptionMsg;
	
	
//	Admin side
	@FindBy(xpath="//h4[contains(text(),\"Help Center\")]")
    WebElement adminHelpCenterMsg;
	@FindBy(name="create-ticket")
	WebElement adminCreateTicketBtn;
	@FindBy(xpath="//p[contains(text(),\"User is required\")]")
	WebElement adminUserRequiredMsg;
	@FindBy(xpath="//p[contains(text(),\"Subject is required\")]")
	WebElement adminSubjectRequiredMsg;
	@FindBy(xpath="//p[contains(text(),\"Description Name is required\")]")
	WebElement admDescriptionReqMsg;
	@FindBy(xpath="//p[contains(text(),\"Priority is required\")]")
	WebElement admPriorityReqMsg;
	@FindBy(xpath="//p[contains(text(),\"Department is required\")]")
	WebElement admDepartmentReqMsg;
	@FindBy(xpath="//p[contains(text(),\"Category is required\")]")
	WebElement admCategoryReqMsg;
	@FindBy(xpath="//p[contains(text(),\"Status is required\")]")
	WebElement admStatusReqMsg;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(),\"Add\")]")
	WebElement admAddBtn;
	
	
	@FindBy(xpath="//table[@name=\"all-tickets\"]/tbody")
	WebElement userTicketTable;
	
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	TableUtility tableutility = new TableUtility();
	
	
	public DemoCreateTicketPage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	public String getTicketDashboardMsg() {
		waitutility.waitForAnElement(ticketDashboardMsg, driver);
		String ticketDashboardMsgText = ticketDashboardMsg.getText();
		return ticketDashboardMsgText;		
	}
	public void clickCreateTicketBtn() {
		createTicketBtn.click();
	}
	public String getCreateTicketMsg() {
		waitutility.waitForAnElement(createTicketMsg, driver);
		String createTicketMsgText = createTicketMsg.getText();
		return createTicketMsgText;
	}

	public void selectDepartmentDropdown(String strDepartmentDropdown) throws InterruptedException {
		pageutility.selectByVisibleText(departmentDropdown, driver, strDepartmentDropdown);
	}
	public void selectPriorityDropdown(String strPriorityDropdown) throws InterruptedException {
		pageutility.selectByVisibleText(priorityDropdown, driver, strPriorityDropdown);
	}
	public void selectCategoryDropdown(String strCategoryDropdown) throws InterruptedException {
		pageutility.selectByVisibleText(categoryDropdown, driver, strCategoryDropdown);
	}
	public void enterSubject(String strSubject) {
		waitutility.waitForAnElement(subject, driver);
		subject.sendKeys(strSubject);
	}
	public void uploadAttachment(String strPath) {
		waitutility.waitForAnElement(attachedFile, driver);
		pageutility.uploadFiles(attachedFile, driver, strPath);	
	}
	public void enterDescription(String strDescription) {
		waitutility.waitForAnElement(description, driver);
		description.sendKeys(strDescription);
	}
	public void clickSendRequestBtn() {
		sendRequestBtn.click();
	}
	public void sendCreateTicket(String strDepartmentDropdown ,String strPriorityDropdown ,String strCategoryDropdown ,String strSubject, String strPath, String strDescription) throws InterruptedException {
		this.selectDepartmentDropdown(strDepartmentDropdown);
		this.selectPriorityDropdown(strPriorityDropdown);
		this.selectCategoryDropdown(strCategoryDropdown);
		this.enterSubject(strSubject);
		this.uploadAttachment(strPath);
		this.enterDescription(strDescription);
		this.clickSendRequestBtn();
	}
	
//	user ticket blank messages	
	public String getBlankDepartmentMsg() {
		waitutility.waitForAnElement(blankDepartmentMsg, driver);
		String blankDepartmentMsgText = blankDepartmentMsg.getText();
		return blankDepartmentMsgText;
	}
	public String getBlankPriorityMsg() {
		waitutility.waitForAnElement(blankPriorityMsg, driver);
		String blankPriorityMsgText = blankPriorityMsg.getText();
		return blankPriorityMsgText;
	}
	public String getBlankCategoryMsg() {
		waitutility.waitForAnElement(blankCategoryMsg, driver);
		String blankCategoryMsgText = blankCategoryMsg.getText();
		return blankCategoryMsgText;
	}
	public String getBlankSubjectMsg() {
		waitutility.waitForAnElement(blankSubjectMsg, driver);
		String blankSubjectMsgText = blankSubjectMsg.getText();
		return blankSubjectMsgText;
	}
	public String getBlankDescriptionMsg() {
		waitutility.waitForAnElement(blankDescriptionMsg, driver);
		String blankDescriptionMsgText = blankDescriptionMsg.getText();
		return blankDescriptionMsgText;
	}
//	admin ticket creation	
	public String getAdminHelpCenterMsg() {
		waitutility.waitForAnElement(adminHelpCenterMsg, driver);
		String adminHelpCenterMsgText = adminHelpCenterMsg.getText();
		return adminHelpCenterMsgText;
	}
	public void clickAdminCreateTicketBtn() {
		adminCreateTicketBtn.click();
	}
	public void clickAdmAddBtn() {
		waitutility.waitForAnElement(admAddBtn, driver);
		admAddBtn.click();	
	}
	public String getAdminUserRequiredMsg() {
		waitutility.waitForAnElement(adminUserRequiredMsg, driver);
		String adminUserRequiredMsgText = adminUserRequiredMsg.getText();
		return adminUserRequiredMsgText;	
	}
	public String getAdminSubjectRequiredMsg() {
		waitutility.waitForAnElement(adminSubjectRequiredMsg, driver);
		String adminSubjectRequiredMsgText = adminSubjectRequiredMsg.getText();
		return adminSubjectRequiredMsgText;
	}
	public String getadmDescriptionReqMsg() {
		waitutility.waitForAnElement(admDescriptionReqMsg, driver);
		String admDescriptionReqMsgText = admDescriptionReqMsg.getText();
		return admDescriptionReqMsgText;
	}
	public String getAdmPriorityReqMsg() {
		waitutility.waitForAnElement(admPriorityReqMsg, driver);
		String admPriorityReqMsgText = admPriorityReqMsg.getText();
		return admPriorityReqMsgText;
	}
	public String getadmDepartmentReqMsg() {
		waitutility.waitForAnElement(admDepartmentReqMsg, driver);
		String admDepartmentReqMsgText = admDepartmentReqMsg.getText();
		return admDepartmentReqMsgText;	 
	}
	public String getadmCategoryReqMsg() {
		waitutility.waitForAnElement(admCategoryReqMsg, driver);
		String admCategoryReqMsgText = admCategoryReqMsg.getText();
		return admCategoryReqMsgText;
	}
	public String getadmStatusReqMsg() {
		waitutility.waitForAnElement(admStatusReqMsg, driver);
		String admStatusReqMsgText = admStatusReqMsg.getText();
		return admStatusReqMsgText;
	}
	
	public void getSubjectFromUserTicketTable(String strSubFromUserTicketTable) {
		waitutility.waitForAnElement(userTicketTable, driver);
		tableutility.searchInUserTicketTable(userTicketTable, driver, strSubFromUserTicketTable);
	}
	

	

}

