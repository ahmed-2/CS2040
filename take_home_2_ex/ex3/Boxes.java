/**
 * Name         :	Muhammad Ahmed bin Anwar Bahajjaj
 * Matric. No   :	A0140051A
 * PLab Acct.   :	-
 */

import java.util.*;

public class Boxes {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt(), rows = sc.nextInt(), cols = sc.nextInt();
		String x, y;
		HashMap<String, Boolean> gridBox = new HashMap<>();
		HashMap<String, Boolean> gridRow = new HashMap<>();
		HashMap<String, Boolean> gridCol = new HashMap<>();
		for (int i = 0; i < op; i++) {
			switch(sc.next()) {
				case "SIT":
					x = sc.next();
					y = sc.next();
					gridBox.put(x + " "+ y, true);
					gridRow.put(x, true);
					gridCol.put(y, true); 
					break;
				case "BOX":
					x = sc.next();
					y = sc.next();
					System.out.println(search(gridBox, x + " " + y));
					break;
				case "ROW":
					x = sc.next();
					System.out.println(search(gridRow, x));
					break;
				case "COL":
					y = sc.next();
					System.out.println(search(gridCol, y));
					break;
			}
		}
	}

	public String search(HashMap<String, Boolean> grid, String key) {
		if (grid.containsKey(key)) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static void main(String[] args) {
		Boxes newBoxes = new Boxes();
		newBoxes.run();
	}
}