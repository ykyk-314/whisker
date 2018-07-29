package com.internousdev.whisker.util;

public class InputChecker {

	public static boolean length(String value, int min, int max){
		return min <= value.length() && value.length() <= max;
	}
}
