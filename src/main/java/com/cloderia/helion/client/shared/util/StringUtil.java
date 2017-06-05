/**
 * 
 */
package com.cloderia.helion.client.shared.util;

import java.util.Random;

/**
 * @author adrian
 *
 */
public class StringUtil {

	/**
	 * @param string
	 * @return
	 */
	public static Boolean isValidString(String string) {
		if (string == null)
			return false;
		if (string.trim().isEmpty())
			return false;
		return true;
	}

	/**
	 * @return
	 */
	public static String generateRandom(int length) {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < length) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

}
