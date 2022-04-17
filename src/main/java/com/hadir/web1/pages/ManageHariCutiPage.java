package com.hadir.web1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class ManageHariCutiPage {
	WebDriver driver;

	public ManageHariCutiPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#sidenav-main > div > div > ul > li:nth-child(12) > a")
	WebElement btnManageHariCuti;

	@FindBy(id = "exampleModalLabel")
	WebElement textAddDaftarHariCuti;

	// Add Data Tipe
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > div > button")
	WebElement btnAddDataHariCut;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > div > div > div.rdt > input")
	WebElement addDateHariCuti;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > div > div > div.rdt.rdtOpen > div > div > table > tbody > tr:nth-child(3) > td:nth-child(5)")
	WebElement selectDateHariCuti;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button.btn.btn-primary")
	WebElement btnSubmitAdd;

	// Edit Data Hari Cuti
	@FindBy(id = "t1")
	WebElement btnEdit;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > div > div > div.rdt.rdtOpen > div > div > table > tbody > tr:nth-child(4) > td:nth-child(7)")
	WebElement selectDateEditHariCuti;

	// Delete Data Tipe
	@FindBy(id = "t2")
	WebElement btnDelete;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement btnSubmitDelete;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span")
	WebElement textSuccessDeleteData;

	public void goToManageHariCuti() {
		tunggu(2);
		btnManageHariCuti.click();
	}

	public void addManageHariCuti() {
		tunggu(3);
		btnAddDataHariCut.click();
		tunggu(2);
		addDateHariCuti.click();
		tunggu(1);
		selectDateHariCuti.click();
		tunggu(1);
		textAddDaftarHariCuti.click();
		tunggu(1);
		btnSubmitAdd.click();
	}

	public void editManageHariCuti() {
		tunggu(2);
		btnEdit.click();
		tunggu(2);
		addDateHariCuti.click();
		tunggu(1);
		selectDateEditHariCuti.click();
		tunggu(1);
		textAddDaftarHariCuti.click();
		tunggu(1);
		btnSubmitAdd.click();
	}

	public void deleteManageHariCuti() {
		tunggu(5);
		btnDelete.click();
		tunggu(2);
		btnSubmitDelete.click();
	}

	public String getTextSuccessDeleteData() {
		return textSuccessDeleteData.getText();
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
