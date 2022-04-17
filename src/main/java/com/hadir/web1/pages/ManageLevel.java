package com.hadir.web1.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class ManageLevel {

	WebDriver driver;

	public ManageLevel() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	// Manage Posisi Page
	@FindBy(css = "#sidenav-main > div > div > ul > li:nth-child(15) > a")
	WebElement btnManageLevel;
	
	//form tambah data
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > div > button")
	WebElement btnTambahLevel;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div")
	WebElement formTambahLevel;
	@FindBy(css = "#zz1")
	WebElement inputMasukanLevel;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button.btn.btn-primary")
	WebElement btnSumbitTambahLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-success.alert-dismissible.show > span")
	WebElement txtManageLevel;

	//form ubah data
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
	WebElement txtUbahLevel;
	
	
	//hapus data
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.table-responsive > table > tbody > tr:nth-child(2)")
	WebElement pilihLevel1;
	@FindBy(css = "#t2")
	WebElement btnHapusLevel;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div")
	WebElement formActiveElement;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement btnSubmitHapusLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-success.alert-dismissible.show > span")
	WebElement txtHapusLevel;

	
	public void go_to_Manage_Level() {
		btnManageLevel.click();
		tunggu(2);
	}
	public void tambah_level() {
		btnTambahLevel.click();
		tunggu(3);
		inputMasukanLevel.sendKeys("Staff");
		btnSumbitTambahLevel.click();
		}

	public void ubah_level() {
		btnUbahLevel.click();
		tunggu(2);
		inputUbahLevel.sendKeys("PKWT");
		btnSubmitUbahLevel.click();
	}
	public void hapus_Level() {
		btnHapusLevel.click();
		tunggu(2);
		btnSubmitHapusLevel.click();
	}
	public String get_Txt_Tambah_Level() {
		return txtManageLevel.getText();
	
	}
	public String get_Txt_Ubah_Level() {
		return txtUbahLevel.getText();
		
	}
	public String get_Txt_Hapus_Level() {
		return txtHapusLevel.getText();
	
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
