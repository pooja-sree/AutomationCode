package org.reach24.Reach24NEP.runnerFiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.reach24.Reach24NEP.util.BeforeAndAfterScenarios;
import org.reach24.Reach24NEP.util.BrowserConfig;


@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features/",
        glue = "org/reach24/Reach24NEP/stepDefinitions",
        tags = "@Smoke",
        monochrome = true,
        plugin= {"summary",
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "rerun:target/failed_scenario.txt"}
)

public class SmokeRunner {
    static BrowserConfig browserConfig = new BrowserConfig();
    static BeforeAndAfterScenarios beforeScenarios = new BeforeAndAfterScenarios();
    @BeforeClass
    public static void setup() {
        beforeScenarios.loginTenant("TD");
        beforeScenarios.loginTenant("TD2");
        beforeScenarios.loginTenant("CC");
        beforeScenarios.loginTenant("CC1");
        beforeScenarios.loginTenant("CCHQ");
        beforeScenarios.loginTenant("Admin");
        beforeScenarios.loginTenant("Fleet");
        beforeScenarios.loginTenant("SP");
        beforeScenarios.loginTenant("SP1");
        beforeScenarios.loginTenant("SP2");
        beforeScenarios.loginTenant("SP3");
        beforeScenarios.loginTenant("SP4");
        beforeScenarios.loginTenant("SP5");
        beforeScenarios.loginTenant("SP7");
        beforeScenarios.loginTenant("SPHQ");
        beforeScenarios.loginTenant("AutoForward");
    }

    @AfterClass
    public static void tearDown() {
        browserConfig.closeDriver();
    }
}