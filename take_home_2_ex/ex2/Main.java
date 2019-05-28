/**
 * Name         :	Muhammad Ahmed bin Anwar Bahajjaj
 * Matric. No   :	A0140051A
 * PLab Acct.   :	-
 */

import java.util.*;

class Main {
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
		Main newRanking = new Main();
		newRanking.run();
	}
}

class Student {
    private static int x = 0;
    private String _name;
    private int _score;
    private int _rank;
    private int _order;

    public Student(String name, int score) {
        _name = name;
        _score = score;
        _order = x;
        x++;
    }

    public int getScore() {
        return _score;
    }

    public int getOrder() {
        return _order;
    }

    public int getRank() {
        return _rank;
    }

    public void setRank(int rank) {
        _rank = rank;
    }

    @Override
    public String toString() {
        return _name + " " + _rank;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Student) {
            Student b = (Student) other;
            return this._name.equals(b._name) && 
                this._score == b._score;
        }
        else 
            return false;
    }
}

class InputComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y){
        return Integer.compare(x.getOrder(), y.getOrder());
    }
}

class ScoreComparator implements Comparator<Student> {
    @Override   //Higher Score will be 'First'
    public int compare(Student x, Student y){
        return Integer.compare(y.getScore(), x.getScore());
    }
}
