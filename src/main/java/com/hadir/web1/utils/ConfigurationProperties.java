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

	@Value("${textGagal}")
	private String textGagal;

	@Value("${textTambahData}")
	private String textTambahData;

	@Value("${textUpdateData}")
	private String textUpdateData;

	@Value("${textHapusData}")
	private String textHapusData;

	@Value("${textSuccessExport}")
	private String textSuccessExport;

	@Value("${textReportingKaryawan}")
	private String textReportingKaryawan;

	@Value("${textManageTipe}")
	private String textManageTipe;

	@Value("${textManageLevel}")
	private String textManageLevel;

	@Value("${textManageAbsenPoint}")
	private String textManageAbsenPoint;

	@Value("${textManageSetting}")
	private String textManageSetting;

	@Value("${textReject}")
	private String textReject;

	@Value("${textManageDepartemen}")
	private String textManageDepartemen;

	@Value("${textInvalidFormStaff}")
	private String textInvalidFormStaff;

	@Value("${textInvalidFormRegistration}")
	private String textInvalidFormRegistration;

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

	public String getTextGagal() {
		return textGagal;
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

	public String getTextSuccessExport() {
		return textSuccessExport;
	}

	public String getTextReportingKaryawan() {
		return textReportingKaryawan;
	}

	public String getTextManageTipe() {
		return textManageTipe;
	}

	public String getTextManageLevel() {
		return textManageLevel;
	}

	public String getTextManageAbsenPoint() {
		return textManageAbsenPoint;
	}

	public String getTextManageSetting() {
		return textManageSetting;
	}

	public String getTextReject() {
		return textReject;
	}

	public String getTextInvalidFormStaff() {
		return textInvalidFormStaff;
	}

	public String getTextInvalidFormRegistration() {
		return textInvalidFormRegistration;
	}

	public String getTextManageDepartemen() {
		return textManageDepartemen;
	}

}