import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), col = sc.nextInt();
        char[][] grid = new char[row][col];
        char[] rows = new char[row];
        String temp;
        
        for(int x = 0; x < row; x++) {
            temp = sc.nextLine();
            rows = temp.trim().toCharArray();
            for (int y = 0; y < rows.length; y++) {
                grid[x][y] = rows[y];
            }
        }
        
        int result = play(grid, 0, 0, 0);
        switch (result) {
            case -1:
                System.out.println("Out");
                break;
            case -2:
                System.out.println("Lost");
                break;
            default:
                System.out.println(result);
                break;
        }
    }
    
    public static int play(char[][] grid, int x, int y, int c) {
        /*if (x < 0 || y < 0 || x > grid.length || y > grid[0].length) {
            //Out
            return -1;
        } else if (moves[x][y] == 1) {
            //Lost
            return -2;
        } else */
        try {
            grid[x][y] = 'a';
            switch(grid[x][y]) {
                case 'N':
                    return play(grid, x-1, y, c+1);
                    //break;
                case 'S':
                    return play(grid, x+1, y, c+1);
                    //break;
                case 'E':
                    return play(grid, x, y+1, c+1);
                    //break;
                case 'W':
                    return play(grid, x, y-1, c+1);
                    //break;
                case 'T':
                    return c;
                default:
                    return -1;
            }
        } catch (Exception e) {
            return -2;
        }
    }
}
