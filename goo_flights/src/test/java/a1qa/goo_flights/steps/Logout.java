package a1qa.goo_flights.steps;

import a1qa.goo_flights.elements.Header;
import cucumber.api.java.en.When;

public class Logout {
	
	@When("^I logged out$")
	public void logout() throws Throwable {
	    new Header().logout();
	}
}