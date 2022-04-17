package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.RegisterPage;
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
public class RegisterStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportRegister.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		registerPage = new RegisterPage();
		extentTest = reports.startTest("Testing halaman register");
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

	@Given("User mengakses url web")
	public void user_mengakses_url_web() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User login ke halaman web")
	public void user_login_ke_halaman_web() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User login ke halaman web");
	}

	@And("User klik menu register")
	public void user_klik_menu_register() {
		registerPage.goToRegisterPage();
		extentTest.log(LogStatus.PASS, "User klik menu register");
	}

	@And("User melakukan pencarian data karyawan")
	public void user_melakukan_pencarian_data_karyawan() {
		registerPage.searchDataKaryawan();
		extentTest.log(LogStatus.PASS, "User melakukan pencarian data karyawan");
	}

	@And("User melakukan perubahan data")
	public void user_melakukan_perubahan_data() {
		registerPage.editDataKaryawan();
		extentTest.log(LogStatus.PASS, "User melakukan perubahan data");
	}

	@Then("User berhasil melakukan perubahan data")
	public void user_berhasil_melakukan_perubahan_data() {
		assertEquals(configurationProperties.getTxtRegisterPage(), registerPage.getTextRegisterPage());
		extentTest.log(LogStatus.PASS, "User berhasil melakukan perubahan data");

	}
}
