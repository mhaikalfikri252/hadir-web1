package com.hadir.web1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class ManageDepartemenPage {

	WebDriver driver;

	public ManageDepartemenPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Manage Departemen Page
	@FindBy(linkText = "Manage Departemen")
	WebElement btnManageDepartemen;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > div > button")
	WebElement btnTambahData;
	@FindBy(id = "t1")
	WebElement btnEditData;
	@FindBy(id = "t2")
	WebElement btnHapusData;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span")
	WebElement textSuccessTambahData;

	// Form Tambah Data
	@FindBy(id = "zz1")
	WebElement inputDepartemen;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button.btn.btn-secondary")
	WebElement btnClose;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button.btn.btn-primary")
	WebElement btnSubmit;

	// Form Ubah Data
	@FindBy(id = "zz1")
	WebElement editDepartemen;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > button.btn.btn-secondary")
	WebElement btnCloseEdit;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > button.btn.btn-primary")
	WebElement btnSubmitEdit;

	// Form Hapus Data
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement btnSubmitHapus;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-footer > button.btn.btn-secondary")
	WebElement btnSubmitClose;

	public void goToManageDepartemen() {
		btnManageDepartemen.click();
		tunggu(2);
	}

	public void tambahDataDepartemen() {
		btnTambahData.click();
		tunggu(2);
		inputDepartemen.sendKeys("IT Support");
		btnSubmit.click();
	}

	public void editDataDepartemen() {
		tunggu(5);
		btnEditData.click();
		tunggu(2);
		editDepartemen.clear();
		tunggu(2);
		editDepartemen.sendKeys("Operasional");
		tunggu(5);
		btnSubmitEdit.click();
	}

	public void deleteDataDepartemen() {
		btnHapusData.click();
		tunggu(2);
		btnSubmitHapus.click();
		tunggu(2);
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
