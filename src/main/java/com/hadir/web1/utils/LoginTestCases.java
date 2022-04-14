package com.hadir.web1.utils;

public enum LoginTestCases {

	T1("Testing Login User"), T2("Testing Login Invalid User");

	private String testName;

	LoginTestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
