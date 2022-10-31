package com.TestCase;

import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.PageClass.LoginPage;
import com.PageClass.PollPage;
import com.Utilities.Utilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static com.Reporting.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;

public class PollSurveyVerificationTest extends BaseClass {

  @BeforeMethod
  public void SetUp() {
	  initialization();
  }
  @DataProvider

  public Object[][]  Poll_Survey() throws Exception {
  	Object AnswerData[][] = Utilities.getTestData("LogOn");
  	return AnswerData;
  }
  
  @Test(dataProvider= "Poll_Survey", priority=1,description="Poll Survey on Order")
  public void PollSurvey(Method method,String Email,String Password, String Answer) throws Exception {
	  startTest(method.getName(),"Poll Survey on Order");
	  LoginPage logpage= new LoginPage();
	  logpage.login(Email, Password);
	  Thread.sleep(2000);
	  PollPage pollpage = new PollPage();
	  pollpage.PollResponse(Answer);
  }
  @AfterMethod
  public void TearDown() {
	  driver.quit();
  }

}
