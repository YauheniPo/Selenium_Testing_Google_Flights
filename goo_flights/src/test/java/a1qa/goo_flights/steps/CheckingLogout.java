package a1qa.goo_flights.steps;

import a1qa.goo_flights.elements.Header;
import cucumber.api.java.en.Then;

public class CheckingLogout {
	
	@Then("^I am not authorized$")
	public void checkUserIsNotLogged() throws Throwable {
		 new Header().checkUserLogout();
	}
}