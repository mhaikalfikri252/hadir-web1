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

	@When("Admin klik staff page")
	public void customer_klik_staff_page() {
		staffPage.goToStaffPage();
		extentTest.log(LogStatus.PASS, "Admin klik staff page");
	}
	
	@When("Admin search data by NIK")
	public void admin_search_data_by_nik() {
	    staffPage.searchByNik();
	    extentTest.log(LogStatus.PASS,"Admin search data by NIK");
	}
	
	@Then("Tampil data berdasarkan NIK")
	public void tampil_data_berdasarkan_nik() {
		String expected = "D6180259";
	    assertEquals(expected, staffPage.TextValidNik());
	    extentTest.log(LogStatus.PASS,"Tampil data berdasarkan NIK");
	}

	@When("Admin search data by invalid NIK")
	public void admin_search_data_by_ivalid_nik() {
		staffPage.searchByInvalidNik();
		 extentTest.log(LogStatus.PASS,"Admin search data by invalid NIK");
	}

	@Then("Tampil error data NIK tidak ditemukan")
	public void tampil_error_data_tidak_ditemukan() {
		String expected = "No staff found";
	    assertEquals(expected, staffPage.textSearchInvalid());
	    extentTest.log(LogStatus.PASS,"Tampil error data NIK tidak ditemukan");
	}
	
	@When("Admin search data by name")
	public void admin_search_data_by_name() {
		staffPage.searchByName();
	}

	@Then("Tampil data berdasarkan name")
	public void tampil_data_berdasarkan_name() {
		String expected = "Meinida Cindy";
	    assertEquals(expected, staffPage.TextValidName());
	    extentTest.log(LogStatus.PASS,"Tampil error data NIK tidak ditemukan");
	}

	@When("Admin search data by invalid name")
	public void admin_search_data_by_invalid_name() {
	    staffPage.searchByInvalidName();
	    extentTest.log(LogStatus.PASS,"Admin search data by invalid name");
	}

	@Then("Tampil error data name tidak ditemukan")
	public void tampil_error_data_name_tidak_ditemukan() {
		String expected = "No staff found";
	    assertEquals(expected, staffPage.textSearchInvalid());
	    extentTest.log(LogStatus.PASS,"Tampil error data name tidak ditemukan");
	}

	@When("Admin search data by leader")
	public void admin_search_data_by_leader() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Tampil data berdasarkan leader")
	public void tampil_data_berdasarkan_leader() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin search data by invalid leader")
	public void admin_search_data_by_invalid_leader() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Tampil error data leader tidak ditemukan")
	public void tampil_error_data_leader_tidak_ditemukan() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin search data by divisi")
	public void admin_search_data_by_divisi() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Tampil data berdasarkan divisi")
	public void tampil_data_berdasarkan_divisi() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin search data by invalid divisi")
	public void admin_search_data_by_invalid_divisi() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Tampil error data divisi tidak ditemukan")
	public void tampil_error_data_divisi_tidak_ditemukan() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Tampil halaman History Staff")
	public void tampil_halaman_history_staff() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	

	@When("Admin klik view history staff")
	public void admin_klik_view_history_staff() {
		staffPage.historyStaffPage();
		extentTest.log(LogStatus.PASS, "Admin klik view history staff");
	}

	@When("Admin klik edit data staff")
	public void admin_klik_edit_data_staff() {
		staffPage.goToStaffPage();
		staffPage.editDataStaff();
		staffPage.formEditDataStaff();
		extentTest.log(LogStatus.PASS, "Admin klik edit data staff");
	}

	@Then("Admin success go to view history staff page and edit data")
	public void admin_success_go_to_view_history_staff_page_and_edit_data() {
		assertEquals("OK", staffPage.getTextStaffPage());
		extentTest.log(LogStatus.PASS, "Admin success go to view history staff page and edit data");

	}
}
