package steps;

import java.util.StringTokenizer;

import a1qa.framework.test.BaseTest;
import a1qa.google.flights.pages.FlightsPage;
import a1qa.google.flights.pages.HomePage;
import a1qa.google.flights.pages.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.*;
import static a1qa.google.flights.utils.FlightsConfig.*;

public class CheckingTrackPrices extends BaseTest {
	
	private HomePage homePage;
	private FlightsPage flightsPage;

	@When("^I choose Places tab$")
	public void switchPlacesTab() throws Throwable {
		homePage = new HomePage().clickPlacesTag();
	}

	@When("^entered the '(.*?)'$")
	public void enterPlace(String place) throws Throwable {
		homePage = new HomePage().typePlace(place);
	}

	@Then("^in results viewed correct information '(.*?)'$")
	public void checkResult(String place) throws Throwable {
		log.info("Checking the result of the entered place");
		String content = homePage.getPlaceContent();
		String delim = ", ";
		
		StringTokenizer tokenizer = new StringTokenizer(content, delim); 
		while (tokenizer.hasMoreTokens()) {
			if(place.indexOf(tokenizer.nextToken()) < 0) {
				log.error("Incorrected place result");
			}
		}
	}

	@When("^I choose this result$")
	public void switchResult() throws Throwable {
		homePage.clickPlaceResult();
	}

	@Then("^there is this '(.*?)'$")
	public void checkPlace(String place) throws Throwable {
	   assertTrue(place.indexOf(homePage.getPlaceName()) >= 0, "Incorrect place");
	}

	@When("^I choose this place$")
	public void switchPlace() throws Throwable {
		 homePage.clickPlace();
	}

	@When("^information flights$")
	public void informationFlights() throws Throwable {
	    homePage.clickPlaceFlights();
	}

	@Then("^opened flights page$")
	public void flightsPage() throws Throwable {
		flightsPage = new FlightsPage();
	}

	@When("^I clicked track prices$")
	public void clickTrackPrices() throws Throwable {
		flightsPage.clickTrackPrices();
	}

	@Then("^track prices function is turned on$")
	public void checkTrackPricesStatusIsON() throws Throwable {
		assertEquals(SWITCH_ON, flightsPage.getStatusSwitchTrackPrices(), "Incorrected switch work");
		
		//Выключаем для корректной работы следующих тестов
		flightsPage.clickTrackPrices();
	}
	
	@Then("^was opened page with login form$")
	public void isLoginForm() throws Throwable {
		new LoginPage();
	}
	
	@Then("^track prices function is turned off$")
	public void checkTrackPricesStatusIsOFF() throws Throwable {
		assertEquals(SWITCH_OFF, flightsPage.getStatusSwitchTrackPrices(), "Incorrected switch work");
	}
}