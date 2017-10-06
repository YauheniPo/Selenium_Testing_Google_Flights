package steps;

import a1qa.google.flights.elements.Header;
import cucumber.api.java.en.Then;

public class CheckLogout {
	
	@Then("^I am not authorized$")
	public void checkUserIsNotLogged() throws Throwable {
		 new Header().checkUserLogout();
	}
}