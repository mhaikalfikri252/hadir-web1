package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.ManageLevelPage;
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

public class ManageLevelStepDefination {

	private static WebDriver driver;
	private LoginPage loginPage;
	private ManageLevelPage manageLevel;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportManageLevel.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		manageLevel = new ManageLevelPage();
		extentTest = reports.startTest("Testing Halaman Manage Level");
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

	@Given("User masuk situs hadir Web 1")
	public void user_masuk_situs_hadir() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("Admin login ke halaman web1")
	public void admin_login_ke_halaman_web() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Admin login ke halaman web1");
	}

	@And("Admin klik menu manage level")
	public void admin_klik_menu_manage_level() {
		manageLevel.goToManageLevel();
		extentTest.log(LogStatus.PASS, "Admin klik menu manage level");
	}

	@And("Admin klik tambah level")
	public void admin_klik_tambah_level() {
		manageLevel.tambahLevel();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "Admin klik tambah level");
	}

	@And("Admin klik ubah level")
	public void admin_klik_ubah_posisi() {
		manageLevel.ubahLevel();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "Admin klik ubah level");

	}

	@And("Admin klik hapus level")
	public void admin_klik_hapus_posisi() {
		driver.navigate().refresh();
		manageLevel.hapusLevel();
		extentTest.log(LogStatus.PASS, "Admin klik hapus level");
	}

	@Then("Admin success go to tambah level and ubah level and hapus level")
	public void admin_success_go_to_tambah_level_and_ubah_level_and_hapus_level() {
		assertEquals(configurationProperties.getTextHapusData(), manageLevel.getTextHapusLevel());
		extentTest.log(LogStatus.PASS, "Admin success go to tambah level and ubah level and hapus level");
	}
}
