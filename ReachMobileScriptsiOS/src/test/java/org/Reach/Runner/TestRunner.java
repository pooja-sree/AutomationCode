package org.Reach.Runner;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.Reach.iOS.Utils.Base;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        glue = "org.Reach.StepDefinitions",
        plugin = {"html:report/report.html", "json:report/report.json"}
//        dryRun = true
)
public class TestRunner {

}
