package com.hadir.web1.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class ManageAbsenPointPage {
	WebDriver driver;

	public ManageAbsenPointPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#sidenav-main > div > div > ul > li:nth-child(13) > a")
	WebElement btnManageAbsenPoint;

	// Add Data Absen Point
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > div > button")
	WebElement btnAddDataAbsenPoint;

	@FindBy(id = "zz1")
	List<WebElement> addAbsenLocation;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button.mb-4.btn.btn-primary")
	WebElement btnSearch;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button:nth-child(7)")
	WebElement btnSubmitAdd;

	// Edit Data Absen Point
	@FindBy(id = "t1")
	WebElement btnEdit;

	@FindBy(id = "zz1")
	WebElement editAbsenLocation;

	@FindBy(id = "zz2")
	WebElement EditLatitude;

	@FindBy(id = "zz3")
	WebElement EditLongitude;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button.btn.btn-primary")
	WebElement btnSubmitEdit;

	// Delete Data Absen Point
	@FindBy(id = "t2")
	WebElement btnDelete;

	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement btnSubmitDelete;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span")
	WebElement textSuccessDeleteData;

	public void goToManageAbsenPoint() {
		tunggu(2);
		btnManageAbsenPoint.click();
	}

	public void addManageAbsenPoint() {
		tunggu(3);
		btnAddDataAbsenPoint.click();
		tunggu(2);
		addAbsenLocation.get(0).sendKeys("Rumah");
		tunggu(1);
		addAbsenLocation.get(1).sendKeys("Banda Aceh");
		tunggu(1);
		btnSearch.click();
		tunggu(2);
		btnSubmitAdd.click();
	}

	public void editManageAbsenPoint() {
		tunggu(2);
		btnEdit.click();
		tunggu(2);
		editAbsenLocation.sendKeys("Kantor");
		tunggu(1);
		EditLatitude.sendKeys("123456");
		tunggu(1);
		EditLongitude.sendKeys("098765");
		tunggu(1);
		btnSubmitEdit.click();
	}

	public void deleteManageAbsenPoint() {
		tunggu(2);
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
