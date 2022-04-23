package com.hadir.web1.utils;

public enum TestCases {

	T1("Testing Login Page"), T2("Testing Dashboard Page"), T3("Testing Form Registration Page"),
	T4("Testing Form Registration Invalid Page"), T5("Testing Staff Page"), T6("Testing Staff Invalid Page"),
	T7("Testing Register Page"), T8("Testing Reporting Karyawan Page"), T9("Testing Self Registration Page"),
	T10("Testing Manage Tipe Page"), T11("Testing Manage Tipe Invalid Page"), T12("Testing Manage Hari Cuti Page"),
	T13("Testing Manage Hari Cuti Invalid Page"), T14("Testing Manage Absen Point Page"),
	T15("Testing Manage Absen Point Invalid Page"), T16("Testing Manage Posisi Page"),
	T17("Testing Manage Posisi Invalid Page"), T18("Testing Manage Level Page"),
	T19("Testing Manage Level Invalid Page"), T20("Testing Manage Setting Page"),
	T21("Testing Manage Setting Invalid Page"), T22("Testing Manage Departemen Page"),
	T23("Testing Manage Departemen Invalid Page"), T24("Testing Login Invalid Page");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}

}
