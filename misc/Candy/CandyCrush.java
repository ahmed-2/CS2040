//Ahmed Bahajjaj

import java.util.*;

public class CandyCrush {
    private void run() {
        //Reading and initialising values
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(), columns = sc.nextInt(), ref = 0;
        //coords to store coordinates of colorful values
        int coords[][] = new int[10][2];
        long grid[][] = new long[rows][columns];
        long temp, max = 0;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                temp = sc.nextLong();
                if (temp < 0) {
                    coords[ref][0] = x;
                    coords[ref][1] = y;
                    ref++;
                }
                grid[x][y] = temp;
            }
        }
        //options to store values adjacent to colorful values
        long[][] options = new long[ref][4];
        int[] pos = {0,0};
        //Cycle through all colorful values
        for (int x = 0; x < ref; x++) {
            //First read position
            if (coords[x][0] == 0) {
                //Top
                pos[0] = 1;
            } else if (coords[x][0] == (rows - 1)) {
                //Bottom
                pos[0] = 2;
            }
            if (coords[x][1] == 0) {
                //Left
                pos[1] = 1;
            } else if (coords[x][1] == (columns - 1)) {
                //Right
                pos[1] = 2;
            }
            //Check what are the adjacent values
            options[x] = check(grid, coords[x], pos);
            //Cycle through all adjacent values
            for (long opt : options[x]) {
                //if next to another colourful, immediately end program
                if (opt < 0) {
                    System.out.println(rows * columns);
                    ref = 0;
                    break;
                }
                //count total number available in grid of adjacent values
                temp = Arrays.stream(grid)
                    .flatMapToLong(i -> Arrays.stream(i))
                    .filter(i -> i == opt)
                    .count();
                if (temp > max) {
                    max = temp;
                }
            }
            if (ref == 0) {
                break;
            }
        }
        if (ref != 0) {
            System.out.println(max + 1);
        }
    }

    //Checks all coordinates of colorful, returns an array with all adjacent values
    private long[] check(long[][] grid, int[] coords, int[] pos) {
        long[] options;
        if (pos[0] == 1 && pos[1] == 1) {
            //Top-Left
            options = new long[2];
            options[0] = getDown(grid, coords);  //Down
            options[1] = getRight(grid, coords);  //Right
        } else if (pos[0] == 1 && pos[1] == 0) {
            //Top
            options = new long[3];
            options[0] = getDown(grid, coords);  //Down
            options[1] = getLeft(grid, coords);  //Left
            options[2] = getRight(grid, coords);  //Right
        } else if (pos[0] == 1 && pos[1] == 2) {
            //Top-Right
            options = new long[2];
            options[0] = getDown(grid, coords);  //Down
            options[1] = getLeft(grid, coords);  //Left
        } else if (pos[0] == 0 && pos[1] == 2) {
            //Right
            options = new long[3];
            options[0] = getUp(grid, coords);  //Up
            options[1] = getDown(grid, coords);  //Down
            options[2] = getLeft(grid, coords);  //Left
        } else if (pos[0] == 2 && pos[1] == 2) {
            //Bottom-Right
            options = new long[2];
            options[0] = getUp(grid, coords);  //Up
            options[1] = getLeft(grid, coords);  //Left
        } else if (pos[0] == 2 && pos[1] == 0) {
            //Bottom
            options = new long[3];
            options[0] = getUp(grid, coords);  //Up
            options[1] = getLeft(grid, coords);  //Left
            options[2] = getRight(grid, coords);  //Right
        } else if (pos[0] == 2 && pos[1] == 1) {
            //Bottom-Left
            options = new long[2];
            options[0] = getUp(grid, coords);  //Up
            options[1] = getRight(grid, coords);  //Right
        } else if (pos[0] == 0 && pos[1] == 1) {
            //Left
            options = new long[3];
            options[0] = getUp(grid, coords);  //Up
            options[1] = getDown(grid, coords);  //Down
            options[2] = getRight(grid, coords);  //Right
        } else {
            options = new long[4];
            options[0] = getUp(grid, coords);  //Up
            options[1] = getDown(grid, coords);  //Down
            options[2] = getLeft(grid, coords);  //Left
            options[3] = getRight(grid, coords);  //Right
        }
        return options;
    }

    private long getDown(long[][] grid, int[] coords) {
        //Gets Down
        return grid[coords[0]+1][coords[1]];
    }

    private long getUp(long[][] grid, int[] coords) {
        //Gets Up
        return grid[coords[0]-1][coords[1]];
    }

    private long getLeft(long[][] grid, int[] coords) {
        //Gets Left
        return grid[coords[0]][coords[1]-1];
    }

    private long getRight(long[][] grid, int[] coords) {
        //Gets Right
        return grid[coords[0]][coords[1]+1];
    }

    public static void main(String[] args) { 
        CandyCrush newCrush = new CandyCrush();
        newCrush.run();
    }
}
