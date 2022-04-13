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

	@FindBy(css = "#navbar-main > div > a")
	WebElement textDashboard;

	public void submitLogin(String username, String password) {
		userName.sendKeys(username);
		userPassword.sendKeys(password);
		btnLogin.click();
	}

	public String getTextDashboard() {
		return textDashboard.getText();
	}
}
