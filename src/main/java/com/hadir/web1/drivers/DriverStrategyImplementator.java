package com.hadir.web1.drivers;

import com.hadir.web1.utils.Constants;

public class DriverStrategyImplementator {

	public static DriverStrategy chooseStrategy(String strategy) {

		switch (strategy) {
		case Constants.CHROME:
			return new Chrome();
		case Constants.FIREFOX:
			return new Firefox();
		default:
			return null;
		}
	}
}
