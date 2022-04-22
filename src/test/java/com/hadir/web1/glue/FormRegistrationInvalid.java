package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.FormRegistrationPage;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.utils.ConfigurationProperties;
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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class FormRegistrationInvalid {
	
	private static WebDriver driver;
	private FormRegistrationPage formRegistration;
	private LoginPage loginPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportStaffInvalid.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		formRegistration = new FormRegistrationPage();
		loginPage = new LoginPage();
		extentTest = reports.startTest("Testing Menu Staff Invalid");
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

	@When("Admin Klik Halaman Form Registration")
	public void admin_klik_staff_page() {
		formRegistration.goToFormRegistrationInvalid();
		extentTest.log(LogStatus.PASS, "Admin klik staff page");
	}
	
	@And("Admin edit data invalid form registration")
	public void admin_search_data_staff_invalid() {
		formRegistration.invalidFoto();
		
	}
	
	
	@Then("Admin tidak berhasil menambah data")
	public void admin_tidak_berhaisl_tambah_dan_ubah_data_staff() {
		assertEquals(configurationProperties.getTextInvalidFormRegistration(), formRegistration.textInvalidFoto());
		
	}

}