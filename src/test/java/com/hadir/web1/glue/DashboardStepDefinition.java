package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.DashboardPage;
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
	
	@Given("User akses url")
	public void admin_akses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User login dan menampilkan dashboard")
	public void admin_akses_login() {
		tunggu();
		extentTest.log(LogStatus.PASS, "User klik login button");

	}

	@And("User klik card staff")
	public void customer_klik_cardStaff() {
		dashboardPage.go_to_cardStaff();
		extentTest.log(LogStatus.PASS, "User klik card Staff");
	}
	
	@And("User klik card leader")
	public void customer_klik_cardLeader() {
		dashboardPage.go_to_cardLeader();
		extentTest.log(LogStatus.PASS, "User klik card leader");
	}
	
	@And("User klik card change request")
	public void customer_klik_chanReq() {
		dashboardPage.go_to_cardChanReq();
		extentTest.log(LogStatus.PASS, "User klik card change request");
	}
	
	@And("User klik card supervisior")
	public void customer_klik_cardSupervisior() {
		dashboardPage.go_to_cardSupervisor();
		extentTest.log(LogStatus.PASS, "User klik card supervisior");
	}
	
	@And("User klik card manager")
	public void customer_klik_cardManager() {
		dashboardPage.go_to_cardManager();
		extentTest.log(LogStatus.PASS, "User klik card manager");
	}
	
	@And("User klik card head")
	public void customer_klik_cardHead() {
		dashboardPage.go_to_cardHead();
		extentTest.log(LogStatus.PASS, "User klik card head");
	}

	@And("User klik button See All")
	public void customer_klik_seeAll() {
		dashboardPage.go_to_btnSeeAll();
		extentTest.log(LogStatus.PASS, "User klik button See All");
	}
	
	@Then("User berhasil cek button in Dashboard")
	public void user_succes_cek () {
		assertEquals(configurationProperties.getTextDashboard(), dashboardPage.getTextDashboard());
		extentTest.log(LogStatus.PASS, "Admin success go to view history staff page and edit data");

	}
	public static void tunggu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
