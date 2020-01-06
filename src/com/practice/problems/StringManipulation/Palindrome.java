package com.practice.problems.StringManipulation;

public class Palindrome {

	public static void main(String[] args) {

		String str = "Madam";
		palindrome(str);

	}

	private static boolean palindrome(String str) {
		char[] charArray = str.toCharArray();
		int length = charArray.length;
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - i - 1))
				return false;
		}
		return true;
	}
	
	private static String removeChar(String str, char c) {
        if (str == null)
            return null;
        return str.replaceAll(Character.toString(c), "");
    }

	
}
