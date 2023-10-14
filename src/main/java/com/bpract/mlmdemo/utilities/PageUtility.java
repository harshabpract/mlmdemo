package com.bpract.mlmdemo.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectByVisibleText(WebElement element, WebDriver driver, String str) throws InterruptedException {
		Thread.sleep(1000);
		Select s = new Select(element);
		if(s.getOptions().size()>1) {
			s.selectByVisibleText(str);
		}
	}
	
	public void scrollToElement(WebElement element, WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void clearWebField(WebElement element){
		while(!element.getAttribute("value").equals("")){
			element.sendKeys(Keys.BACK_SPACE);
			}
		}
	public void uploadFiles(WebElement element, WebDriver driver, String path) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		element.sendKeys(path);
		}
	
	public void selectFromAutoSuggestion(WebElement element, WebDriver driver, String username) throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(element).click().sendKeys(username).build().perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
		}
//	profile image upload
	public void uploadImage(WebElement element, WebDriver driver, String path) throws AWTException, InterruptedException {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		Robot rb = new Robot();
		StringSelection str = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		}
}
