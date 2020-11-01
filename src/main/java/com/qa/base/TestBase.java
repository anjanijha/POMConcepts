package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties pro;
	
	public TestBase() {
		try {
			pro=new Properties();
			FileInputStream ip= new FileInputStream("E:\\AutomationTesting\\PageObjectModelAutomation\\src\\main\\java\\com\\qa\\config\\config.properties");
			pro.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
		String browserName=pro.getProperty("browser");
		if(browserName.equals("chrom")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\AutomationTesting\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			System.getProperty("webdriver.chrom.driver","E:\\AutomationTesting\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver");
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		
		
		
		
	}

}
