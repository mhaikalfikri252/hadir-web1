package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.StaffPage;
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
public class StaffStepDefinition {

	private static WebDriver driver;
	private StaffPage staffPage;
	private LoginPage loginPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportStaff.html");
	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		staffPage = new StaffPage();
		loginPage = new LoginPage();
		extentTest = reports.startTest("Testing View History Staff Page");
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

	@Given("Admin akses url")
	public void admin_akses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("Admin akses login")
	public void admin_akses_login() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Admin klik login button");

	}

	@And("Admin klik staff page")
	public void customer_klik_staff_page() {
		staffPage.go_to_staff_page();
		extentTest.log(LogStatus.PASS, "Admin klik staff page");
	}

	@And("Admin klik view history staff")
	public void admin_klik_view_history_staff() {
		staffPage.historyStaffPage();
		extentTest.log(LogStatus.PASS, "Admin klik view history staff");
	}

	@And("Admin klik edit data staff")
	public void admin_klik_edit_data_staff() {
		staffPage.go_to_staff_page();
		staffPage.edit_data_staff();
		staffPage.form_edit_staff();
		extentTest.log(LogStatus.PASS, "Admin klik edit data staff");
	}

	@Then("Admin success go to view history staff page and edit data")
	public void admin_success_go_to_view_history_staff_page_and_edit_data() {
		assertEquals(configurationProperties.getTxtEditPage(), staffPage.get_Txt_Staff_page());
		extentTest.log(LogStatus.PASS, "Admin success go to view history staff page and edit data");

	}
}
