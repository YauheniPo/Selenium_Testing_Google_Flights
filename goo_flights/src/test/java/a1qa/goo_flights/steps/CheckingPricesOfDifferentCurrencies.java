package a1qa.goo_flights.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static a1qa.framework.utils.RegExConfig.*;
import static org.testng.Assert.*;

import a1qa.context.ScenarioContext;
import a1qa.framework.test.BaseTest;
import a1qa.goo_flights.pages.HomePage;
import a1qa.goo_flights.utils.CurrenciesLocators;

public class CheckingPricesOfDifferentCurrencies extends BaseTest {
 
	private String currency;

	@When("^I switched currency '(.*?)'$")
	public void switchCurrency(String cur) throws Throwable {
		this.currency = cur;
		new HomePage().clickLeftBar().selectCurrency(currency);
		assertTrue(new HomePage().checkCurrency(currency), "Error currency");
	}

	@Then("^there was a new price$")
	public void fetchPrice() throws Throwable {
		ScenarioContext.getInstance().put(currency, Double.valueOf(getStrToRegEx(new HomePage().getPlacePrice(), REG_EX_VALUE_INT)));
	}

	@Then("^the price difference corresponds to a '(.*?)' within (\\d+)$")
	public void pricesEquals(String coeff, int pct) throws Throwable {
		log.info("Checking the price difference");
		double coefficient = Double.valueOf(coeff);
		
		double firstPrice = (Double) ScenarioContext.getInstance().getValue(CurrenciesLocators.USD.toString());

		double secondPrice = (Double) ScenarioContext.getInstance().getValue(CurrenciesLocators.EUR.toString());

		double coeffCurrency = firstPrice / secondPrice;
		assertEquals(coefficient, coeffCurrency, (coeffCurrency / 100) * pct);
	}
}