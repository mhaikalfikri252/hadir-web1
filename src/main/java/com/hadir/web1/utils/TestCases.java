package com.hadir.web1.utils;

public enum TestCases {

	T1("Testing Login User");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
