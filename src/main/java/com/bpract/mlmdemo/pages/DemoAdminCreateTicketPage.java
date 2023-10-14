package com.bpract.mlmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.mlmdemo.utilities.PageUtility;
import com.bpract.mlmdemo.utilities.TableUtility;
import com.bpract.mlmdemo.utilities.WaitUtility;

public class DemoAdminCreateTicketPage {
	WebDriver driver;
	public DemoAdminCreateTicketPage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	TableUtility tableutility = new TableUtility();
	
	@FindBy(name="create-ticket")
	WebElement adminCreateTicketBtn;
	@FindBy(xpath="//h4[contains(text(),\"Help Center\")]")
    WebElement adminHelpCenterMsg;
	@FindBy(name="user-search")
	WebElement userSearch;
	@FindBy(name="subject")
	WebElement subject;
	@FindBy(xpath="//*[@id=\"description\"]/div/div[1]")
	WebElement description;
	@FindBy(name="priority_id")
	WebElement priorityDropdown;
	@FindBy(name="department_id")
	WebElement departmentDropdown;
	@FindBy(name="category_id")
	WebElement categoryDropdown;
	@FindBy(name="status")
	WebElement statusDropdown;
	@FindBy(name="attachments_url")
	WebElement documentUpload;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(),\"Add\")]")
	WebElement admAddBtn;
	@FindBy(xpath="//table[@name=\"ticket-table\"]/tbody")
	WebElement adminTicketDashboard;
	@FindBy(xpath="//table[@name=\"ticket-table\"]/tbody/tr[1]/td[3]")
	WebElement usernameFromTicketTable;
	@FindBy(xpath="//table[@name=\"ticket-table\"]/tbody/tr[1]/td[5]")
	WebElement subjectFromTicketTable;

//	Department creation	
	@FindBy(xpath="//span[contains(text(),\"Departments\")]")
	WebElement departmentCreationMenu;
	@FindBy(name="department")
	WebElement departmentCreateBtn;
	@FindBy(xpath="//span[contains(text(),\"Add Department\")]")
	WebElement addDepartmentPageMsg;
	@FindBy(name="name")
	WebElement deptmntName;
	@FindBy(xpath="//div[@name=\"description\"]/div/div/textarea[1]")
	WebElement deptmntDescription;
	@FindBy(name="active")
	WebElement deptmntStatusDropdown;
	@FindBy(name="sort_order")
	WebElement deptmntSortorder;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement deptmntSubmitBtn;
	@FindBy(xpath="//table[@name=\"department-table\"]/tbody")
	WebElement departmentNameFromTktTable;
	
//	ticket categories creation
	@FindBy(xpath="//span[contains(text(),\"Categories\")]")
	WebElement tktCategoriesmenu;
	@FindBy(name="category")
	WebElement tktCategoryAddBtn;
	@FindBy(xpath="//span[contains(text(),\"Add Category\")]")
	WebElement tktCategoriesPageMsg;
	@FindBy(name="name")
	WebElement tktCategoryName;
	@FindBy(xpath="//div[@name=\"description\"]/div/div/textarea[1]")
	WebElement tktCategoryDescription;
	@FindBy(name="active")
	WebElement tktCategoryStatus;
	@FindBy(name="submit")
	WebElement categorySubmitBtn;
	@FindBy(xpath="//table[@name=\"category-table\"]/tbody")
	WebElement categoryNameFromTktTable;
	
//	ticket priority blank test
	@FindBy(xpath="//span[contains(text(),\"Priorities\")]")
	WebElement priorityMenu;
	@FindBy(name="priority")
	WebElement priorityAddBtn;
	@FindBy(xpath="//span[contains(text(),\"Add Priority\")]")
	WebElement addPriorityMsg;
	@FindBy(xpath="//p[contains(text(),\"Name is required\")]")
	WebElement getPriorityRequireMsg;
	@FindBy(xpath="//p[contains(text(),\"Color is required\")]")
	WebElement getPriorityColorRequiredMsg;
	@FindBy(xpath="//p[contains(text(),\"Description is required\")]")
	WebElement getPriorityDescriptionRequiredMsg;
	@FindBy(name="submit")
	WebElement prioritySubmitBtn;
	
	
	
	public void clickCreateTicketBtn() {
		waitutility.waitForAnElement(adminCreateTicketBtn, driver);
		adminCreateTicketBtn.click();
	}
	public String getAdminHelpCenterMsg() {
		waitutility.waitForAnElement(adminHelpCenterMsg, driver);
		String adminHelpCenterMsgText = adminHelpCenterMsg.getText();
		return adminHelpCenterMsgText;
	}
	public void enterUserSearch(String strUserSearch) throws InterruptedException {
		waitutility.waitForAnElement(userSearch, driver);
		pageutility.selectFromAutoSuggestion(userSearch, driver, strUserSearch);
	}
	public void enterSubject(String strSubject) {
//		waitutility.waitForAnElement(subject, driver);
		subject.sendKeys(strSubject);
	}
	public void enterDescription(String strDescription) {
//		waitutility.waitForAnElement(description, driver);
		description.sendKeys(strDescription);
	}
	public void selectpriorityDropdown(String strPriorityDropdown) throws InterruptedException {
		pageutility.selectByVisibleText(priorityDropdown, driver, strPriorityDropdown);
	}
	public void selectDepartmentDropdown(String strDepartmentDropdown) throws InterruptedException {
		pageutility.selectByVisibleText(departmentDropdown, driver, strDepartmentDropdown);
	}
	public void selectCategoryDropdown(String strCategoryDropdown) throws InterruptedException {
		pageutility.selectByVisibleText(categoryDropdown, driver, strCategoryDropdown);	
	}
	public void selectStatusDropdown(String strStatusDropdown) throws InterruptedException {
		pageutility.selectByVisibleText(statusDropdown, driver, strStatusDropdown);
	}
	public void uploadDocumentUpload(String strDocumentUpload) {
		pageutility.uploadFiles(documentUpload, driver, strDocumentUpload);
	}
	public void clickAdmAddBtn() {
		waitutility.waitForAnElement(admAddBtn, driver);
		admAddBtn.click();	
	}
	public void adminCreateTicket(String strUserSearch, String strSubject, String strDescription, String strPriorityDropdown, String strDepartmentDropdown, String strCategoryDropdown ,String strStatusDropdown, String strDocumentUpload) throws InterruptedException {
		this.enterUserSearch(strUserSearch);
		this.enterSubject(strSubject);
		this.enterDescription(strDescription);
		this.selectpriorityDropdown(strPriorityDropdown);
		this.selectDepartmentDropdown(strDepartmentDropdown);
		this.selectCategoryDropdown(strCategoryDropdown);
		this.selectStatusDropdown(strStatusDropdown);
		this.uploadDocumentUpload(strDocumentUpload);
		this.clickAdmAddBtn();
	}
	public void searchInAdminTicketDashboard(String strTktUsername, String strTktSubject) {
//		driver.navigate().refresh();
//		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(adminTicketDashboard, driver);
		tableutility.searchInAdminTicketDashboard(adminTicketDashboard, driver, strTktUsername, strTktSubject);
	}
//	another method to find details from table(only for table without sort order)
//	public String getUsernameFromTicketTable() {
//		waitutility.waitForAnElement(usernameFromTicketTable, driver);
//		String usernameFromTicketTableText = usernameFromTicketTable.getText();
//		return usernameFromTicketTableText;
//	}
//	public String getSubjectFromTicketTable() {
//		waitutility.waitForAnElement(subjectFromTicketTable, driver);
//		String subjectFromTicketTableText = subjectFromTicketTable.getText();
//		return subjectFromTicketTableText;
//	}
	
//	Department creation
	public void clickDepartmentCreateMenu() {
		waitutility.waitForAnElement(departmentCreationMenu, driver);
		departmentCreationMenu.click();
	}
	public void clickDepartmentCreateBtn() {
		waitutility.waitForAnElement(departmentCreateBtn, driver);
		departmentCreateBtn.click();
	}
	public String getAddDepartmentPageMsg() {
		waitutility.waitForAnElement(addDepartmentPageMsg, driver);
		String addDepartmentPageMsgText = addDepartmentPageMsg.getText();
		return addDepartmentPageMsgText;
	}
	public void enterDeptmntName(String strDeptmntName) {
		waitutility.waitForAnElement(deptmntName, driver);
		deptmntName.sendKeys(strDeptmntName);
	}
	public void enterDeptmntDescription(String strDeptmntDescription) {
		waitutility.waitForAnElement(deptmntDescription, driver);
		deptmntDescription.sendKeys(strDeptmntDescription);
	}
	public void selectDeptmntStatusDropdown(String strDeptmntStatusDropdown) throws InterruptedException {
		pageutility.selectByVisibleText(deptmntStatusDropdown, driver, strDeptmntStatusDropdown);
	}
	public void enterDeptmntSortorder(String strDeptmntSortorder) {
		waitutility.waitForAnElement(deptmntSortorder, driver);
		deptmntSortorder.sendKeys(strDeptmntSortorder);
	}
	public void clickDeptmntSubmitBtn() {
		waitutility.waitForAnElement(deptmntSubmitBtn, driver);
		deptmntSubmitBtn.click();
	}
	public void createDepartmentDetails(String strDeptmntName ,String strDeptmntDescription , String strDeptmntStatusDropdown, String strDeptmntSortorder) throws InterruptedException {
		this.enterDeptmntName(strDeptmntName);
		this.enterDeptmntDescription(strDeptmntDescription);
		this.selectDeptmntStatusDropdown(strDeptmntStatusDropdown);
		this.enterDeptmntSortorder(strDeptmntSortorder);
		this.clickDeptmntSubmitBtn();
	}
	public void searchInAdminTicketDepartment(String strDeptmntName) {
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(departmentNameFromTktTable, driver);
		tableutility.searchInAdminTicketDepartment(departmentNameFromTktTable, driver, strDeptmntName);
	}
	
//	ticket categories creation
	public void clickTktCategoriesmenu() {
		waitutility.waitForAnElement(tktCategoriesmenu, driver);
		tktCategoriesmenu.click();
	}
	public void clickTktCategoryAddBtn() {
		waitutility.waitForAnElement(tktCategoryAddBtn, driver);
		tktCategoryAddBtn.click();
	}
	public String getTktCategoriesPageMsg() {
		waitutility.waitForAnElement(tktCategoriesPageMsg, driver);
		String tktCategoriesPageMsgText = tktCategoriesPageMsg.getText();
		return tktCategoriesPageMsgText;
	}
	public void enterTktCategoryName(String strTktCategoryName) {
		waitutility.waitForAnElement(tktCategoryName, driver);
		tktCategoryName.sendKeys(strTktCategoryName); 
	}
	public void enterTktCategoryDescription(String strTktCategoryDescription) {
		waitutility.waitForAnElement(tktCategoryDescription, driver);
		tktCategoryDescription.sendKeys(strTktCategoryDescription);	
	}
	public void selectTktCategoryStatus(String strTktCategoryStatus) throws InterruptedException {
		waitutility.waitForAnElement(tktCategoryStatus, driver);
		pageutility.selectByVisibleText(tktCategoryStatus, driver, strTktCategoryStatus);
	}
	public void clickCategorySubmitBtn() {
		categorySubmitBtn.click();
	}
	public void createTktCategories(String strTktCategoryName, String strTktCategoryDescription, String strTktCategoryStatus) throws InterruptedException {
		this.enterTktCategoryName(strTktCategoryName);
		this.enterTktCategoryDescription(strTktCategoryDescription);
		this.selectTktCategoryStatus(strTktCategoryStatus);
		this.clickCategorySubmitBtn();
	}
	public void searchInAdminTicketCategory(String strCategoryName) {
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(categoryNameFromTktTable, driver);
		tableutility.searchInAdminTicketCategory(categoryNameFromTktTable, driver, strCategoryName);
	}
	
//	ticket priority blank test
	public void clickPriorityMenu() {
		waitutility.waitForAnElement(priorityMenu, driver);
		priorityMenu.click();
	}
	public void clickPriorityAddBtn() {
		waitutility.waitForAnElement(priorityAddBtn, driver);
		priorityAddBtn.click();
	}
	public String getAddPriorityMsg() {
		waitutility.waitForAnElement(addPriorityMsg, driver);
		String addPriorityMsgText = addPriorityMsg.getText();
		return addPriorityMsgText;
	}
	public void clickPrioritySubmitBtn() {
		waitutility.waitForAnElement(prioritySubmitBtn, driver);
		prioritySubmitBtn.click();
	}
	public String getPriorityRequireMsg() {
		waitutility.waitForAnElement(getPriorityRequireMsg, driver);
		String getPriorityRequireMsgText = getPriorityRequireMsg.getText();
		return getPriorityRequireMsgText;
	}
	public String getPriorityColorRequiredMsg() {
		waitutility.waitForAnElement(getPriorityColorRequiredMsg, driver);
		String getPriorityColorRequiredMsgText = getPriorityColorRequiredMsg.getText();
		return getPriorityColorRequiredMsgText;
	}
	public String getPriorityDescriptionRequiredMsg() {
		waitutility.waitForAnElement(getPriorityDescriptionRequiredMsg, driver);
		String getPriorityDescriptionRequiredMsgText = getPriorityDescriptionRequiredMsg.getText();
		return getPriorityDescriptionRequiredMsgText;
	}

}
