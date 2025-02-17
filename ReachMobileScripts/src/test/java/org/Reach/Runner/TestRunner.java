package org.Reach.Runner;

import org.Reach.StepDefinitions.LaunchApplication;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        glue = "org/Reach/StepDefinitions",
        plugin = {"html:report/report.html", "json:report/report.json"}
)
public class TestRunner {



}
