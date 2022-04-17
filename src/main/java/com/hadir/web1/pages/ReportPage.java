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

	// Search By
	@FindBy(css = "#root > div > div.mt--7.container-fluid > div > div > div.shadow.card > div.border-0.card-header > form > div > div:nth-child(2) > div > select")
	WebElement dropdown_search;

	@FindBy(css = "#root > div > div.mt--7.container-fluid > div > div > div.shadow.card > div.border-0.card-header > form > div > div.col-lg-4 > div > input")
	WebElement input_keyword;

	@FindBy(css = "#root > div > div.mt--7.container-fluid > div > div > div.shadow.card > div.border-0.card-header > form > div > div.col-sm-2 > button")
	WebElement btnSearch;
	
	//hasil
	
	@FindBy(css = "#ekspor > tbody > tr > td:nth-child(1) > input[type=checkbox]")
	WebElement checkbox;
	
	@FindBy(css = "#root > div > div.mt--7.container-fluid > div > div > div.shadow.card > div.border-0.card-header > div > button")
	WebElement btnExport;
	
	
	//dialog box
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > div > div.col-md-2.col-sm-12 > div > div > select")
	WebElement dropdown_pilihWaktu;
	
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > div > div.col-md-3.col-sm-12 > div > div > div.rdt > input")
	WebElement datepicker;
	
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > div > div.col-md-3.col-sm-12 > div > div > div.rdt.rdtOpen > div > div > table:nth-child(2) > tbody > tr:nth-child(1) > td:nth-child(1)")
	WebElement pilih_bulan;
	
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > div > div.text-center.mt--4 > button")
	WebElement btnSearch2;
	
	@FindBy(css = "#test-table-xls-button")
	WebElement btnSiapExport;
	
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > div.progress-info > div.progress-label > span")
	WebElement txtSuccessExport;
	
	
	public void goToReportPage() {
		btnReport.click();
		tunggu(2);
	}
	
	public void searchDataReport() {
		dropdown_search.click();
		for (int i = 1; i <= 1; i++) {
			dropdown_search.sendKeys(Keys.DOWN);
		}
		dropdown_search.sendKeys(Keys.ENTER);
		tunggu(2);
		input_keyword.sendKeys("D6190141");
		btnSearch.click();
		tunggu(2);
	}
	
	public void exportData() {
		
		checkbox.click();
		tunggu(2);
		btnExport.click();
		tunggu(2);
		
		dropdown_pilihWaktu.click();
		for (int i = 1; i <= 3; i++) {
			dropdown_pilihWaktu.sendKeys(Keys.DOWN);
		}
		dropdown_pilihWaktu.sendKeys(Keys.ENTER);
		tunggu(2);
		
		datepicker.click();
		tunggu(2);
		pilih_bulan.click();
		tunggu(2);
		btnSearch2.click();
		tunggu(2);
		btnSiapExport.click();
		tunggu(2);
		
	}
	
	public String getTextReportPage() {
		return txtSuccessExport.getText();
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
