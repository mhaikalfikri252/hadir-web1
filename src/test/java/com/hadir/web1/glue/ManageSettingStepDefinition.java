package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.ManageSettingPage;
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
public class ManageSettingStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private ManageSettingPage manageSettingPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportManageSetting.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		manageSettingPage = new ManageSettingPage();
		extentTest = reports.startTest("Testing Halaman Manage Setting");
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

	@Given("User akses url web")
	public void user_akses_url_web() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User klik menu manage setting")
	public void user_klik_menu_manage_setting() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		tunggu();
		manageSettingPage.goToManageSetting();
		extentTest.log(LogStatus.PASS, "User klik menu manage setting");
	}

	@And("User klik ubah data")
	public void user_klik_ubah_data() {
		manageSettingPage.ubahData();
		extentTest.log(LogStatus.PASS, "User klik ubah data");
	}

	@And("User klik switch liveness")
	public void user_klik_switch_liveness() {
		manageSettingPage.changeLiveness();
		extentTest.log(LogStatus.PASS, "User klik switch liveness");
	}

	@Then("User success go to manage setting and edit data validation timer")
	public void user_success_go_to_manage_setting_and_edit_data_validation_timer() {
		try {
			assertEquals(configurationProperties.getTextUpdateData(), manageSettingPage.getTextSuccessManageSetting());
		} catch (Exception e) {
			e.printStackTrace();
		}
		extentTest.log(LogStatus.PASS, "User success go to manage setting and edit data validation timer");
	}

	public static void tunggu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
