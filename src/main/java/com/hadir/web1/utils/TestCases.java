package com.hadir.web1.utils;

public enum TestCases {

	T1("Testing Login User"),
	T2("Testing view history Staff Page");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
