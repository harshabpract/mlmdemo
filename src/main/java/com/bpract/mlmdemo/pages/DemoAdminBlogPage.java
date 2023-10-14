package com.bpract.mlmdemo.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.mlmdemo.utilities.PageUtility;
import com.bpract.mlmdemo.utilities.TableUtility;
import com.bpract.mlmdemo.utilities.WaitUtility;

public class DemoAdminBlogPage {
	WebDriver driver;
	public DemoAdminBlogPage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	TableUtility tableutility = new TableUtility();
//	blog category creation
	@FindBy(xpath="//a[contains(text(),\"Category\")]")
	WebElement clickBlogCategoryBtn;
	@FindBy(xpath="//h4[contains(text(),\"Blog Category\")]")
	WebElement getBlogCatPageMsg; 
	@FindBy(xpath="//h2/span[contains(text(),\"Add Category\")]")
	WebElement getAddCategoryMsg;
	@FindBy(name="name")
	WebElement enterCategoryName;
	@FindBy(xpath="//div/textarea[@name=\"description\"]")   
	WebElement enterCategoryDescription;
	@FindBy(xpath="//button[contains(text(),\"Submit\")]")
	WebElement clickCategorySubmitBtn;
	@FindBy(xpath="//table[@name=\"name-category\"]/tbody")
	WebElement blogCategoryFromTable;
//	private blog creation
	@FindBy(xpath="//a[contains(text(),\"Create Post\")]")
	WebElement clickCreatePostBtn;
	@FindBy(name="title")
	WebElement enterPvtTitle;
	@FindBy(xpath="//div/input[@name=\"category\"]")
	WebElement selectPvtCatDropdown;
	@FindBy(name="products")
	WebElement selectPvtProductCatDropdown;
	@FindBy(xpath="//div/textarea[@name=\"meta_keywords\"]")
	WebElement enterPvtMetaKeyword;
	@FindBy(xpath="//div/textarea[@name=\"meta_description\"]")
	WebElement enterPvtMetaDescription;
	@FindBy(xpath="//div[@id=\"description\"]/div/div/p")
	WebElement enterPvtDescription;
	@FindBy(xpath="//div[@name=\"short-description\"]/div/div/textarea")
	WebElement enterPvtShortDescptn;
	@FindBy(name="document_url")
	WebElement pvtDocUpload;
	@FindBy(xpath="//div/p/span[contains(text(),\"browse\")]")
	WebElement pvtImageUpload;
	@FindBy(name="submit")
	WebElement clickPvtSubmitBtn;
	@FindBy(xpath="//table[@name=\"published-table\"]/tbody")
	WebElement blogFromTable;
//	public blog creation
	@FindBy(xpath="//span[contains(text(),\"Public\")]")
	WebElement publicRadioBtn;
	
//	blog category creation
	public void clickBlogCategoryBtn() {
		waitutility.waitForAnElement(clickBlogCategoryBtn, driver);
		clickBlogCategoryBtn.click();
	}
	public String getBlogCatPageMsg() {
		waitutility.waitForAnElement(getBlogCatPageMsg, driver);
		String getBlogCatPageMsgText = getBlogCatPageMsg.getText();
		return getBlogCatPageMsgText;
	}
	
	public String getAddCategoryMsg() {
		waitutility.waitForAnElement(getAddCategoryMsg, driver);
		String getAddCategoryMsgText = getAddCategoryMsg.getText();
		return getAddCategoryMsgText;
	}
	public void enterCategoryName(String strEnterCategoryName) {
		waitutility.waitForAnElement(enterCategoryName, driver);
		enterCategoryName.sendKeys(strEnterCategoryName);
	}
	public void enterCategoryDescription(String strEnterCategoryDescription) {
//		waitutility.waitForAnElement(enterCategoryDescription, driver);
		enterCategoryDescription.sendKeys(strEnterCategoryDescription);
	}
	public void clickCategorySubmitBtn() {
		waitutility.waitForAnElement(clickCategorySubmitBtn, driver);
		clickCategorySubmitBtn.click();
	}
	public void blogCategoryDetails(String strEnterCategoryName, String strEnterCategoryDescription) {
		this.enterCategoryName(strEnterCategoryName);
		this.enterCategoryDescription(strEnterCategoryDescription);
		this.clickCategorySubmitBtn();
	}
	public void searchInAdminBlogCategory(String strBlogCategory) {
		waitutility.waitForAnElement(blogCategoryFromTable, driver);
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(blogCategoryFromTable, driver);
		tableutility.searchInAdminBlogCategory(blogCategoryFromTable, driver, strBlogCategory);
	}
//	private blog creation
	public void clickCreatePostBtn() {
		waitutility.waitForAnElement(clickCreatePostBtn, driver);
		clickCreatePostBtn.click();
	}
	public void enterPvtTitle(String strEnterPvtTitle) {
		waitutility.waitForAnElement(enterPvtTitle, driver);
		enterPvtTitle.sendKeys(strEnterPvtTitle);
	}
	public void selectPvtCatDropdown(String strPvtCatDropdown) throws InterruptedException {
		waitutility.waitForAnElement(selectPvtCatDropdown, driver);
		pageutility.selectFromAutoSuggestion(selectPvtCatDropdown, driver, strPvtCatDropdown);
	}
	public void selectPvtProductCatDropdown(String strPvtProductCatDropdown) throws InterruptedException {
		waitutility.waitForAnElement(selectPvtProductCatDropdown, driver);
		pageutility.selectFromAutoSuggestion(selectPvtProductCatDropdown, driver, strPvtProductCatDropdown);
	}
	public void enterPvtMetaKeyword(String strEnterMetaKeyword) {
		enterPvtMetaKeyword.sendKeys(strEnterMetaKeyword);
	}
	public void enterPvtMetaDescription(String strEnterMetaDescription) {
		enterPvtMetaDescription.sendKeys(strEnterMetaDescription);
	}
	public void enterPvtDescription(String strEnterPvtDescription) {
		enterPvtDescription.sendKeys(strEnterPvtDescription);
	}
	public void enterPvtShortDescptn(String strEnterPvtShortDescptn) {
		enterPvtShortDescptn.sendKeys(strEnterPvtShortDescptn);
	}
	public void pvtDocUpload(String strPvtDocUpload) {
		waitutility.waitForAnElement(pvtDocUpload, driver);
		pageutility.uploadFiles(pvtDocUpload, driver, strPvtDocUpload);
	}
	public void pvtImageUpload(String strpvtImageUpload) throws AWTException, InterruptedException {
		pageutility.uploadImage(pvtImageUpload, driver, strpvtImageUpload);
	}
	public void clickPvtSubmitBtn() {
		clickPvtSubmitBtn.click();
	}
	public void pvtBlogDetails(String strEnterPvtTitle, String strPvtCatDropdown, String strPvtProductCatDropdown, String strEnterMetaKeyword, String strEnterMetaDescription, String strEnterPvtDescription, String strEnterPvtShortDescptn, String strPvtDocUpload, String strpvtImageUpload) throws InterruptedException, AWTException {
		this.enterPvtTitle(strEnterPvtTitle);
		this.selectPvtCatDropdown(strPvtCatDropdown);
		this.selectPvtProductCatDropdown(strPvtProductCatDropdown);
		this.enterPvtMetaKeyword(strEnterMetaKeyword);
		this.enterPvtMetaDescription(strEnterMetaDescription);
		this.enterPvtDescription(strEnterPvtDescription);
		this.enterPvtShortDescptn(strEnterPvtShortDescptn);
		this.pvtDocUpload(strPvtDocUpload);
		this.pvtImageUpload(strpvtImageUpload);
		this.clickPvtSubmitBtn();
	}
	public void searchInAdminBlog(String strSearchBlog) {
		waitutility.waitForAnElement(blogFromTable, driver);
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(blogFromTable, driver);
		tableutility.searchInAdminBlog(blogFromTable, driver, strSearchBlog);
	}
//	public blog creation
	public void publicRadioBtn() {
		waitutility.waitForAnElement(publicRadioBtn, driver);
		publicRadioBtn.click();
	}
	public void publicBlogDetails(String strEnterPvtTitle, String strPvtCatDropdown,  String strEnterMetaKeyword, String strEnterMetaDescription, String strEnterPvtDescription, String strEnterPvtShortDescptn, String strPvtDocUpload, String strpvtImageUpload) throws InterruptedException, AWTException {
		this.enterPvtTitle(strEnterPvtTitle);
		this.selectPvtCatDropdown(strPvtCatDropdown);
		this.enterPvtMetaKeyword(strEnterMetaKeyword);
		this.enterPvtMetaDescription(strEnterMetaDescription);
		this.enterPvtDescription(strEnterPvtDescription);
		this.enterPvtShortDescptn(strEnterPvtShortDescptn);
		this.pvtDocUpload(strPvtDocUpload);
		this.pvtImageUpload(strpvtImageUpload);
		this.clickPvtSubmitBtn();
	}
	


}
