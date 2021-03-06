package com.hadir.web1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class ManageLevelPage {

	WebDriver driver;

	public ManageLevelPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Manage Posisi Page
	@FindBy(linkText = "Manage Level")
	WebElement btnManageLevel;
	@FindBy(css = "#navbar-main > div > a")
	WebElement textManageLevel;
	@FindBy(css = "#navbar-main > div > form > div > div > input")
	WebElement search;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-header > button")
	WebElement btnClosePopUp;

	// Form Tambah Data
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > div > button")
	WebElement btnTambahLevel;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div")
	WebElement formTambahLevel;
	@FindBy(css = "#zz1")
	WebElement inputMasukanLevel;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button.btn.btn-primary")
	WebElement btnSumbitTambahLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-success.alert-dismissible.show > span")
	WebElement textManageLevel2;

	// Form Ubah Data
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.table-responsive > table > tbody > tr:nth-child(1)")
	WebElement pilihLevel;
	@FindBy(css = "#t1")
	WebElement btnUbahLevel;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div")
	WebElement formUbahLevel;
	@FindBy(css = "#zz1")
	WebElement inputUbahLevel;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > button.btn.btn-primary")
	WebElement btnSubmitUbahLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-success.alert-dismissible.show > span")
	WebElement textUbahLevel;

	// Form Hapus Data
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.table-responsive > table > tbody > tr:nth-child(2)")
	WebElement pilihLevel1;
	@FindBy(css = "#t2")
	WebElement btnHapusLevel;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div")
	WebElement formActiveElement;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement btnSubmitHapusLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-success.alert-dismissible.show > span")
	WebElement textHapusLevel;

	public void goToManageLevel() {
		btnManageLevel.click();
		tunggu(2);
	}

	public void tambahLevel() {
		btnTambahLevel.click();
		tunggu(3);
		inputMasukanLevel.sendKeys("Staff");
		btnSumbitTambahLevel.click();
	}

	public void tambahDataLevelInvalid() {
		tunggu(3);
		btnTambahLevel.click();
		tunggu(2);
		btnSumbitTambahLevel.click();
		tunggu(2);
		btnClosePopUp.click();
	}

	public void ubahLevel() {
		btnUbahLevel.click();
		tunggu(2);
		inputUbahLevel.sendKeys("PKWT");
		btnSubmitUbahLevel.click();

	}

	public void ubahDataLevelInvalid() {
		tunggu(2);
		btnUbahLevel.click();
		tunggu(2);
		inputUbahLevel.clear();
		tunggu(2);
		btnSubmitUbahLevel.click();
		tunggu(2);
		btnClosePopUp.click();
	}

	public void hapusLevel() {
		btnHapusLevel.click();
		tunggu(2);
		btnSubmitHapusLevel.click();
	}

	public String getTextTambahLevel() {
		return textManageLevel2.getText();
	}

	public String getTextUbahLevel() {
		return textUbahLevel.getText();
	}

	public String getTextHapusLevel() {
		return textHapusLevel.getText();
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
