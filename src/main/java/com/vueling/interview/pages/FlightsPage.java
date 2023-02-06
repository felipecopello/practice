package com.vueling.interview.pages;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FlightsPage extends Page {

    private final static Logger LOGGER = LogManager.getLogger(FlightsPage.class);

    @FindBy(css = "div#outboundFlightCardsContainer div.trip-selector_button")
    private List<WebElement> buttonOutboundFlightList;

    @FindBy(css = "div#inboundFlightCardsContainer div.trip-selector_button")
    private List<WebElement> buttonInboundFlightList;

    @FindBy(id = "stvContinueButton")
    private WebElement buttonContinue;

    public FlightsPage(WebDriver driver) {
	super(driver);
    }

    public void isPageOpen() {
	String expectedURL = "https://tickets.vueling.com/ScheduleSelectNew.aspx";
	Assert.assertEquals(expectedURL, driver.getCurrentUrl(), "Page is not open");
    }

    public void selectRandomOutboundFlight() {
	Random rand = new Random();
	WebElement buttonFlight = buttonOutboundFlightList.get(rand.nextInt(buttonOutboundFlightList.size()));
	buttonFlight.click();
    }

    public void selectRandomInboundFlight() {
	Random rand = new Random();
	WebElement buttonFlight = buttonInboundFlightList.get(rand.nextInt(buttonInboundFlightList.size()));
	buttonFlight.click();
    }

    public void selectFare(String input) {
	String locator = "//label[@for='%s']/div[@class='fares-box_footer']/span[@class='fares-box_radio']";
	locator = String.format(locator, input);

	WebElement spanFare = driver.findElement(By.xpath(locator));
	spanFare.click();
    }

    public void clickButtonContinue() {
	buttonContinue.click();
    }

}
