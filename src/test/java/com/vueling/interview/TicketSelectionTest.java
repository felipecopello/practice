package com.vueling.interview;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vueling.interview.pages.FlightsPage;
import com.vueling.interview.pages.TicketPage;

public class TicketSelectionTest extends TestNgTestBase {

    private TicketPage ticketPage;

    @BeforeMethod
    public void initPageObjects() {
	ticketPage = PageFactory.initElements(driver, TicketPage.class);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DP.class)
    public void testHomePageHasAHeader(String fareOption) {
	driver.get("https://tickets.vueling.com/");

	ticketPage.isPageOpen();
	ticketPage.acceptCookies();
	ticketPage.fillTicketSearch();
	ticketPage.fillDepartureDate();
	ticketPage.fillReturnDate();
	ticketPage.selectPassengers();

	FlightsPage flightsPage = ticketPage.openSearchFlightsPage();
	flightsPage.isPageOpen();
	flightsPage.selectRandomOutboundFlight();
	flightsPage.selectFare(fareOption);
	flightsPage.clickButtonContinue();
    }
}
