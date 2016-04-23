package com.web.util;

public class Translate {
	public static String translate(String source) {
		if (source.equals("B超")) {
			return "B_ultrasonic";
		}
		if (source.equals("X光")) {
			return "X_Rate";
		}
		if (source.equals("CT")) {
			return "CT";
		}

		if (source.equals("MRI")) {
			return "MRI";
		}

		return "";
	}

}
