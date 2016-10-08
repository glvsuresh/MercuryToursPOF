package com.training.mercurytours.pages;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.training.mercurytours.utils.CommonLib;

public class LoginPage extends CommonLib {
	
	
	private WebDriver oBrowser;
	private WebElement userName,password,login;
	
	public LoginPage(WebDriver oBrowser)
	{
		this.oBrowser=oBrowser;
		PageFactory.initElements(oBrowser, this);
		if(oBrowser.getTitle().equalsIgnoreCase("Welcome: Mercury Tours"))
		{
			System.out.println("Login Page is Displayed");
		}
		else
		{
			throw new NoSuchWindowException("Error Occured while displaying MT Login Page");
		}
	}
	
	public FindFlightsPage Login(String sUsername,String sPassword)
	{
		userName.sendKeys(sUsername);
		password.sendKeys(sPassword);
		login.click();
		return PageFactory.initElements(oBrowser, FindFlightsPage.class);
	}
	

}
