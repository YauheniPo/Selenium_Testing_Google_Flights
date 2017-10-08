package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",
        plugin = {"pretty", "html:target/cucumber",},
        glue = "steps",
        tags = "@track_prices_for_guest, @track_prices_for_user, @checking_currencies_and_prices, @sorting_hotels_prices, @sorting_airlines"      
)
public class RunnerTest {
}