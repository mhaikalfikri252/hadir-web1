package com.hadir.web1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class ManagePosisiPage {

	WebDriver driver;

	public ManagePosisiPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Manage Posisi Page
	@FindBy(linkText = "Manage Posisi")
	WebElement btnManagePosisi;

	// Form Tambah Data
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > div > button")
	WebElement btnTambahPosisi;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div")
	WebElement formTambahPosisi;
	@FindBy(css = "#zz1")
	WebElement inputMasukanPosisi;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button.btn.btn-primary")
	WebElement btnSumbitTambahPosisi;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-success.alert-dismissible.show > span")
	WebElement txtManagePosisi;

	// Form Ubah Data
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.table-responsive > table > tbody > tr:nth-child(1)")
	WebElement pilihPosisi;
	@FindBy(css = "#t1")
	WebElement btnUbahData;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div")
	WebElement formUbahPosisi;
	@FindBy(css = "#zz1")
	WebElement inputUbahPosisi;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > button.btn.btn-primary")
	WebElement btnSubmitUbahPosisi;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-success.alert-dismissible.show > span")
	WebElement txtUbahPosisi;

	// Hapus Data
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.table-responsive > table > tbody > tr:nth-child(1)")
	WebElement pilihPosisi1;
	@FindBy(css = "#t2")
	WebElement btnHapusData;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div")
	WebElement formActiveElement;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement btnSubmitHapusPosisi;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-success.alert-dismissible.show > span")
	WebElement txtHapusPosisi;

	public void goToManagePosisi() {
		btnManagePosisi.click();
		tunggu(2);
	}

	public void tambahPosisi() {
		btnTambahPosisi.click();
		tunggu(3);
		inputMasukanPosisi.sendKeys("Regen");
		btnSumbitTambahPosisi.click();
	}

	public void ubahPosisi() {
		btnUbahData.click();
		tunggu(2);
		inputUbahPosisi.sendKeys("Dummy");
		btnSubmitUbahPosisi.click();
	}

	public void hapusPosisi() {
		btnHapusData.click();
		tunggu(2);
		btnSubmitHapusPosisi.click();
	}

	public String getTextTambahPosisi() {
		return txtManagePosisi.getText();
	}

	public String getTextUbahPosisi() {
		return txtUbahPosisi.getText();
	}

	public String getTextHapusPosisi() {
		return txtHapusPosisi.getText();
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
