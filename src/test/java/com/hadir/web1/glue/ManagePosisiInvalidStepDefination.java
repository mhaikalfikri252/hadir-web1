package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.ManagePosisiPage;
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
public class ManagePosisiInvalidStepDefination {

	private static WebDriver driver;
	private ManagePosisiPage managePosisiPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportManageLevelInvalid.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		managePosisiPage = new ManagePosisiPage();
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

	@When("Admin tambah data posisi invalid")
	public void user_tambah_data_posisi_invalid() {
		managePosisiPage.tambahDataPosisiInvalid();
		extentTest.log(LogStatus.PASS, "User tambah data posisi invalid");
	}

	@And("Admin ubah data posisi invalid")
	public void user_edit_data_posisi_invalid() {
		managePosisiPage.ubahDataPosisiInvalid();
		extentTest.log(LogStatus.PASS, "User edit data posisi invalid");
	}

	@Then("Admin tidak berhasil tambah dan ubah data posisi")
	public void admin_tidak_berhasil_tambah_dan_hapus_data_posisi() {
		assertEquals(configurationProperties.getTextHapusData(), managePosisiPage.getTextUbahPosisi());
		extentTest.log(LogStatus.PASS, "admin tidak berhasil tambah dan ubah data posisi");
	}

}
