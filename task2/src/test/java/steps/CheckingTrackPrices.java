package steps;

import java.util.StringTokenizer;

import a1qa.framework.test.BaseTest;
import a1qa.google.flights.pages.FlightsPage;
import a1qa.google.flights.pages.HomePage;
import a1qa.google.flights.pages.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static a1qa.google.flights.pages.HomePage.*;
import static org.testng.Assert.*;
import static a1qa.google.flights.utils.FlightsConfig.*;

public class CheckingTrackPrices extends BaseTest {
	
	private HomePage homePage;
	private FlightsPage flightsPage;

	@When("^I choose Places tab$")
	public void i_switched_Places_tab() throws Throwable {
		homePage = new HomePage().clickPlacesTag();
	}

	@When("^entered the '(.*?)'$")
	public void entered_the_Moscow_Russia(String place) throws Throwable {
		homePage.typePlace(place);
	}

	@Then("^in results viewed correct information '(.*?)'$")
	public void in_results_viewed_correct_information(String place) throws Throwable {
		String content = homePage.getElement(HOME_PAGE_PLACE_CONTENT).getText().trim();
		String delim = ", ";
		
		StringTokenizer tokenizer = new StringTokenizer(content, delim); 
		while (tokenizer.hasMoreTokens()) {
			if(place.indexOf(tokenizer.nextToken()) < 0) {
				log.error("Incorrected place result");
			}
		}
	}

	@When("^I choose this result$")
	public void i_switched_this_result() throws Throwable {
		homePage.clickPlaceResult();
	}

	@Then("^there is this '(.*?)'$")
	public void there_is_this_place(String place) throws Throwable {
	   assertTrue(place.indexOf(homePage.getPlaceName()) >= 0, "Incorrect place");
	}

	@When("^I choose this place$")
	public void i_switched_this_place() throws Throwable {
		 homePage.clickPlace();
	}

	@When("^information flights$")
	public void information_flights() throws Throwable {
	    homePage.clickPlaceFlights();
	}

	@Then("^opened flights page$")
	public void opened_flights_page() throws Throwable {
		flightsPage = new FlightsPage();
	}

	@When("^I clicked track prices$")
	public void i_clicked_track_prices() throws Throwable {
		flightsPage.clickTrackPrices();
	}

	@Then("^track prices function is turned on$")
	public void track_prices_function_is_turned_on() throws Throwable {
		assertEquals(SWITCH_ON, flightsPage.getStatusSwitchTrackPrices(), "Incorrected switch work ");
		
		//Выключаем для корректной работы следующих тестов
		flightsPage.clickTrackPrices();
	}
	
	@Then("^was opened page with login form$")
	public void isLoginForm() throws Throwable {
		new LoginPage();
	}
	
	@Then("^track prices function is turned off$")
	public void track_prices_function_is_turned_off() throws Throwable {
		assertEquals(SWITCH_OFF, flightsPage.getStatusSwitchTrackPrices(), "Incorrected switch work ");
	}
}