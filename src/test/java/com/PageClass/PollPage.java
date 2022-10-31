package com.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;
import com.Utilities.Utilities;

public class PollPage extends BaseClass {
@FindBy(xpath="//label[contains(text(),'Excellent')]//preceding-sibling::input")
WebElement ExcellentSelection;
@FindBy(xpath="//label[contains(text(),'Good')]//preceding-sibling::input")
WebElement GoodSelection;
@FindBy(xpath="//label[contains(text(),'Poor')]//preceding-sibling::input")
WebElement PoorSelection;
@FindBy(xpath="//label[contains(text(),'Very bad')]//preceding-sibling::input")
WebElement VeryBadSelection;
@FindBy(xpath="//input[@value='Vote']")
WebElement VoteButton;

public PollPage() {
	PageFactory.initElements(driver, this);
}

public void PollResponse(String Answer) {

	if (Answer.equals("Excellent")) {
		ExcellentSelection.click();
	}else if (Answer.equals("Good")) {
		GoodSelection.click();	
	}else if (Answer.equals("Poor")) {
		PoorSelection.click();
	}else {
		VeryBadSelection.click();
	}
	VoteButton.click();
	Utilities.Takescreenshot("Survey");
}
}
