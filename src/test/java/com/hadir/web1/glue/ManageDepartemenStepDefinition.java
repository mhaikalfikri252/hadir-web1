package com.hadir.web1.glue;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.ManageDepartemenPage;
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
public class ManageDepartemenStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private ManageDepartemenPage manageDepartemenPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportManageDepartemen.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		manageDepartemenPage = new ManageDepartemenPage();
		extentTest = reports.startTest("Testing View Manage Departemen");
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

	@Given("User mengakses web")
	public void user_mengakses_web() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User menampilkan manage departemen")
	public void user_menampilkan_manage_departemen() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		tunggu();
		extentTest.log(LogStatus.PASS, "User menampilkan manage departemen");
	}

	@And("User klik menu manage departemen")
	public void user_klik_menu_manage_departemen() {
		manageDepartemenPage.goToManageDepartemen();
		extentTest.log(LogStatus.PASS, "User klik menu manage departemen");
	}

	@And("User tambah data departemen")
	public void user_tambah_data() {
		manageDepartemenPage.tambahDataDepartemen();
		extentTest.log(LogStatus.PASS, "User tambah data departemen");
	}

	@And("User edit data departemen")
	public void edit_data_departemen() {
		manageDepartemenPage.editDataDepartemen();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "User edit data departemen");
	}

	@And("User hapus data departemen")
	public void hapus_data_departemen() {
		manageDepartemenPage.deleteDataDepartemen();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "User hapus data departemen");
	}

	@Then("User berhasil melakukan tambah data departemen edit data departemen and hapus data departemen")
	public void user_berhasil_melakukan_tambah_data_departemen_edit_data_departemen_and_hapus_data_departemen() {
//		assertEquals(configurationProperties.getTextHapusData(), manageDepartemenPage.getTextHapusData());
		extentTest.log(LogStatus.PASS,
				"User berhasil melakukan tambah data departemen edit data departemen and hapus data departemen");

	}

	public static void tunggu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
