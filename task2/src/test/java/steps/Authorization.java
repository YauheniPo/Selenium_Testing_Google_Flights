package steps;

import a1qa.google.flights.elements.Header;
import cucumber.api.java.en.When;

public class Authorization {

	@When("^I logged in with '(.*?)' and '(.*?)'$")
	public void logging(String login, String password) throws Throwable {
	    new Header().logging().loginAs(login, password);
	}
}