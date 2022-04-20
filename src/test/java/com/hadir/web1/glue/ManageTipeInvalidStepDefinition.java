package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.ManageTipePage;
import com.hadir.web1.utils.ConfigurationProperties;
import com.hadir.web1.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class ManageTipeInvalidStepDefinition {

	private static WebDriver driver;
	private ManageTipePage manageTipePage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportManageTipeInvalid.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		manageTipePage = new ManageTipePage();
		extentTest = reports.startTest("Testing Halaman Manage Tipe Invalid");
	}

	@AfterStep
	public void getResult(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			String screenshotPath = Utils.getScreenshot(driver, scenario.getName().replace(" ", "_"));
			extentTest.log(LogStatus.FAIL, "Screenshot:/n" + extentTest.addScreenCapture(screenshotPath));
		}
	}

	@After
	public void closeObject() {
		reports.endTest(extentTest);
		reports.flush();
	}

	@AfterAll
	public static void closeBrowser() {
		// driver.quit();
	}

	@When("User tambah data tipe invalid")
	public void user_tambah_data_tipe_invalid() {
		manageTipePage.addDataTipeInvalid();
		extentTest.log(LogStatus.PASS, "User tambah data tipe invalid");
	}

	@And("User edit data tipe invalid")
	public void user_edit_data_tipe_invalid() {
		manageTipePage.editDataTipeInvalid();
		extentTest.log(LogStatus.PASS, "User edit data tipe invalid");

	}

	@Then("User tidak berhasil tambah dan edit data tipe")
	public void user_tidak_berhasil_tambah_dan_edit_data_tipe() {
		assertEquals(configurationProperties.getTextManageTipe(), manageTipePage.getTextManageTipe());
		extentTest.log(LogStatus.PASS, "User tidak berhasil tambah dan edit data tipe");
	}

}
