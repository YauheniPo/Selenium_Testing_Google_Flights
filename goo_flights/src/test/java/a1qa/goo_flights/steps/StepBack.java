package a1qa.goo_flights.steps;

import a1qa.framework.entity.AbstractEntity;
import a1qa.framework.test.BaseTest;
import cucumber.api.java.en.When;

public class StepBack extends BaseTest{
	
	@When("^I went one step back$")
	public void stepBack() throws Throwable {
		AbstractEntity.clickback();
	}
}