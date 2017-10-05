package steps;

import a1qa.google.flights.pages.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckingTrackPrices {
	
	private HomePage homePage;

	@When("^I switched Places tab$")
	public void i_switched_Places_tab() throws Throwable {
		homePage = new HomePage().clickPlacesTag();
	}

	@When("^entered the '(.*?)'$")
	public void entered_the_Moscow_Russia(String place) throws Throwable {
		homePage.typePlace(place);
	}

	@Then("^in results viewed correct information '(.*?)'$")
	public void in_results_viewed_correct_information(String place) throws Throwable {
		homePage.clickPlaceResult(place);
	}

	@When("^I switched this result$")
	public void i_switched_this_result() throws Throwable {
	    
	}

	@Then("^there is this place$")
	public void there_is_this_place() throws Throwable {
	    
	}

	@When("^I switched this place$")
	public void i_switched_this_place() throws Throwable {
	    
	}

	@When("^information flights$")
	public void information_flights() throws Throwable {
	    
	}

	@Then("^opened flights page$")
	public void opened_flights_page() throws Throwable {
	    
	}

	@When("^I clicked track prices$")
	public void i_clicked_track_prices() throws Throwable {
	    
	}

	@Then("^track prices function is turned on$")
	public void track_prices_function_is_turned_on() throws Throwable {
	    
	}

	@When("^I logged out$")
	public void i_logged_out() throws Throwable {
	    
	}

	@Then("^flights page was opened$")
	public void flights_page_was_opened() throws Throwable {
	    
	}

	@Then("^track prices function is turned$")
	public void track_prices_function_is_turned() throws Throwable {
	    
	}
}