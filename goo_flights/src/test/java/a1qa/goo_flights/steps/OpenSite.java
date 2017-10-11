package a1qa.goo_flights.steps;

import a1qa.goo_flights.pages.HomePage;
import cucumber.api.java.en.Given;

public class OpenSite {
	
	@Given("^site https://www\\.google\\.com/flights/ was opened$")
	public void openSite() throws Throwable {
	    new HomePage();
	}
}