package com.hadir.web1.utils;

public enum TestCases {

	T1("Testing Login"), T2("Testing Dashboard"), T3("Testing Form Registration"),
	T4("Testing Form Registration Invalid"), T5("Testing Staff"), T6("Testing Staff Invalid"), T7("Testing Register"),
	T8("Testing Reporting Karyawan"),
//	T9("Testing Self Registration"), 
	T9("Testing Manage Tipe"), T10("Testing Manage Tipe Invalid"), T11("Testing Manage Hari Cuti"),
	T12("Testing Manage Hari Cuti Invalid"), T13("Testing Manage Absen Point"),
	T14("Testing Manage Absen Point Invalid"), T15("Testing Manage Posisi"), T16("Testing Manage Posisi Invalid"),
	T17("Testing Manage Level"), T18("Testing Manage Level Invalid"), T19("Testing Manage Setting"),
	T20("Testing Manage Setting Invalid"), T21("Testing Manage Departemen"), T22("Testing Manage Departemen Invalid"),
	T23("Testing Login Invalid");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}

}
