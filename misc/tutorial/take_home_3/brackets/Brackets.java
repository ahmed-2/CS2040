/*
 * Name       : Andy Lam Kwok Wee
 * Matric No. : A0183821E
 * Plab Acct. :
 */
import java.util.*;

public class Brackets {
    private void run() {
        Scanner reader = new Scanner(System.in);
        int numOperations = reader.nextInt();
        for (int i = 0; i < numOperations; i++) {
            int numBrackets = reader.nextInt();
            reader.nextLine();
            char[] charQueue = reader.nextLine().toCharArray();
            System.out.println(checkValidity(charQueue) ? "Valid" : "Invalid");
        }
    }

    public boolean checkValidity(char[] queue) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < queue.length; i++) {
            char currentBracket = queue[i];
            if (stack.isEmpty()) {
                stack.push(currentBracket);
            } else {
                if (compatibleBracket(stack.peek()) == currentBracket) {
                    stack.pop();
                } else {
                    stack.push(currentBracket);
                }
            }
        }
        return stack.isEmpty();
    }

    public char compatibleBracket(char bracket) {
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
