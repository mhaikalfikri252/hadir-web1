package com.hadir.web1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class ManageTipePage {
	WebDriver driver;

	public ManageTipePage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Manage Tipe")
	WebElement btnManageTipe;

	@FindBy(css = "#navbar-main > div > a")
	WebElement textManageTipe;

	@FindBy(css = "#navbar-main > div > form > div > div > input")
	WebElement search;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-header > button")
	WebElement btnClosePopUp;

	// Add Data Tipe
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > div > button")
	WebElement btnAddDataTipe;

	@FindBy(id = "zz1")
	WebElement addTipe;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button.btn.btn-primary")
	WebElement btnSubmitAdd;

	// Edit Data Tipe
	@FindBy(id = "t1")
	WebElement btnEdit;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > button.btn.btn-primary")
	WebElement btnSubmitEdit;

	// Delete Data Tipe
	@FindBy(id = "t2")
	WebElement btnDelete;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement btnSubmitDelete;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div[2]/span")
	WebElement textSuccessDeleteData;

	public void goToManageTipe() {
		tunggu(2);
		btnManageTipe.click();
	}

	public void addDataTipe() {
		tunggu(3);
		btnAddDataTipe.click();
		tunggu(2);
		addTipe.sendKeys("Magang");
		tunggu(1);
		btnSubmitAdd.click();
	}

	public void addDataTipeInvalid() {
		tunggu(3);
		btnAddDataTipe.click();
		tunggu(2);
		btnSubmitAdd.click();
		tunggu(2);
		btnClosePopUp.click();
	}

	public void editDataTipe() {
		tunggu(2);
		btnEdit.click();
		tunggu(2);
		addTipe.clear();
		tunggu(1);
		addTipe.sendKeys("Internship");
		tunggu(1);
		btnSubmitEdit.click();
	}

	public void editDataTipeInvalid() {
		tunggu(2);
		btnEdit.click();
		tunggu(2);
		addTipe.clear();
		tunggu(2);
		btnSubmitEdit.click();
		tunggu(2);
		btnClosePopUp.click();
	}

	public void deleteDataTipe() {
		tunggu(3);
		btnDelete.click();
		tunggu(2);
		btnSubmitDelete.click();
	}

	public void searchDataTipe() {
		tunggu(1);
		search.sendKeys("Internship");
		search.sendKeys(Keys.ENTER);
	}

	public String getTextSuccessDeleteData() {
		return textSuccessDeleteData.getText();
	}

	public String getTextManageTipe() {
		return textManageTipe.getText();
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
