package com.hadir.web1.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class FormRegistrationPage {

	private WebDriver driver;

	public FormRegistrationPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Form Registration")
	WebElement btnFormRegistration;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(2) > div:nth-child(1) > div > div > input")
	WebElement inputFotoWajah;
	@FindBy(id = "input-username")
	WebElement inputUsername;
	@FindBy(id = "input-email")
	WebElement inputEmail;
	@FindBy(id = "input-first-name")
	WebElement inputFullName;
	@FindBy(id = "input-password")
	WebElement inputPassword;
	@FindBy(id = "input-imei")
	WebElement inputImei;
	@FindBy(id = "input-nik")
	WebElement inputNik;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > select")
	WebElement dropDownLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > select > option:nth-child(5)")
	WebElement selectdropDownLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > select > option:nth-child(5)")
	WebElement dropDownTipeKaryawan;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div > select > option:nth-child(3)")
	WebElement selectDropDownTipeKaryawan;
	@FindBy(id = "input-deptName")
	WebElement dropDownDepartemen;
	@FindBy(css = "#input-deptName > option:nth-child(5)")
	WebElement selectdropDownDepartemen;
	@FindBy(id = "input-posisi")
	WebElement dropDownPosisi;
	@FindBy(css = "#input-posisi > option:nth-child(16)")
	WebElement selectDropDownPosisi;
	@FindBy(id = "input-jam-kerja")
	WebElement dropDownJamKerja;
	@FindBy(css = "#input-jam-kerja > option:nth-child(2)")
	WebElement selectDropDownJamKerja;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(4) > div > div > div > div:nth-child(1) > input")
	WebElement inputJamMasuk;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(4) > div > div > div > div:nth-child(2) > input")
	WebElement inputJamKeluar;
	@FindBy(id = "input-lokasi")
	WebElement dropDownLokasi;
	@FindBy(css = "#input-lokasi > option:nth-child(3)")
	WebElement selectDropDownLokasi;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(9) > div > div > button")
	WebElement btnSubmit;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div > select")
	WebElement dropDownLeader;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div > select > option:nth-child(2)")
	WebElement selectDropdownLeader;

	// Assert Text
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.bg-white.border-0.card-header > div > div.col-8 > h3")
	WebElement textHome;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(2) > div:nth-child(1) > div > div > small")
	WebElement textValidFoto;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(2) > div:nth-child(1) > div > div > small")
	WebElement textInvalidFoto;
	@FindBy(css = "body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled")
	WebElement textOK;

	public void goToFormRegistration() {
		btnFormRegistration.click();
	}

	public String getTextHome() {
		return textHome.getText();
	}

	public void invalidFoto() {
		tunggu(2);
//		inputFotoWajah.sendKeys("C:\\Users\\Roby\\Pictures\\Saved Pictures\\random1.png");
		inputFotoWajah.sendKeys("C:\\Users\\M Haikal Fikri\\Pictures\\Sticker Logo\\Flutter.png");
	}

	public String textInvalidFoto() {
		tunggu(8);
		return textInvalidFoto.getText();
	}

	public void validFoto() {
		tunggu(2);
//		inputFotoWajah.sendKeys("C:\\Users\\Roby\\Pictures\\Saved Pictures\\fotoku.png");
		inputFotoWajah.sendKeys("C:\\Users\\M Haikal Fikri\\Pictures\\test\\foto.jpg");
	}

	public String textValidFoto() {
		tunggu(5);
		return textInvalidFoto.getText();
	}

	public void inputForm() {
		tunggu(3);
//		inputFotoWajah.sendKeys("C:\\Users\\Roby\\Pictures\\Saved Pictures\\fotoku.png");
		inputFotoWajah.sendKeys("C:\\Users\\M Haikal Fikri\\Pictures\\test\\foto.jpg");
		tunggu(5);
		inputUsername.sendKeys("DummyDatatiga");
		tunggu(3);
		inputEmail.sendKeys("dummydua@gmail.com");
		tunggu(1);
		inputFullName.sendKeys("Data Dummyy tiga");
		tunggu(1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", inputPassword);
		tunggu(1);
		inputPassword.sendKeys("12345678");
		tunggu(1);
		inputImei.sendKeys("jhvjhlsdnmvbs09a");
		tunggu(1);
		js.executeScript("arguments[0].scrollIntoView();", inputNik);
		tunggu(1);
		inputNik.sendKeys("16170033");
		tunggu(1);
		dropDownLevel.click();
		tunggu(1);
		selectdropDownLevel.click();
		tunggu(1);
		dropDownTipeKaryawan.click();
		tunggu(1);
		selectDropDownTipeKaryawan.click();
		tunggu(1);
		dropDownDepartemen.click();
		tunggu(1);
		selectdropDownDepartemen.click();
		tunggu(1);
		dropDownPosisi.click();
		tunggu(1);
		selectDropDownPosisi.click();
		tunggu(1);
		dropDownJamKerja.click();
		tunggu(1);
		selectDropDownJamKerja.click();
		tunggu(1);
		inputJamMasuk.sendKeys("09.00");
		tunggu(1);
		inputJamKeluar.sendKeys("04.00");
		tunggu(1);
		js.executeScript("arguments[0].scrollIntoView();", btnSubmit);
		btnSubmit.click();
		tunggu(5);
//		dropDownLeader.click();
//		selectDropdownLeader.click();
	}

	public String getTextSuccess() {
		return textOK.getText();
	}

	public void goToFormRegistrationInvalid() {
		textOK.click();
		tunggu(1);
		btnFormRegistration.click();
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