package com.hadir.web1.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Register Page
	@FindBy(linkText = "Register")
	WebElement btnRegister;

	// Check Fitur
	@FindBy(id = "t4")
	WebElement btnLihatDetail;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > ul > li:nth-child(1)")
	WebElement btnFirst;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > ul > li:nth-child(9)")
	WebElement btnEnd;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > ul > li:nth-child(8)")
	WebElement btnNext;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > ul > li:nth-child(2)")
	WebElement btnPrevious;

	// Search By
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div:nth-child(2) > div > select")
	WebElement dropDownSearch;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div.col-lg-4 > div > input")
	WebElement inputKeyword;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div.col-lg-4 > div > select")
	WebElement dropDownKeyword;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div.col-sm-2 > button")
	WebElement btnSearch;

	// Edit Data Karyawan
	@FindBy(css = "#t1")
	WebElement btnUbahData;

	// Form Edit Data
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div")
	WebElement formActiveElement;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(2) > input")
	WebElement editNama;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(3) > select")
	WebElement editLevel;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(4) > select")
	WebElement editLeader;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(6) > input")
	WebElement editPassword;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(7) > input")
	WebElement editNIK;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(8) > select")
	WebElement editTipeKaryawan;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(9) > select")
	WebElement editPosisi;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(11) > select")
	WebElement editJamKerja;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(12) > select")
	WebElement editLokasiKerja;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(15) > input")
	WebElement editJumlahCuti;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > button")
	WebElement btnSubmit;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-success.alert-dismissible.show > span")
	WebElement textSuccessUpdateData;

	public void goToRegisterPage() {
		btnRegister.click();
		tunggu(2);
	}

	public void searchDataKaryawan() {
		for (int i = 0; i < 5; i++) {
			dropDownSearch.click();
			tunggu(1);
			dropDownSearch.sendKeys(Keys.DOWN);
			tunggu(1);
			dropDownSearch.sendKeys(Keys.ENTER);
			tunggu(1);
		}
		tunggu(2);
		dropDownKeyword.click();
		for (int i = 1; i <= 1; i++) {
			dropDownKeyword.sendKeys(Keys.DOWN);
		}
		dropDownKeyword.sendKeys(Keys.ENTER);
		tunggu(1);
		btnSearch.click();
		tunggu(2);
		btnLihatDetail.click();
		tunggu(2);
	}

	public void invalidData() {

	}

	public void editDataKaryawan() {
		btnUbahData.click();
		tunggu(2);
		editNama.sendKeys(" Testing");
		tunggu(1);
		editLevel.click();
		tunggu(1);
		for (int i = 0; i <= 3; i++) {
			editLevel.sendKeys(Keys.DOWN);
		}
		tunggu(1);
		editLevel.sendKeys(Keys.ENTER);
		tunggu(2);
		editLeader.click();
		tunggu(2);
		editPassword.sendKeys("1234");
		tunggu(2);
		scroll();
		editNIK.sendKeys(Keys.BACK_SPACE);
		tunggu(1);
		editNIK.sendKeys("0");
		tunggu(2);
		editTipeKaryawan.click();
		for (int i = 0; i <= 3; i++) {
			editTipeKaryawan.sendKeys(Keys.DOWN);
		}
		tunggu(1);
		editTipeKaryawan.sendKeys(Keys.ENTER);
		tunggu(2);
		editPosisi.click();
		for (int i = 0; i <= 3; i++) {
			editPosisi.sendKeys(Keys.DOWN);
		}
		tunggu(1);
		editPosisi.sendKeys(Keys.ENTER);
		tunggu(2);
		editJamKerja.click();
		tunggu(1);
		for (int i = 1; i <= 3; i++) {
			editJamKerja.sendKeys(Keys.DOWN);
		}
		tunggu(1);
		editJamKerja.sendKeys(Keys.ENTER);
		tunggu(2);
		editLokasiKerja.click();
		tunggu(1);
		for (int i = 1; i <= 2; i++) {
			editLokasiKerja.sendKeys(Keys.DOWN);
		}
		tunggu(1);
		editLokasiKerja.sendKeys(Keys.ENTER);
		tunggu(2);
		btnSubmit.click();
		tunggu(4);
	}

	public String getTextSuccesUpdateData() {
		return textSuccessUpdateData.getText();
	}

	public void tunggu(int detik) {
		try {
			Thread.sleep(detik * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scroll() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
	}

}
