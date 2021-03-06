/**
 * Name         :	Ahmed Bahajjaj
 * Matric. No   :	A0140051A
 * PLab Acct.   :
 */

import java.util.*;

public class Censorship {
    private void run() {
        //Declare Variables
        Scanner sc = new Scanner(System.in);
        int ref, num = sc.nextInt();
        String print, word;
        ArrayList<String> words = new ArrayList<>();
        LinkedList<String> story = new LinkedList<>();

        //Read censored words and story
        for (int i = 0; i < num; i++) {
            words.add(sc.next());
        }
        while (sc.hasNext()) {
            story.add(sc.next());
        }
        int storySize = story.size();
        int wordsSize = words.size();

        //Process censorship on story and print
        for (int i = 0; i < storySize; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            print = story.poll();
            ref = 0;
            for (int x = 0; x < words.size(); x++) {
                word = words.get(x);
                if (word.equalsIgnoreCase(print)) {
                    for (int y = 0; y < word.length(); y++) {
                        System.out.print("*");
                    }
                    ref = 1;
                    break;
                }
            }
            if (ref == 0) {
                System.out.print(print);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Censorship newCensorship = new Censorship();
        newCensorship.run();
    }
}
