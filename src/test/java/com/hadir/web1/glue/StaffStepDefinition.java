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
	public void admin_klik_staff_page() {
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
		extentTest.log(LogStatus.PASS,"Admin search data by name");
	}

	@Then("Tampil data berdasarkan name")
	public void tampil_data_berdasarkan_name() {
		String expected = "Meinida Cindy";
	    assertEquals(expected, staffPage.TextValidName());
	    extentTest.log(LogStatus.PASS,"Tampil data berdasarkan name");
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

	@When("Admin search data by divisi")
	public void admin_search_data_by_divisi() {
	    staffPage.searchByDivisi();
	    extentTest.log(LogStatus.PASS,"Admin search data by divisi");
	}

	@Then("Tampil data berdasarkan divisi")
	public void tampil_data_berdasarkan_divisi() {
		String expected = "Edit data";
	    assertEquals(expected, staffPage.TextValidDivisi());
	    extentTest.log(LogStatus.PASS,"Tampil data berdasarkan divisi");
	}

	@When("Admin search data by invalid divisi")
	public void admin_search_data_by_invalid_divisi() {
		staffPage.searchByInvalidDivisi();
		extentTest.log(LogStatus.PASS,"Admin search data by invalid divisi");
	}

	@Then("Tampil error data divisi tidak ditemukan")
	public void tampil_error_data_divisi_tidak_ditemukan() {
		String expected = "No staff found";
	    assertEquals(expected, staffPage.textSearchInvalid());
	    extentTest.log(LogStatus.PASS,"Tampil error data divisi tidak ditemukan");
	}
	
	
	@When("Admin klik view history staff")
	public void admin_akses_view_hostory_staff() {
		staffPage.btnViewHistory();
		extentTest.log(LogStatus.PASS,"Admin klik view history staff");
	}

	@Then("Tampil halaman History Staff")
	public void tampil_halaman_history_staff() {
		String expected = "Reporting";
	    assertEquals(expected, staffPage.textHistoryPage());
	    extentTest.log(LogStatus.PASS,"Tampil halaman History Staff");
	}
	
   @When("Admin eksport data history staff")
   public void admin_import_data_history_staff() {
	   staffPage.historyStaffPage();
	   extentTest.log(LogStatus.PASS,"Admin eksport data history staff");
   }

	@When("Admin edit data staff")
	public void admin_klik_edit_data_staff() {
		staffPage.editDataStaff();
		staffPage.formEditDataStaff();
		extentTest.log(LogStatus.PASS, "Admin edit data staff");
	}

	@Then("Admin success go to view history staff page and edit data")
	public void admin_success_go_to_view_history_staff_page_and_edit_data() {
		assertEquals(configurationProperties.getTextOk(), staffPage.getTextStaffPage());
		extentTest.log(LogStatus.PASS, "Admin success go to view history staff page and edit data");

	}
}
