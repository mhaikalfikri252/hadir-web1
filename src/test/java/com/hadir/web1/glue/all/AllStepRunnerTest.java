package com.hadir.web1.glue.all;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report-hadir.html" }, features = {
		"src/main/resources/features/A Login.feature", "src/main/resources/features/B Dashboard.feature",
		"src/main/resources/features/C FormRegistration.feature",
		"src/main/resources/features/D FormRegistrationInvalid.feature", "src/main/resources/features/E Staff.feature",
		"src/main/resources/features/F StaffInvalid.feature", "src/main/resources/features/G Register.feature",
		"src/main/resources/features/H Report.feature",
//		"src/main/resources/features/I SelfRegistration.feature",
		"src/main/resources/features/I ManageTipe.feature", "src/main/resources/features/J ManageTipeInvalid.feature",
		"src/main/resources/features/K ManageHariCuti.feature",
		"src/main/resources/features/L ManageHariCutiInvalid.feature",
		"src/main/resources/features/M ManageAbsenPoint.feature",
		"src/main/resources/features/N ManageAbsenPointInvalid.feature",
		"src/main/resources/features/O ManagePosisi.feature",
		"src/main/resources/features/P ManagePosisiInvalid.feature",
		"src/main/resources/features/Q ManageLevel.feature", "src/main/resources/features/R ManageLevelInvalid.feature",
		"src/main/resources/features/S ManageSetting.feature",
		"src/main/resources/features/T ManageSettingInvalid.feature",
		"src/main/resources/features/U ManageDepartemen.feature",
		"src/main/resources/features/V ManageDepartemenInvalid.feature",
		"src/main/resources/features/W LoginInvalid.feature" })

public class AllStepRunnerTest {

}
