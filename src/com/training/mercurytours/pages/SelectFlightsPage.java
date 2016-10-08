package com.training.mercurytours.pages;

import java.util.List;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.mercurytours.utils.CommonLib;

public class SelectFlightsPage extends CommonLib {
	
	private WebDriver oBrowser;

	private WebElement reserveFlights;
	
	@FindAll({@FindBy(name="outFlight")})
    private List<WebElement> sDeptAirlines;
	
	@FindAll({@FindBy(name="inFlight")})
    private List<WebElement> sRtnAirlines;
	
	public SelectFlightsPage(WebDriver oBrowser)
	{
		this.oBrowser=oBrowser;
		if(oBrowser.getTitle().equalsIgnoreCase("Select a Flight: Mercury Tours"))
		{
			System.out.println("Select Flights is Displayed");
		}
		else
		{
			throw new NoSuchWindowException("Failed to display Select Flights Page");
		}
	}
	
	public BookFlightPage selectTrvlFlights(String strDeptAirlines,String strRtnAirlines)
	{
		
		clickOnElemByusingName(sDeptAirlines, strDeptAirlines);
		clickOnElemByusingName(sRtnAirlines, strRtnAirlines);
		reserveFlights.click();
		return PageFactory.initElements(oBrowser, BookFlightPage.class);
	}

}
