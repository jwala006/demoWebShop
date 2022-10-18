package com.PageClass;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;

public class RegistrationPage extends BaseClass {
	//Page objects
	@FindBy(linkText="Register")
	WebElement RegistrationLink;
	@FindBy(id="gender-male")
	WebElement Male;
	@FindBy(id="gender-female")
	WebElement Female;
	@FindBy(xpath=".//input[@id='FirstName']")
	WebElement FirstName;
	@FindBy(xpath=".//input[@id='LastName']")
	WebElement LastName;
	@FindBy(xpath=".//input[@id='Email']")
	WebElement Email;
	@FindBy(xpath=".//input[@id='Password']")
	WebElement Password;
	@FindBy(xpath=".//input[@id='ConfirmPassword']")
	WebElement ConfirmPassword;
	@FindBy(xpath=".//input[@id='register-button']")
	WebElement RegisterButton;
	@FindBy(xpath="//div[@class='result' and contains(text(),'Your registration completed')]")
	WebElement RegisterComplete;
	@FindBy(xpath="//input[@class='button-1 register-continue-button']")
	WebElement ContinueToHome;
	
	//Page Initialization
	public RegistrationPage()  {
		PageFactory.initElements(driver, this);
	
	}
	
	//Page Methods
	public  String verifyHomeTitle() {
		return driver.getTitle();
	}
	
	public  String verifyRegisterTitle() {
		return driver.getTitle();
	}
	public void clickRegistration() {
		RegistrationLink.click();
	}
	public void SelectMale() {
		Male.click();
	}
	public void SelectFemale() {
		Female.click();
	}
    public void Registration(String FName,String LName,String email, String Pwd,String cpwd) {
    	FirstName.sendKeys(FName);
    	LastName.sendKeys(LName);
    	Email.sendKeys(email);
    	Password.sendKeys(Pwd);
    	ConfirmPassword.sendKeys(cpwd);
    	RegisterButton.click();
    }
    public String  verifyRegistration() {
    	return RegisterComplete.getText();
    }

public void returnHome() {
	ContinueToHome.click();
	
}

}
