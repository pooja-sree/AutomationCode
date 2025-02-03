package com.rev.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

	


	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "src/test/resources/Feature/PatientPlan.feature",
	    glue = "com	\\rev\\stepDefinitions",
	    //tags = "@Scenario1"
	   
	    plugin = {"html:report/report.html" , "json:report/report.json"}
	    )
	    
	    		public class Runner {

	

}
