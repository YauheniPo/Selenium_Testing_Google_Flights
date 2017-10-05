package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",
        plugin = {"pretty", "html:target/cucumber",},
        glue = "steps",
        tags = "@check_wallet, @edit_profile, @logout, @special_offer, @steam_download"      
)
public class RunnerTest {
}