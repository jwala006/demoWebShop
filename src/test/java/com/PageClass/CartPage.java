package com.PageClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;
import com.Utilities.Utilities;

public class CartPage extends BaseClass {

    @FindBy(xpath="//*[@class='product-price order-total']//strong")
    WebElement total;
    @FindBy(xpath="//input[@id='termsofservice']")
    WebElement Term;
    @FindBy(xpath="//*[@id='checkout']")
    WebElement Checkout;
    
   public CartPage() {
	   PageFactory.initElements(driver, this);
   }
   
   public String TotalCost() {
	   String Total= total.getText();
	   return Total;
	   
   }
   public void CheckoutProcess() throws Exception {
	   Utilities.Takescreenshot("AdditingToCartComplete");
       Actions pageDown = new Actions(driver);
       pageDown.sendKeys(Keys.PAGE_DOWN).build().perform();
       Thread.sleep(2000);
	   Term.click();
	   Checkout.click();
   }
}
