package steps;

import a1qa.google.flights.pages.HomePage;
import cucumber.api.java.en.Given;

public class SwapLanguageVersionSite {
	
	@Given("^Swap language version of the site$")
	public void choiceLanguageSite() throws Throwable {
		new HomePage().clickLeftBar().choiceLanguage();
	}
}