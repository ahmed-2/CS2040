class MyInteger { 
    public int x;
    public MyInteger(int n) { x = n; } public static void swap1(int a, int b) {
        int temp = a; a = b;
        b = temp;
    }
    public static void swap2(MyInteger a, MyInteger b) {
        int temp = a.x; a.x = b.x;
        b.x = temp;
    }
    public static void swap3(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    public static void main(String[] args) {
        int c = 1;
        int d = 3;
        MyInteger e = new MyInteger(1); MyInteger f = new MyInteger(2);
        int[] arr = {9, 8, 7, 6, 5};
    }
}
// Are the int values within c and d swapped?
swap1(c, d);
// Are the int values contained in e and f swapped?
swap2(e, f);
// Are the int values within arr[1] and arr[3] swapped?
swap3(arr, 1, 3);
}
