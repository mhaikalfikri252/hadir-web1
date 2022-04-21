package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.SelfRegistPage;
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

public class SelfRegistrationStepDefinition {

	private static WebDriver driver;
	private SelfRegistPage selfRegistPage;
	private LoginPage loginPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportSelfRegistration.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		selfRegistPage = new SelfRegistPage();
		loginPage = new LoginPage();
		extentTest = reports.startTest("Testing Menu Self Registration");
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

	@Given("User akses url web hadir")
	public void user_akses_url_web_hadir() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User melakukan login di web hadir")
	public void user_melakukan_login_di_web_hadir() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Admin klik login button");
	}

	@When("User klik Self Registration")
	public void user_klik_self_registration() {
		selfRegistPage.aksesSelfregist();
		extentTest.log(LogStatus.PASS, "User klik Self Registration");
	}

	@Then("Tampil halaman Self Registration")
	public void tampil_halaman_self_registration() {
		String expected = "Self registration request";
		assertEquals(expected, selfRegistPage.TextHome());
		extentTest.log(LogStatus.PASS, "Tampil halaman Self Registration");
	}

	@When("Klik edit data")
	public void klik_edit_data() {
		selfRegistPage.goToForm();
		extentTest.log(LogStatus.PASS, "Klik edit data");
	}

	@Then("Tampil halaman edit data")
	public void tampil_halaman_edit_data() {
		String expected = "USER INFORMATION";
		assertEquals(expected, selfRegistPage.TextEdit());
		extentTest.log(LogStatus.PASS, "Tampil halaman Self Registration");
	}

	@When("edit data staff")
	public void edit_data_staff() {
		selfRegistPage.editData();
	}

	@Then("Data berhasil Diedit")
	public void data_berhasil_diedit() {
		assertEquals(configurationProperties.getTextOk(), selfRegistPage.TextSubmit());
		extentTest.log(LogStatus.PASS, "Data berhasil Diedit");
	}

//	@When("Reject data karyawan")
//	public void reject_data_karyawan() {
//	   selfRegist.reject();
//	   extentTest.log(LogStatus.PASS,"Reject data karyawan"); 
//	}
//
//	@Then("Data berhasil di reject")
//	public void data_berhasil_di_reject() {
//		assertEquals(configurationProperties.getTextReject(), selfRegist.TextSubmit());
//	    extentTest.log(LogStatus.PASS,"Data berhasil di reject"); 
//	}

}
