package com.training.mercurytours.pages;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmationPage {
	
	private WebDriver oBrowser;
	
	@FindBy(xpath="//img[contains(@src,'Logout')]")
	private WebElement btnLogOut;
	
	public FlightConfirmationPage(WebDriver oBrowser)
	{
		this.oBrowser=oBrowser;
		if(oBrowser.getTitle().equalsIgnoreCase("Flight Confirmation: Mercury Tours"))
		{
			System.out.println("Flight Confirmation Displayed");
		}
		else
		{
			throw new NoSuchWindowException("Failed to display Flight Confirmation Page");
		}
	}

	public LogOutPage clickOnLogOut()
	{
		btnLogOut.click();
		return PageFactory.initElements(oBrowser, LogOutPage.class);
	}
	
}
