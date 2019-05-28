/**
 * Name         :   Ahmed Bahajjaj
 * Matric. No   :   A0140051A
 * PLab Acct.   :
 */

import java.util.*;

public class Ballpassing {
    private void run() {
        //Variable Declarations
        Scanner sc = new Scanner(System.in);
        int numStu, numEvent;
        LinkedList<String> students = new LinkedList<>();

        //Reading of students & number of events
        numStu = sc.nextInt();
        for (int i = 0; i < numStu; i++) {
            students.add(sc.next());
        }
        numEvent = sc.nextInt();

        //Commence iteration of student list to pass ball
        ListIterator<String> iter = students.listIterator();
        iter.next();
        for (int i = 0; i < numEvent; i++) {

            //Switch case on Event call
            switch(sc.next()) {
                case "NEXT":
                    if (!iter.hasNext()) {
                        iter = students.listIterator();
                    }
                    System.out.println(iter.next());
                    break;
                case "JOIN":
                    iter.add(sc.next());
                    System.out.println(iter.previous());
                    iter.next();
                    break;
                case "LEAVE":
                    iter.remove();
                    if (!iter.hasNext()) {
                        iter = students.listIterator();
                    }
                    System.out.println(iter.next());
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Ballpassing newBallpassing = new Ballpassing();
        newBallpassing.run();
    }
}
