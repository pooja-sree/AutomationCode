package com.pg4.pg.Runner;

import com.Pg4.Pg.Util.BrowserConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Config/Features/Login.feature",
        glue = "com.pg4.pg.stepDefinitions",

        plugin = {"html:report/report.html" , "json:report/report.json"}

)
public class Runner {








}
