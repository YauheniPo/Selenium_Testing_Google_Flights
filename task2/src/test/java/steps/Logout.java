package steps;

import a1qa.google.flights.elements.Header;
import cucumber.api.java.en.When;

public class Logout {
	
	@When("^I logged out$")
	public void logout() throws Throwable {
	    new Header().logout();
	}
}