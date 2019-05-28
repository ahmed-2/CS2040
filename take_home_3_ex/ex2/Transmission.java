/*
 * Name       : Muhammad Ahmed bin Anwar Bahajjaj
 * Matric No. : A0140051A
 * Plab Acct. : Nil
 */
import java.util.*;

public class Transmission {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), ops = sc.nextInt();
        TreeSet<Integer> cats = new TreeSet<>();
        for (int i = 0; i < ops; i++) {
            String ins = sc.next();
            switch (ins) {
                case "SLEEP":
                cats.add(sc.nextInt());
                break;
                case "WAKE":
                cats.remove(sc.nextInt());
                break;
                case "TRANSMIT":
                int x = sc.nextInt(), y = sc.nextInt();
                System.out.println(cats.lower(y+1) == null || x > cats.lower(y+1)
                ? "YES" : "NO");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Transmission newTransmission = new Transmission();
        newTransmission.run();
    }
}
