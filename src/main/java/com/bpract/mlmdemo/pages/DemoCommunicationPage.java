package com.bpract.mlmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.mlmdemo.utilities.PageUtility;
import com.bpract.mlmdemo.utilities.TableUtility;
import com.bpract.mlmdemo.utilities.WaitUtility;

public class DemoCommunicationPage {
	WebDriver driver;
	public DemoCommunicationPage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	TableUtility tableutility = new TableUtility();
	
//	FAQ category creation
	@FindBy(xpath="//h4[contains(text(),\"FAQ's\")]")
	WebElement faqDashbordMsg;
	@FindBy(name="faq-category")
	WebElement faqCategoryBtn;
	@FindBy(name="add-category")
	WebElement faqAddCategory;
	@FindBy(xpath="//h2[contains(text(),\"Add FAQ's Category\")]")
	WebElement addFaqCategoryPageMsg;
	@FindBy(name="name")
	WebElement enterCategoryname;
	@FindBy(xpath="/html/body/div[2]/div[3]/div/form/div[1]/p/div/div[2]/div/textarea[1]")
	WebElement enterCategorydescription;
	@FindBy(name="active")
	WebElement selectCategoryDropdown;
	@FindBy(name="faq-submit")
	WebElement faqCategorySubmitBtn;
	@FindBy(xpath="//table[@name=\"faq-category\"]/tbody")
	WebElement faqCategoryFromTable;
//	FAQ creation
	@FindBy(name="add-faq")
	WebElement faqAddBtn;
	@FindBy(id="add-faqs")
	WebElement getAddFaqMsg;
	@FindBy(name="category_id")
	WebElement selectFaqCategory;
	@FindBy(xpath="/html/body/div[2]/div[3]/div/form/div[1]/p/div/div[2]/div/textarea[1]")
	WebElement enterFaqQuestion;
	@FindBy(xpath="/html/body/div[2]/div[3]/div/form/div[1]/p/div/div[3]/div/div[2]/div/div[1]")
	WebElement enterFaqDescription;
	@FindBy(name="faq-submit")
	WebElement faqSubmitBtn;
	@FindBy(xpath="//table[@name=\"faq-table\"]/tbody")
	WebElement faqFromTable;
//	articl category
	@FindBy(xpath="//span[contains(text(),\"Article Category\")]")
	WebElement clickArticleCategoryMenu;
	@FindBy(xpath="//button[contains(text(),\"Article Category\") and @type=\"button\"]")
	WebElement clickAddArticleCategory;
	@FindBy(xpath="//h2[contains(text(),\"Add Article Category\")]")
	WebElement getAddArticleCategoryPageMsg;
	@FindBy(name="name")
	WebElement enterArticleCategoryName;
	@FindBy(xpath="//*[@id=\"description\"]/div/div[1]")
	WebElement enterArticleCategoryDescription;
	@FindBy(name="submit")
	WebElement clickArticleCategorySubmitBtn;
	@FindBy(xpath="//table[@name=\"category-table\"]/tbody")
	WebElement articleCategoryFromTable;
//	Create article
	@FindBy(name="add-article")
	WebElement clickAddArticle;
	@FindBy(xpath="//h2[contains(text(),\"Add Article\")]")
	WebElement getAddArticleMsg;
	@FindBy(name="title")
	WebElement enterArticleTitle;
	@FindBy(name="category_id")
	WebElement selectArticleCategoryDropdown;
	@FindBy(xpath="//*[@id=\"description\"]/div/div[1]")
	WebElement enterArtcleDescription;
	@FindBy(name="submit")
	WebElement clickArticleSubmitBtn;
	@FindBy(xpath="//table[@name=\"article-table\"]/tbody")
	WebElement articleFromTable;

	
	
//	admin faq category creation
	public String getFaqDashbordMsg() {
		waitutility.waitForAnElement(faqDashbordMsg, driver);
		String faqDashbordMsgText = faqDashbordMsg.getText();
		return faqDashbordMsgText;
	}
	public void clickFaqCategoryBtn() {
		faqCategoryBtn.click();
	}
	public void clickFaqAddCategory() {
		waitutility.waitForAnElement(faqAddCategory, driver);
		faqAddCategory.click();
	}
	public String getAddFaqCategoryPageMsg() {
		String addFaqCategoryPageMsgText = addFaqCategoryPageMsg.getText();
		return addFaqCategoryPageMsgText;
	}
	public void enterCategoryname(String strEnterCategoryname) {
		waitutility.waitForAnElement(enterCategoryname, driver);
		enterCategoryname.sendKeys(strEnterCategoryname);
	}
	public void enterCategorydescription(String strEnterCategorydescription) {
		enterCategorydescription.sendKeys(strEnterCategorydescription);
	}
	public void selectCategoryDropdown(String strSelectCategoryDropdown) throws InterruptedException {
		waitutility.waitForAnElement(selectCategoryDropdown, driver);
		pageutility.selectByVisibleText(selectCategoryDropdown, driver, strSelectCategoryDropdown);
	}
	public void clickFaqCategorySubmitBtn() {
		waitutility.waitForAnElement(faqCategorySubmitBtn, driver);
		faqCategorySubmitBtn.click();
	}
	public void FaqCategoryDetails(String strEnterCategoryname, String strEnterCategorydescription, String strSelectCategoryDropdown) throws InterruptedException {
		this.enterCategoryname(strEnterCategoryname);
		this.enterCategorydescription(strEnterCategorydescription);
		this.selectCategoryDropdown(strSelectCategoryDropdown);
		this.clickFaqCategorySubmitBtn();
	}
	public void searchInAdminFaqCategory(String strFaqCategory) {
		waitutility.waitForAnElement(faqCategoryFromTable, driver);
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(faqCategoryFromTable, driver);
		tableutility.searchInAdminFaqCategory(faqCategoryFromTable, driver, strFaqCategory);
	}

//	FAQ  creation
	public void clickFaqAddBtn() {
		waitutility.waitForAnElement(faqAddBtn, driver);
		faqAddBtn.click();
	}
	public String getAddFaqMsg() {
		String getAddFaqMsgText = getAddFaqMsg.getText();
		return getAddFaqMsgText;
	}
	public void selectFaqCategory(String strSelectFaqCategory) throws InterruptedException {
		waitutility.waitForAnElement(selectFaqCategory, driver);
		pageutility.selectByVisibleText(selectFaqCategory, driver, strSelectFaqCategory);
	}
	public void enterFaqQuestion(String strEnterFaqQuestion) {
		enterFaqQuestion.sendKeys(strEnterFaqQuestion);	
	}
	public void enterFaqDescription(String strEnterFaqDescription) {
		waitutility.waitForAnElement(enterFaqDescription, driver);
		enterFaqDescription.sendKeys(strEnterFaqDescription);
	}
	public void clickFaqSubmitBtn() {
		faqSubmitBtn.click();
	}
	public void addFaqDetails(String strSelectFaqCategory, String strEnterFaqQuestion, String strEnterFaqDescription) throws InterruptedException {
		this.selectFaqCategory(strSelectFaqCategory);
		this.enterFaqQuestion(strEnterFaqQuestion);
		this.enterFaqDescription(strEnterFaqDescription);
		this.clickFaqSubmitBtn();
	}
	public void searchInAdminFaq(String strFaq) {
		waitutility.waitForAnElement(faqFromTable, driver);
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(faqFromTable, driver);
		tableutility.searchInAdminFaq(faqFromTable, driver, strFaq);
	}

	
//	article category
	public void clickArticleCategoryMenu() {
		waitutility.waitForAnElement(clickArticleCategoryMenu, driver);
		clickArticleCategoryMenu.click();
	}
	public void clickAddArticleCategory() {
		waitutility.waitForAnElement(clickAddArticleCategory, driver);
		clickAddArticleCategory.click();
	}
	public String getAddArticleCategoryPageMsg() {
		String getAddArticleCategoryPageMsgText = getAddArticleCategoryPageMsg.getText();
		return getAddArticleCategoryPageMsgText;
	}
	public void enterArticleCategoryName(String strEnterArticleCategoryName) {
		waitutility.waitForAnElement(enterArticleCategoryName, driver);
		enterArticleCategoryName.sendKeys(strEnterArticleCategoryName);
	}
	public void enterArticleCategoryDescription(String strEnterArticleCategoryDescription) {
		enterArticleCategoryDescription.sendKeys(strEnterArticleCategoryDescription);
	}
	public void clickArticleCategorySubmitBtn() {
		waitutility.waitForAnElement(clickArticleCategorySubmitBtn, driver);
		clickArticleCategorySubmitBtn.click();
	}
	public void articleCategoryDetails(String strEnterArticleCategoryName, String strEnterArticleCategoryDescription) {
		this.enterArticleCategoryName(strEnterArticleCategoryName);
		this.enterArticleCategoryDescription(strEnterArticleCategoryDescription);
		this.clickArticleCategorySubmitBtn();
	}
	
	public void searchInAdminArticleCategory(String strArticleCategory) {
		waitutility.waitForAnElement(articleCategoryFromTable, driver);
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(articleCategoryFromTable, driver);
		tableutility.searchInAdminArticleCategory(articleCategoryFromTable, driver, strArticleCategory);
	}
//	Create article
	public void clickAddArticle() {
		waitutility.waitForAnElement(clickAddArticle, driver);
		clickAddArticle.click();
	}
	public String getAddArticleMsg() {
		String getAddArticleMsgText = getAddArticleMsg.getText();
		return getAddArticleMsgText;
	}
	public void enterArticleTitle(String strEnterArticleTitle) {
		enterArticleTitle.sendKeys(strEnterArticleTitle);
	}
	public void selectArticleCategoryDropdown(String strSelectArticleCategoryDropdown) throws InterruptedException {
		waitutility.waitForAnElement(selectArticleCategoryDropdown, driver);
		pageutility.selectByVisibleText(selectArticleCategoryDropdown, driver, strSelectArticleCategoryDropdown);
	}
	public void enterArtcleDescription(String strEnterArtcleDescription) {
		enterArtcleDescription.sendKeys(strEnterArtcleDescription);
	}
	public void clickArticleSubmitBtn() {
		clickArticleSubmitBtn.click();
	}
	public void addArticleDetails(String strEnterArticleTitle, String strSelectArticleCategoryDropdown, String strEnterArtcleDescription) throws InterruptedException {
		this.enterArticleTitle(strEnterArticleTitle);
		this.selectArticleCategoryDropdown(strSelectArticleCategoryDropdown);
		this.enterArtcleDescription(strEnterArtcleDescription);
		this.clickArticleSubmitBtn();
	}
	public void searchInAdminArticle(String strSearchArticle) {
		waitutility.waitForAnElement(articleFromTable, driver);
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(articleFromTable, driver);
		tableutility.searchInAdminArticle(articleFromTable, driver, strSearchArticle);
	}

}
