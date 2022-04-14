package com.hadir.web1.utils;

public enum StaffTestCases {

	T1("Customer klik Staff");

	private String testName;

	StaffTestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
