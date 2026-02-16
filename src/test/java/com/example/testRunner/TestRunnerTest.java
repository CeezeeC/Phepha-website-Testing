package com.example.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/example/stepDefinitions",
        plugin = {"pretty",
                  "html:target/CucumberReport.html",
                  "json:target/CucumberReport.json"
        },
        publish = true ,
        tags ="@Regression"

)

public class TestRunnerTest

{

}
