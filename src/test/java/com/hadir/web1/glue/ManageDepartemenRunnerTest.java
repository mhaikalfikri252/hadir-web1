package com.hadir.web1.glue;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports-managedepartemen.html" }, features = {
		"src/main/resources/features/ManageDepartemen.feature", "src/main/resources/features/ManageDepartemenInvalid.feature" })

public class ManageDepartemenRunnerTest {

}

