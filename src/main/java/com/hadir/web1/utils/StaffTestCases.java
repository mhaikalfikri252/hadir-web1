package com.hadir.web1.utils;

public enum StaffTestCases {

	T1("Testing View History Staff Page");

	private String testName;

	StaffTestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
