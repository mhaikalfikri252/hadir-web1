package com.hadir.web1.glue.all;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report-hadir.html" }, features = {
		"src/main/resources/features", })

public class AllStepRunnerTest {

}
