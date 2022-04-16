package com.hadir.web1.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	@FindBy(css = "#sidenav-main > div > div > ul > li:nth-child(14) > a")
	WebElement btnManagePosisi;
	
	//form tambah data
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

	//form ubah data
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
	
	
	//hapus data
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.table-responsive > table > tbody > tr:nth-child(2)")
	WebElement pilihPosisi1;
	@FindBy(css = "#t2")
	WebElement btnHapusData;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div")
	WebElement formActiveElement;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement btnSubmitHapusPosisi;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-success.alert-dismissible.show > span")
	WebElement txtHapusPosisi;

	
	public void go_to_Manage_Posisi_page() {
		btnManagePosisi.click();
		tunggu(2);
	}
	public void tambah_posisi() {
		btnTambahPosisi.click();
		tunggu(3);
		inputMasukanPosisi.sendKeys("Regen");
		btnSumbitTambahPosisi.click();
		}

	public void ubah_posisi() {
		btnUbahData.click();
		tunggu(2);
		inputUbahPosisi.sendKeys("Dummy");
		btnSubmitUbahPosisi.click();
	}
	public void hapus_posisi() {
		btnHapusData.click();
		tunggu(2);
		btnSubmitHapusPosisi.click();
	}
	public String get_Txt_Tambah_Posisi() {
		return txtManagePosisi.getText();
	
	}
	public String get_Txt_Ubah_Posisi() {
		return txtUbahPosisi.getText();
		
	}
	public String get_Txt_Hapus_Posisi() {
		return txtHapusPosisi.getText();
	
	}
	public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


	