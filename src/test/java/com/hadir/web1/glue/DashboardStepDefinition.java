package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.DashboardPage;
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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class DashboardStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportDashboard.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		extentTest = reports.startTest("Testing View Dashboard Page");
	}

	@AfterStep
	public void getResult(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			String screenshotPath = Utils.getScreenshot(driver, scenario.getName().replace(" ", "_"));
			extentTest.log(LogStatus.FAIL, "FailedTestsScreenshot:/n" + extentTest.addScreenCapture(screenshotPath));
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

	@Given("User mengakses url web hadir")
	public void user_mengakses_url_web_hadir() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User login dan menampilkan dashboard")
	public void user_login_dan_menampilkan_dashboard() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		tunggu();
		extentTest.log(LogStatus.PASS, "User klik login button");

	}

	@And("User klik card staff")
	public void user_klik_card_staff() {
		dashboardPage.go_to_cardStaff();
		extentTest.log(LogStatus.PASS, "User klik card Staff");
	}

	@And("User klik card leader")
	public void user_klik_card_leader() {
		dashboardPage.go_to_cardLeader();
		extentTest.log(LogStatus.PASS, "User klik card leader");
	}

	@And("User klik card change request")
	public void user_klik_card_change_request() {
		dashboardPage.go_to_cardChanReq();
		extentTest.log(LogStatus.PASS, "User klik card change request");
	}

	@And("User klik card supervisior")
	public void user_klik_card_supervisor() {
		dashboardPage.go_to_cardSupervisor();
		extentTest.log(LogStatus.PASS, "User klik card supervisior");
	}

	@And("User klik card manager")
	public void user_klik_card_manager() {
		dashboardPage.go_to_cardManager();
		extentTest.log(LogStatus.PASS, "User klik card manager");
	}

	@And("User klik card head")
	public void user_klik_card_head() {
		dashboardPage.go_to_cardHead();
		extentTest.log(LogStatus.PASS, "User klik card head");
	}

	@And("User klik button See All")
	public void user_klik_button_see_all() {
		dashboardPage.go_to_btnSeeAll();
		extentTest.log(LogStatus.PASS, "User klik button See All");
	}

	@Then("User berhasil cek button in Dashboard")
	public void user_berhasil_cek_button_in_dashboard() {
		assertEquals(configurationProperties.getTextDashboard(), dashboardPage.getTextDashboard());
		extentTest.log(LogStatus.PASS, "User berhasil cek button in dashboard");

	}

	public static void tunggu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
