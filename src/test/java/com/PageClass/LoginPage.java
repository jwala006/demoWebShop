package com.PageClass;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;
import com.Utilities.Utilities;

public class LoginPage extends BaseClass {
	@FindBy(xpath= "//a[contains(text(),'Log in')]")
	WebElement loginbutton;
	@FindBy(xpath=".//input[@id='Email']")
	WebElement Email;
	@FindBy(xpath=".//input[@id='Password']")
	WebElement Password;
	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement logClick;
	@FindBy(xpath="//img[@src='/Themes/DefaultClean/Content/images/logo.png']")
	WebElement logo;
	public LoginPage() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public  String verifyHomePage() {
		return driver.getTitle();
	}
    public void login(String email,String Pwd) throws Exception {
    Utilities.Takescreenshot("HomePage");
    loginbutton.click();
	Email.sendKeys(email);
	Password.sendKeys(Pwd);
	Utilities.Takescreenshot("LoginDetails");
	Thread.sleep(2000);
	logClick.click();
}

    public boolean verifyLogo() {
    	return logo.isDisplayed();
    }
}
