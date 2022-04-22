package com.hadir.web1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class LoginPage {
	WebDriver driver;

	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#root > div > div.mt--8.container > div > div > div > div > form > div.mb-3.form-group > div > input")
	WebElement userName;

	@FindBy(css = "#root > div > div.mt--8.container > div > div > div > div > form > div:nth-child(2) > div > input")
	WebElement userPassword;

	@FindBy(css = "#root > div > div.mt--8.container > div > div > div > div > form > div.text-center > button")
	WebElement btnLogin;

	@FindBy(css = "#navbar-main > div > ul > li > a > div > span > img")
	WebElement btnProfile;

	@FindBy(css = "#navbar-main > div > ul > li > div > a:nth-child(4)")
	WebElement btnLogout;

	@FindBy(css = "#navbar-main > div > a")
	WebElement textDashboard;

	@FindBy(css = "#root > div > div.mt--8.container > div > div > div > div > div > div > span")
	WebElement textInvalidLogin;

	public void submitLogin(String usernamee, String password) {
		userName.sendKeys(usernamee);
		userPassword.sendKeys(password);
		btnLogin.click();
	}

	public void logoutAction() {
		tunggu(2);
		btnProfile.click();
		tunggu(1);
		btnLogout.click();
		tunggu(1);
		driver.switchTo().alert().accept();
	}

	public String getTextDashboard() {
		return textDashboard.getText();
	}

	public String getTextInvalidLogin() {
		return textInvalidLogin.getText();
	}

	void tunggu(int detik) {
		try {
			Thread.sleep(detik * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
