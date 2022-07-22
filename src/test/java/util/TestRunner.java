package util;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/featureFiles"},
        glue = {"stepDefinition"},
//        monochrome = true,
        tags = {"@test"},
        plugin = {"pretty", "html:target/cucumber-html-report",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml"}
)
public class TestRunner {
}
