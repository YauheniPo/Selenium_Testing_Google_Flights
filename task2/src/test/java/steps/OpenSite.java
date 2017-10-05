package steps;

import a1qa.google.flights.pages.HomePage;
import cucumber.api.java.en.Given;

public class OpenSite {
	
	@Given("^site https://www\\.google\\.com/flights/ was opened$")
	public void openSite() throws Throwable {
	    new HomePage();
	}
}