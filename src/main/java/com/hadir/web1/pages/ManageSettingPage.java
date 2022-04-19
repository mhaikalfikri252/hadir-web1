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
	
	// menu manage setting
	@FindBy(css="#root > div > div.mt--8.container-fluid > div > div > div.shadow.card > div.table-responsive > table > tbody > tr > td:nth-child(4) > div > div:nth-child(2)")
	WebElement switchLiveness;
	@FindBy(id="t1")
	WebElement btnEditMngSetting;
	@FindBy(css="#sidenav-main > div > div > ul > li:nth-child(16) > a")
	WebElement btnMngSetting;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span")
	WebElement txtSuccessMngSet;
	
	//form edit manage setting
	@FindBy(id= "zz1")
	List<WebElement> inputValidationTimer;
	@FindBy(css= "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > button.btn.btn-primary")
	WebElement btnSubmitMngSetting;
	@FindBy(css="body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > form > button.btn.btn-secondary")
	WebElement btnClose;
	
	public void goToManageSetting() {
		btnMngSetting.click();
		tunggu(2);
	}
	
	public void ubah_Data() {
		tunggu(5);
		btnEditMngSetting.click();
		tunggu(2);
		inputValidationTimer.get(0).clear();
		tunggu(2);
		inputValidationTimer.get(0).sendKeys("200");
		tunggu(2);
		inputValidationTimer.get(1).clear();
		tunggu(2);
		inputValidationTimer.get(1).sendKeys("100");
		tunggu(2);
		btnSubmitMngSetting.click();
		tunggu(2);
		btnClose.click();
	}
	
	public void change_liveness() {
		tunggu(2);
		switchLiveness.click();
		tunggu(5);
	}
	
	public String getTxtManageSettingPage() {
		return txtSuccessMngSet.getText();
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
