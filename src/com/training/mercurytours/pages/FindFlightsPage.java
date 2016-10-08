package com.training.mercurytours.pages;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.mercurytours.utils.CommonLib;

public class FindFlightsPage extends CommonLib{
	
	private WebDriver oBrowser;
	private WebElement passCount,fromPort,fromDay,toPort,toDay,airline,findFlights;
	
	@FindBy(xpath="//input[@value='Business']")
	private WebElement sServClass;
	
	public FindFlightsPage(WebDriver oBrowser)
	{
		this.oBrowser=oBrowser;
		if(oBrowser.getTitle().equalsIgnoreCase("Find a Flight: Mercury Tours:"))
		{
			System.out.println("Flight Finder Page is displayed");
		}
		else
		{
			throw new NoSuchWindowException("Failed to display Flight finder page");
		}
	}
	
	public SelectFlightsPage searchForFlight(String sPasCount,String sDept,String sTrvlDate,String sArrival,String sRtnDate,String sAirlines)
	{
		selectValFromListbox(passCount, sPasCount);
		selectValFromListbox(fromPort, sDept);
		selectValFromListbox(fromDay, sTrvlDate);
		selectValFromListbox(toPort, sArrival);
		selectValFromListbox(toDay, sRtnDate);
		sServClass.click();
		selectValFromListbox(airline, sAirlines);
		findFlights.click();
		return PageFactory.initElements(oBrowser, SelectFlightsPage.class);
	}

}
