package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author PhucTV7
 *
 */
public class Validator {

	private static Matcher matcher;
	private static Pattern pattern;
	
	/**
	 * @param email
	 * @return true if email is valid, otherwise return false
	 */
	public static boolean isEmail(String email) {
		pattern = Pattern.compile(Constant.EMAIL);
		matcher = pattern.matcher(email);
		return matcher.matches();
		
	}
	
	
	/**
	 * @param phone
	 * @return true if phone is valid, otherwise return false
	 */
	public static boolean isPhoneNumber(String phone) {
		pattern = Pattern.compile(Constant.PHONE);
		matcher = pattern.matcher(phone);
		return matcher.matches();
		
	}
}
