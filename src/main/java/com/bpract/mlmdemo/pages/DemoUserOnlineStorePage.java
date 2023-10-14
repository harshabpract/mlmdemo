package com.bpract.mlmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.mlmdemo.utilities.PageUtility;
import com.bpract.mlmdemo.utilities.WaitUtility;

public class DemoUserOnlineStorePage {
	WebDriver driver;
	@FindBy(xpath="//h4[contains(text(),\"Product Subscription\")]")
	WebElement productSubscriptionMsg;
	@FindBy(xpath="//label[contains(text(),\"Select Month\")]")
	WebElement monthDropdown;
	@FindBy(name="buy-now")
	WebElement buyNowBtn;
	@FindBy(xpath="//*[contains(text(),\"Order Summary\")]")
	WebElement ordersummeryMsg;
	@FindBy(xpath="//h6[contains(text(),\"combo1\")]")
	WebElement product;
	
	
	
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	public DemoUserOnlineStorePage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	public String getProductSubscriptionMsg() {
		waitutility.waitForAnElement(productSubscriptionMsg, driver);
		String productSubscriptionMsgText = productSubscriptionMsg.getText();
		return productSubscriptionMsgText;
	}
	public void selectMonthDropdown(String strMonthDropdown) throws InterruptedException {
		waitutility.waitForAnElement(monthDropdown, driver);
		pageutility.selectByVisibleText(monthDropdown, driver, strMonthDropdown);
	}
	public void clickBuyNowBtn() {
		waitutility.waitForAnElement(product, driver);
//		pageutility.scrollToElement(product, driver);
		buyNowBtn.click();
	}
	public void selMonth(String strMonthDropdown) throws InterruptedException {
		this.selectMonthDropdown(strMonthDropdown);
		this.clickBuyNowBtn();
	}
	public String getOrdersummeryMsg() {
		waitutility.waitForAnElement(ordersummeryMsg, driver);
		String ordersummeryMsgText = ordersummeryMsg.getText();
		return ordersummeryMsgText;
	}

}
