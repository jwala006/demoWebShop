package com.PageClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;
import com.Utilities.Utilities;

public class ComputerDesktopSection extends BaseClass {
	
	@FindBy(xpath="//ul[@class='top-menu' ]//a[contains(text(),'Computers')]")
	WebElement Top_Computers;
	@FindBy(xpath="//ul[@class='top-menu' ]//a[contains(text(),'Desktops')]")
	WebElement Top_Desktop;
    @FindBy(xpath="//*[text()='Build your own cheap computer']")
    WebElement ComputerName1;
    @FindBy(xpath="//*[text()='Build your own computer']")
    WebElement ComputerName2;
    @FindBy(xpath="//a[text()='Build your own expensive computer']")
    WebElement ComputerName3;
    @FindBy(xpath="//*[text()='Slow ']//preceding::input[1]")
    WebElement Slow_Processor;
    @FindBy(xpath="//*[text()='Medium  [+15.00]']//preceding::input[1]")
    WebElement Medium_Processor;
    @FindBy(xpath="//*[text()='Fast  [+100.00]']//preceding::input[1]")
    WebElement Fast_Processor;
    @FindBy(xpath="//*[text()='8GB  [+60.00]']//preceding::input[1]")
    WebElement EigthGB_RAM;
    @FindBy(xpath="//*[text()='4GB  [+20.00]']//preceding::input[1]")
    WebElement FourGB_RAM;
    @FindBy(xpath="//*[text()='400 GB  [+100.00]']//preceding::input[1]")
    WebElement FourHundredGB_HDD;
    @FindBy(xpath="//*[text()='Image Viewer  [+5.00]']//preceding::input[1]")
    WebElement ImageViewer;
    @FindBy(xpath="//*[text()='Office Suite  [+100.00]']//preceding::input[1]")
    WebElement OfficeSuite;
    @FindBy(xpath="//*[text()='Other Office Suite  [+40.00]']//preceding::input[1]")
    WebElement OtherOfficeSuite;
    @FindBy(xpath="//span[@class='price-value-72']")
    WebElement PriceValue;
    @FindBy(xpath="//*[@id='addtocart_74_EnteredQuantity']")
    WebElement Quantity;
    @FindBy(xpath="//*[@class='button-1 add-to-cart-button']")
    WebElement AddToCart;
    @FindBy(xpath="//*[text()='shopping cart']")
    WebElement ShoppingCart;
    @FindBy(xpath="//*[@class='content']//text()")
    WebElement CartMessage;

    
    public ComputerDesktopSection(){
    	PageFactory.initElements(driver, this);
    }
    public void NavigateToDesktop() throws Exception {
    	Actions action= new Actions(driver);
    	action.moveToElement(Top_Computers).build().perform();
    	Utilities.Takescreenshot("ComputerSection");
    	Top_Desktop.click();
    	Thread.sleep(2000);
    }
    public void ComputerSelection(String Computer) throws Exception {
    	Utilities.Takescreenshot("ComputerPage");
    	if(Computer.equals("Build your own cheap computer")) {
    		ComputerName1.click();
    	}else if(Computer.equals("Build your own computer")) {
    		ComputerName2.click();}
    		else if (Computer.equals("Build your own expensive computer")) {
    			ComputerName3.click();
    		}
    	Thread.sleep(2000);
    	}
    public void AddToCartFormFiilUp(String Processor,String RAM,String HDD) throws Exception {
    	if(Processor.equals("Slow")) {
    		Slow_Processor.click();
    	}else if(Processor.equals("Medium")) {
    		Medium_Processor.click();
    	}else if(Processor.equals("Fast")) {
    		Fast_Processor.click();
    	}
    	if(RAM.equals("8 GB")) {
    		EigthGB_RAM.click();
    	}else if(RAM.equals("4 GB")){
    		FourGB_RAM.click();
    	}else {
    		System.out.println("Value is already Selected");
    	}
    	if(HDD.equals("400 GB")) {
    		 FourHundredGB_HDD.click();
    	}else {
    		System.out.println("Value is already Selected");
    	}
    	ImageViewer.click();
    	Thread.sleep(1000);
        Actions pageDown = new Actions(driver);
        pageDown.sendKeys(Keys.PAGE_DOWN).build().perform();
    	Utilities.Takescreenshot("FormDetails");
    	AddToCart.click();
    	Thread.sleep(1000);
    	Utilities.Takescreenshot("CartFormComplete");
    	//ShoppingCart.click();
    }
   /* public String CartAddValidation() {
    	String Cart_Message= CartMessage.getText();
    	String Shopping= ShoppingCart.getText();
    	String MessageValidation= Cart_Message.concat(" "+Shopping);
    	System.out.println(MessageValidation);
    	return MessageValidation;
    }*/
    public void moveToCartPage() throws Exception {
    	
    	ShoppingCart.click();
    }
    }


