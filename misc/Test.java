import java.util.*;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(testFunction(sc.nextInt()));//, sc.nextInt()));
    }

    public static int testFunction(int n) {
        if (n <= 1) return n;
        return testFunction(n-1) + testFunction(n-2);
    }

    public static int testFunction(int n, int k) {
        if (k == 0 || k == n) return 1;
        return testFunction(n-1, k-1) + testFunction(n-1, k);
    }
}
