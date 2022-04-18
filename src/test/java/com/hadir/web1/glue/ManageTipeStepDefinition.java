package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.ManageTipePage;
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
public class ManageTipeStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private ManageTipePage manageTipePage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportManageTipe.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		manageTipePage = new ManageTipePage();
		extentTest = reports.startTest("Testing Halaman Manage Tipe");
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

	@Given("User mengakses web hadir")
	public void user_mengakses_web_hadir() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User akses login")
	public void user_akses_login() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User login ke halaman web");
	}

	@And("User klik manage tipe")
	public void user_klik_manage_tipe() {
		manageTipePage.goToManageTipe();
		extentTest.log(LogStatus.PASS, "User klik manage tipe");
	}

	@And("User tambah data tipe")
	public void user_tambah_data_tipe() {
		manageTipePage.addManageTipe();
		extentTest.log(LogStatus.PASS, "User add manage tipe");
	}

	@And("User edit data tipe")
	public void user_edit_data_tipe() {
		manageTipePage.editManageTipe();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "User edit manage tipe");

	}

	@And("User hapus data tipe")
	public void user_hapus_data_tipe() {
		manageTipePage.deleteManageTipe();
		extentTest.log(LogStatus.PASS, "User delete manage tipe");
	}

	@Then("User berhasil hapus data")
	public void user_berhasil_hapus_data() {
		assertEquals(configurationProperties.getTextHapusData(), manageTipePage.getTextSuccessDeleteData());
		extentTest.log(LogStatus.PASS, "User berhasil melakukan hapus data tipe");
	}

}
