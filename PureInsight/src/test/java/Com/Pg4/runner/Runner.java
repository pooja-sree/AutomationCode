package Com.Pg4.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Pg3Feature/NewPatient.feature",
        glue = "Com/Pg4/StepDefinition",

        plugin = {"html:report/report.html" , "json:report/report.json"}

)

public class Runner{


}
