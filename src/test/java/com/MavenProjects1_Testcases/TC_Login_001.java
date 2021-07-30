package com.MavenProjects1_Testcases;




import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MavenProjects1_PageObjects.PageObject;



public class TC_Login_001 extends Baseclass

{
	

	
    
	@Test
	public void Login() throws IOException, InterruptedException
	{
		logger.info("url will be sending");
		driver.get(url);
		PageObject pg=new PageObject(driver);
		pg.username(username);
		logger.info("username passed");
		pg.password1(password);
		pg.ulogin();
		Thread.sleep(5000);
		if(driver.getTitle().equals("kkjkjkjk"))
		{
			Assert.assertTrue(true);
			logger.info("true case");
			pg.logout1();
		}
		
		else
		{
			captureScreen(driver,"Login");
		    Assert.assertTrue(false);
			
		}
		
	
		
	}
	
	
}
