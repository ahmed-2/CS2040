/*
 * Name       : Muhammad Ahmed bin Anwar Bahajjaj
 * Matric No. :	A0140051A
 * Plab Acct. :	Nil
 */
import java.util.*;

public class Classphoto {
	private void run() {
		Scanner sc = new Scanner(System.in);
		TreeSet<Student> students = new TreeSet<>();
		students.add(new Student("Rar", 0));
		int numStu = sc.nextInt();
		for (int i = 0; i < numStu; i++) {
			Student temp = new Student(sc.next(), sc.nextInt());
			students.add(temp);
			System.out.println(students.lower(temp));
		}
		//System.out.println("Size: "+students.size());
		while(!students.isEmpty()) {
			System.out.print(students.pollFirst());
			if (!students.isEmpty()) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Classphoto newClassphoto = new Classphoto();
		newClassphoto.run();
	}
}

class Student implements Comparable<Student> {
	protected String name;
	protected int order;
	protected int height;
	private static int id = 0;
	
	public Student(String name, int height) {
		this.name = name;
		this.height = height;
		order = id;
		id++;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Student other) {
		int temp = Integer.compare(this.height, other.height);
		if (temp == 0) {
			return Integer.compare(other.order, this.order);
		} else {
			return temp;
		}
	}
}