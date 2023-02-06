package com.vueling.interview.pages;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TicketPage extends Page {
    private final static Logger LOGGER = LogManager.getLogger(TicketPage.class);

    @FindBy(id = "AvailabilitySearchInputSearchView_TextBoxMarketOrigin1")
    private WebElement inputOrigin;

    @FindBy(id = "AvailabilitySearchInputSearchView_TextBoxMarketDestination1")
    private WebElement inputDestination;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement buttonAcceptCookies;

    @FindBy(css = "div#divButtonBuscadorNormal")
    private WebElement buttonFindFlights;

    @FindBy(css = "td > a")
    private List<WebElement> calendarDates;

    @FindBy(css = "div.wrapper_elForm_section>a")
    private List<WebElement> dropDownListAdultPassengers;

    @FindBy(id = "AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD")
    private WebElement dropDownListChildrenPassengers;

    public TicketPage(WebDriver driver) {
	super(driver);
    }

    public void acceptCookies() {
	LOGGER.info("Accepting cookies if present");
	if (buttonAcceptCookies.isDisplayed()) {
	    buttonAcceptCookies.click();
	}
    }

    public FlightsPage openSearchFlightsPage() {
	buttonFindFlights.click();
	return new FlightsPage(driver);
    }

    public void isPageOpen() {
	String expectedTitle = "Vueling";
	Assert.assertEquals(expectedTitle, driver.getTitle(), "Page is not open");
    }

    public void fillTicketSearch() {
	LOGGER.info("Filling ticket search");
	inputOrigin.sendKeys("Barcelona");
	inputOrigin.sendKeys(Keys.RETURN);
	inputDestination.sendKeys("Madrid");
	inputDestination.sendKeys(Keys.RETURN);
    }

    public void fillDepartureDate() {
	LocalDate departureDate = LocalDate.now().plusDays(4);
	for (WebElement date : calendarDates) {
	    if (Integer.parseInt(date.getText()) == departureDate.getDayOfMonth()) {
		date.click();
		break;
	    }
	}
    }

    public void fillReturnDate() {
	LocalDate departureDate = LocalDate.now().plusDays(7);
	for (WebElement date : calendarDates) {
	    if (Integer.parseInt(date.getText()) == departureDate.getDayOfMonth()) {
		date.click();
		break;
	    }
	}
    }

    public void selectPassengers() {
	LOGGER.info("Selecting Passengers");
	for (WebElement option : dropDownListAdultPassengers) {
	    if (Integer.parseInt(option.getText()) == 2) {
		option.click();
		break;
	    }
	}
	Select select = new Select(dropDownListChildrenPassengers);
	select.selectByValue("1");
    }

}
