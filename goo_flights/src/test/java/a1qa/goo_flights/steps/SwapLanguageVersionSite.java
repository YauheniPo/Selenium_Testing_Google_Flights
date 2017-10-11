package a1qa.goo_flights.steps;

import a1qa.goo_flights.pages.HomePage;
import cucumber.api.java.en.Given;

public class SwapLanguageVersionSite {
	
	@Given("^Swap language version of the site$")
	public void choiceLanguageSite() throws Throwable {
		new HomePage().clickLeftBar().choiceLanguage();
	}
}