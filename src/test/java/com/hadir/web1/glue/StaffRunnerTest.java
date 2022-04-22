package com.hadir.web1.glue;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports-staff.html" }, features = {
		"src/main/resources/features/Staff.feature", "src/main/resources/features/StaffInvalid.feature" })

public class StaffRunnerTest {

}
