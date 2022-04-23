package com.hadir.web1.utils;

public enum TestCases {

	T1("Testing Login Page"), T2("Testing Dashboard Page"), T3("Testing Form Registration Page"),
	T4("Testing Form Registration Invalid"), T5("Testing Staff Page"), T6("Testing Staff Invalid"),
	T7("Testing Register Page"), T8("Testing Reporting Karyawan Page"), T9("Testing Self Registration Page"),
	T10("Testing Manage Tipe Page"), T11("Testing Manage Tipe Invalid"), T12("Testing Manage Hari Cuti Page"),
	T13("Testing Manage Hari Cuti Invalid"), T14("Testing Manage Absen Point Page"),
	T15("Testing Manage Absen Point Invalid"), T16("Testing Manage Posisi Page"), T17("Testing Manage Posisi Invalid"),
	T18("Testing Manage Level Page"), T19("Testing Manage Level Invalid"), T20("Testing Manage Setting Page"),
	T21("Testing Manage Setting Invalid"), T22("Testing Manage Departemen Page"),
	T23("Testing Manage Departemen Invalid"), T24("Testing Login Invalid");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}

}
