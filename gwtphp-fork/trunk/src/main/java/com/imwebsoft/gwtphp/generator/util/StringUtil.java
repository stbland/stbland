package com.imwebsoft.gwtphp.generator.util;

/**
 * @author Mile
 * 
 */
public class StringUtil {

	/**
	 * 
	 * @param string
	 * @return
	 */

	public static String getFirstLetterUp(String string) {
		String result;
		result = string.substring(0, 1).toUpperCase();
		if (string.length() > 1) {
			result += string.substring(1, string.length());
		}
		return result;
	}
}
