package com.revilia.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Feature",
    glue = "com\\revilia\\stepDefinitions",
    dryRun = false,// to check if steps in Feature file has their corresponding step definitions
    //Strict = false,// Same as of dryrun but will execute the tc and will fail the case lastly
    monochrome = false,// To make the console result more clear and human readable
   
    plugin= {"html:report/report.html" , "json:report/report.json"} // Report generation
    //tags = "@Scenario1"
   
    //plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-reports"}
)
public class Testrunner {
}	