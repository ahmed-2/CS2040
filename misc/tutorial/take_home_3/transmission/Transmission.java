
/*
 * Name       :  Andy Lam Kwok Wee
 * Matric No. :  A0183821E
 * Plab Acct. :
 */
import java.util.*;

public class Transmission {
    private TreeSet<Integer> sleepingCatList = new TreeSet<>();

    private void run() {
        Scanner reader = new Scanner(System.in);
        int numCats = reader.nextInt();
        int numOperations = reader.nextInt();
        for (int i = 0; i < numOperations; i++) {
            String operation = reader.next();
            int currentCat = reader.nextInt();
            switch (operation) {
                case ("WAKE"):
                    sleepingCatList.remove(currentCat);
                    break;
                case ("SLEEP"):
                    sleepingCatList.add(currentCat);
                    break;
                default:
                    int lastCat = reader.nextInt();
                    System.out.println(sleepingCatList.lower(lastCat + 1) == null 
                        || currentCat > sleepingCatList.lower(lastCat + 1) ? "YES" : "NO");
            }
        }
    }

    public static void main(String[] args) {
        Transmission newTransmission = new Transmission();
        newTransmission.run();
    }
}