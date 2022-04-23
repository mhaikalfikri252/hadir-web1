package com.hadir.web1.glue.all;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-repor.html" }, features = {
		"src/main/resources/features/Login.feature", "src/main/resources/features/Dashboard.feature",
		"src/main/resources/features/FormRegistration.feature",
		"src/main/resources/features/FormRegistrationInvalid.feature", "src/main/resources/features/Staff.feature",
		"src/main/resources/features/StaffInvalid.feature", "src/main/resources/features/Register.feature",
		"src/main/resources/features/Report.feature",
//		"src/main/resources/features/SelfRegistration.feature",
		"src/main/resources/features/ManageTipe.feature", "src/main/resources/features/ManageTipeInvalid.feature",
		"src/main/resources/features/ManageHariCuti.feature",
		"src/main/resources/features/ManageHariCutiInvalid.feature",
		"src/main/resources/features/ManageAbsenPoint.feature",
		"src/main/resources/features/ManageAbsenPointInvalid.feature",
		"src/main/resources/features/ManagePosisi.feature", "src/main/resources/features/ManagePosisiInvalid.feature",
		"src/main/resources/features/ManageLevel.feature", "src/main/resources/features/ManageLevelInvalid.feature",
		"src/main/resources/features/ManageSetting.feature", "src/main/resources/features/ManageSettingInvalid.feature",
		"src/main/resources/features/ManageDepartemen.feature",
		"src/main/resources/features/ManageDepartemenInvalid.feature",
		"src/main/resources/features/LoginInvalid.feature" })

public class AllStepRunnerTest {

}
