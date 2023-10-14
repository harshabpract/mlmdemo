package com.bpract.mlmdemo.pages;

import java.awt.AWTException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.mlmdemo.utilities.PageUtility;
import com.bpract.mlmdemo.utilities.WaitUtility;

public class DemoProfilePage {
	WebDriver driver;
	
	@FindBy(xpath="//h6[contains(text(),\"Your Activity History\")]")
	WebElement activityHistoryMsg;
	@FindBy(name="edit-info")
	WebElement editInfoMenu;
	@FindBy(xpath="//h6[contains(text(),\"Social Media Scope\")]")
	WebElement editInfoPageMsg;
	@FindBy(name="first_name")
	WebElement firstName;
	@FindBy(name="last_name")
	WebElement lastName;
	@FindBy(name="gender")
	WebElement genderDropdown;
	@FindBy(name="country")
	WebElement countryDropdown;
	@FindBy(name="state")
	WebElement state;
	@FindBy(name="city")
	WebElement city;
	@FindBy(name="zipcode")
	WebElement zipcode;
	@FindBy(name="address")
	WebElement address;
	@FindBy(name="mobile")
	WebElement mobile;
	@FindBy(name="save")
	WebElement saveBtn;
	@FindBy(xpath="//button[contains(text(),\"Profile\")]")
	WebElement profileMenuBtn;
	@FindBy(name="settings")   //settings page password change
	WebElement settingsBtn;
	@FindBy(name="password")   //settings page password change
	WebElement settingsPwd;
	@FindBy(name="confirmNewPassword")  //settings page password change
	WebElement settingsConfirmPwd;
	@FindBy(name="submit")
	WebElement settingsPwdSubmitBtn;   //settings page password change
	@FindBy(xpath="//p[contains(text(),\"Password must be at least 8 characters\")]")  //settings  password length validation 
	WebElement pwdLengthMsg;
	@FindBy(xpath="//p[contains(text(),\"Password must be at least 8 characters\")]")  //settings  password length validation 
	WebElement pwdBlankMsg;
	//to verify profile info
	@FindBy(xpath="//h4[contains(text(),\"Profile\")]")  
	WebElement profileMsg;
	@FindBy(name="profile")
	WebElement profileBtn;
	@FindBy(name="firstnameLastname")
	WebElement firstnameLastnameMsg;
	@FindBy(name="gender")
	WebElement genderMsg;
	@FindBy(name="mobile")
	WebElement mobileMsg;
	@FindBy(name="zipcode")
	WebElement zipcodeMsg;
	@FindBy(name="address")
	WebElement addressMsg;
	@FindBy(xpath="//p[contains(text(),\"palakkad\")]")
	WebElement cityMsg;
	
	//coin address update
	@FindBy(name="1")
	WebElement liteCoin;
	@FindBy(name="2")
	WebElement etherium;
	@FindBy(name="3")
	WebElement bitcoin;
	@FindBy(name="4")
	WebElement bitcoinCash;
	@FindBy(name="coin-address")
	WebElement coinAddressSaveBtn;
	@FindBy(xpath="//h6[contains(text(),\"Change Coin Address\")]")
	WebElement scrollCoinAddress;
//	user profile pic upload
	@FindBy(id="profile-image-upload")
	WebElement profileImgUpload;
	
	
	
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	
	public DemoProfilePage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	
	
	
	public String getactivityHistoryMsg() {
		waitutility.waitForAnElement(activityHistoryMsg, driver);
		String activityHistoryMsgText = activityHistoryMsg.getText();
		return activityHistoryMsgText;
		
	}
	public void clickEditInfoMenu() {
		editInfoMenu.click();
	}
	public String getEditInfoPageMsg() {
		waitutility.waitForAnElement(editInfoPageMsg, driver);
		String editInfoPageMsgText = editInfoPageMsg.getText();
		return editInfoPageMsgText;
				
	}
	
	//edit info
	public void enterFirstname(String strFirstname) {
		firstName.sendKeys(strFirstname);
	}
	public void enterLastname(String strLastname) {
		lastName.sendKeys(strLastname);
	}
	public void selectGender(String strGender) throws InterruptedException {
		pageutility.selectByVisibleText(genderDropdown, driver, strGender);
	}
	public void selectCountry(String strCountry) throws InterruptedException {
		pageutility.selectByVisibleText(countryDropdown, driver, strCountry);
	}
	public void enterState(String strState) {
		waitutility.waitForAnElement(state, driver);
		state.sendKeys(strState);
	}
	public void enterCity(String StrCity) {
		waitutility.waitForAnElement(city, driver);
		city.sendKeys(StrCity);
	}
	public void enterZipcode(String strZipcode) {
		waitutility.waitForAnElement(zipcode, driver);
		zipcode.sendKeys(strZipcode);
	}
	public void enterAddress(String strAddress) {
		waitutility.waitForAnElement(address, driver);
		address.sendKeys(strAddress);
	}
	public void enterMobile(String strMobile) {
		waitutility.waitForAnElement(mobile, driver);
		mobile.sendKeys(strMobile);
	}
	public void clickSaveBtn() {
		saveBtn.click();
	}
	
	
	public void clickSettingsBtn() {//settings page password change
		waitutility.waitForAnElement(settingsBtn, driver);
		settingsBtn.click();
	}
	public void enterSettingsPwd(String strSettingsPwd) {   //settings page password change
		waitutility.waitForAnElement(settingsPwd, driver);
		settingsPwd.sendKeys(strSettingsPwd);
	}
	public void enterSettingsConfirmPwd(String strSettingsConfirmPwd) {  //settings page password change
		waitutility.waitForAnElement(settingsConfirmPwd, driver);
		settingsConfirmPwd.sendKeys(strSettingsConfirmPwd);
	}
	
	public void clickSettingsPwdSubmitBtn() {   //settings page password change
		settingsPwdSubmitBtn.click();
	}
	//For clear edit info field
	public void clearFirstName() {
		pageutility.clearWebField(firstName);
	}
	public void clearLastName() {
		pageutility.clearWebField(lastName);
	}
	public void clearState() {
		pageutility.clearWebField(state);
	}
	public void clearCity() {
		pageutility.clearWebField(city);
	}
	public void clearZipcode() {
		pageutility.clearWebField(zipcode);
	}
	public void clearAddress() {
		pageutility.clearWebField(address);
	}
	public void clearMobile() {
		pageutility.clearWebField(mobile);
	}
	
	
	//coin address update
	public void enterLiteCoin(String strLiteCoin) {
		waitutility.waitForAnElement(liteCoin, driver);
		liteCoin.sendKeys(strLiteCoin);
	}
	public void enterEtherium(String strEntherium) {
		waitutility.waitForAnElement(etherium, driver);
		etherium.sendKeys(strEntherium);
	}
	public void enterBitcoin(String strBitcoin) {
		waitutility.waitForAnElement(bitcoin, driver);
		bitcoin.sendKeys(strBitcoin);
	}
	public void enterBitcoinCash(String strBitcoinCash) {
		waitutility.waitForAnElement(bitcoinCash, driver);
		bitcoinCash.sendKeys(strBitcoinCash);
	}
	public void clickCoinAddressSaveBtn() {
		pageutility.scrollToElement(scrollCoinAddress, driver);
		coinAddressSaveBtn.click();
	}
	public String getCoinAddressFieldMsg() {
		waitutility.waitForAnElement(scrollCoinAddress, driver);
		String scrollCoinAddressText = scrollCoinAddress.getText();
		return scrollCoinAddressText;
	}
	//coin address update
	public void clearLiteCoin() {
		pageutility.clearWebField(liteCoin);
	}
	public void clearEntherium() {
		pageutility.clearWebField(etherium);
	}
	public void clearBitcoin() {
		pageutility.clearWebField(bitcoin);	
	}
	public void clearBitcoinCash() {
		pageutility.clearWebField(bitcoinCash);
	}
	//coin address update
	public void updateCoinAddress(String strLiteCoin ,String strEntherium ,String strBitcoin ,String strBitcoinCash) {
		this.enterLiteCoin(strLiteCoin);
		this.enterEtherium(strEntherium);
		this.enterBitcoin(strBitcoin);
		this.enterBitcoinCash(strBitcoinCash);
		this.clickCoinAddressSaveBtn();
	}
	//coin address update
	public void clearUpdateCoinAddress(String strLiteCoin ,String strEntherium ,String strBitcoin ,String strBitcoinCash) {
		this.clearLiteCoin();
		this.enterLiteCoin(strLiteCoin);
		this.clearEntherium();
		this.enterEtherium(strEntherium);
		this.clearBitcoin();
		this.enterBitcoin(strBitcoin);
		this.clearBitcoinCash();
		this.enterBitcoinCash(strBitcoinCash);
		this.clickCoinAddressSaveBtn();
	}
	
	
	//Edit info for new user
	public void editinfo(String strFirstname, String strLastname, String strGender, String strCountry, String strState, String StrCity, String strZipcode, String strAddress, String strMobile) throws InterruptedException {
		this.enterFirstname(strFirstname);
		this.enterLastname(strLastname);
		this.selectGender(strGender);
		this.selectCountry(strCountry);
		this.enterState(strState);
		this.enterCity(StrCity);
		this.enterAddress(strAddress);
		this.enterZipcode(strZipcode);
		this.enterMobile(strMobile);
		this.clickSaveBtn();
	}
	//To edit already filled edit info
	public void updateEditInfo(String strFirstname, String strLastname, String strGender, String strCountry, String strState, String StrCity, String strZipcode, String strAddress, String strMobile) throws InterruptedException {
		this.clearFirstName();
		this.enterFirstname(strFirstname);
		this.clearLastName();
		this.enterLastname(strLastname);
		this.selectGender(strGender);
		this.selectCountry(strCountry);
		this.clearState();
		this.enterState(strState);
		this.clearCity();
		this.enterCity(StrCity);
		this.clearAddress();
		this.enterAddress(strAddress);
		this.clearZipcode();
		this.enterZipcode(strZipcode);
		this.clearMobile();
		this.enterMobile(strMobile);
		this.clickSaveBtn();
	}
	
	public void settingsPassworUpdate(String strSettingsPwd ,String strSettingsConfirmPwd) {
		this.enterSettingsPwd(strSettingsPwd);
		this.enterSettingsConfirmPwd(strSettingsConfirmPwd);
		this.clickSettingsPwdSubmitBtn();
	}
	
	public String getPwdLengthMsg() {
		waitutility.waitForAnElement(pwdLengthMsg, driver);
		String pwdLengthMsgText = pwdLengthMsg.getText();  
		return pwdLengthMsgText;
	}
	
	 
	public String getPwdBlankMsg() {
		waitutility.waitForAnElement(pwdBlankMsg, driver);
		String pwdBlankMsgText = pwdBlankMsg.getText();  
		return pwdBlankMsgText;
	}
	public void clickProfileBtn() {
		pageutility.scrollToElement(profileMsg, driver);  //to scroll to profile message
		profileBtn.click();
	}
	public String getFirstnameLastnameMsg() {
		waitutility.waitForAnElement(firstnameLastnameMsg, driver);
		String firstnameLastnameMsgText = firstnameLastnameMsg.getText();
		return firstnameLastnameMsgText;
	}
	public String getGenderMsg() {
		waitutility.waitForAnElement(genderMsg, driver);
		String genderMsgText = genderMsg.getText();
		return genderMsgText;
	}
	public String getMobileMsg() {
		waitutility.waitForAnElement(mobileMsg, driver);
		String mobileMsgText = mobileMsg.getText();
		return mobileMsgText;
	}
	
	public String getZipcodeMsg() {
		waitutility.waitForAnElement(zipcodeMsg, driver);
		String zipcodeMsgText = zipcodeMsg.getText();
		return zipcodeMsgText;
	}
	
	public String getAddressMsg() {
		waitutility.waitForAnElement(addressMsg, driver);
		String addressMsgText = addressMsg.getText();
		return addressMsgText;
	}
	public String getcityMsg() {
		waitutility.waitForAnElement(cityMsg, driver);
		String cityMsgText = cityMsg.getText();
		return cityMsgText;
	}
	
	public void profileImgUpload(String strProfileImgUpload) throws AWTException, InterruptedException {
		pageutility.uploadImage(profileImgUpload, driver, strProfileImgUpload);
		
	}

}

