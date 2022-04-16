package com.hadir.web1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web1.drivers.DriverSingleton;

public class DashboardPage {

	private WebDriver driver;

	public DashboardPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Dashboard")
	WebElement btnDashboard;

	@FindBy(css = "#root > div > div.header.bg-gradient-info.pb-8.pt-5.pt-md-8 > div > div > div:nth-child(1) > div:nth-child(1) > a > div > div > div > div:nth-child(1)")
	WebElement cardStaff;
	@FindBy(css = "#root > div > div.header.bg-gradient-info.pb-8.pt-5.pt-md-8 > div > div > div:nth-child(1) > div:nth-child(2) > a > div > div > div")
	WebElement cardLeader;
	@FindBy(css = "#root > div > div.header.bg-gradient-info.pb-8.pt-5.pt-md-8 > div > div > div:nth-child(1) > div:nth-child(3) > a > div > div > div")
	WebElement cardChanReq;
	@FindBy(css = "#root > div > div.header.bg-gradient-info.pb-8.pt-5.pt-md-8 > div > div > div.mt-4.row > div:nth-child(1) > a > div > div")
	WebElement cardSupervisor;
	@FindBy(css = "#root > div > div.header.bg-gradient-info.pb-8.pt-5.pt-md-8 > div > div > div.mt-4.row > div:nth-child(2) > a > div > div")
	WebElement cardManager;
	@FindBy(css = "#root > div > div.header.bg-gradient-info.pb-8.pt-5.pt-md-8 > div > div > div.mt-4.row > div:nth-child(3) > a > div > div")
	WebElement cardHead;
	@FindBy(css = "#root > div > div.mt--8.container-fluid > div > div.mb-5.col-xl-6 > div > div.border-0.card-header > div > div.col.text-right > a")
	WebElement btnSeeAll;

	@FindBy(css = "#navbar-main > div > form > div")
	WebElement inputSearch;

	@FindBy(css = "#navbar-main > div > a")
	WebElement textDashboard;

	public void go_to_cardStaff() {
		cardStaff.click();
		tunggu(2);
		btnDashboard.click();
	}

	public void go_to_cardLeader() {
		cardLeader.click();
		tunggu(2);
		btnDashboard.click();
	}

	public void go_to_cardChanReq() {
		cardChanReq.click();
		tunggu(2);
		btnDashboard.click();
	}

	public void go_to_cardSupervisor() {
		cardSupervisor.click();
		tunggu(2);
		btnDashboard.click();
	}

	public void go_to_cardManager() {
		cardManager.click();
		tunggu(2);
		btnDashboard.click();
	}

	public void go_to_cardHead() {
		cardHead.click();
		tunggu(2);
		btnDashboard.click();
	}

	public void go_to_btnSeeAll() {
		btnSeeAll.click();
		tunggu(2);
		btnDashboard.click();
	}

	public void search(String search) {
		inputSearch.sendKeys(search);
		inputSearch.sendKeys(Keys.ENTER);
	}

	public String getTextDashboard() {
		return textDashboard.getText();
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
