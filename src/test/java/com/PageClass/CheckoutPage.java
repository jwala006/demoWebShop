package com.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Base.BaseClass;
import com.Utilities.Utilities;

public class CheckoutPage extends BaseClass {
	@FindBy(xpath="//*[@id='BillingNewAddress_Company']")
	WebElement Company;
    @FindBy(xpath="//*[@id='BillingNewAddress_CountryId']")
    WebElement Country;
    @FindBy(xpath="//*[@id='BillingNewAddress_StateProvinceId']")
    WebElement State;
    @FindBy(xpath="//*[@id='BillingNewAddress_City']")
    WebElement City;
    @FindBy(xpath="//*[@id='BillingNewAddress_Address1']")
    WebElement Address;
    @FindBy(xpath="//*[@id='BillingNewAddress_ZipPostalCode']")
    WebElement PinCode;
    @FindBy(xpath="//*[@id='BillingNewAddress_PhoneNumber']")
    WebElement PhoneNumber;
    @FindBy(xpath="//*[@onclick='Billing.save()']")
    WebElement BiilingContinue;
    @FindBy(xpath="//*[@onclick='Shipping.save()']")
    WebElement ShippingContinue;
    @FindBy(xpath="//*[text()='Ground (0.00)']//preceding::input[1]")
    WebElement GroundMethod;
    @FindBy(xpath="//*[text()='Next Day Air (0.00)']//preceding::input[1]")
    WebElement AirMethod;
    @FindBy(xpath="//*[@onclick='ShippingMethod.save()']")
    WebElement MethodContinue;
    @FindBy(xpath="//*[@value='Payments.CashOnDelivery']")
    WebElement CashOnDelivery;
    @FindBy(xpath="//*[@value='Payments.Manual']")
    WebElement CreditCard;
    @FindBy(xpath="//*[@onclick='PaymentMethod.save()']")
    WebElement PaymentContinue;
    @FindBy(xpath="//*[@onclick='PaymentInfo.save()']")
    WebElement CODContinue;
    @FindBy(xpath="//*[@id='CreditCardType']")
    WebElement Cardtype;
    @FindBy(xpath="//*[@id='CardholderName']")
    WebElement Holdername;
    @FindBy(xpath="//*[@id='CardNumber']")
    WebElement cardnumber;
    @FindBy(xpath="//*[@id='ExpireMonth']")
    WebElement expirymonth;
    @FindBy(xpath="//*[@id='ExpireYear']")
    WebElement expiryyear;
    @FindBy(xpath="//*[@id='CardCode']")
    WebElement code;
    @FindBy(xpath="//*[@onclick='PaymentInfo.save()']")
    WebElement CreditContinue;
    @FindBy(xpath="//*[@onclick='ConfirmOrder.save()']")
    WebElement Confirm;
    @FindBy(xpath="//*[@class='button-2 order-completed-continue-button']")
    WebElement CompletedContinue;

	public CheckoutPage() {
	PageFactory.initElements(driver, this);
	}
	public void CashOnDeliveryPayment(String CompanyName,String CountryName,String StateName,String CityName,String AddressDetails,String ZIP,String Pno,String ShipMethod) throws Exception {
		Utilities.Takescreenshot("CheckoutPage");
		Thread.sleep(3000);
		Company.sendKeys(CompanyName);
		Select country = new Select(Country);
		country.selectByVisibleText(CountryName);
		Thread.sleep(2000);
		Select state = new Select(State);
		state.selectByVisibleText(StateName);
		Thread.sleep(1000);
		City.sendKeys(CityName);
		Address.sendKeys(AddressDetails);
		PinCode.sendKeys(ZIP);
		PhoneNumber.sendKeys(Pno);
		Utilities.Takescreenshot("Billing");
		BiilingContinue.click();
		Thread.sleep(1000);
		Utilities.Takescreenshot("Shipping");
		ShippingContinue.click();
		Thread.sleep(2000);
		if(ShipMethod.equals("Ground")) {
			GroundMethod.click();
		}else {
			AirMethod.click();
		}
		Utilities.Takescreenshot("method");
		MethodContinue.click();
		Thread.sleep(1000);
		CashOnDelivery.click();
		Utilities.Takescreenshot("COD");
		PaymentContinue.click();
		Utilities.Takescreenshot("codMessage");
		CODContinue.click();
		Thread.sleep(2000);
		Utilities.Takescreenshot("OrderConfirm");
		Confirm.click();
		Utilities.Takescreenshot("OrderCompleted");
		CompletedContinue.click();
	}
	public void CreditCartPayment(String CompanyName,String CountryName,String StateName,String CityName,String AddressDetails,String ZIP,String Pno,String ShipMethod,String cardType,String HolderName) throws Exception {
		Utilities.Takescreenshot("CheckoutPage");
		Thread.sleep(3000);
		Company.sendKeys(CompanyName);
		Select country = new Select(Country);
		country.selectByVisibleText(CountryName);
		Select state = new Select(State);
		state.selectByVisibleText(StateName);
		City.sendKeys(CityName);
		Address.sendKeys(AddressDetails);
		PinCode.sendKeys(ZIP);
		PhoneNumber.sendKeys(Pno);
		Utilities.Takescreenshot("Billing");
		BiilingContinue.click();
		Thread.sleep(1000);
		Utilities.Takescreenshot("Shipping");
		ShippingContinue.click();
		Thread.sleep(2000);
		if(ShipMethod.equals("Ground")) {
			GroundMethod.click();
		}else {
			AirMethod.click();
		}
		Utilities.Takescreenshot("method");
		MethodContinue.click();
		Thread.sleep(1000);
		CreditCard.click();
		Utilities.Takescreenshot("CreditCardPayment");
		PaymentContinue.click();
		Select cardTYPE= new Select(Cardtype);
		cardTYPE.selectByVisibleText(cardType);
		Holdername.sendKeys(HolderName);
		cardnumber.sendKeys(prop.getProperty("CardNumber"));
		Thread.sleep(1000);
		Select MonthExp= new Select(expirymonth);
		MonthExp.selectByValue(prop.getProperty("Month"));
		Select expYear = new Select(expiryyear);
		expYear.selectByVisibleText(prop.getProperty("Year"));
		code.sendKeys(prop.getProperty("Code"));
		Utilities.Takescreenshot("PaymentInfo");
		CreditContinue.click();
		Thread.sleep(2000);
		Utilities.Takescreenshot("OrderConfirm");
		Confirm.click();
		Utilities.Takescreenshot("OrderCompleted");
		CompletedContinue.click();
		Thread.sleep(2000);
	}

}