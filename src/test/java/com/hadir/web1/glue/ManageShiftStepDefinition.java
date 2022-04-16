package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.ManageShift;
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
public class ManageShiftStepDefinition {
	
	private static WebDriver driver;
	private LoginPage loginPage;
	private ManageShift mngShift;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportShitManagemen.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		mngShift = new ManageShift();
		extentTest = reports.startTest("Testing Manage Shift Page");
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
	
	@Given("Akses url oleh admin")
	public void akses_url_oleh_admin() {
			driver = DriverSingleton.getDriver();
			driver.get(Constants.URL);
			extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}
	
	@When("Admin mengakses login")
	public void admin_akses_login() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Admin klik login button");
	}


	@When("Admin klik Manage Shift page")
	public void admin_klik_manage_shift_page() {
	   mngShift.go_to_mng_shift();
	   extentTest.log(LogStatus.PASS, "Admin add shift time");
	}
	
	@When("Admin add shift time")
	public void admin_add_shift_time() {
	  mngShift.addShift();
	  extentTest.log(LogStatus.PASS, "Admin klik Manage Shift page");
	}
	
	@When("Admin Search By Shift Code")
	public void admin_search_by_shift_code() {
	    mngShift.searchBy();
	    extentTest.log(LogStatus.PASS, "Admin Search By Shift Code");
	}
		

	@When("Admin edit shift time")
	public void admin_edit_shift_time() {
	    mngShift.editDataShift();
		extentTest.log(LogStatus.PASS, "Admin edit shift time");

	}

	
	@Then("Admin success go to add shift page and edit data")
	public void admin_success_go_to_add_shift_page_and_edit_data() {
		assertEquals(configurationProperties.getTxtShiftPage(), mngShift.get_Txt_Shift_Page());
		extentTest.log(LogStatus.PASS, "Admin success go to add shift page and edit data");

	}


}
