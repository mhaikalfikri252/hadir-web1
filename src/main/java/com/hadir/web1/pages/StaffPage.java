package com.hadir.web1.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class StaffPage {

	private WebDriver driver;

	public StaffPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Staff Page
	@FindBy(linkText = "Staff")
	WebElement btnStaff;
	@FindBy(linkText = "View history")
	WebElement btnViewStaff;
	@FindBy(linkText = "Edit data")
	WebElement btnEdit;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.row > div:nth-child(2) > div > div.pt-0.pt-md-4.card-body > div > div.mt-2 > a:nth-child(1)")
	WebElement viewHistoryMeinida;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.border-0.p-1.ml-2.card-header > form > div > div:nth-child(2) > div > select")
	WebElement searchBy;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.border-0.p-1.ml-2.card-header > form > div > div.col-lg-4 > div > input")
	WebElement inputSearchStaff;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.border-0.p-1.ml-2.card-header > form > div > div.col-sm-2 > button")
	WebElement btnSerachStaff;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.row > div:nth-child(1) > div > div.pt-0.pt-md-4.card-body > div > div.mt-2 > a:nth-child(2)")
	WebElement btnEditStaff;
//	End Staff Page

//	View Staff Page
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/form/div/div[3]/div/div/div[2]/input")
	WebElement startDate;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div.col-md-3.col-sm-12 > div > div > div.rdt.rdtOpen > div > div > table > thead > tr:nth-child(1) > th.rdtSwitch")
	WebElement selectStartDate;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div:nth-child(3) > div > div > div.rdt.rdtOpen > div > div > table > thead > tr:nth-child(1) > th.rdtPrev")
	WebElement rdtSwitch;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div:nth-child(4) > div > div > div.rdt.rdtOpen > input")
	WebElement endDate;
	@FindBy(id = "eskport")
	WebElement eksportHistory;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div.col-md-2.col-sm-12 > div > div > select")
	WebElement filterBy;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > h3")
	WebElement reportingText;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div.text-center.mt--4 > button")
	WebElement btn_Search_Filter_History;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/form/div/div[3]/div/div/div[2]/div/div/table/tbody/tr[1]/td[5]")
	WebElement selectDateHistory;
//	End View Staff Page

//	Form Edit Staff
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(2) > div:nth-child(1) > div > div > input")
	WebElement btn_choose_file_edit_staff;
	@FindBy(id = "input-email")
	WebElement inputEmailEditDataStaff;
	@FindBy(id = "input-first-name")
	WebElement inputFullNameEditDataStaff;
	@FindBy(id = "input-nik")
	WebElement inputNikEditStaff;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > select")
	WebElement selectLevelEditStaff;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div > select")
	WebElement selectTipeKaryawanEditStaff;
	@FindBy(id = "input-deptName")
	WebElement selectDeptEditStaff;
	@FindBy(id = "input-posisi")
	WebElement selectPosisiEditStaff;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(5) > div > div > select")
	WebElement selectAbsenPointEditStaff;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(9) > div > div > button")
	WebElement btnSubmitEditStaff;
	@FindBy(css = "body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled")
	WebElement PopUpSubmit;

//		Search Staff
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.row > div")
	WebElement searchByNik;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.border-0.p-1.ml-2.card-header > form > div > div.col-sm-2 > button")
	WebElement btnSubmitSearch;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.border-0.p-1.ml-2.card-header > form > div > div:nth-child(2) > div > select")
	WebElement drpdwnSearchBy;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.border-0.p-1.ml-2.card-header > form > div > div:nth-child(2) > div > select > option:nth-child(2)")
	WebElement selectByNik;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.border-0.p-1.ml-2.card-header > form > div > div.col-lg-4 > div > select")
	WebElement drpdwnDivisi;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.border-0.p-1.ml-2.card-header > form > div > div.col-lg-4 > div > select > option:nth-child(13)")
	WebElement selectDivisifromSearch;
	
//	Text Assert
	@FindBy(css = "#swal2-content")
	WebElement textEndStaff;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.row > div")
	WebElement textInvalidSearch;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.row > div > div > div.pt-0.pt-md-4.card-body > div > div.h5.font-weight-300")
	WebElement textValidNik;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.row > div > div > div.pt-0.pt-md-4.card-body > div > h3")
	WebElement textSearchName;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.row > div:nth-child(1) > div > div.pt-0.pt-md-4.card-body > div > div.mt-2 > a:nth-child(2) > button")
	WebElement textSearchDivisi;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > h3")
	WebElement textHistoryPage;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.border-0.p-1.ml-2.card-header > form > div > div.col-lg-4 > div > select > option:nth-child(8)")
	WebElement selectDrpdwnDivisi;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.row > div")
	WebElement textInvalidDivisi;
	@FindBy(css = "#root > div > div.mt-2.container-fluid > div > div.border-0.p-1.ml-2.card-header > form > div > div:nth-child(2) > div > select > option:nth-child(3)")
	WebElement drpdwnName;
	
	public void goToStaffPage() {
		btnStaff.click();
		tunggu(2);

	}
	
	public void searchByNik() {
		drpdwnSearchBy.click();
		tunggu(1);
		drpdwnSearchBy.sendKeys(Keys.DOWN);
		drpdwnSearchBy.sendKeys(Keys.ENTER);
		inputSearchStaff.sendKeys("D6180259");
		tunggu(1);
		btnSubmitSearch.click();
		tunggu(4);
	}
	
	public String TextValidNik() {
		return textValidNik.getText();
	}
	
	public void searchByInvalidNik() {
		tunggu(1);
		inputSearchStaff.sendKeys(Keys.CONTROL, "a");
		inputSearchStaff.sendKeys("D61802590");
		tunggu(1);
		btnSubmitSearch.click();
		tunggu(5);
	}
	
	public String textSearchInvalid() {
		return textInvalidSearch.getText();		
	}
	
	
	public void searchByName() {
		drpdwnSearchBy.click();
		tunggu(1);
		drpdwnSearchBy.sendKeys(Keys.DOWN);
		drpdwnSearchBy.sendKeys(Keys.ENTER);
		inputSearchStaff.sendKeys(Keys.CONTROL, "a");
		inputSearchStaff.sendKeys("Meinida");
		tunggu(1);
		btnSubmitSearch.click();
		tunggu(4);
	}
	
	public String TextValidName() {
		return textSearchName.getText();
	}
	
	public void searchByInvalidName() {
		tunggu(1);
		drpdwnSearchBy.click();
		tunggu(1);
		inputSearchStaff.sendKeys(Keys.CONTROL, "a");
		inputSearchStaff.sendKeys("Meinidaa");
		tunggu(1);
		btnSubmitSearch.click();
		tunggu(5);
	}
	
	public String textSearchByNameInvalid() {
		return textInvalidSearch.getText();		
	}
	
	public void searchByDivisi() {
		drpdwnSearchBy.click();
		tunggu(1);
		drpdwnSearchBy.sendKeys(Keys.DOWN);
		drpdwnSearchBy.sendKeys(Keys.DOWN);
		drpdwnSearchBy.sendKeys(Keys.ENTER);
		drpdwnDivisi.sendKeys(Keys.DOWN);
		drpdwnDivisi.sendKeys(Keys.ENTER);
		tunggu(1);
		btnSubmitSearch.click();
		tunggu(4);
	}
	
	public String TextValidDivisi() {
		return textSearchDivisi.getText();
	}
	
	public void searchByInvalidDivisi() {
		drpdwnDivisi.click();
		tunggu(2);
//		for(int i = 1;i<=6;i++) {
//			drpdwnDivisi.sendKeys(Keys.DOWN);		
//			}
//		drpdwnDivisi.sendKeys(Keys.ENTER);
		selectDrpdwnDivisi.click();
		tunggu(1);
		btnSubmitSearch.click();
		tunggu(2);
	}
	
	
	public String textInvalidDivisi() {
		return textInvalidSearch.getText();		
	}
	
	
	public void btnViewHistory() {
		tunggu(2);
		drpdwnSearchBy.click();
		tunggu(2);
	drpdwnName.click();
		inputSearchStaff.sendKeys(Keys.CONTROL, "a");
		tunggu(2);
		inputSearchStaff.sendKeys("Meinida");
		tunggu(2);
		btnSerachStaff.click();
		tunggu(4);
		btnViewStaff.click();
	}
	
	
	
	public String textHistoryPage() {
		return textHistoryPage.getText(); 
	}
	
	

	public void historyStaffPage() {
		tunggu(2);
		filterBy.click();
		tunggu(2);
		for (int i = 1; i <= 2; i++) {
			filterBy.sendKeys(Keys.DOWN);
		}
		filterBy.sendKeys(Keys.ENTER);
		tunggu(2);
		startDate.click();
		tunggu(2);
		for (int i = 1; i <= 7; i++) {
			rdtSwitch.click();
		}
		tunggu(1);
		selectDateHistory.click();
		tunggu(2);
		btn_Search_Filter_History.click();
		tunggu(2);
		eksportHistory.click();
		tunggu(2);
	}

	public void editDataStaff() {
		btnStaff.click();
		tunggu(2);
		searchBy.click();
		tunggu(2);
		for (int i = 1; i <= 2; i++) {
			searchBy.sendKeys(Keys.DOWN);
		}

		searchBy.sendKeys(Keys.ENTER);
		tunggu(2);
		inputSearchStaff.sendKeys("meinida");
		tunggu(2);
		btnSerachStaff.click();
		tunggu(2);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnEdit);
		btnEditStaff.click();
	}

	public void formEditDataStaff() {
		btn_choose_file_edit_staff.sendKeys("C:\\Users\\Roby\\Pictures\\Saved Pictures\\bango.jpg");
		inputEmailEditDataStaff.sendKeys(Keys.CONTROL, "a");
		inputEmailEditDataStaff.sendKeys("cindymeinidaprtw@gmail.com");
		inputFullNameEditDataStaff.sendKeys(Keys.CONTROL, "a");
		inputFullNameEditDataStaff.sendKeys("Meinida Cindy Pratiwi");
		tunggu(2);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", inputNikEditStaff);
		inputNikEditStaff.sendKeys(Keys.CONTROL, "a");
		inputNikEditStaff.sendKeys("D6180259");
		for (int i = 1; i <= 4; i++) {
			selectTipeKaryawanEditStaff.sendKeys(Keys.DOWN);
		}
		selectTipeKaryawanEditStaff.sendKeys(Keys.ENTER);

		for (int i = 1; i <= 4; i++) {
			selectDeptEditStaff.sendKeys(Keys.DOWN);
		}
		selectDeptEditStaff.sendKeys(Keys.ENTER);

		for (int i = 1; i <= 2; i++) {
			selectPosisiEditStaff.sendKeys(Keys.DOWN);
		}
		selectPosisiEditStaff.sendKeys(Keys.ENTER);

		for (int i = 1; i <= 7; i++) {
			selectAbsenPointEditStaff.sendKeys(Keys.DOWN);
		}
		selectAbsenPointEditStaff.sendKeys(Keys.ENTER);

		js.executeScript("arguments[0].scrollIntoView();", btnSubmitEditStaff);
		btnSubmitEditStaff.click();

	}

	public String getTextStaffPage() {
		tunggu(5);
		return PopUpSubmit.getText();
	}

	public void tunggu(int detik) {
		try {
			Thread.sleep(detik * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
