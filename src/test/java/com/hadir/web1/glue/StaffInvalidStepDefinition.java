package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.StaffPage;
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
public class StaffInvalidStepDefinition {

	private static WebDriver driver;
	private StaffPage staffPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportStaffInvalid.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		staffPage = new StaffPage();
		extentTest = reports.startTest("Testing Menu Staff Invalid");
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
//		driver.quit();
	}

	@When("Admin Klik Halaman Staff")
	public void admin_klik_staff_page() {
		staffPage.goToStaffPageInvalid();
		extentTest.log(LogStatus.PASS, "Admin klik staff page");
	}

	@And("Admin search data staff invalid")
	public void admin_search_data_staff_invalid() {
		staffPage.searchInvalidStaff();
		extentTest.log(LogStatus.PASS, "Admin search data staff invalid");
	}

	@And("Admin edit data staff invalid")
	public void admin_edit_data_staff_invalid() {
		staffPage.invalidEditData();
		extentTest.log(LogStatus.PASS, "Admin edit data staff invalid");
	}

	@Then("Admin tidak berhasil tambah dan ubah data staff")
	public void admin_tidak_berhaisl_tambah_dan_ubah_data_staff() {
		assertEquals(configurationProperties.getTextInvalidFormStaff(), staffPage.TextInvalid());
		extentTest.log(LogStatus.PASS, "Admin tidak berhasil tambah dan ubah data staff");
	}

}