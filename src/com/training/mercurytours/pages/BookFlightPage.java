package com.training.mercurytours.pages;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BookFlightPage {
	
	
	private WebDriver oBrowser;
	private WebElement passFirst0,passLast0,creditnumber,buyFlights;
	
	public BookFlightPage(WebDriver oBrowser)
	{
		this.oBrowser=oBrowser;
		if(oBrowser.getTitle().equalsIgnoreCase("Book a Flight: Mercury Tours"))
		{
			System.out.println("Book Flight Page is displayed");
		}
		else
		{
			throw new NoSuchWindowException("Failed to display BookFlights Page");
		}
	}
	
	public FlightConfirmationPage enterPassngrDetails(String sFirstName,String sLastName,String sCreditNo)
	{
		passFirst0.sendKeys(sFirstName);
		passLast0.sendKeys(sLastName);
		creditnumber.sendKeys(sCreditNo);
		buyFlights.click();
		return PageFactory.initElements(oBrowser, FlightConfirmationPage.class);
	}

}
