package com.TestCase;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Base.BaseClass;
import com.PageClass.CartPage;
import com.PageClass.CheckoutPage;
import com.PageClass.ComputerDesktopSection;
import com.PageClass.LoginPage;
import com.PageClass.RegistrationPage;
import com.Utilities.Utilities;
import static com.Reporting.ExtentTestManager.startTest;

public class Testcase extends  BaseClass{
	
	
@BeforeMethod
	public void Setup() {
		initialization();	 
	}

@DataProvider

public Object[][]  getData() throws Exception {
	Object data[][] = Utilities.getTestData("regData");
	return data;
}
@Test(dataProvider="getData",priority = 1,description ="New Registration Validation")

public void NewRegistration(Method method,String Gender,String FirstName,String LastName,String Email,String Password,String ConfirmPassword) throws Exception {

startTest(method.getName(),"New Registration Validation");
RegistrationPage reg= new RegistrationPage();
String HomeTitle= reg.verifyHomeTitle();
System.out.println(HomeTitle);
Assert.assertEquals(HomeTitle,"Demo Web Shop");
Utilities.Takescreenshot("HomePage");
reg.clickRegistration();
Thread.sleep(2000);
String RegPageTitle= reg.verifyRegisterTitle();
Assert.assertEquals(RegPageTitle,"Demo Web Shop. Register");
Utilities.Takescreenshot("RegistrationPage");
if(Gender.equals("Male")) {
	reg.SelectMale();
}else {
	reg.SelectFemale();
}
reg.Registration(FirstName,LastName,Email, Password, ConfirmPassword);
Utilities.Takescreenshot("RegistrationConfirm");
String confirmreg = reg.verifyRegistration();
Assert.assertEquals(confirmreg, "Your registration completed");
reg.returnHome();
Utilities.Takescreenshot("BackToHomePage");
}

@DataProvider

public Object[][]  Order_Desktop_CashOnDelivery() throws Exception {
	Object logindata[][] = Utilities.getTestData("DesktopCheckoutCOD");
	return logindata;
}
@Test(dataProvider="Order_Desktop_CashOnDelivery",priority = 2,description="Desktop Cash on Delivery Validation")
public void Desktop_Order_CashOnDelivery(Method method,String Email, String Password,String Computer,String Processor,String RAM,String HDD,String CompanyName,String CountryName,String StateName,String CityName,String AddressDetails,String ZIP,String Pno,String ShipMethod) throws Exception {
	startTest(method.getName(),"Desktop Cash on Delivery Validation");
	LoginPage logpage= new LoginPage();
	ComputerDesktopSection desktops= new ComputerDesktopSection();
	CartPage cart= new CartPage();
	CheckoutPage CheckOut= new CheckoutPage();
	logpage.login(Email, Password);
	Utilities.Takescreenshot("LoggedIn");
	desktops.NavigateToDesktop();
	desktops.ComputerSelection(Computer);
	desktops.AddToCartFormFiilUp(Processor, RAM, HDD);
	//Assert.assertEquals(desktops.CartAddValidation(), "The product has been added to your shopping cart");
	desktops.moveToCartPage();
	cart.CheckoutProcess();
	Thread.sleep(2000);
	CheckOut.CashOnDeliveryPayment(CompanyName, CountryName, StateName, CityName, AddressDetails, ZIP, Pno, ShipMethod);	
}
@DataProvider

public  Object[][] Order_Desktop_CreditCard() throws Exception{
Object DesktopOrderData[][] = Utilities.getTestData("DesktopCheckoutCC");
return DesktopOrderData;
}

@Test(dataProvider="Order_Desktop_CreditCard",priority = 3,description="Desktop order Credit Card Validation")

public void Desktop_Order_CreditCard(Method method,String Email, String Password,String Computer,String Processor,String RAM,String HDD,String CompanyName,String CountryName,String StateName,String CityName,String AddressDetails,String ZIP,String Pno,String ShipMethod,String cardType,String HolderName) throws Exception {
	startTest(method.getName(),"Desktop order Credit Card Validation");
	LoginPage logpage= new LoginPage();
	ComputerDesktopSection desktops= new ComputerDesktopSection();
	CartPage cart= new CartPage();
	CheckoutPage CheckOut= new CheckoutPage();
	logpage.login(Email, Password);
	Utilities.Takescreenshot("LoggedIn");
	desktops.NavigateToDesktop();
	desktops.ComputerSelection(Computer);
	desktops.AddToCartFormFiilUp(Processor, RAM, HDD);
	//Assert.assertEquals(desktops.CartAddValidation(), "The product has been added to your shopping cart");
	desktops.moveToCartPage();
	cart.CheckoutProcess();
	Thread.sleep(2000);
    CheckOut.CreditCartPayment(CompanyName, CountryName, StateName, CityName, AddressDetails, ZIP, Pno, ShipMethod, cardType, HolderName);
	
}

@AfterMethod

public void teardown() {
driver.quit();
}
}
