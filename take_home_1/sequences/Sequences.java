/**
 * Name         :	Ahmed Bahajjaj
 * Matric. No   :	A0140051A
 * PLab Acct.   :
 */

import java.util.*;

public class Sequences {
	private void run() {
		Scanner sc = new Scanner(System.in);
		/**
		 * 	number:	number of repetitions
		 * 	type:	arithmetic vs geometric choice
		 * 	first:	'A' value, first starting point
		 * 	factor:	Factor to increment or multiply (depending on type)
		 * 	value:	value that will be written to (to keep 'first' value intact)
		 *  */	
		long number, type, first, factor;
		long value = 0;

		number = sc.nextLong();
		type = sc.nextLong();
		first = sc.nextLong();
		factor = sc.nextLong();

		//First select type
		if (type == 1) {
			//Loop through imperatively with appropriate increments
			for (int i = 0; i < number; i++) {
				if (i == 0) {
					value = first;
					System.out.print(value);
				} else {
					value += factor;
					System.out.print(" " + value);
				}
			}
		} else if (type == 2) {
			//Loop through imperatively with appropriate increments
			for (int i = 0; i < number; i++) {
				if (i == 0) {
					value = first;
					System.out.print(value);
				} else {
					value *= factor;
					System.out.print(" " + value);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Sequences newSequences = new Sequences();
		newSequences.run();
	}
}
