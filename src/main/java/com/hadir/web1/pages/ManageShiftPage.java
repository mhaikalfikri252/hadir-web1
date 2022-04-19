package com.hadir.web1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class ManageShiftPage {

	WebDriver driver;

	public ManageShiftPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

//	Manage Shift Page
	@FindBy(linkText = "Manage Shift")
	WebElement btnMngShift;

//	Search Manage Shift
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div:nth-child(1) > div:nth-child(2) > div > select")
	WebElement btnSearchBy;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div:nth-child(1) > div.col-lg-4 > div > select")
	WebElement dropdwnShiftCode;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div:nth-child(1) > div.col-lg-4 > div > select > option:nth-child(5)")
	WebElement selectShift1;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div:nth-child(1) > div.col-sm-2 > button")
	WebElement btnSearch;
//	End Search Manage Shift

//	Edit Data Shift
	@FindBy(id = "t4")
	WebElement btnEditMngShift;
	@FindBy(id = "input-code_kelas_shift")
	WebElement inputCodeShift;
	@FindBy(css = "#input-posisi > option:nth-child(2)")
	WebElement selectDropDwnCode;
	@FindBy(id = "input-shift_hari")
	WebElement DrpdwnDay;
	@FindBy(xpath = "//*[@id=\"input-code_kelas_shift\"]/option[4]")
	WebElement inputDay;
	@FindBy(id = "input-shift_masuk")
	WebElement inputShiftMasuk;
	@FindBy(id = "input-shift_keluar")
	WebElement inputShiftKeluar;
	@FindBy(id = "input-shift_lembur")
	WebElement inputShiftLembur;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(7) > div > div > button")
	WebElement btnSubmitEditShift;
	@FindBy(css = "body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled")
	WebElement btnOk;
//	End Edit Data Shift

//	Add Data Shift
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > div > a > button")
	WebElement btnAddShift;
	@FindBy(id = "input-posisi")
	WebElement drpDwnPosisi;
	@FindBy(css = "#input-posisi > option:nth-child(2)")
	WebElement inputCode;
	@FindBy(id = "input-hari")
	WebElement drpDwnAddDay;
	@FindBy(css = "#input-hari > option:nth-child(4)")
	WebElement inputDayAddShift;
	@FindBy(id = "shift_masuk")
	WebElement inputShiftIn;
	@FindBy(id = "shift_keluar")
	WebElement inputShiftOut;
	@FindBy(id = "shift_lembur")
	WebElement inputShiftOvertime;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(7) > div > div > button")
	WebElement btnSubmitAddShift;
	@FindBy(css = "body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled")
	WebElement btnOkAddShift;

	public void goToManageShift() {
		tunggu(2);
		btnMngShift.click();
	}

	public void searchBy() {
		tunggu(3);
		btnSearchBy.click();
		btnSearchBy.sendKeys(Keys.DOWN);
		tunggu(1);
		btnSearchBy.sendKeys(Keys.ENTER);
		tunggu(1);
		dropdwnShiftCode.click();
		tunggu(1);
		selectShift1.click();
		tunggu(1);
		btnSearch.click();
		tunggu(3);
	}

	public void editDataShift() {
		btnEditMngShift.click();
		tunggu(1);
//		inputCodeShift.click();
//		tunggu(1);
//		selectDropDwnCode.click();
//		tunggu(1);
		DrpdwnDay.click();
		tunggu(1);
		inputDay.click();
		tunggu(3);
		inputShiftMasuk.sendKeys("0800");
		tunggu(1);
		inputShiftKeluar.sendKeys("0400");
		tunggu(1);
		inputShiftLembur.sendKeys("0200");
		tunggu(1);
		btnSubmitEditShift.click();
	}

	public void addDataShift() {
		tunggu(1);
		btnAddShift.click();
		tunggu(1);
		inputCode.click();
		tunggu(1);

//		drpDwnAddDay.click();
//		for(int i = 1; i <=4 ;i++) {
//			drpDwnAddDay.sendKeys(Keys.DOWN);
//		}
//		drpDwnAddDay.click();
//		tunggu(1);

		drpDwnAddDay.click();
		tunggu(1);
		inputDayAddShift.click();
		tunggu(2);
		inputShiftIn.sendKeys("0900AM");
		tunggu(1);
		inputShiftOut.sendKeys("0400PM");
		tunggu(1);
		inputShiftOvertime.sendKeys("0300PM");
		tunggu(1);
		btnSubmitAddShift.click();
		tunggu(1);
		btnOkAddShift.click();
		tunggu(2);
		btnMngShift.click();
	}

	public String getTextManageShiftPage() {
		return btnOk.getText();
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
