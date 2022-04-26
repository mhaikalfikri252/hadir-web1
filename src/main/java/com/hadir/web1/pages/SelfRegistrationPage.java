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
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > select > option:nth-child(4)")
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
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div > select")
	WebElement dropDownLeader;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div > select > option:nth-child(2)")
	WebElement selectDropDownLeader;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(1) > div:nth-child(2) > div > select")
	WebElement dropDownSupervisor;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(1) > div:nth-child(2) > div > select > option:nth-child(3)")
	WebElement selectDropDownSupervisor;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(1) > div:nth-child(3) > div > select")
	WebElement dropDownManager;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(1) > div:nth-child(3) > div > select > option:nth-child(5)")
	WebElement selectDropDownManager;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(2) > div:nth-child(1) > div > select")
	WebElement dropDownHead;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(2) > div:nth-child(1) > div > select > option:nth-child(4)")
	WebElement selectDropDownHead;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(2) > div:nth-child(2) > div > select")
	WebElement dropDownGM;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(2) > div:nth-child(2) > div > select > option:nth-child(2)")
	WebElement selectDropDownGM;
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
		tunggu(1);
		btnSelfRegistration.click();
		tunggu(1);
	}

	public String getTextHome() {
		tunggu(1);
		return textHome.getText();
	}

	public void goToForm() {
		tunggu(1);
		btnGoToForm.click();
		tunggu(1);
	}

	public String getTextEdit() {
		tunggu(1);
		return textEditPage.getText();
	}

	public void editData() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dropDownLevel);
		dropDownLevel.click();
		tunggu(1);
		selectDropDownLevel.click();
		tunggu(1);
		dropDownTipeKaryawan.click();
		tunggu(1);
		selectDropDownTipeKaryawan.click();
		tunggu(1);
		dropDownDepartemenName.click();
		tunggu(1);
		selectdropDownDepartemenName.click();
		tunggu(1);
		dropDownInputPosisi.click();
		tunggu(1);
		selectDropDownInputPosisi.click();
		tunggu(1);
		dropDownJamKerja.click();
		tunggu(1);
		selectDropDownJamKerja.click();
		tunggu(1);
//		dropDownLeader.click();
//		tunggu(1);
//		selectDropDownLeader.click();
//		tunggu(1);
//		dropDownSupervisor.click();
//		tunggu(1);
//		selectDropDownSupervisor.click();
//		tunggu(1);
//		dropDownManager.click();
//		tunggu(1);
//		selectDropDownManager.click();
//		tunggu(1);
//		dropDownHead.click();
//		tunggu(1);
//		selectDropDownHead.click();
//		tunggu(1);
//		dropDownGM.click();
//		tunggu(1);
//		selectDropDownGM.click();
//		tunggu(1);
		btnSubmit.click();
		tunggu(5);
	}

	public String getTextSubmit() {
		tunggu(1);
		return textEditSubmit.getText();
	}

	public void rejectData() {
		textEditSubmit.click();
		tunggu(1);
		driver.navigate().back();
		tunggu(1);
		btnReject.click();
		alasanReject.sendKeys("Data Sudah Ada");
		tunggu(2);
		submitReject.click();
		tunggu(5);
	}

	public String getTextReject() {
		tunggu(1);
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