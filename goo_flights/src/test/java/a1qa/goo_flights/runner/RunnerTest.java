package a1qa.goo_flights.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/features/"}, 
		glue = "a1qa/goo_flights/steps", 
		tags = "@track_prices_for_guest, @track_prices_for_user, @checking_currencies_and_prices, @sorting_hotels_prices, @sorting_airlines",  
		strict = true, 
		format = {"pretty", "html:target/cukes", "json:target/cukes/report.json", "junit:target/cukes/junit.xml"}
		)
public class RunnerTest extends AbstractTestNGCucumberTests{

}