package a1qa.goo_flights.steps;

import a1qa.framework.test.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAfterScenario extends BaseTest{
	
	@Before
	public void beforeScenario(Scenario scenario) {
		before();
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		after();
	}
}