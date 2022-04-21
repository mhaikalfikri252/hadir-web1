package com.hadir.web1.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class FormRegistPage {

	private WebDriver driver;

	public FormRegistPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Form Registration")
	WebElement btnFormRegist;
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
	WebElement drpdwnLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > select > option:nth-child(5)")
	WebElement selectDrpdwnLevel;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div > select > option:nth-child(5)")
	WebElement drpdwnTipeKrywn;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div > select > option:nth-child(3)")
	WebElement selectDrpdwnTipeKrywn;
	@FindBy(id = "input-deptName")
	WebElement drpdwnDepart;
	@FindBy(css = "#input-deptName > option:nth-child(5)")
	WebElement selectDrpdwnDepart;
	@FindBy(id = "input-posisi")
	WebElement drpdwnPosisi;
	@FindBy(css = "#input-posisi > option:nth-child(16)")
	WebElement selectDrpdwnPosisi;
	@FindBy(id = "input-jam-kerja")
	WebElement drpdwnJamKerja;
	@FindBy(css = "#input-jam-kerja > option:nth-child(2)")
	WebElement selectDrpdwnJamKerja;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(4) > div > div > div > div:nth-child(1) > input")
	WebElement inputJamMasuk;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(5) > div:nth-child(4) > div > div > div > div:nth-child(2) > input")
	WebElement inputJamKeluar;
	@FindBy(id = "input-lokasi")
	WebElement drpdwnLokasi;
	@FindBy(css = "#input-lokasi > option:nth-child(3)")
	WebElement selectDrpdwnLokasi;
	@FindBy(css =  "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(9) > div > div > button")
	WebElement btnSubmit;
	
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div > select")
	WebElement drpdwnLeader;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div > select > option:nth-child(2)")
	WebElement selectDrpdwnLeader;
	
	
//	assert txt
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.bg-white.border-0.card-header > div > div.col-8 > h3")
	WebElement textHome;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(2) > div:nth-child(1) > div > div > small")
	WebElement textValidFoto;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div.bg-secondary.shadow.card > div.card-body > form > div:nth-child(2) > div:nth-child(1) > div > div > small")
	WebElement textInvalidFoto;
	@FindBy(css = "body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled")
	WebElement textOK;
	
	public void goToFormRegist() {
		btnFormRegist.click();
	}
	
	public String textHome() {
		return textHome.getText();
	}
	
	public void invalidFoto() {
		tunggu(2);
		inputFotoWajah.sendKeys("C:\\Users\\Roby\\Pictures\\Saved Pictures\\random1.png");
	}
	
	public String textInvalidFoto() {
		tunggu(5);
		return textInvalidFoto.getText();
	}
	
	public void validFoto() {
		tunggu(2);
		inputFotoWajah.sendKeys("C:\\Users\\Roby\\Pictures\\Saved Pictures\\fotoku.png");
	}
	
	public String textValidFoto() {
		tunggu(5);
		return textInvalidFoto.getText();
	}
	
	public void inputForm() {
		inputUsername.sendKeys("DummyDatatiga");
		inputEmail.sendKeys("dummydua@gmail.com");
		inputFullName.sendKeys("Data Dummyy tiga");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", inputPassword);
		inputPassword.sendKeys("12345678");
		inputImei.sendKeys("jhvjhlsdnmvbs09a");
		js.executeScript("arguments[0].scrollIntoView();", inputNik);
		inputNik.sendKeys("16170033");
		drpdwnLevel.click();
		selectDrpdwnLevel.click();
		drpdwnTipeKrywn.click();
		selectDrpdwnTipeKrywn.click();
		drpdwnDepart.click();
		selectDrpdwnDepart.click();
		drpdwnPosisi.click();
		selectDrpdwnPosisi.click();
		tunggu(1);
		drpdwnJamKerja.click();
		selectDrpdwnJamKerja.click();
		inputJamMasuk.sendKeys("09.00");
		inputJamKeluar.sendKeys("04.00");
		tunggu(1);
		js.executeScript("arguments[0].scrollIntoView();", btnSubmit);
		btnSubmit.click();
//		drpdwnLeader.click();
//		selectDrpdwnLeader.click();
		

	}
	
	public String TextSuccess() {
	return textOK.getText();	
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


	

