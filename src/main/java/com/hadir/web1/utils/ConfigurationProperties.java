package com.hadir.web1.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;

	@Value("${usernamee}")
	private String userName;

	@Value("${password}")
	private String password;

	@Value("${textInvalidLogin}")
	private String textInvalidLogin;

	@Value("${textDashboard}")
	private String textDashboard;

	@Value("${textOk}")
	private String textOk;

	@Value("${textTambahData}")
	private String textTambahData;

	@Value("${textUpdateData}")
	private String textUpdateData;

	@Value("${textHapusData}")
	private String textHapusData;

	@Value("${textHapusAbsenPoint}")
	private String textHapusAbsenPoint;

	@Value("${textSuccessExport}")
	private String textSuccessExport;

	@Value("${textSuccessMngSet}")
	private String textSuccessMngSet;

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

	public String getTextOk() {
		return textOk;
	}

	public String getTextTambahData() {
		return textTambahData;
	}

	public String getTextUpdateData() {
		return textUpdateData;
	}

	public String getTextHapusData() {
		return textHapusData;
	}

	public String getTextHapusAbsenPoint() {
		return textHapusAbsenPoint;
	}

	public String getTextSuccessExport() {
		return textSuccessExport;
	}

	public String getTextSuccessMngSet() {
		return textSuccessMngSet;
	}

}