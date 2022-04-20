package com.hadir.web1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;


public class SelfRegistPage {

	private WebDriver driver;

	public SelfRegistPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Self Registration")
	WebElement btnSelfRegist;
	
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div > div > div.border-0.card-header > h3")
	WebElement textHome;
	
	
	public void aksesSelfregist() {
		btnSelfRegist.click();
	}
	
	public String TextHome() {
		return textHome.getText();		
	}

}
