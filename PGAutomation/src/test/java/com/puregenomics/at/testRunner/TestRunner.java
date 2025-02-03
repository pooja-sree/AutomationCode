package com.puregenomics.at.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;	
import cucumber.api.testng.AbstractTestNGCucumberTests;



@RunWith(Cucumber.class)
@CucumberOptions(
				features = "src\\test\\resources\\Features",
				glue= {"stepDefinition"},
				plugin = {"pretty", "json:target/cucumber-reports/PG3_Automation.json"},
				tags = {"@login"},
				monochrome = true
				)


public class TestRunner extends AbstractTestNGCucumberTests {
	

}

