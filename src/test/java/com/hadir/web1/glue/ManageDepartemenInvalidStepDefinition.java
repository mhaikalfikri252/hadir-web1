package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.ManageDepartemenPage;
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

public class ManageDepartemenInvalidStepDefinition {

	private static WebDriver driver;
	private ManageDepartemenPage manageDepartemenPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportManageDepartemenInvalid.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		manageDepartemenPage = new ManageDepartemenPage();
		extentTest = reports.startTest("Testing Halaman Manage Departemen Invalid");
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

	@When("User tambah data departemen invalid")
	public void user_tambah_data_departemen_invalid() {
		manageDepartemenPage.tambahDataDepartemenInvalid();
		extentTest.log(LogStatus.PASS, "User tambah data departemen invalid");
	}

	@And("User edit data departemen invalid")
	public void user_edit_data_departemen_invalid() {
		manageDepartemenPage.editDataDepartemenInvalid();
		extentTest.log(LogStatus.PASS, "User edit data departemen invalid");
	}

	@Then("User tidak berhasil tambah dan edit data departemen")
	public void user_tidak_berhasil_tambah_dan_edit_data_departemen() {
		assertEquals(configurationProperties.getTextManageDepartemen(), manageDepartemenPage.getTextManageDepartemen());
		extentTest.log(LogStatus.PASS, "User tidak berhasil tambah dan edit data tipe");
	}

}
