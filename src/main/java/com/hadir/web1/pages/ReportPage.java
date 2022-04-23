package com.hadir.web1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class ReportPage {

	WebDriver driver;

	public ReportPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Register Page
	@FindBy(linkText = "Reporting karyawan")
	WebElement btnReport;

	@FindBy(css = "#navbar-main > div > a")
	WebElement textReportingKaryawan;

	// Search By
	@FindBy(css = "#root > div > div.mt--7.container-fluid > div > div > div.shadow.card > div.border-0.card-header > form > div > div:nth-child(2) > div > select")
	WebElement dropDownSearch;

	@FindBy(css = "#root > div > div.mt--7.container-fluid > div > div > div.shadow.card > div.border-0.card-header > form > div > div.col-lg-4 > div > input")
	WebElement inputKeyword;

	@FindBy(css = "#root > div > div.mt--7.container-fluid > div > div > div.shadow.card > div.border-0.card-header > form > div > div.col-sm-2 > button")
	WebElement btnSearch;

	// Hasil
	@FindBy(css = "#ekspor > tbody > tr > td:nth-child(1) > input[type=checkbox]")
	WebElement checkbox;

	@FindBy(css = "#root > div > div.mt--7.container-fluid > div > div > div.shadow.card > div.border-0.card-header > div > button")
	WebElement btnExport;

	// Dialog Box
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > div > div.col-md-2.col-sm-12 > div > div > select")
	WebElement dropDownPilihWaktu;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > div > div.col-md-3.col-sm-12 > div > div > div.rdt > input")
	WebElement datepicker;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > div > div.col-md-3.col-sm-12 > div > div > div.rdt.rdtOpen > div > div > table:nth-child(2) > tbody > tr:nth-child(1) > td:nth-child(1)")
	WebElement pilih_bulan;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > div > div.text-center.mt--4 > button")
	WebElement btnSearch2;

	@FindBy(css = "#test-table-xls-button")
	WebElement btnSiapExport;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > div.progress-info > div.progress-label > span")
	WebElement textSuccessExport;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > div.modal-footer > button")
	WebElement btnClosePopUp;

	public void goToReportPage() {
		btnReport.click();
		tunggu(2);
	}

	public void searchDataReport() {
		dropDownSearch.click();
		for (int i = 1; i <= 1; i++) {
			dropDownSearch.sendKeys(Keys.DOWN);
		}
		dropDownSearch.sendKeys(Keys.ENTER);
		tunggu(2);
		inputKeyword.sendKeys("D6190141");
		btnSearch.click();
		tunggu(2);
	}

	public void exportData() {
		checkbox.click();
		tunggu(2);
		btnExport.click();
		tunggu(2);
		dropDownPilihWaktu.click();
		for (int i = 1; i <= 3; i++) {
			dropDownPilihWaktu.sendKeys(Keys.DOWN);
		}
		dropDownPilihWaktu.sendKeys(Keys.ENTER);
		tunggu(2);
		datepicker.click();
		tunggu(2);
		pilih_bulan.click();
		tunggu(2);
		btnSearch2.click();
		tunggu(2);
		btnSiapExport.click();
		tunggu(3);
		btnClosePopUp.click();
	}

	public String getTextReportPage() {
		return textSuccessExport.getText();
	}

	public String getTextReportingKaryawan() {
		return textReportingKaryawan.getText();
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
