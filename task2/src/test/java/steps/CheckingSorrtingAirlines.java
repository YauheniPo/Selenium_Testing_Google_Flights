package steps;

import java.util.List;

import org.openqa.selenium.WebElement;

import a1qa.google.flights.pages.FlightsPage;
import a1qa.google.flights.utils.Airlines;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static a1qa.google.flights.pages.FlightsPage.*;

public class CheckingSorrtingAirlines {
	
	private FlightsPage flightPage;
	
	@When("^I clicked sorting airlines$")
	public void i_clicked_sorting_airlines() throws Throwable {
		flightPage = new FlightsPage();
		flightPage.clickAirline();
	}

	@When("^choose Belavia$")
	public void choose_Belavia() throws Throwable {
	    flightPage.switchAirline(Airlines.BELAVIA.getTitle());
	}

	@Then("^flights only Belavia$")
	public void flights_only_Belavia() throws Throwable {
		List<WebElement> flights = flightPage.getListFlights();
		flights.forEach(flight -> {
			if(!Airlines.BELAVIA.getTitle().equals(flight.findElement(FLIGHTS_PAGE_AIRLINE_TITLE).getText())) {
				
			}
		});
	}
}