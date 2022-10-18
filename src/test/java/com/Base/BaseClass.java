package com.Base;
//Base Class
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.Utilities.Utilities;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		try {
		prop= new Properties();
		FileInputStream ip= new FileInputStream("C:\\Users\\jwala\\eclipse-workspace\\workspace\\demowebshop\\src\\test\\java\\com\\EnvironmentVariable\\config.properties");
	prop.load(ip);}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	//initialization of drivers
	@SuppressWarnings("deprecation")
	public static void initialization() {
		 String browserName= prop.getProperty("browser");
		 if(browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeLocation"));
			 driver= new ChromeDriver();
		 }
		 if(browserName.equals("edge")) {
			 System.setProperty("webdriver.edge.driver", prop.getProperty("EdgeLocation"));
			 driver= new EdgeDriver();
		 }
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Utilities.page_load_timeout,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(Utilities.implicit_wait,TimeUnit.SECONDS);
		 driver.get(prop.getProperty("URL"));
		  
	}


}
