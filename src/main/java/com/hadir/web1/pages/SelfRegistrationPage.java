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
	WebElement btnSelfRegist;
	
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > h3")
	WebElement textHome;
//	edit data
	@FindBy(id = "t4")
	WebElement btnGoToForm;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > select")
	WebElement drpdwnLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > select > option:nth-child(2)")
	WebElement selectDrpdwnLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div > select")
	WebElement drpdwnTipeKaryawan;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div > select > option:nth-child(3)")
	WebElement selectDrpdwnTipeKaryawan;
	@FindBy(id = "input-deptName")
	WebElement drpdwnDeptname;
	@FindBy(css = "#input-deptName > option:nth-child(5)")
	WebElement selectDrpdwnDeptName;
	@FindBy(id = "input-posisi")
	WebElement drpdwnInpPosisi;
	@FindBy(css = "#input-posisi > option:nth-child(2)")
	WebElement selectDrpdwnInpPosisi;
	@FindBy(id = "input-jam-kerja")
	WebElement drpdwnJamKerja;
	@FindBy(css = "#input-jam-kerja > option:nth-child(2)")
	WebElement selectDrpdwnjamKerja;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(9) > div > div > button")
	WebElement btnSubmit;
	
//	reject data
	@FindBy(id = "t2")
	WebElement btnReject;
	@FindBy(id = "exampleFormControlInput1")
	WebElement alasanReject;
	@FindBy(css = "body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body.text-danger > div > form > button.btn.btn-primary")
	WebElement submitReject;
	
//	assert Text
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > h6:nth-child(1)")
	WebElement TextEditPage;
	@FindBy(css = "body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled")
	WebElement textEditSubmit;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.alert.alert-danger.alert-dismissible.show > span")
	WebElement textReject;
	
	
	public void aksesSelfregist() {
		btnSelfRegist.click();
	}
	
	public String TextHome() {
		return textHome.getText();		
	}
	
	public void goToForm() {
		btnGoToForm.click();
	}
	
	public String TextEdit() {
		return TextEditPage.getText();		
	}
	public void editData() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", drpdwnLevel);
		drpdwnLevel.click();
		selectDrpdwnLevel.click();
		tunggu(2);
		drpdwnTipeKaryawan.click();
		selectDrpdwnTipeKaryawan.click();

		drpdwnDeptname.click();
		selectDrpdwnDeptName.click();
		drpdwnInpPosisi.click();
		selectDrpdwnInpPosisi.click();
		drpdwnJamKerja.click();
		selectDrpdwnjamKerja.click();
		btnSubmit.click();
		tunggu(5);
	}
	
	public String TextSubmit() {
		return textEditSubmit.getText();		
	}
	
	public void reject() {
		tunggu(3);
		textEditSubmit.click();
		driver.navigate().back();
		tunggu(1);
		btnReject.click();
		alasanReject.sendKeys("Data Sudah Ada");
		tunggu(2);
		submitReject.click();
		
	}
	
	
	public String TextReject() {
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