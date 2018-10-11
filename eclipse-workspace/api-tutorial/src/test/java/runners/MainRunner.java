package runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = {"html:target/cucumber"},
		features = "src/test/resources/features",
		glue = "stepDefs",
		tags = "@github",
		dryRun = false
		
		)


public class MainRunner {

}
