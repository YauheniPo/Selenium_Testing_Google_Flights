package a1qa.goo_flights.steps;

import java.util.List;

import a1qa.framework.test.BaseTest;
import a1qa.goo_flights.pages.FlightsPage;
import a1qa.goo_flights.utils.Airlines;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.*;

public class CheckingSorrtingAirlines extends BaseTest {
	
	private FlightsPage flightPage;
	
	@When("^I clicked sorting airlines$")
	public void clickSortAirlines() throws Throwable {
		flightPage = new FlightsPage();
		flightPage.clickAirline();
	}

	@When("^choose Belavia$")
	public void choiceAirline() throws Throwable {
	    flightPage.switchAirline(Airlines.BELAVIA.getTitle());
	}

	@Then("^flights only Belavia$")
	public void checkFlights() throws Throwable {
		log.info("Checking sorting airlines");
		List<String> flights = flightPage.getListTitleAirlines();
		assertTrue(flightPage.isCorrectSorting(flights, Airlines.BELAVIA.getTitle()), "Error airlines sorting");
		log.info("Sorted airlines complete");
	}
}