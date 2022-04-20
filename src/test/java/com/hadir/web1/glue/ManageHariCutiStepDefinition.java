package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.ManageHariCutiPage;
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
public class ManageHariCutiStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private ManageHariCutiPage manageHariCutiPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportManageHariCuti.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		manageHariCutiPage = new ManageHariCutiPage();
		extentTest = reports.startTest("Testing Halaman Manage Hari Cuti");
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

	@Given("User mengakses web hadir1")
	public void user_mengakses_web_hadir1() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User akses login web")
	public void user_akses_login_web() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User login ke halaman web");
	}

	@And("User klik manage hari cuti")
	public void user_klik_manage_hari_cuti() {
		manageHariCutiPage.goToManageHariCuti();
		extentTest.log(LogStatus.PASS, "User klik manage hari cuti");
	}

	@And("User tambah data hari cuti")
	public void user_tambah_data_hari_cuti() {
		manageHariCutiPage.addDataHariCuti();
		extentTest.log(LogStatus.PASS, "User tambah data hari cuti");
	}

	@And("User edit data hari cuti")
	public void user_edit_data_hari_cuti() {
		manageHariCutiPage.editDataHariCuti();
		extentTest.log(LogStatus.PASS, "User edit data hari cuti");

	}

	@And("User hapus data hari cuti")
	public void user_hapus_data_hari_cuti() {
		driver.navigate().refresh();
		manageHariCutiPage.deleteDataHariCuti();
		extentTest.log(LogStatus.PASS, "User hapus data hari cuti");
	}

	@Then("User berhasil hapus data hari cuti")
	public void user_berhasil_hapus_data_hari_cuti() {
		assertEquals(configurationProperties.getTextHapusData(), manageHariCutiPage.getTextSuccessDeleteData());
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "User berhasil melakukan hapus data hari cuti");
	}

}
