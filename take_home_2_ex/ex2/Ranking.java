/**
 * Name         :	Muhammad Ahmed bin Anwar Bahajjaj
 * Matric. No   :	A0140051A
 * PLab Acct.   :	-
 */

import java.util.*;

public class Ranking {
	private void run() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<>();
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			list.add(new Student(sc.next(), sc.nextInt()));
		}
		InputComparator inComp = new InputComparator();		
		ScoreComparator scComp = new ScoreComparator();
		Collections.sort(list, scComp);
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				list.get(i).setRank(i+1);
			} else if (list.get(i).getScore() == list.get(i-1).getScore()) {
				list.get(i).setRank(list.get(i-1).getRank());
			} else {
				list.get(i).setRank(i+1 );
			}
		}
		Collections.sort(list, inComp);
        for (Student stu : list) {
			System.out.println(stu);
		}
	}

	public static void main(String[] args) {
		Ranking newRanking = new Ranking();
		newRanking.run();
	}
}
