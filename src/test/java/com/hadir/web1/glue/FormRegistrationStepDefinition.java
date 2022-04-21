package com.hadir.web1.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.FormRegistrationPage;
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
public class FormRegistrationStepDefinition {

	
	private static WebDriver driver;
	private FormRegistrationPage formRegist;
	private LoginPage loginPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportFormRegistration.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		formRegist = new FormRegistrationPage();
		loginPage = new LoginPage();
		extentTest = reports.startTest("Testing Menu Form Registration");
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
	
	@Given("Admin akses url web hadir")
	public void admin_akses_url_web_hadir() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("Admin akses loginn")
	public void admin_akses_loginn() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Admin klik login button");

	}
	
	@When("User klik Form Registration")
	public void user_klik_form_registration() {
	    formRegist.goToFormRegist();
	    extentTest.log(LogStatus.PASS, "User klik Form Registration");
	}

	@Then("Tampil halaman Form Registration")
	public void tampil_halaman_form_registration() {
	   String expect = "Daftarin anggota karyawanmu disini!";
	   assertEquals(expect, formRegist.textHome());
	   extentTest.log(LogStatus.PASS, "Tampil halaman Form Registration");
	}

	@When("Masukkan form Registrasi")
	public void masukkan_valid_form() {
		formRegist.inputForm();
		extentTest.log(LogStatus.PASS, "Isi form registration");
	}

	@Then("Data berhasil di upload")
	public void data_berhasil_di_upload() {
		
		assertEquals(configurationProperties.getTextOk(), formRegist.TextSuccess());
		extentTest.log(LogStatus.PASS, "Data berhasil di upload");
	}

}