package com.MavenProjects1_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject
{

	public WebDriver ldriver;
	
	
	
   public PageObject(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"Email\"]")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password2;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]")
	WebElement logout;
	
	public void username(String uname) 
	{   email.clear();
		email.sendKeys(uname);
	}
	public void password1(String pwd)
	{
		password2.clear();
		password2.sendKeys(pwd);
	}
	
	public void ulogin()
	{
		login.click();
	}
	
	public void logout1()
	{
		logout.click();
	}













}



