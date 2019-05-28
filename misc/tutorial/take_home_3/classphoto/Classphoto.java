/*
 * Name       : Andy Lam Kwok Wee
 * Matric No. : A0183821E
 * Plab Acct. :
 */
import java.util.*;

public class Classphoto {
    TreeSet<Student> heap = new TreeSet<>();
	
	private void run() {
        Scanner reader = new Scanner(System.in);
        int numStudents = reader.nextInt();
        heap.add(new Student("Rar", 0));
        for (int i = 0; i < numStudents; i++) {
            String name = reader.next();
            int height = reader.nextInt();
            Student student = new Student(name, height);
            heap.add(student);
            System.out.println(heap.lower(student));
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            sb.append(heap.pollFirst() + " ");
        }
        System.out.println(sb.toString().trim());
    }

	public static void main(String[] args) {
		Classphoto newClassphoto = new Classphoto();
		newClassphoto.run();
	}
}

class Student implements Comparable<Student> {
    int height;
    String name;

    public Student(String name, int height) {
        this.height = height;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public int compareTo(Student other) {
        int diff = this.height - other.height;
        if (diff <= 0) {
            return -1;
        } else {
            return 1;
        }
    }
}