/**
 *
 * author	: [Ahmed Bahajjaj]
 * matric no: [A0140051A]
 * 
 */

import java.util.*;

public class HelloWorld {
	
	public static void main(String[] args) {

		// declare the necessary variables
		int select, line;
		String value, operator;
		int[] operand = new int[2];
		List<Integer> output = new ArrayList<>();

		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
		select = sc.nextInt();
		if (select == 1) {
			line = sc.nextInt();
			//int[] output = new int[line];
			for (int i = 0; i < line; i++) {
				operator = sc.next();
				operand[0] = sc.nextInt();
				operand[1] = sc.nextInt();
				if (opTest(operator)) {
					output.add(and(operand[0], operand[1]));
				} else {
					output.add(or(operand[0], operand[1]));
				}
			}
			run(output);
		} else if (select == 2) {
			value = "0";
			while (sc.hasNext()) {
				operator = sc.next();
				if (operator.equals(value)){
					break;
				} else {
					operand[0] = sc.nextInt();
					operand[1] = sc.nextInt();
					if (opTest(operator)) {
						output.add(and(operand[0], operand[1]));
					} else {
						output.add(or(operand[0], operand[1]));
					}
				}
			}
			run(output);
		} else if (select == 3) {
			while (sc.hasNext()) {
				operator = sc.next();
				operand[0] = sc.nextInt();
				operand[1] = sc.nextInt();
				if (opTest(operator)) {
					output.add(and(operand[0], operand[1]));
				} else {
					output.add(or(operand[0], operand[1]));
				}
			}
			run(output);
		} else {
			//System.out.println();
		}
	}

	public static void run (List<Integer> output) {
		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}
	}

	public static int and (int x, int y) {
		if (x == 1 && y == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int or (int x, int y) {
		if (x == 0 && y == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	public static boolean opTest(String operator) {
		if (operator.equals("AND")) {
			return true;
		} else {
			return false;
		}
	}
}
