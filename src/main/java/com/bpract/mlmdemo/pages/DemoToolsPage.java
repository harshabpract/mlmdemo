package com.bpract.mlmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.mlmdemo.utilities.PageUtility;
import com.bpract.mlmdemo.utilities.TableUtility;
import com.bpract.mlmdemo.utilities.WaitUtility;

public class DemoToolsPage {
	WebDriver driver;
	
	public DemoToolsPage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	TableUtility tableutility = new TableUtility();
	
	@FindBy(xpath="//h4[contains(text(),\"Documents \")]")
	WebElement documentPageMsg;
	@FindBy(xpath="//button[@name=\"add\"]")
	WebElement toolsFileUploadBtn;
	@FindBy(name="title")
	WebElement docTitle;
	@FindBy(name="sort_order")
	WebElement docSortOrder;
	@FindBy(name="document_url")
	WebElement toolsDocUpload;
	@FindBy(name="submit")
	WebElement toolsDocsubmitBtn;
	@FindBy(xpath="//table[@name=\"tools-documents\"]/tbody")
	WebElement docTable;
//Tools video
	@FindBy(xpath="//h4[contains(text(),\"Videos\")]")
	WebElement toolsVideoMsg;
	@FindBy(name="add")
	WebElement addVideobtn;
	@FindBy(id="tool-video")
	WebElement videoAddMsg;
	@FindBy(name="title")
	WebElement videoTitle;
	@FindBy(name="video_tool_url")
	WebElement videoURL;
	@FindBy(name="submit")
	WebElement videoSubmitBtn;
	public String getDocumentPageMsg() {
		waitutility.waitForAnElement(documentPageMsg, driver);
		String documentPageMsgText = documentPageMsg.getText();
		return documentPageMsgText;
	}
	public void clickToolsFileUploadBtn() {
		waitutility.waitForAnElement(toolsFileUploadBtn, driver);
		toolsFileUploadBtn.click();
	}
	public void enterDocTitle(String strDocTitle) {
		waitutility.waitForAnElement(docTitle, driver);
		docTitle.sendKeys(strDocTitle);
	}
	public void enterDocSortOrder(String strDocSortOrder) {
		waitutility.waitForAnElement(docSortOrder, driver);
		docSortOrder.sendKeys(strDocSortOrder);
	}
	public void uploadToolsdoc(String strToolsDocUpload) {
		waitutility.waitForAnElement(toolsDocUpload, driver);
		pageutility.uploadFiles(toolsDocUpload, driver, strToolsDocUpload);
	}
	public void clickToolsDocsubmitBtn() {
		waitutility.waitForAnElement(toolsDocsubmitBtn, driver);
		toolsDocsubmitBtn.click();
	}
	public void createToolsDocument(String strDocTitle ,String strDocSortOrder ,String strToolsDocUpload) {
		this.enterDocTitle(strDocTitle);
		this.enterDocSortOrder(strDocSortOrder);
		this.uploadToolsdoc(strToolsDocUpload);
		this.clickToolsDocsubmitBtn();
	}
	public void searchInDocTable(String strDocFileTitle) {
//		driver.navigate().refresh();
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(docTable, driver);
		tableutility.searchInAdminToolsDocument(docTable, driver, strDocFileTitle);
	}
	public String getToolsVideoMsg() {
		waitutility.waitForAnElement(toolsVideoMsg, driver);
		String toolsVideoMsgText = toolsVideoMsg.getText();
		return toolsVideoMsgText;
	}
	public void clickAddVideobtn() {
		waitutility.waitForAnElement(addVideobtn, driver);
		addVideobtn.click();
	}
	public String getVideoAddMsg() {
		waitutility.waitForAnElement(videoAddMsg, driver);
		String videoAddMsgText = videoAddMsg.getText();
		return videoAddMsgText;
	}
	public void enterVideoTitle(String strVideoTitle) {
		waitutility.waitForAnElement(videoTitle, driver);
		videoTitle.sendKeys(strVideoTitle);
	}
	public void enterVideoURL(String strVideoURL) {
		waitutility.waitForAnElement(videoURL, driver);
		videoURL.sendKeys(strVideoURL);
	}
	public void clickVideoSubmitBtn() {
		waitutility.waitForAnElement(videoSubmitBtn, driver);
		videoSubmitBtn.click();
	}
	public void toolsVideoCreation(String strVideoTitle ,String strVideoURL) {
		this.enterVideoTitle(strVideoTitle);
		this.enterVideoURL(strVideoURL);
		this.clickVideoSubmitBtn();
	}

}
