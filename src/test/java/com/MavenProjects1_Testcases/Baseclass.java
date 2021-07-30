package com.MavenProjects1_Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import comm.MavenProjects1_Utility.Readconfig;

public class Baseclass
{
	Readconfig readconfig=new Readconfig();
			
	public String url=readconfig.Applicationurl();
	public String username=readconfig.Username();
	public String password=readconfig.password();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	@Parameters("browser")
	public void Setup(String str)
	{
		
		logger=Logger.getLogger("MavenProjects1");
		PropertyConfigurator.configure("log4j.properties");
		if (str.equals("IE"))
		{
		System.setProperty("webdriver.ie.driver",readconfig.getinternetPath());
		driver=new InternetExplorerDriver();
		}
		else 
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}
	
	@AfterClass
	public void breakdown()
	{
		driver.quit();
	}
	

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
}
