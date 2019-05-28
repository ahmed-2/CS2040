public class tut4 {
    public static void main(String[] args) { 
        tut4 tut = new tut4();
        tut.run()
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        //int val = sum(sc.nextInt());
        //System.out.println(val);
        int[][] colourMatrix = {
            {1,1,1,1,2,2,2,1},
            {1,1,1,0,0,0,0,2},
            {2,1,0,0,0,0,2,2},
            {1,0,0,0,0,0,2,2},
            {2,0,0,2,2,2,1,1},
            {2,0,0,2,2,0,0,0},
            {1,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,2}
        };
        System.out.println("Before fill...");
        printMatrix(colourMatrix);
        System.out.println();
        colourMatrix = paintBucketFill(colourMatrix, 2, 3, sc.nextInt()); 
        System.out.println("After fill...");
        printMatrix(colourMatrix);
    }

    private void int sum(int n) {
        if (n == 1) {
            return n;
        } else {
            return n + sum(n-1);
        }
    }

    private void printMatrix(int[][] matrix){
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            } // not particular about extra trailing space here
            System.out.println();
        }
    }

    private int[][[] paintBucketFill(
    int[][] matrix, int row, int col, int our) {
        try {
            if (matrix[row][col] == our) {
                //return paintBucketFill(matrix, r-1, col, our);
        } catch (Exception e) {
            //;
        }
    }
}
