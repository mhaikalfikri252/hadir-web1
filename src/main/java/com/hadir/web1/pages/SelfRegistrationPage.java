package com.hadir.web1.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class SelfRegistrationPage {

	private WebDriver driver;

	public SelfRegistrationPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Self Registration")
	WebElement btnSelfRegistration;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > h3")
	WebElement textHome;

	// Edit Data
	@FindBy(id = "t4")
	WebElement btnGoToForm;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > select")
	WebElement dropDownLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > select > option:nth-child(6)")
	WebElement selectDropDownLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div > select")
	WebElement dropDownTipeKaryawan;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div > select > option:nth-child(3)")
	WebElement selectDropDownTipeKaryawan;
	@FindBy(id = "input-deptName")
	WebElement dropDownDepartemenName;
	@FindBy(css = "#input-deptName > option:nth-child(5)")
	WebElement selectdropDownDepartemenName;
	@FindBy(id = "input-posisi")
	WebElement dropDownInputPosisi;
	@FindBy(css = "#input-posisi > option:nth-child(2)")
	WebElement selectDropDownInputPosisi;
	@FindBy(id = "input-jam-kerja")
	WebElement dropDownJamKerja;
	@FindBy(css = "#input-jam-kerja > option:nth-child(2)")
	WebElement selectDropDownJamKerja;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(9) > div > div > button")
	WebElement btnSubmit;

	// Reject Data
	@FindBy(id = "t2")
	WebElement btnReject;
	@FindBy(id = "exampleFormControlInput1")
	WebElement alasanReject;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button.btn.btn-primary")
	WebElement submitReject;

	// Assert Text
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > h6:nth-child(1)")
	WebElement textEditPage;
	@FindBy(css = "body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled")
	WebElement textEditSubmit;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-danger.alert-dismissible.show > span")
	WebElement textReject;

	public void goToSelfRegistration() {
		btnSelfRegistration.click();
	}

	public String getTextHome() {
		return textHome.getText();
	}

	public void goToForm() {
		btnGoToForm.click();
	}

	public String getTextEdit() {
		return textEditPage.getText();
	}

	public void editData() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dropDownLevel);
		dropDownLevel.click();
		selectDropDownLevel.click();
		tunggu(1);
		dropDownTipeKaryawan.click();
		selectDropDownTipeKaryawan.click();
		tunggu(1);
		dropDownDepartemenName.click();
		selectdropDownDepartemenName.click();
		tunggu(1);
		dropDownInputPosisi.click();
		selectDropDownInputPosisi.click();
		tunggu(1);
		dropDownJamKerja.click();
		selectDropDownJamKerja.click();
		tunggu(1);
		btnSubmit.click();
		tunggu(5);
	}

	public String getTextSubmit() {
		return textEditSubmit.getText();
	}

	public void rejectData() {
		textEditSubmit.click();
		driver.navigate().back();
		tunggu(1);
		btnReject.click();
		alasanReject.sendKeys("Data Sudah Ada");
		tunggu(2);
		submitReject.click();
		tunggu(5);
	}

	public String getTextReject() {
		return textReject.getText();
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