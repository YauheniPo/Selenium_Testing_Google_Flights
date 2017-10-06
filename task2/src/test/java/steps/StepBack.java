package steps;

import a1qa.framework.entity.MainForEntityFramework;
import a1qa.framework.test.BaseTest;
import cucumber.api.java.en.When;

public class StepBack extends BaseTest{
	
	@When("^I went one step back$")
	public void stepBack() throws Throwable {
		MainForEntityFramework.clickback();
	}
}