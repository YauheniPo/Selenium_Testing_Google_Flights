package steps;

import a1qa.google.flights.pages.HomePage;
import a1qa.google.flights.utils.Currency;
import context.ScenarioContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static a1qa.framework.utils.RegExConfig.*;
import static org.testng.Assert.*;

public class Checking_Prices_Of_Different_Currencies {

	private String currency;

	@When("^I switched currency '(.*?)'$")
	public void switchCurrency(String cur) throws Throwable {
		this.currency = cur;
		new HomePage().clickLeftBar().selectСurrency(currency);
	}

	@Then("^there was a new price$")
	public void fetchPrice() throws Throwable {
		ScenarioContext.getInstance().put(currency, Double.valueOf(getStrToRegEx(new HomePage().getPlacePrice(), REG_EX_VALUE_INT)));
	}

	@Then("^the price difference corresponds to a '(.*?)' within (\\d+)$")
	public void pricesEquals(String coeff, int pct) throws Throwable {
		double coefficient = Double.valueOf(coeff);
		
		double firstPrice = (Double) ScenarioContext.getInstance().getValue(Currency.USD.toString());
		double secondPrice = (Double) ScenarioContext.getInstance().getValue(Currency.EUR.toString());
		
		double coeffCurrency = firstPrice / secondPrice;
		assertEquals(coefficient, coeffCurrency, (coeffCurrency / 100) * pct);
	}
}