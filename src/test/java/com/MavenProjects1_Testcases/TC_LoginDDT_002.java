package com.MavenProjects1_Testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MavenProjects1_PageObjects.PageObject;

import comm.MavenProjects1_Utility.Excel_Utility;

public class TC_LoginDDT_002 extends Baseclass

{

@Test(dataProvider="loginTest")
public void login(String Username,String userpwd) throws IOException, InterruptedException
{
	
	logger.info("url will be sending");
	driver.get(url);
	PageObject pg=new PageObject(driver);
	pg.username(Username);
	logger.info("username passed");
	pg.password1(userpwd);
	pg.ulogin();
	if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
	{
		Assert.assertTrue(true);
		logger.info("true case");
		Thread.sleep(5000);
		pg.logout1();
		
	}
	else
	{
		captureScreen(driver,"LoginDDT");
		Assert.assertTrue(false);
		logger.info("false case");
	}
	
	
	
}
@DataProvider(name="loginTest")
public String[][] getdata() throws IOException
{
	String path=System.getProperty("user.dir")+"//src//test//java//com//MavenProjects1_Testdata//Book1.xlsx";
	int a=Excel_Utility.getRowCount(path, "Sheet1");
	int b=Excel_Utility.getCellCount(path, "Sheet1", 1);
	
	String[][] logindata=new String[a][b];
	
	for(int i=1;i<=a;i++)
	{
		for(int j=0;j<b;j++)
		{
			 logindata[i-1][j]= Excel_Utility.getCellData(path, "Sheet1", i, j);
		}
	}
	
	return logindata;
}
}
