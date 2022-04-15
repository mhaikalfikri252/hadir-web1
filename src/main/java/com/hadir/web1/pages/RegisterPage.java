package com.hadir.web1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	//register page
	@FindBy(linkText = "Register")
	WebElement btnRegister;

	// Search By
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div:nth-child(2) > div > select")
	WebElement dropdown_search;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div.col-lg-4 > div > input")
	WebElement input_keyword;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > form > div > div.col-sm-2 > button")
	WebElement btnSearch;


	//Edit data karyawan
	@FindBy(id = "t1")
	WebElement btnUbahData;

	//Form Edit Data
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div")
	WebElement formActiveElement;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(2) > input")
	WebElement editNama;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(3) > select")
	WebElement editLevel;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(7) > input")
	WebElement editNIK;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(8) > select")
	WebElement editTipeKaryawan;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > div:nth-child(15) > input")
	WebElement editJumlahCuti;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > button")
	WebElement btnSubmit;

	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-success.alert-dismissible.show > span")
	WebElement txtSuccess;




	public void go_to_Register_page() {
		btnRegister.click();
		tunggu(2);
	}

	public void search_data_karyawan() {
		dropdown_search.click();
		for(int i = 1; i<=1;i++) {
			dropdown_search.sendKeys(Keys.DOWN);
		}
		dropdown_search.sendKeys(Keys.ENTER);
		tunggu(2);

		input_keyword.sendKeys("1234567890");
		btnSearch.click();
	}

	public void edit_data_karyawan() {
		btnUbahData.click();
		tunggu(2);
		editNama.sendKeys("Dummy");

		editLevel.click();
		for(int i = 0; i<=3;i++) {
			editLevel.sendKeys(Keys.DOWN);
		}
		editLevel.sendKeys(Keys.ENTER);

		tunggu(2);

		editNIK.sendKeys("0");

		editTipeKaryawan.click();
		for(int i = 0; i<=3;i++) {
			editTipeKaryawan.sendKeys(Keys.DOWN);
		}
		editTipeKaryawan.sendKeys(Keys.ENTER);

		tunggu(2);
		editJumlahCuti.sendKeys("12");
		btnSubmit.click();

	}

	public String get_Txt_Register_Page() {
		return txtSuccess.getText();
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
