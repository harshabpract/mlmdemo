package com.bpract.mlmdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.mlmdemo.utilities.WaitUtility;

public class DemoHomePage {
    WebDriver driver;
    public DemoHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    WaitUtility waitutility = new WaitUtility();
//    user side
    @FindBy(xpath="//div[contains(text(),\"Dashboard\")]")
    WebElement dashboardMsg;
    @FindBy(xpath="//div[contains(text(),\"My Profile\")]")
    WebElement myProfileBtn;
    @FindBy(xpath="//div[contains(text(),\"help Center\")]")
    WebElement helpCenterMenu;
    @FindBy(xpath="//div[contains(text(),\"Support Tickets\")]")
	WebElement supportTicketsMenu;
    @FindBy(xpath="//div[contains(text(),\"Online Store\")]")
    WebElement onlineStoreMenu;
    @FindBy(xpath="//div[contains(text(),\"Product & Subscriptions\")]")
    WebElement productSubscriptionMenu;
//    Admin side
    @FindBy(xpath="//*[@id=\"root\"]/div[2]/div[2]/div/div/div/div/div[1]/div[2]/div/div/div/div[2]/ul[1]/div[5]/div[2]")
    WebElement adminCommunicationMenu;
    @FindBy(xpath="//div[contains(text(),\"Help Center\")]")
    WebElement adminHelpcenterMenu;
//  admin tools doc
    @FindBy(xpath="//div[contains(text(),\"Tools\")]")
	WebElement toolsMenu;
    @FindBy(xpath="//div[contains(text(),\"Documents\")]")
    WebElement documentsSubMenu;
//  admin tools video
    @FindBy(xpath="//div[contains(text(),\"Videos\")]")
    WebElement toolsVideoMenu;
//  admin communication FAQ
    @FindBy(xpath="//div[contains(text(),\"FAQ's\")]")
    WebElement faqMenu;
//	admin communication Articles 
	@FindBy(xpath="//div[contains(text(),\"Articles\")]")
	WebElement clickArticlesMenu;
//	Admin communication blog
	@FindBy(xpath="//div[contains(text(),\"Blogs\")]")
	WebElement clickBlogMenu;
	
 
    public String getDashboardMsg() {
        waitutility.waitForAnElement(dashboardMsg, driver);
        String dashboardMsgText = dashboardMsg.getText();
        return dashboardMsgText;
    }
    
    public void clickMyProfileBtn() {
    	myProfileBtn.click();
    }

    public void clickHelpCenterMenu() {
    	waitutility.waitForAnElement(helpCenterMenu, driver);
		helpCenterMenu.click();
	}
	public void clickSupportTicketsMenu() {
		supportTicketsMenu.click();
	}
   public void clickAdminCommunicationMenu() {
	   adminCommunicationMenu.click();
   }
   public void clickAdminHelpcenterMenu() {
	   waitutility.waitForAnElement(adminHelpcenterMenu, driver);
	   adminHelpcenterMenu.click();
   }
   public void clickOnlineStoreMenu() {
	   waitutility.waitForAnElement(onlineStoreMenu, driver);
	   onlineStoreMenu.click();
   }
   public void clickProductSubscriptionMenu() {
	   productSubscriptionMenu.click();
   }
   public void clickToolsMenu() {
	   waitutility.waitForAnElement(toolsMenu, driver);
	   toolsMenu.click();
   }
   public void clickDocumentsSubMenu() {
	   waitutility.waitForAnElement(documentsSubMenu, driver);
	   documentsSubMenu.click();
   }
   public void clickToolsVideoMenu() {
	   waitutility.waitForAnElement(toolsVideoMenu, driver);
	   toolsVideoMenu.click();
   }
   public void clickFaqMenu() {
	   waitutility.waitForAnElement(faqMenu, driver);
	   faqMenu.click();
   }
//	Articles category
	public void clickArticlesMenu() {
		waitutility.waitForAnElement(clickArticlesMenu, driver);
		clickArticlesMenu.click();
	}
//	blog admin
	public void clickBlogMenu() {
		waitutility.waitForAnElement(clickBlogMenu, driver);
		clickBlogMenu.click();
	}
	

   }