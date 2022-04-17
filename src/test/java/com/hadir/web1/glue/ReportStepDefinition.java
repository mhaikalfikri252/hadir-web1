package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.RegisterPage;
import com.hadir.web1.pages.ReportPage;
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
public class ReportStepDefinition {
	
	private static WebDriver driver;
	private LoginPage loginPage;
	private ReportPage reportPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportingKaryawan.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		reportPage = new ReportPage();
		extentTest = reports.startTest("Testing halaman report");
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
	
	@Given("User mengakses halaman web")
	public void user_mengakses_halaman_web() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}
	
	@When("User login ke halaman website")
	public void user_login_ke_halaman_website() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User login ke halaman web");
	}
	
	@And("User klik menu report")
	public void user_klik_menu_report() {
	   reportPage.goToReportPage();
	   extentTest.log(LogStatus.PASS, "User klik menu report");
	}
	
	@And("User melakukan pencarian data")
	public void user_melakukan_pencarian_data() {
	   reportPage.searchDataReport();
	   extentTest.log(LogStatus.PASS, "User melakukan pencarian data karyawan");
	}
	
	
	@And("User melakukan export data")
	public void user_melakukan_export_data() {
	   reportPage.exportData();
	   extentTest.log(LogStatus.PASS, "User melakukan export data");
	}
	
	@Then("User berhasil melakukan export data")
	public void user_berhasil_melakukan_export_data() {
		assertEquals(configurationProperties.getTxtSuccessExport(), reportPage.getTextReportPage());
		extentTest.log(LogStatus.PASS, "User berhasil melakukan perubahan data");
	}
	

}
