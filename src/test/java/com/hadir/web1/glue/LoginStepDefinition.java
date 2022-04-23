package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class LoginStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportLogin.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		extentTest = reports.startTest("Testing User Login");
//		LoginTestCases[] tests = LoginTestCases.values();
//		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
//		Utils.testCount++;
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

	@Given("User mengakses url")
	public void user_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User klik login button")
	public void user_klik_login_button() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User klik login button");
	}

	@Then("User berhasil login")
	public void user_berhasil_login() {
		tunggu();
		assertEquals(configurationProperties.getTextDashboard(), loginPage.getTextDashboard());
		extentTest.log(LogStatus.PASS, "User berhasil login");
	}

	public static void tunggu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scroll() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
	}

}
