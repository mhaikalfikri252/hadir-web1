package com.hadir.web1.pages;

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

	@FindBy(css = "#sidenav-main > div > div > ul > li:nth-child(11) > a")
	WebElement btnManageTipe;

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

	public void addManageTipe() {
		tunggu(3);
		btnAddDataTipe.click();
		tunggu(2);
		addTipe.sendKeys("Test");
		tunggu(1);
		btnSubmitAdd.click();
	}

	public void editManageTipe() {
		tunggu(2);
		btnEdit.click();
		tunggu(2);
		addTipe.clear();
		tunggu(1);
		addTipe.sendKeys("Test Edit");
		tunggu(1);
		btnSubmitEdit.click();
	}

	public void deleteManageTipe() {
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
