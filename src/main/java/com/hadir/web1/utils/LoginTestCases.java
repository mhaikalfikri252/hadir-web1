package com.hadir.web1.utils;

public enum LoginTestCases {

	T1("Testing Login User"), T2("Testing Login Invalid User"), T3("Testing view history Staff Page");

	private String testName;

	LoginTestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
