package cs2336asg2.cxm190008;

//Work class
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class Work {

    //find pattern method
    public void findPattern(String filename) throws FileNotFoundException {

        //open file
        Scanner inputFile = new Scanner(new File(filename));

        //initialize
        boolean found = false;
        int i = 0, j = 0;
        int dif = 4;
        int row = inputFile.nextInt();
        int col = inputFile.nextInt();
        int[][] grid = new int[row][col];
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                grid[i][j] = inputFile.nextInt();
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

        //close file
        inputFile.close();

        //find patterns vertically
        for (i = 0; i <= row - dif; i++) {
            for (j = 0; j < col; j++) {

                //call down method and compare
                if (checkSequence(grid, i, j, "down") == dif && found == false) {
                    found = true;
                    display(i, j, grid, found);
                }
            }
        }

        //find patterns horizontally
        for (i = 0; i < row; i++) {
            for (j = 0; j <= col - dif; j++) {

                //call across method and compare
                if (checkSequence(grid, i, j, "across") == dif && found == false) {
                    found = true;
                    display(i, j, grid, found);
                }
            }
        }

        //find patterns diagonally
        //right to left diagonal
        for (i = 0; i <= row - dif; i++) {
            for (j = 0; j <= col - dif; j++) {

                //call diagonal method
                if (checkSequence(grid, i, j, "dDown") == dif && found == false) {
                    found = true;
                    display(i, j, grid, found);
                }
            }
        }
        //left to right diagonal
        for (i = row - dif + 1; i < 6; i++) {
            for (j = 0; j <= col - dif; j++) {

                //call diagonal method
                if (checkSequence(grid, i, j, "dUp") == dif && found == false) {
                    found = true;
                    display(i, j, grid, found);
                }
            }
        }
        if (found == false) {
            display(i, j, grid, found);
        }
    }

    private int checkSequence(int[][] grid, int i, int j, String direction) {

        //initialize
        int check = 0, first = 0, second = 0, third = 0, fourth = 0;

        //to find horizontal
        if ("across".equals(direction)) {
            first = grid[i][j];
            second = grid[i][j + 1];
            third = grid[i][j + 2];
            fourth = grid[i][j + 3];
        }

        //to find vertical
        if ("down".equals(direction)) {
            first = grid[i][j];
            second = grid[i + 1][j];
            third = grid[i + 2][j];
            fourth = grid[i + 3][j];
        }

        //to find right to left diagonal
        if ("dDown".equals(direction)) {
            first = grid[i][j];
            second = grid[i + 1][j + 1];
            third = grid[i + 2][j + 2];
            fourth = grid[i + 3][j + 3];
        }

        //to find left to right diagonal
        if ("dUp".equals(direction)) {
            first = grid[i][j];
            second = grid[i - 1][j + 1];
            third = grid[i - 2][j + 2];
            fourth = grid[i - 3][j + 3];
        }

        //check if numbers are equal
        if (first == second) {
            check++;
        }
        if (second == third) {
            check++;
        }
        if (third == fourth) {
            check++;
        }
        if (fourth == first) {
            check++;
        }
        
        //return number of matches
        return check;
    }

    //display function
    private void display(int i, int j, int[][] grid, boolean found) {
        if (found == true) {
            //if sequence is found
            System.out.println("Sequence of " + grid[i][j] + " starts at " + (i + 1) + "," + (j + 1));
        } else {
            //if sequence is not found
            System.out.println("No sequence found.");
        }
    }
}
