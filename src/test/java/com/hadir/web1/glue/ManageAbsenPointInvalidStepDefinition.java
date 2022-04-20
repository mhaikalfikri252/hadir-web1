package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.ManageAbsenPointPage;
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
public class ManageAbsenPointInvalidStepDefinition {

	private static WebDriver driver;
	private ManageAbsenPointPage manageAbsenPointPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportManageAbsenPointInvalid.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		manageAbsenPointPage = new ManageAbsenPointPage();
		extentTest = reports.startTest("Testing Halaman Manage Absen Point Invalid");
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

	@When("User tambah data absen point invalid")
	public void user_tambah_data_absen_point_invalid() {
		manageAbsenPointPage.addDataAbsenPointInvalid();
		extentTest.log(LogStatus.PASS, "User tambah data absen point invalid");
	}

	@And("User edit data absen point invalid")
	public void user_edit_data_absen_point_invalid() {
		manageAbsenPointPage.editDataAbsenPointInvalid();
		extentTest.log(LogStatus.PASS, "User edit data absen point invalid");

	}

	@Then("User tidak berhasil tambah dan edit data absen point")
	public void user_tidak_berhasil_tambah_dan_edit_data_absen_point() {
		assertEquals(configurationProperties.getTextManageAbsenPoint(), manageAbsenPointPage.getTextManageAbsenPoint());
		extentTest.log(LogStatus.PASS, "User tidak berhasil tambah dan edit data absen point");
	}

}
