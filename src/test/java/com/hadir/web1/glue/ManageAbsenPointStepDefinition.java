package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.ManageAbsenPointPage;
import com.hadir.web1.utils.ConfigurationProperties;
import com.hadir.web1.utils.Constants;
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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class ManageAbsenPointStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private ManageAbsenPointPage manageAbsenPointPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportManageAbsenPoint.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		manageAbsenPointPage = new ManageAbsenPointPage();
		extentTest = reports.startTest("Testing Halaman Manage Absen Point");
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

	@Given("User mengakses link web hadir")
	public void user_mengakses_web_hadir() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User akses login link web")
	public void user_akses_login() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User login ke halaman web");
	}

	@And("User klik manage absen point")
	public void user_klik_manage_absen_point() {
		manageAbsenPointPage.goToManageAbsenPoint();
		extentTest.log(LogStatus.PASS, "User klik manage absen point");
	}

	@And("User tambah data absen point")
	public void user_tambah_data_absen_point() {
		manageAbsenPointPage.addDataAbsenPoint();
		extentTest.log(LogStatus.PASS, "User add manage absen point");
	}

	@And("User edit data absen point")
	public void user_edit_data_absen_point() {
		manageAbsenPointPage.editDataAbsenPoint();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "User edit manage absen point");

	}

	@And("User search data absen point")
	public void user_search_data_absen_point() {
		manageAbsenPointPage.searchDataAbsenPoint();
		extentTest.log(LogStatus.PASS, "User search data absen point");
	}

	@And("User hapus data absen point")
	public void user_hapus_data_absen_point() {
		manageAbsenPointPage.deleteDataAbsenPoint();
		extentTest.log(LogStatus.PASS, "User delete manage tipe");
	}

	@Then("User berhasil hapus data absen point")
	public void user_berhasil_hapus_data() {
		assertEquals(configurationProperties.getTextHapusAbsenPoint(), manageAbsenPointPage.getTextSuccessDeleteData());
		extentTest.log(LogStatus.PASS, "User berhasil melakukan hapus data absen point");
	}

}
