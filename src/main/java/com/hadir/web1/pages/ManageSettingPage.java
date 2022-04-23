package com.hadir.web1.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class ManageSettingPage {

	WebDriver driver;

	public ManageSettingPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Manage Setting")
	WebElement btnManageSetting;

	@FindBy(css = "#navbar-main > div > a")
	WebElement textManageSetting;

	// Menu Manage Setting
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.shadow.card > div.table-responsive > table > tbody > tr > td:nth-child(4) > div > div:nth-child(2)")
	WebElement switchLiveness;
	@FindBy(id = "t1")
	WebElement btnEditManageSetting;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span")
	WebElement textSuccessManageSetting;

	// Form Edit Manage Setting
	@FindBy(id = "zz1")
	List<WebElement> inputValidationTimer;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > button.btn.btn-primary")
	WebElement btnSubmitManageSetting;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > button.btn.btn-secondary")
	WebElement btnClose;

	public void goToManageSetting() {
		btnManageSetting.click();
		tunggu(2);
	}

	public void ubahData() {
		tunggu(5);
		btnEditManageSetting.click();
		tunggu(2);
		inputValidationTimer.get(0).clear();
		tunggu(2);
		inputValidationTimer.get(0).sendKeys("200");
		tunggu(2);
		inputValidationTimer.get(1).clear();
		tunggu(2);
		inputValidationTimer.get(1).sendKeys("100");
		tunggu(2);
		btnSubmitManageSetting.click();
		tunggu(2);
		btnClose.click();
	}

	public void ubahDataInvalid() {
		tunggu(5);
		btnEditManageSetting.click();
		tunggu(2);
		inputValidationTimer.get(0).clear();
		inputValidationTimer.get(1).clear();
		tunggu(2);
		btnSubmitManageSetting.click();
		tunggu(2);
		inputValidationTimer.get(1).sendKeys("100");
		tunggu(2);
		btnSubmitManageSetting.click();
		tunggu(2);
		btnClose.click();
	}

	public void changeLiveness() {
		tunggu(2);
		switchLiveness.click();
		tunggu(5);
	}

	public String getTextSuccessManageSetting() {
		return textSuccessManageSetting.getText();
	}

	public String getTextManageSetting() {
		return textManageSetting.getText();
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
