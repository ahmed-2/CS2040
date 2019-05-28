/*
 * Name       :     Muhammad Ahmed bin Anwar Bahajjaj
 * Matric No. :     A0140051A
 * Plab Acct. :     Nil
 */
import java.util.*;

public class Brackets {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), count;
        for (int i = 0; i < num; i++) {
            count = sc.nextInt();
            char[] line = sc.next().toCharArray();
            System.out.println(check(line) ? "Valid" : "Invalid");
        }
    }

    public boolean check(char[] line) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length; i++) {
            char bracket = line[i];
            if (stack.isEmpty()) {
                stack.push(bracket);
            } else {
                if (shape(stack.peek()) == bracket) {
                    stack.pop();
                } else {
                    stack.push(bracket);
                }
            }
        }
        return stack.isEmpty();
    }

    public char shape(char bracket) {
        switch (bracket) {
            case ('('): return ')';
            case ('['): return ']';
            case ('{'): return '}';
            default: return '.';
        }
    }

    public static void main(String[] args) {
        Brackets newBrackets = new Brackets();
        newBrackets.run();
    }
}
