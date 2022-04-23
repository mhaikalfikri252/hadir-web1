package com.hadir.web1.glue.all;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web1.config.AutomationFrameworkConfig;
import com.hadir.web1.drivers.DriverSingleton;
import com.hadir.web1.pages.DashboardPage;
import com.hadir.web1.pages.FormRegistrationPage;
import com.hadir.web1.pages.LoginPage;
import com.hadir.web1.pages.ManageAbsenPointPage;
import com.hadir.web1.pages.ManageDepartemenPage;
import com.hadir.web1.pages.ManageHariCutiPage;
import com.hadir.web1.pages.ManageLevelPage;
import com.hadir.web1.pages.ManagePosisiPage;
import com.hadir.web1.pages.ManageSettingPage;
import com.hadir.web1.pages.ManageTipePage;
import com.hadir.web1.pages.RegisterPage;
import com.hadir.web1.pages.ReportPage;
import com.hadir.web1.pages.SelfRegistrationPage;
import com.hadir.web1.pages.StaffPage;
import com.hadir.web1.utils.ConfigurationProperties;
import com.hadir.web1.utils.Constants;
import com.hadir.web1.utils.TestCases;
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
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class AllStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private FormRegistrationPage formRegistrationPage;
	private StaffPage staffPage;
	private RegisterPage registerPage;
	private ReportPage reportPage;
	private SelfRegistrationPage selfRegistrationPage;
	private ManageTipePage manageTipePage;
	private ManageHariCutiPage manageHariCutiPage;
	private ManageAbsenPointPage manageAbsenPointPage;
	private ManagePosisiPage managePosisiPage;
	private ManageLevelPage manageLevelPage;
	private ManageSettingPage manageSettingPage;
	private ManageDepartemenPage manageDepartemenPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportHadir.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		formRegistrationPage = new FormRegistrationPage();
		staffPage = new StaffPage();
		registerPage = new RegisterPage();
		reportPage = new ReportPage();
		selfRegistrationPage = new SelfRegistrationPage();
		manageTipePage = new ManageTipePage();
		manageHariCutiPage = new ManageHariCutiPage();
		manageAbsenPointPage = new ManageAbsenPointPage();
		managePosisiPage = new ManagePosisiPage();
		manageLevelPage = new ManageLevelPage();
		manageSettingPage = new ManageSettingPage();
		manageDepartemenPage = new ManageDepartemenPage();
		TestCases[] tests = TestCases.values();
		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
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

	// Login

	@Given("User mengakses url")
	public void user_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("User klik login button")
	public void user_klik_login_button() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User klik login button");
	}

	@Then("User berhasil login")
	public void user_berhasil_login() {
		tunggu();
		assertEquals(configurationProperties.getTextDashboard(), loginPage.getTextDashboard());
		extentTest.log(LogStatus.PASS, "User berhasil login");
	}

	// Dashboard

	@When("User klik card staff")
	public void user_klik_card_staff() {
		dashboardPage.goToCardStaff();
		extentTest.log(LogStatus.PASS, "User klik card Staff");
	}

	@And("User klik card leader")
	public void user_klik_card_leader() {
		dashboardPage.goToCardLeader();
		extentTest.log(LogStatus.PASS, "User klik card leader");
	}

	@And("User klik card change request")
	public void user_klik_card_change_request() {
		dashboardPage.goToCardChangeRequest();
		extentTest.log(LogStatus.PASS, "User klik card change request");
	}

	@And("User klik card supervisior")
	public void user_klik_card_supervisor() {
		dashboardPage.goToCardSupervisor();
		extentTest.log(LogStatus.PASS, "User klik card supervisior");
	}

	@And("User klik card manager")
	public void user_klik_card_manager() {
		dashboardPage.goToCardManager();
		extentTest.log(LogStatus.PASS, "User klik card manager");
	}

	@And("User klik card head")
	public void user_klik_card_head() {
		dashboardPage.goToCardHead();
		extentTest.log(LogStatus.PASS, "User klik card head");
	}

	@And("User klik button See All")
	public void user_klik_button_see_all() {
		dashboardPage.goToBtnSeeAll();
		extentTest.log(LogStatus.PASS, "User klik button See All");
	}

	@Then("User berhasil cek button in Dashboard")
	public void user_berhasil_cek_button_in_dashboard() {
		assertEquals(configurationProperties.getTextDashboard(), dashboardPage.getTextDashboard());
		extentTest.log(LogStatus.PASS, "User berhasil cek button in dashboard");

	}

	// Form Registration

	@When("User klik Form Registration")
	public void user_klik_form_registration() {
		formRegistrationPage.goToFormRegistration();
		extentTest.log(LogStatus.PASS, "User klik Form Registration");
	}

	@Then("Tampil halaman Form Registration")
	public void tampil_halaman_form_registration() {
		String expect = "Daftarin anggota karyawanmu disini!";
		assertEquals(expect, formRegistrationPage.getTextHome());
		extentTest.log(LogStatus.PASS, "Tampil halaman Form Registration");
	}

	@And("Masukkan form Registrasi")
	public void masukkan_valid_form() {
		formRegistrationPage.inputForm();
		extentTest.log(LogStatus.PASS, "Isi form registration");
	}

	@Then("Data berhasil di upload")
	public void data_berhasil_di_upload() {
		assertEquals(configurationProperties.getTextOk(), formRegistrationPage.getTextSuccess());
		extentTest.log(LogStatus.PASS, "Data berhasil di upload");
	}

	// Form Registration Invalid

	@When("Admin Klik Halaman Form Registration")
	public void admin_klik_form_registration_page() {
		formRegistrationPage.goToFormRegistrationInvalid();
		extentTest.log(LogStatus.PASS, "Admin klik staff page");
	}

	@And("Admin edit data invalid form registration")
	public void admin_edit_data_invalid_form_registration() {
		formRegistrationPage.invalidFoto();
	}

	@Then("Admin tidak berhasil menambah data")
	public void admin_tidak_berhaisl_tambah_dan_ubah_data_staff() {
		assertEquals(configurationProperties.getTextInvalidFormRegistration(), formRegistrationPage.textInvalidFoto());
	}

	// Staff

	@When("Admin klik staff page")
	public void customer_klik_staff_page() {
		staffPage.goToStaffPage();
		extentTest.log(LogStatus.PASS, "Admin klik staff page");
	}

	@And("Admin klik view history staff")
	public void admin_klik_view_history_staff() {
		staffPage.historyStaffPage();
		extentTest.log(LogStatus.PASS, "Admin klik view history staff");
	}

	@And("Admin klik edit data staff")
	public void admin_klik_edit_data_staff() {
		staffPage.goToStaffPage();
		staffPage.editDataStaff();
		staffPage.formEditStaff();
		extentTest.log(LogStatus.PASS, "Admin klik edit data staff");
	}

	@Then("Admin success go to view history staff page and edit data")
	public void admin_success_go_to_view_history_staff_page_and_edit_data() {
		assertEquals(configurationProperties.getTextOk(), staffPage.getTextStaffPage());
		extentTest.log(LogStatus.PASS, "Admin success go to view history staff page and edit data");
	}

	// Staff Invalid

	@When("Admin Klik Halaman Staff")
	public void admin_klik_staff_page() {
		staffPage.goToStaffPageInvalid();
		extentTest.log(LogStatus.PASS, "Admin klik staff page");
	}

	@And("Admin search data staff invalid")
	public void admin_search_data_staff_invalid() {
		staffPage.searchInvalidStaff();
		extentTest.log(LogStatus.PASS, "Admin search data staff invalid");
	}

	@And("Admin edit data staff invalid")
	public void admin_edit_data_staff_invalid() {
		staffPage.invalidEditData();
		extentTest.log(LogStatus.PASS, "Admin edit data staff invalid");
	}

	@Then("Admin tidak berhasil tambah dan ubah data staff")
	public void admin_tidak_berhasil_tambah_dan_ubah_data_staff() {
		assertEquals(configurationProperties.getTextInvalidFormStaff(), staffPage.getTextInvalid());
		extentTest.log(LogStatus.PASS, "Admin tidak berhasil tambah dan ubah data staff");
	}

	// Register

	@When("User klik menu register")
	public void user_klik_menu_register() {
		registerPage.goToRegisterPage();
		extentTest.log(LogStatus.PASS, "User klik menu register");
	}

	@And("User melakukan pencarian data karyawan")
	public void user_melakukan_pencarian_data_karyawan() {
		registerPage.searchDataKaryawan();
		extentTest.log(LogStatus.PASS, "User melakukan pencarian data karyawan");
	}

	@And("User melakukan perubahan data")
	public void user_melakukan_perubahan_data() {
		registerPage.editDataKaryawan();
		extentTest.log(LogStatus.PASS, "User melakukan perubahan data");
	}

	@Then("User berhasil melakukan perubahan data")
	public void user_berhasil_melakukan_perubahan_data() {
		assertEquals(configurationProperties.getTextUpdateData(), registerPage.getTextRegisterPage());
		extentTest.log(LogStatus.PASS, "User berhasil melakukan perubahan data");
	}

	// Reporting Karyawan

	@When("User klik menu report")
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
		assertEquals(configurationProperties.getTextReportingKaryawan(), reportPage.getTextReportingKaryawan());
		extentTest.log(LogStatus.PASS, "User berhasil melakukan perubahan data");
	}

	// Self Registration

	@When("User klik Self Registration")
	public void user_klik_self_registration() {
		try {
			selfRegistrationPage.goToSelfRegistration();
		} catch (Exception e) {
			e.printStackTrace();
		}
		extentTest.log(LogStatus.PASS, "User klik Self Registration");
	}

	@And("Klik edit data")
	public void klik_edit_data() {
		try {
			selfRegistrationPage.goToForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
		extentTest.log(LogStatus.PASS, "Klik edit data");
	}

	@And("edit data staff")
	public void edit_data_staff() {
		try {
			selfRegistrationPage.editData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Data berhasil Diedit")
	public void data_berhasil_diedit() {
		try {
			assertEquals(configurationProperties.getTextOk(), selfRegistrationPage.getTextSubmit());
		} catch (Exception e) {
			e.printStackTrace();
		}
		extentTest.log(LogStatus.PASS, "Data berhasil Diedit");
	}

	// Manage Tipe

	@When("User klik manage tipe")
	public void user_klik_manage_tipe() {
		manageTipePage.goToManageTipe();
		extentTest.log(LogStatus.PASS, "User klik manage tipe");
	}

	@And("User tambah data tipe")
	public void user_tambah_data_tipe() {
		manageTipePage.addDataTipe();
		extentTest.log(LogStatus.PASS, "User add manage tipe");
	}

	@And("User edit data tipe")
	public void user_edit_data_tipe() {
		manageTipePage.editDataTipe();
		extentTest.log(LogStatus.PASS, "User edit manage tipe");
	}

	@And("User search data tipe")
	public void user_search_data_tipe() {
		manageTipePage.searchDataTipe();
		extentTest.log(LogStatus.PASS, "User search data tipe");
	}

	@And("User hapus data tipe")
	public void user_hapus_data_tipe() {
		manageTipePage.deleteDataTipe();
		extentTest.log(LogStatus.PASS, "User delete manage tipe");
	}

	@Then("User berhasil hapus data tipe")
	public void user_berhasil_hapus_data_tipe() {
		assertEquals(configurationProperties.getTextHapusData(), manageTipePage.getTextSuccessDeleteData());
		extentTest.log(LogStatus.PASS, "User berhasil melakukan hapus data tipe");
	}

	// Manage Tipe Invalid

	@When("User tambah data tipe invalid")
	public void user_tambah_data_tipe_invalid() {
		manageTipePage.addDataTipeInvalid();
		extentTest.log(LogStatus.PASS, "User tambah data tipe invalid");
	}

	@And("User edit data tipe invalid")
	public void user_edit_data_tipe_invalid() {
		manageTipePage.editDataTipeInvalid();
		extentTest.log(LogStatus.PASS, "User edit data tipe invalid");
	}

	@Then("User tidak berhasil tambah dan edit data tipe")
	public void user_tidak_berhasil_tambah_dan_edit_data_tipe() {
		assertEquals(configurationProperties.getTextManageTipe(), manageTipePage.getTextManageTipe());
		extentTest.log(LogStatus.PASS, "User tidak berhasil tambah dan edit data tipe");
	}

	// Manage Hari Cuti

	@When("User klik manage hari cuti")
	public void user_klik_manage_hari_cuti() {
		manageHariCutiPage.goToManageHariCuti();
		extentTest.log(LogStatus.PASS, "User klik manage hari cuti");
	}

	@And("User tambah data hari cuti")
	public void user_tambah_data_hari_cuti() {
		manageHariCutiPage.addDataHariCuti();
		extentTest.log(LogStatus.PASS, "User tambah data hari cuti");
	}

	@And("User edit data hari cuti")
	public void user_edit_data_hari_cuti() {
		manageHariCutiPage.editDataHariCuti();
		extentTest.log(LogStatus.PASS, "User edit data hari cuti");
	}

	@And("User search data hari cuti")
	public void user_search_data_hari_cuti() {
		manageHariCutiPage.searchDataHariCuti();
		extentTest.log(LogStatus.PASS, "User search data hari cuti");
	}

	@And("User hapus data hari cuti")
	public void user_hapus_data_hari_cuti() {
		driver.navigate().refresh();
		manageHariCutiPage.deleteDataHariCuti();
		extentTest.log(LogStatus.PASS, "User hapus data hari cuti");
	}

	@Then("User berhasil hapus data hari cuti")
	public void user_berhasil_hapus_data_hari_cuti() {
		assertEquals(configurationProperties.getTextHapusData(), manageHariCutiPage.getTextSuccessDeleteData());
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "User berhasil melakukan hapus data hari cuti");
	}

	// Manage Hari Cuti Invalid

	@When("User tambah data hari cuti invalid")
	public void user_tambah_data_hari_cuti_invalid() {
		manageHariCutiPage.addDataHariCutiInvalid();
		extentTest.log(LogStatus.PASS, "User tambah data hari cuti invalid");
	}

	@Then("User tidak berhasil tambah data hari cuti")
	public void user_tidak_berhasil_tambah_data_hari_cuti() {
		assertEquals(configurationProperties.getTextReject(), manageHariCutiPage.getTextFailedAddData());
		extentTest.log(LogStatus.PASS, "User tidak berhasil tambah data hari cuti");
	}

	// Manage Absen Point

	@When("User klik manage absen point")
	public void user_klik_manage_absen_point() {
		manageAbsenPointPage.goToManageAbsenPoint();
		extentTest.log(LogStatus.PASS, "User klik manage absen point");
	}

	@And("User tambah data absen point")
	public void user_tambah_data_absen_point() {
		manageAbsenPointPage.addDataAbsenPoint();
		extentTest.log(LogStatus.PASS, "User add manage absen point");
	}

	@And("User edit data absen point")
	public void user_edit_data_absen_point() {
		manageAbsenPointPage.editDataAbsenPoint();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "User edit manage absen point");
	}

	@And("User search data absen point")
	public void user_search_data_absen_point() {
		manageAbsenPointPage.searchDataAbsenPoint();
		extentTest.log(LogStatus.PASS, "User search data absen point");
	}

	@And("User hapus data absen point")
	public void user_hapus_data_absen_point() {
		manageAbsenPointPage.deleteDataAbsenPoint();
		extentTest.log(LogStatus.PASS, "User delete manage tipe");
	}

	@Then("User berhasil hapus data absen point")
	public void user_berhasil_hapus_data_absen_point() {
		try {
			assertEquals(configurationProperties.getTextHapusData(), manageAbsenPointPage.getTextSuccessDeleteData());
		} catch (Exception e) {
			e.printStackTrace();
		}
		extentTest.log(LogStatus.PASS, "User berhasil melakukan hapus data absen point");
	}

	// Manage Absen Point Invalid

	@When("User tambah data absen point invalid")
	public void user_tambah_data_absen_point_invalid() {
		manageAbsenPointPage.addDataAbsenPointInvalid();
		extentTest.log(LogStatus.PASS, "User tambah data absen point invalid");
	}

	@And("User edit data absen point invalid")
	public void user_edit_data_absen_point_invalid() {
		manageAbsenPointPage.editDataAbsenPointInvalid();
		extentTest.log(LogStatus.PASS, "User edit data absen point invalid");
	}

	@Then("User tidak berhasil tambah dan edit data absen point")
	public void user_tidak_berhasil_tambah_dan_edit_data_absen_point() {
		assertEquals(configurationProperties.getTextManageAbsenPoint(), manageAbsenPointPage.getTextManageAbsenPoint());
		extentTest.log(LogStatus.PASS, "User tidak berhasil tambah dan edit data absen point");
	}

	// Manage Posisi

	@When("Admin klik menu manage posisi")
	public void admin_klik_menu_manage_posisi() {
		managePosisiPage.goToManagePosisi();
		extentTest.log(LogStatus.PASS, "Admin klik menu manage posisi page");
	}

	@And("Admin klik tambah posisi")
	public void admin_klik_tambah_posisi() {
		managePosisiPage.tambahPosisi();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "Admin klik tambah posisi");
	}

	@And("Admin klik ubah posisi")
	public void admin_klik_ubah_posisi() {
		managePosisiPage.ubahPosisi();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "Admin klik ubah posisi");
	}

	@And("Admin klik hapus posisi")
	public void admin_klik_hapus_posisi() {
		managePosisiPage.hapusPosisi();
		extentTest.log(LogStatus.PASS, "Admin klik hapus posisi");
	}

	@Then("Admin success go to tambah posisi and ubah posisi and hapus posisi")
	public void admin_success_go_to_tambah_posisi_and_ubah_posisi_and_hapus_posisi() {
		assertEquals(configurationProperties.getTextHapusData(), managePosisiPage.getTextHapusPosisi());
		extentTest.log(LogStatus.PASS, "Admin success go to tambah posisi and ubah posisi and hapus posisi");
	}

	// Manage Posisi Invalid

	@When("Admin tambah data posisi invalid")
	public void user_tambah_data_posisi_invalid() {
		managePosisiPage.tambahDataPosisiInvalid();
		extentTest.log(LogStatus.PASS, "User tambah data posisi invalid");
	}

	@And("Admin ubah data posisi invalid")
	public void user_edit_data_posisi_invalid() {
		managePosisiPage.ubahDataPosisiInvalid();
		extentTest.log(LogStatus.PASS, "User edit data posisi invalid");
	}

	@Then("Admin tidak berhasil tambah dan ubah data posisi")
	public void admin_tidak_berhasil_tambah_dan_hapus_data_posisi() {
		assertEquals(configurationProperties.getTextHapusData(), managePosisiPage.getTextUbahPosisi());
		extentTest.log(LogStatus.PASS, "admin tidak berhasil tambah dan ubah data posisi");
	}

	// Manage Level

	@When("Admin klik menu manage level")
	public void admin_klik_menu_manage_level() {
		manageLevelPage.goToManageLevel();
		extentTest.log(LogStatus.PASS, "Admin klik menu manage level");
	}

	@And("Admin klik tambah level")
	public void admin_klik_tambah_level() {
		manageLevelPage.tambahLevel();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "Admin klik tambah level");
	}

	@And("Admin klik ubah level")
	public void admin_klik_ubah_level() {
		manageLevelPage.ubahLevel();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "Admin klik ubah level");
	}

	@And("Admin klik hapus level")
	public void admin_klik_hapus_level() {
		driver.navigate().refresh();
		manageLevelPage.hapusLevel();
		extentTest.log(LogStatus.PASS, "Admin klik hapus level");
	}

	@Then("Admin success go to tambah level and ubah level and hapus level")
	public void admin_success_go_to_tambah_level_and_ubah_level_and_hapus_level() {
		assertEquals(configurationProperties.getTextHapusData(), manageLevelPage.getTextHapusLevel());
		extentTest.log(LogStatus.PASS, "Admin success go to tambah level and ubah level and hapus level");
	}

	// Manage Level Invalid

	@When("User tambah data level invalid")
	public void user_tambah_data_level_invalid() {
		manageLevelPage.tambahDataLevelInvalid();
		extentTest.log(LogStatus.PASS, "User tambah data level invalid");
	}

	@And("User edit data level invalid")
	public void user_edit_data_level_invalid() {
		manageLevelPage.ubahDataLevelInvalid();
		extentTest.log(LogStatus.PASS, "User edit data level invalid");
	}

	@Then("User tidak berhasil tambah dan hapus data level")
	public void user_tidak_berhasil_tambah_dan_hapus_data_level() {
		assertEquals(configurationProperties.getTextHapusData(), manageLevelPage.getTextHapusLevel());
		extentTest.log(LogStatus.PASS, "User tidak berhasil tambah dan hapus data level");
	}

	// Manage Setting

	@When("User klik menu manage setting")
	public void user_klik_menu_manage_setting() {
		manageSettingPage.goToManageSetting();
		extentTest.log(LogStatus.PASS, "User klik menu manage setting");
	}

	@And("User klik ubah data")
	public void user_klik_ubah_data() {
		manageSettingPage.ubahData();
		extentTest.log(LogStatus.PASS, "User klik ubah data");
	}

	@And("User klik switch liveness")
	public void user_klik_switch_liveness() {
		manageSettingPage.changeLiveness();
		extentTest.log(LogStatus.PASS, "User klik switch liveness");
	}

	@Then("User success go to manage setting and edit data validation timer")
	public void user_success_go_to_manage_setting_and_edit_data_validation_timer() {
		try {
			assertEquals(configurationProperties.getTextUpdateData(), manageSettingPage.getTextSuccessManageSetting());
		} catch (Exception e) {
			e.printStackTrace();
		}
		extentTest.log(LogStatus.PASS, "User success go to manage setting and edit data validation timer");
	}

	// Manage Setting Invalid

	@When("User ubah data setting invalid")
	public void user_ubah_data_setting_invalid() {
		manageSettingPage.ubahDataInvalid();
		extentTest.log(LogStatus.PASS, "User ubah data setting invalid");
	}

	@Then("User tidak berhasil ubah data setting")
	public void user_tidak_berhasil_ubah_data_setting() {
		assertEquals(configurationProperties.getTextManageSetting(), manageSettingPage.getTextManageSetting());
		extentTest.log(LogStatus.PASS, "User tidak berhasil ubah data setting");
	}

	// Manage Departemen

	@When("User klik menu manage departemen")
	public void user_klik_menu_manage_departemen() {
		manageDepartemenPage.goToManageDepartemen();
		extentTest.log(LogStatus.PASS, "User klik menu manage departemen");
	}

	@And("User tambah data departemen")
	public void user_tambah_data() {
		manageDepartemenPage.tambahDataDepartemen();
		extentTest.log(LogStatus.PASS, "User tambah data departemen");
	}

	@And("User edit data departemen")
	public void edit_data_departemen() {
		manageDepartemenPage.editDataDepartemen();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "User edit data departemen");
	}

	@And("User hapus data departemen")
	public void hapus_data_departemen() {
		manageDepartemenPage.deleteDataDepartemen();
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "User hapus data departemen");
	}

	@Then("User berhasil melakukan tambah data departemen edit data departemen and hapus data departemen")
	public void user_berhasil_melakukan_tambah_data_departemen_edit_data_departemen_and_hapus_data_departemen() {
		// assertEquals(configurationProperties.getTextHapusData(),
		// manageDepartemenPage.getTextHapusData());
		extentTest.log(LogStatus.PASS,
				"User berhasil melakukan tambah data departemen edit data departemen and hapus data departemen");
	}

	// Manage Departemen Invalid

	@When("User tambah data departemen invalid")
	public void user_tambah_data_departemen_invalid() {
		manageDepartemenPage.tambahDataDepartemenInvalid();
		extentTest.log(LogStatus.PASS, "User tambah data departemen invalid");
	}

	@And("User edit data departemen invalid")
	public void user_edit_data_departemen_invalid() {
		manageDepartemenPage.editDataDepartemenInvalid();
		extentTest.log(LogStatus.PASS, "User edit data departemen invalid");
	}

	@Then("User tidak berhasil tambah dan edit data departemen")
	public void user_tidak_berhasil_tambah_dan_edit_data_departemen() {
		assertEquals(configurationProperties.getTextManageDepartemen(), manageDepartemenPage.getTextManageDepartemen());
		extentTest.log(LogStatus.PASS, "User tidak berhasil tambah dan edit data tipe");
	}

	// Login Invalid

	@When("User melakukan logout")
	public void user_melakukan_logout() {
		loginPage.logoutAction();
		extentTest.log(LogStatus.PASS, "User melakukan logout");
	}

	@And("User kembali melakukan login")
	public void user_kembali_melakukan_login() {
		loginPage.submitLogin("user", "user123");
		extentTest.log(LogStatus.PASS, "User kembali melakukan login");
	}

	@Then("User tidak berhasil login")
	public void user_tidak_berhasil_login() {
		tunggu();
		assertEquals(configurationProperties.getTextInvalidLogin(), loginPage.getTextInvalidLogin());
		extentTest.log(LogStatus.PASS, "User tidak berhasil login");
	}

	public static void tunggu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scroll() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
	}

}
