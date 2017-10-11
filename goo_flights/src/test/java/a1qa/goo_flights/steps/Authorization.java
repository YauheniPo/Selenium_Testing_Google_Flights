package a1qa.goo_flights.steps;

import a1qa.goo_flights.elements.Header;
import cucumber.api.java.en.When;

public class Authorization {

	@When("^I logged in with '(.*?)' and '(.*?)'$")
	public void logging(String login, String password) throws Throwable {
	    new Header().logging().loginAs(login, password);
	    new Header().checkAuthorization(login);
	}
}