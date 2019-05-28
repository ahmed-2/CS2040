/**
 *
 * author	: [Ahmed Bahajjaj]
 * matric no: [A0140051A]
 * 
 */

import java.util.*;

public class StringComparison {
	
	public static void main(String[] args) {

		// declare the necessary variables (including scanner)
		Scanner sc = new Scanner(System.in);
		String first, second;
		int value;

		// read input and process them accordingly
		first = sc.next();
		second = sc.next();

		value = first.compareToIgnoreCase(second);
		if (value < 0) {
			System.out.println(1);
		} else if (value > 0) {
			System.out.println(2);
		} else if (value == 0) {
			System.out.println(0);
		} else {

		}
	}
}
