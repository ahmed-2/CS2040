/*
 * author		: [Ahmed Bahajjaj]
 * matric no.	: [A0140051A]
 */

import java.util.*;

public class Palindrome {
	/* use this method to check whether the string is palindrome word or not
	 * 		PRE-Condition  : Input must be a string
	 * 		POST-Condition : Returns true if string is a palindrome (ignores case sensitivity), returns false otherwise
	 */
	public static boolean isPalindrome(String word) {
		String first, last;
		int size = word.length();
		if (size > 2) {
			first = word.substring(0,1);
			last = word.substring(size - 1, size);
			if (first.equalsIgnoreCase(last)) {
				return isPalindrome(word.substring(1, size - 1));
			} else {
				return false;
			}
		} else if (size == 2) {
			first = word.substring(0,1);
			last = word.substring(1,2);
			return first.equalsIgnoreCase(last);
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		// declare the necessary variables (and scanner object)
		Scanner sc = new Scanner(System.in);
		String first, second, combined;

		// read input and process them accordingly
		first = sc.next();
		second = sc.next();
		combined = first + second;

		// simulate and output
		if (isPalindrome(combined)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}