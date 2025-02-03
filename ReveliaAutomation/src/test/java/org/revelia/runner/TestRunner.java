package org.revelia.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features", // Specify the path to your feature files
        glue = {"org/revelia/stepDefinition"},                // Specify the package where your step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports"} // Specify the plugins for reporting
)
public class TestRunner {
	
}
