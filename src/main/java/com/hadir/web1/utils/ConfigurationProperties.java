package com.hadir.web1.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;

	@Value("${email}")
	private String email;

	@Value("${usernamee}")
	private String userName;

	@Value("${password}")
	private String password;

	@Value("${textInvalidLogin}")
	private String textInvalidLogin;

	@Value("${textDashboard}")
	private String textDashboard;

	@Value("${txtEditPage}")
	private String txtEditPage;

	@Value("${txtRegisterPage}")
	private String txtRegisterPage;

	@Value("${txtBerhasilUpdateData}")
	private String txtBerhasilUpdateData;

	@Value("${txtHapusPosisi}")
	private String txtHapusPosisi;

	@Value("${txtShiftPage}")
	private String txtShiftPage;

	@Value("${textBerhasilHapusDataTipe}")
	private String textBerhasilHapusDataTipe;
	
	@Value("${TxtSuccessTambahData}")
	private String TxtSuccessTambahData;

	@Value("${txtSuccessMngSet}")
	private String txtSuccessMngSet;

	public String getTxtSuccessTambahData() {
		return TxtSuccessTambahData;
	}
	
	public String getTxtSuccessMngSet() {
		return txtSuccessMngSet;
	}

	public String getTextBerhasilHapusDataTipe() {
		return textBerhasilHapusDataTipe;
	}

	public String getBrowser() {
		return browser;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public String getTextInvalidLogin() {
		return textInvalidLogin;
	}

	public String getTextDashboard() {
		return textDashboard;
	}

	public String getTxtEditPage() {
		return txtEditPage;
	}

	public String getTxtRegisterPage() {
		return txtRegisterPage;
	}

	public String getTxtManagePosisiPage() {
		return txtBerhasilUpdateData;
	}

	public String getTxtHapusPosisi() {
		return txtHapusPosisi;
	}

	public String getTxtShiftPage() {
		return txtShiftPage;
	}
}